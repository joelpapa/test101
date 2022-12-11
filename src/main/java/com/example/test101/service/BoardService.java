package com.example.test101.service;

import com.example.test101.entity.Board;
import com.example.test101.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;

    public void write(Board board){
        boardRepository.save(board);
    }

    public Page<Board> boardList(Pageable pageable) {
        return boardRepository.findAll(pageable);
    }
}
