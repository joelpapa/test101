package com.example.test101.controller;

import com.example.test101.dto.MemberFormDto;
import com.example.test101.entity.Member;
import com.example.test101.service.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/members")
@Controller
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;
    private final PasswordEncoder passwordEncoder;

    @GetMapping(value = "/new")
    public String memberForm(Model model) {
        model.addAttribute("memberFormDto", new MemberFormDto());
        return "members/memberForm";
    }

    @PostMapping(value="/new")
    public String memberForm(MemberFormDto memberFormDto, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()) {
            return "members/memberForm";
        }
        try {
            Member member = Member.createMember(memberFormDto, passwordEncoder);
            memberService.save(member);
            model.addAttribute("message", "가입되었습니다.가입하신 아이디와 비밀번호로 로긴하세요");
            model.addAttribute("searchUrl", "/");
        } catch (IllegalStateException e){
            model.addAttribute("errorMessage", e.getMessage());
            return "/members/memberForm";
        }
        return "/message";
    }



    @GetMapping(value = "/login")
    public String loginMember(){

        return "/members/memberLoginForm";
    }

    @GetMapping(value = "/login/error")
    public String loginError(Model model){
        model.addAttribute("loginError", "아이디 또는 비밀번호를 확인해주세요");
        return "/members/memberLoginForm";
    }

    @GetMapping(value="/logout")
    public String logout() {
        return "members/logout_success";
    }
}
