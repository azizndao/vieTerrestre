package io.github.azizndao.vieterrestre.repository;

import at.favre.lib.crypto.bcrypt.BCrypt;
import io.github.azizndao.vieterrestre.models.User;
import io.github.azizndao.vieterrestre.utils.DatabaseUtils;
import jakarta.persistence.EntityManager;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;

public class AuthRepositoryImpl implements AuthRepository {
    private final Connection connection = DatabaseUtils.getConnection();
    private final EntityManager entityManager = DatabaseUtils.getEntityManager();

    static int BCRYPT_HASH_COST = 12;

    @Override
    public User getUserByEmail(String email) {
        var transaction = entityManager.getTransaction();
        transaction.begin();
        transaction.commit();
        try (var stm = connection.prepareStatement("SELECT * FROM users WHERE email = ?");) {
            stm.setString(1, email);
            var rs = stm.executeQuery();
            if (rs.next()) {
                var user = new User()
                        .setId(rs.getInt("id"))
                        .setFirstName(rs.getString("first_name"))
                        .setLastName(rs.getString("last_name"))
                        .setBirthday(rs.getObject("birthday", LocalDate.class))
                        .setEmail(rs.getString("email"))
                        .setPassword(rs.getString("password"))/*
                        .setCreatedAt(LocalDateTime.parse(rs.getObject("created_at").toString(), DateTimeFormatter.ISO_OFFSET_DATE_TIME))
                        .setUpdatedAt(LocalDateTime.parse(rs.getObject("updated_at").toString(), DateTimeFormatter.ISO_OFFSET_DATE_TIME))
                        .setDeletedAt(LocalDateTime.parse(rs.getObject("deleted_at").toString(), DateTimeFormatter.ISO_OFFSET_DATE_TIME))
                        .setBannedAt(LocalDateTime.parse(rs.getObject("banned_at").toString(), DateTimeFormatter.ISO_OFFSET_DATE_TIME))*/;
                rs.close();
                return user;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public User authenticate(String email, String password) {
        var user = getUserByEmail(email);
        var passwordMatch = BCrypt.verifyer().verify(password.toCharArray(), user.getPassword());
        return passwordMatch.verified ? user.setPassword(null) : null;
    }

    @Override
    public User register(String email, String password, String firstName, String lastName, LocalDate birthday) {
        try (var stm = connection.prepareStatement("INSERT INTO users (email, password, first_name, last_name, birthday) VALUES (?, ?, ?, ?, ?)");) {
            stm.setString(1, email);
            stm.setString(2, BCrypt.withDefaults().hashToString(BCRYPT_HASH_COST, password.toCharArray()));
            stm.setString(3, firstName);
            stm.setString(4, lastName);
            stm.setDate(5, Date.valueOf(birthday));
            stm.execute();
            return getUserByEmail(email);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean updatePassword(String username, String password) {
        return false;
    }

    @Override
    public boolean updateProfile(String username, String firstName, String lastName, LocalDate birthday) {
        return false;
    }
}
