package com.example.que.repos;

import com.example.que.domain.Que;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QueRepo extends JpaRepository<Que, Long> {
    Que findQueById(Long id);
}
