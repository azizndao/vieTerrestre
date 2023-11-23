package io.github.azizndao.vieterrestre.repository;

import io.github.azizndao.vieterrestre.models.Alert;
import io.github.azizndao.vieterrestre.utils.DatabaseUtils;

import java.sql.Connection;
import java.sql.SQLException;


public class AlertRepositoryImpl implements AlertRepository {

    final Connection connection = DatabaseUtils.getConnection();


    public AlertRepositoryImpl() {
    }

    @Override
    public Alert getAlert(int id) throws SQLException {
        return null;
    }

    @Override
    public Alert save(String type, String description, float lontitude, float latitude) {
        try (
                var stm = connection.prepareStatement(
                        "INSERT INTO alerts (type, description, latitude, longitude, author_id) VALUES (?, ?, ?, ?, ?)"
                );
        ) {
            stm.setString(1, type);
            stm.setString(2, description);
            stm.setFloat(3, lontitude);
            stm.setFloat(4, latitude);
            var rs = stm.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public Alert delete(int id) {
        return null;
    }

    @Override
    public Alert update(Alert alert) {
        return null;
    }
}
