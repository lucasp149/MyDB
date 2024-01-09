package com.solvd.storeDataBase.persistence.implementation;

import com.solvd.storeDataBase.domain.Deposit;

import java.sql.*;

import static com.solvd.storeDataBase.ConnectToDb.connectToDb;

public class DepositRepositoryImplementation extends GeneralRepositoryImplementation<Deposit> {
    final String TABLE_NAME = "deposits";

    @Override
    public Long create(Deposit deposit) throws SQLException {
        try (Connection conn = connectToDb()) {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO deposits(name,address_id) VALUES (?,?)", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, deposit.getName());
            ps.setLong(2,deposit.getAddress().getId());

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
    public void updateById(Long id, Deposit deposit) throws SQLException {
        try (Connection conn = connectToDb()) {
            PreparedStatement ps = conn.prepareStatement("UPDATE deposits set name= ? address_id = ? WHERE id = ?", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, deposit.getName());
            ps.setLong(2,deposit.getAddress().getId());
            ps.setLong(3,id);
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
    public Deposit mapOneObject(ResultSet resultSet) {
        try {
            return new Deposit(resultSet.getLong("id"), resultSet.getString("name"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}