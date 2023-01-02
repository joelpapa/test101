package com.example.test101.service;

import com.example.test101.dto.BoardDto;
import com.example.test101.entity.Board;
import com.example.test101.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;

    public Page<Board> listAll(int pageNumber){
        Sort sort = Sort.by("id").descending();
        Pageable pageable = PageRequest.of(pageNumber -1, 10, sort);
        return boardRepository.findAll(pageable);
    }


    public void save(Board board){
        boardRepository.save(board);
    }

    public Board get(Long id) {
        return boardRepository.findById(id);
    }

    public Board getBoardContent(Long boardid) {
        Board board = boardRepository.findById(boardid);
        return board;
    }
    public void deleteById(Long id) {
        boardRepository.deleteById(id);
    }


}
