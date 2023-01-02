package com.example.test101.controller;

import com.example.test101.dto.BoardDto;
import com.example.test101.entity.Board;
import com.example.test101.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
     boardService.save(board);
     model.addAttribute("message", "글 작성이 완료되었습니다.");
     model.addAttribute("searchUrl", "/board/list");
     return "message";
    }
    @GetMapping(value = "/list")
    public String boardList(Model model)  {
      return listByPage(model, 1);

    }

    @GetMapping("list/page/{pageNumber}")
    public String listByPage(Model model, @PathVariable("pageNumber") int currentPage){
        Page<Board> page = boardService.listAll(currentPage);
        List<Board> list = page.getContent();

        Long totalRows = page.getTotalElements();
        int totalPages = page.getTotalPages();
        int firstPage = Math.max(currentPage - 4, 1);
        int lastPage = Math.min(currentPage + 5, page.getTotalPages());

        model.addAttribute("totalPages", totalPages);
        model.addAttribute("totalRows", totalRows);
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("firstPage", firstPage);
        model.addAttribute("lastPage", lastPage);
        model.addAttribute("list", list);
        return "/board/boardlist";

    }

    @GetMapping("/view/{id}")  //게시판 글 상세내용 보기
    public String boardView(Model model, @PathVariable("id") Long id){
        Board board = boardService.getBoardContent(id);
        model.addAttribute("board", board);
        return "/board/boardview";
    }

    @RequestMapping(value = "/delete/{id}")
    public String deleteBoard(Model model, @PathVariable("id") Long id) {
        boardService.deleteById(id);
        model.addAttribute("message", "글번호 " + id + "가 삭제되었습니다.");
        model.addAttribute("searchUrl", "/board/list");
        return "message";
    }

    @PostMapping("/updatego")
    public String boardUpdatego(Board board, Model model){
        boardService.save(board);
        model.addAttribute("message", "글 수정이 완료되었습니다.");
        model.addAttribute("searchUrl", "/board/list");
        return "message";
    }
    @GetMapping("/update/{id}")  //게시판 글 상세내용 보기
    public String boardUpdate(Model model, @PathVariable("id") Long id){
        Board board = boardService.getBoardContent(id);
        model.addAttribute("board", board);
        return "/board/boardupdate";
    }
}
