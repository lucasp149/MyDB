package org.solved.persistence.implementation;


import org.solved.domain.City;
import org.solved.persistence.DoubleEntityRepository;


import java.sql.*;


import static org.solved.ConnectToDb.connectToDb;

public class CityRepositoryImplementation extends GeneralRepositoryImplementation<City> implements DoubleEntityRepository {

    final String TABLE_NAME = "cities";

    public Long create(City city) throws SQLException {
        try (Connection conn = connectToDb()) {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO cities(name,zone_id) VALUES (?,?)", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, city.getName());
            ps.setLong(2, city.getZone().getId());
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
    public void updateById(Long id, City city) throws SQLException {
        try (Connection conn = connectToDb()) {
            PreparedStatement ps = conn.prepareStatement("UPDATE zones set name= ? zone_id= ? WHERE id = ?", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, city.getName());
            ps.setLong(2, city.getZone().getId());
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
    public City mapOneObject(ResultSet resultSet) {
        try {
            return new City(resultSet.getLong("id"), resultSet.getString("name"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Long getSecondaryEntityId(Long entityId) {
        try (Connection conn = connectToDb()) {
            PreparedStatement ps = conn.prepareStatement("SELECT zone_id from cities WHERE id = ?", Statement.RETURN_GENERATED_KEYS);
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

    public Long getZoneName(Long cityId) {
        try (Connection conn = connectToDb()) {
            PreparedStatement ps = conn.prepareStatement("SELECT zone_id from cities WHERE id = ?", Statement.RETURN_GENERATED_KEYS);
            ps.setLong(1, cityId);

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
