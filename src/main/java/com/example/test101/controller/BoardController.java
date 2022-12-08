package com.example.test101.controller;

import com.example.test101.entity.Board;
import com.example.test101.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping("/board/write")
    public String boardWriteForm(){

        return "/board/boardwrite";
    }

    @PostMapping("/board/writego")
    public String boardwritego(Board board){
     boardService.write(board);
     return "redirect:/";
    }
    @GetMapping("/board/list")
    public String list(Model model) {
        model.addAttribute("list", boardService.boardList());
        return "/board/boardlist";
    }

    @GetMapping("/board/view")
    public String boardView(){
        return "/board/boardview";
    }
}
