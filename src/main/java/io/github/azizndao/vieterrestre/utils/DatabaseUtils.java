package io.github.azizndao.vieterrestre.utils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseUtils {
    private static Connection connection;
    private static EntityManager entityManager;

    static {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection
                    ("jdbc:postgresql://localhost:54444/vieTerrestre", "abdoul", "aziz");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        return connection;
    }

    public static EntityManager getEntityManager() {
        if (entityManager == null) {
            var factory = Persistence.createEntityManagerFactory("default");
            entityManager = factory.createEntityManager();
        }
        return entityManager;
    }
}
