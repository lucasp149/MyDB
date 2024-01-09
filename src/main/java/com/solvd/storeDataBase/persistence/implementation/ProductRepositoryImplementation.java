package com.solvd.storeDataBase.persistence.implementation;

import com.solvd.storeDataBase.domain.Product;
import java.sql.*;

import static com.solvd.storeDataBase.ConnectToDb.connectToDb;

public class ProductRepositoryImplementation extends GeneralRepositoryImplementation<Product> {
    public final static String TABLE_NAME = "products";

    @Override
    public Long create(Product product) throws SQLException {
        try (Connection conn = connectToDb()) {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO products(name,description,price,deposit_id,category_id) VALUES (?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, product.getName());
            ps.setString(2, product.getDescription());
            ps.setBigDecimal(3, product.getPrice());
            ps.setLong(4,product.getDeposit().getId());
            ps.setLong(5,product.getCategory().getId());

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
    public void updateById(Long id, Product product) throws SQLException {
        try (Connection conn = connectToDb()) {
            PreparedStatement ps = conn.prepareStatement("UPDATE products set name = ?, description= ?, price= ?, deposit_id = ?, category_id = ? WHERE id = ?");
            ps.setString(1, product.getName());
            ps.setString(2, product.getDescription());
            ps.setBigDecimal(3, product.getPrice());
            ps.setLong(4,product.getDeposit().getId());
            ps.setLong(5,product.getCategory().getId());
            ps.setLong(6,id);
            ps.executeUpdate();

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    public Long getSecondaryEntityId(Long entityId) {
        try (Connection conn = connectToDb()) {
            PreparedStatement ps = conn.prepareStatement("SELECT deposit_id from products WHERE id = ?");
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


    public Long getThirdEntityId(Long entityId) {
        try (Connection conn = connectToDb()) {
            PreparedStatement ps = conn.prepareStatement("SELECT category_id from products WHERE id = ?");
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

    @Override
    public Product mapOneObject(ResultSet resultSet) {
        try {
            return new Product(resultSet.getLong("id"), resultSet.getString("name"), resultSet.getString("description"), resultSet.getBigDecimal("price"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
