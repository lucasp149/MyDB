package com.solvd.storeDataBase.persistence.implementation;

import com.solvd.storeDataBase.domain.Zone;

import java.sql.*;


import static com.solvd.storeDataBase.ConnectToDb.connectToDb;

public class ZoneRepositoryImplementation extends GeneralRepositoryImplementation<Zone> {
    public final static String TABLE_NAME = "zones";


    @Override
    public Long create(Zone zone) throws SQLException {
        try (Connection conn = connectToDb()) {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO zones(name) VALUES (?)", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, zone.getName());

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
    public void updateById(Long id, Zone zone) throws SQLException {
        try (Connection conn = connectToDb()) {
            PreparedStatement ps = conn.prepareStatement("UPDATE zones set name= ? WHERE id = ?", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, zone.getName());
            ps.setLong(2,id);
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
    public Zone mapOneObject(ResultSet resultSet) {
        try {
            return new Zone(resultSet.getLong("id"), resultSet.getString("name"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
