package com.solvd.storeDataBase.persistence.implementation;

import com.solvd.storeDataBase.domain.Payment;

import java.sql.*;


import static com.solvd.storeDataBase.ConnectToDb.connectToDb;

public class PaymentRepositoryImplementation extends GeneralRepositoryImplementation<Payment> {
    public final static String TABLE_NAME = "payments";


    @Override
    public Long create(Payment payment) throws SQLException {
        try (Connection conn = connectToDb()) {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO payments(type) VALUES (?)", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, payment.getType());

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
    public void updateById(Long id, Payment payment) throws SQLException {
        try (Connection conn = connectToDb()) {
            PreparedStatement ps = conn.prepareStatement("UPDATE payments set type= ? WHERE id = ?", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, payment.getType());
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
    public Payment mapOneObject(ResultSet resultSet) {
        try {
            return new Payment(resultSet.getLong("id"), resultSet.getString("type"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Long findByName(String name) {
        try (Connection conn = connectToDb()) {
            String statement = "select id from payments where type = ?";
            PreparedStatement ps = conn.prepareStatement(statement);
            ps.setString(1, name);

            ResultSet res = ps.executeQuery();

            if (res.next()) {
                return res.getLong(1);
            } else {
                return 0L;
            }

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
