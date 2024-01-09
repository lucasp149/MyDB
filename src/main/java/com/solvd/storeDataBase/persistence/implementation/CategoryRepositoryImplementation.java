package com.solvd.storeDataBase.persistence.implementation;

import com.solvd.storeDataBase.domain.Category;

import java.sql.*;

import static com.solvd.storeDataBase.ConnectToDb.connectToDb;

public class CategoryRepositoryImplementation extends GeneralRepositoryImplementation<Category> {

    public final static String TABLE_NAME = "categories";



    @Override
    public Long create(Category category) throws SQLException {
        try (Connection conn = connectToDb()) {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO categories(name) VALUES (?)", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, category.getName());

            ps.executeUpdate();
            ResultSet keys = ps.getGeneratedKeys();
            System.out.println(keys);
            keys.next();
            return keys.getLong(1);

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateById(Long id, Category category) throws SQLException {
        try (Connection conn = connectToDb()) {
            PreparedStatement ps = conn.prepareStatement("UPDATE categories set name= ? WHERE id = ?", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, category.getName());
            ps.setLong(2, id);
            ps.executeUpdate();

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public String getTableName() {
        return TABLE_NAME;
    }

    @Override
    public Category mapOneObject(ResultSet resultSet) {
        try {
            return new Category(resultSet.getLong("id"), resultSet.getString("name"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
