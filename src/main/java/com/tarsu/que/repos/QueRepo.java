package com.tarsu.que.repos;

import com.tarsu.que.domain.Que;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QueRepo extends JpaRepository<Que, Long> {
    Que findQueById(Long id);
    List<Que> findByQueName(String name);
}
