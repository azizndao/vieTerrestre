package io.github.azizndao.vieterrestre.repository;

import io.github.azizndao.vieterrestre.models.Alert;

import java.sql.SQLException;

public interface AlertRepository {
    Alert getAlert(int id) throws SQLException;

    Alert save(String type, String description, float lontitude, float latitude) throws SQLException;

    Alert delete(int id);

    Alert update(Alert alert);
}
