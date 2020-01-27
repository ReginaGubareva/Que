package com.tarsu.que.repos;

import com.tarsu.que.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
    User findUserById(Long id);
    User findByUsername(String username);
    User findByActivationCode(String code);
    User findByUsernameAndId(String username, Long id);
    void deleteById(Long id);
}
