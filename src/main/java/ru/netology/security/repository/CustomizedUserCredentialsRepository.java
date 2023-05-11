package ru.netology.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.netology.security.model.UserCredentials;

import java.util.Optional;

@Repository
public interface CustomizedUserCredentialsRepository extends JpaRepository<UserCredentials, Long> {
    Optional<UserCredentials> findByLoginEquals(String login);

}
