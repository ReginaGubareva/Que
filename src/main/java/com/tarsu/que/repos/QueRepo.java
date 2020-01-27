package com.tarsu.que.repos;

import com.tarsu.que.domain.Que;
import com.tarsu.que.domain.User;
import com.tarsu.que.dto.QueDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface QueRepo extends JpaRepository<Que, Long> {
    Que findQueById(Long id);
    List<Que> findByQueName(String name);

//    @Query("select new com.tarsu.que.dto.QueDto(" +
//            "q.id, " +
//            "   q.queName, " +
//            "   q.queDescription" +
//            ") " +
//            "from Que q inner join q.usr u" +
//            "where q.usr = :id group by q")
//    List<QueDto> findAllByUser(@Param("author") User author);

    @Query(value = "SELECT * FROM que q WHERE q.user_id = :id", nativeQuery = true)
    Collection<Que> findAllByUserId(@Param("id") Long id);

    void deleteById(String queId);
}

