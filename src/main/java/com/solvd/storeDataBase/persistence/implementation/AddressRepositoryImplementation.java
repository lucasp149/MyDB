package com.solvd.storeDataBase.persistence.implementation;

import org.apache.commons.lang3.StringUtils;
import com.solvd.storeDataBase.domain.Address;


import java.sql.*;
import java.util.Arrays;

import static com.solvd.storeDataBase.ConnectToDb.connectToDb;

public class AddressRepositoryImplementation extends GeneralRepositoryImplementation<Address> {
    final String TABLE_NAME = "addresses";

    @Override
    public Long create(Address address) throws SQLException {
        return create(address, address.getCity().getId());
    }


    @Override
    public void updateById(Long id, Address address) throws SQLException {
        try (Connection conn = connectToDb()) {
            PreparedStatement ps = conn.prepareStatement("UPDATE addresses set street_name= ? number = ? city_id= ? WHERE id = ?", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, address.getStreetName());
            ps.setInt(2, address.getNumber());
            ps.setLong(3, address.getCity().getId());
            ps.setLong(4, id);
            ps.executeUpdate();

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    public Long create(Address address, Long cityId) {
        try (Connection conn = connectToDb()) {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO addresses(street_name,number,city_id) VALUES (?,?,?)", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, address.getStreetName());
            ps.setInt(2, address.getNumber());

            ps.setLong(3, cityId);


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
    public String getTableName() {
        return TABLE_NAME;
    }

    public String separateStreetName (String name) {
        String[] tokens = name.split(" ");
        String[] streetNameArray = Arrays.copyOf(tokens, tokens.length-1);

        return StringUtils.join(streetNameArray," ");
    }

    public int separateStreetNumber (String name) {
        String[] tokens = name.split(" ");
        return Integer.parseInt(tokens[tokens.length - 1]);
    }

    public Long findByName(String name) {
        String streetName = separateStreetName(name);
        int streetNumber = separateStreetNumber(name);
        try (Connection conn = connectToDb()) {
            String statement = "select id from addresses where street_name = ? && number = ? ";
            PreparedStatement ps = conn.prepareStatement(statement);
            ps.setString(1, streetName);
            ps.setInt(2, streetNumber);

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
    public Address mapOneObject(ResultSet resultSet) {
        try {
            return new Address(resultSet.getLong("id"), resultSet.getString("street_name"), resultSet.getInt("number"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
