package com.tdd.controller;

import com.tdd.dto.MemberRequest;
import com.tdd.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService  memberService;

    @PostMapping("")
    public String createMember(MemberRequest request){
        System.out.println("rasdsadsadsaqeqwdasda"+request);
        memberService.createMember(request);
        return "redirect:/index";
    }
    @GetMapping("")
    public String hasAddMemberForm(){
        return "addmember";
    }




}
