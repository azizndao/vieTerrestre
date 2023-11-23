package io.github.azizndao.vieterrestre.repository;

import io.github.azizndao.vieterrestre.models.User;

import java.time.LocalDate;

public interface AuthRepository {

    User getUserByEmail(String email);

    User authenticate(String username, String password);

    User register(String username, String password, String firstName, String lastName, LocalDate birthday);

    boolean updatePassword(String username, String password);

    boolean updateProfile(String username, String firstName, String lastName, LocalDate birthday);
}
