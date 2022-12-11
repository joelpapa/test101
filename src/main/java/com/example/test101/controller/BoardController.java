package com.example.test101.controller;

import com.example.test101.entity.Board;
import com.example.test101.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/board")
@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping("/write")
    public String boardWriteForm(){

        return "/board/boardwrite";
    }

    @PostMapping("/writego")
    public String boardwritego(Board board, Model model){
     boardService.write(board);
     model.addAttribute("message", "글 작성이 완료되었습니다.");
     model.addAttribute("searchUrl", "/board/list");
     return "message";
    }
    @GetMapping("/list")
    public String boarList(Model model,
                       @PageableDefault(page=0, size=10, sort="id", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<Board> list = boardService.boardList(pageable);
        int currentPage = list.getPageable().getPageNumber() + 1;
        int firstPage = Math.max(currentPage - 4, 1);
        int lastPage = Math.min(currentPage + 5, list.getTotalPages());
        model.addAttribute("list", list);
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("firstPage", firstPage);
        model.addAttribute("lastPage", lastPage);

        return "/board/boardlist";
    }

    @GetMapping("/view")
    public String boardView(){
        return "/board/boardview";
    }
}
