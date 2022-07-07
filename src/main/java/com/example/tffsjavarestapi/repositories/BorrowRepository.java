package com.example.tffsjavarestapi.repositories;

import com.example.tffsjavarestapi.models.entities.Borrow;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BorrowRepository  extends JpaRepository<Borrow, Long> {
    @Query(value = "select b from Borrow b join b.books bo where b.active = true and bo.title = :title")
    Borrow findByBookTitle(@Param("title") String title);

    List<Borrow> findAllByIdIn(List<Long> ids);
    Page<Borrow> findAllByIdIn(List<Long> ids, Pageable pageable);

    @Query(value = "select b from Borrow b where b.active = true")
    List<Borrow> findAllNotBack();
    @Modifying
    @Query(value = "update Borrow b set b.active = false, b.updatedDate = current_date where b.id = :id")
    Borrow close(@Param("id") Long id);
}
