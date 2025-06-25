package com.tech.prjm09.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tech.command.BCommand;
import com.tech.command.BContentCommand;
import com.tech.command.BListCommand;
import com.tech.command.BModifyCommand;
import com.tech.command.BModifyViewCommand;
import com.tech.command.BReplyCommand;
import com.tech.command.BReplyViewCommand;
import com.tech.command.BWriteCommand;

import jakarta.servlet.http.HttpServletRequest;
import oracle.jdbc.proxy.annotation.Post;

@Controller
public class BController {
	//dev
	BCommand command;
	@RequestMapping("/list")
	public String list(Model model) {
		System.out.println("list() ctr");
		command=new BListCommand();
		command.execute(model);
		
		return "list";
	}

	@RequestMapping("/write_view")
	public String write_view(Model model) {
		System.out.println("write_view() ctr");
		
		return "write_view";
	}
	@RequestMapping("/write")
	public String write(HttpServletRequest request,
			Model model) {
		System.out.println("write() ctr");
//		db글쓰기동작
		model.addAttribute("request",request);
		command=new BWriteCommand();
		command.execute(model);
		
		return "redirect:list";
	}
	@RequestMapping("/content_view")
	public String content_view(HttpServletRequest request,
			Model model) {
		System.out.println("content_view() ctr");
		model.addAttribute("request",request);
		command=new BContentCommand();
		command.execute(model);
		
		return "content_view";
	}
	@RequestMapping("/modify_view")
	public String modify_view(HttpServletRequest request,
			Model model) {
		System.out.println("modify_view() ctr");
		model.addAttribute("request",request);
		command=new BModifyViewCommand();
		command.execute(model);
		return "modify_view";
	}
	@PostMapping("/modify")
	public String modify(HttpServletRequest request,
			Model model) {
		System.out.println("modify() ctr");
		model.addAttribute("request",request);
		command=new BModifyCommand();
		command.execute(model);
		
		return "redirect:list";
	}
	@RequestMapping("/reply_view")
	public String reply_view(HttpServletRequest request,
			Model model) {
		System.out.println("reply_view() ctr");
		
		model.addAttribute("request",request);
		command=new BReplyViewCommand();
		command.execute(model);
		
		return "reply_view";
	}
	@PostMapping("/reply")
	public String reply(HttpServletRequest request,
			Model model) {
		System.out.println("reply() ctr");
		model.addAttribute("request",request);
		command=new BReplyCommand();
		command.execute(model);
		
		return "redirect:list";
	}
	
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request,
			Model model) {
		System.out.println("delete() ctr");
		model.addAttribute("request",request);
//		command=new BReplyCommand();
//		command.execute(model);
		
		return "redirect:list";
	}
	
	
	
	
}
