package com.bankspring.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bankspring.factory.Command;
import com.bankspring.serviceImpl.MemberServiceImpl;

@Controller
@RequestMapping(value="/member")
public class MemberController {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	MemberServiceImpl memberService;
	Command command;
	
	@RequestMapping(value="/adminForm.do")
	public String adminForm(){
		logger.info("MemberController : adminForm()");
		return "member/adminForm";
	}
	
	@RequestMapping(value="/login.do",method=RequestMethod.POST)
	public String login(@RequestParam("id")String id,
			@RequestParam("password")String password){
		logger.info("MemberController : id = {}, pass ={} ",id, password);
		memberService.login(command);
		return "home/frame";
	}
}
