package com.bankspring.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.bankspring.domain.MemberDto;
import com.bankspring.factory.Command;
import com.bankspring.factory.CommandFactory;
import com.bankspring.serviceImpl.MemberServiceImpl;

@Controller
@SessionAttributes("user")
@RequestMapping(value="/member")
public class MemberController {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	MemberServiceImpl memberService;
	Command command;
	MemberDto member = new MemberDto();
	
	@RequestMapping(value="/adminForm.do")
	public String adminForm(){
		logger.info("MemberController : adminForm()");
		return "member/adminForm";
	}
	
	@RequestMapping(value="/login.do",method=RequestMethod.POST)
	public String login(@RequestParam("userid")String userid,
			@RequestParam("password")String password,
			Model model){
		logger.info("[ 로그인 ] : id = {}, pass ={} ",userid, password);
		member=memberService.login(CommandFactory.search(userid, password));
		if (userid.equals(member.getUserid())) {
			logger.info("=====로그인성공=====");
			model.addAttribute("user", member);
			model.addAttribute("member", member);
			return "member/main";
		} else {
			logger.info("=====로그인실패=====");
			model.addAttribute("member","login false");
			return "member/main";
		}
	}
	@RequestMapping(value="/join.do",method=RequestMethod.POST)
	public String join(@RequestParam("userid")String userid,
			@RequestParam("name")String name,
			@RequestParam("age")String age,
			@RequestParam("email")String email,
			@RequestParam("password")String password,
			ModelMap model ){
		logger.info("회원가입 아이디 ={} , 이름= {}",userid, name);
		member.setUserid(userid);
		member.setName(name);
		member.setAge(age);
		member.setEmail(email);
		member.setPassword(password);
		int joinOk= memberService.joinMember(member);
		return "home/frame";
	}
}
