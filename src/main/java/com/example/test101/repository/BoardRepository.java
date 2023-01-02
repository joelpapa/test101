package com.example.test101.repository;

import com.example.test101.entity.Board;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BoardRepository extends PagingAndSortingRepository<Board, Long> {


    void save(Board board);
    Board findById(Long id);


    void deleteById(Long id);

}
