package org.solved.persistence.implementation;


import org.solved.domain.Passport;
import java.sql.*;

import static org.solved.ConnectToDb.connectToDb;

public class PassportRepositoryImplementation extends GeneralRepositoryImplementation<Passport> {
    public final static String TABLE_NAME = "passports";

    @Override
    public Long create(Passport passport) throws SQLException {
        try (Connection conn = connectToDb()) {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO passports(number) VALUES (?)", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, passport.getNumber());

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
    public void updateById(Long id, Passport passport) throws SQLException {
        try (Connection conn = connectToDb()) {
            PreparedStatement ps = conn.prepareStatement("UPDATE passports set number= ? WHERE id = ?", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, passport.getNumber());
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
    public Passport mapOneObject(ResultSet resultSet) {
        try {
            return new Passport(resultSet.getLong("id"), resultSet.getString("number"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Long findByName(String number) {
        try (Connection conn = connectToDb()) {
            String statement = "select id from passports where number = ?";
            PreparedStatement ps = conn.prepareStatement(statement);
            ps.setString(1, number);

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
