package com.solvd.storeDataBase.persistence.implementation;

import com.solvd.storeDataBase.persistence.GeneralRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.solvd.storeDataBase.ConnectToDb.connectToDb;

public abstract class GeneralRepositoryImplementation<T> implements GeneralRepository<T> {

    private final Connection conn;

    {
        try {
            conn = connectToDb();
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public abstract String getTableName();


    public abstract T mapOneObject(ResultSet resultSet);

    @Override
    public T getById(Long id) throws SQLException {
        try {
            String statement = String.format("Select * from %s where id = ?", getTableName());
            PreparedStatement ps = conn.prepareStatement(statement);
            ps.setLong(1, id);
            ResultSet res = ps.executeQuery();
            if (res.next()) {
                return mapOneObject(res);
            } else {
                return null;
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<T> getAll() throws SQLException {

        try {
            conn.setAutoCommit(false);

            String statement = String.format("Select * from %s", getTableName());
            PreparedStatement ps = conn.prepareStatement(statement);
            ResultSet result = ps.executeQuery();
            List<T> allListed = new ArrayList<>();
            T obj;

            while (result.next()) {
                obj = mapOneObject(result);
                allListed.add(obj);
            }
            return allListed;

        } finally {
            conn.setAutoCommit(true);
        }

    }

    @Override
    public abstract Long create(T t) throws SQLException;

    @Override
    public abstract void updateById(Long id, T t) throws SQLException;

    @Override
    public void deleteById(Long id) {
        try {
            String statement = String.format("Delete * from %s Where id = ?", getTableName());
            PreparedStatement ps = conn.prepareStatement(statement);
            ps.setLong(1, id);

            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }




}
