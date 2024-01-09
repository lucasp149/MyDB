package com.solvd.storeDataBase.persistence.implementation;


import com.solvd.storeDataBase.domain.Store;

import java.sql.*;

import static com.solvd.storeDataBase.ConnectToDb.connectToDb;

public class StoreRepositoryImplementation extends GeneralRepositoryImplementation<Store> {
    public final static String TABLE_NAME = "stores";

    @Override
    public Long create(Store store) throws SQLException {
        try (Connection conn = connectToDb()) {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO stores(name,address_id) VALUES (?,?)", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, store.getName());
            ps.setLong(2, store.getAddress().getId());
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
    public void updateById(Long id, Store store) throws SQLException {
        try (Connection conn = connectToDb()) {
            PreparedStatement ps = conn.prepareStatement("UPDATE stores set type= ? address_id = ? WHERE id = ?", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, store.getName());
            ps.setLong(2, store.getAddress().getId());
            ps.setLong(3, id);
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
    public Store mapOneObject(ResultSet resultSet) {
        try {
            return new Store(resultSet.getLong("id"), resultSet.getString("name"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Long getSecondaryEntityId(Long entityId) {
        try (Connection conn = connectToDb()) {
            PreparedStatement ps = conn.prepareStatement("SELECT address_id from stores WHERE id = ?", Statement.RETURN_GENERATED_KEYS);
            ps.setLong(1, entityId);

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
