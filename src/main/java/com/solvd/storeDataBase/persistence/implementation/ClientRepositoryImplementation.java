package com.solvd.storeDataBase.persistence.implementation;

import org.apache.commons.lang3.StringUtils;
import com.solvd.storeDataBase.domain.Client;

import java.sql.*;
import java.util.Arrays;

import static com.solvd.storeDataBase.ConnectToDb.connectToDb;

public class ClientRepositoryImplementation extends GeneralRepositoryImplementation<Client> {
    final String TABLE_NAME = "clients";


    @Override
    public Long create(Client client) throws SQLException {
        try (Connection conn = connectToDb()) {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO clients(first_name,last_name, address_id,passport_id) VALUES (?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, client.getFirstName());
            ps.setString(2, client.getLastName());
            ps.setLong(3, client.getAddress().getId());
            ps.setLong(4, client.getPassport().getId());
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
    public void updateById(Long id, Client client) throws SQLException {
        try (Connection conn = connectToDb()) {
            PreparedStatement ps = conn.prepareStatement("UPDATE clients set first_name = ? last_name = ? address_id = ? passport_id = ? WHERE id = ?", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, client.getFirstName());
            ps.setString(2, client.getLastName());
            ps.setLong(3, client.getAddress().getId());
            ps.setLong(4, client.getPassport().getId());

            ps.setLong(5, id);
            ps.executeUpdate();

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }



    public Long getThirdEntityId(Long entityId) {
        try (Connection conn = connectToDb()) {
            PreparedStatement ps = conn.prepareStatement("SELECT passport_id from clients WHERE id = ?");
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

    @Override
    public String getTableName() {
        return TABLE_NAME;
    }



    public Long findByName(String name, String lastName) {
        try (Connection conn = connectToDb()) {
            String statement = "select id from clients where first_name = ? && last_name = ? ";
            PreparedStatement ps = conn.prepareStatement(statement);
            ps.setString(1, name);
            ps.setString(2, lastName);

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

    @Override
    public Client mapOneObject(ResultSet res) {
        try {
            return new Client(res.getLong("id"), res.getString("first_name"), res.getString("last_name"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String separateFirstName (String name) {
        String[] tokens = name.split(" ");
        String[] streetNameArray = Arrays.copyOf(tokens, tokens.length-1);

        return StringUtils.join(streetNameArray," ");
    }

    public String separateLastName (String name) {
        String[] tokens = name.split(" ");
        return tokens[tokens.length - 1];
    }
}
