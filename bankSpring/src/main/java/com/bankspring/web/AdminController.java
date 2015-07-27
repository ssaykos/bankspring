package com.bankspring.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bankspring.factory.CommandFactory;
import com.bankspring.serviceImpl.MemberServiceImpl;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	@Autowired MemberServiceImpl memberService;
		
	//command , pageNo 는  필수값 나머지는 선택값
	@RequestMapping("/member.do")
	public ModelAndView member(@RequestParam("command")String command,
			@RequestParam(value="pageNo",defaultValue="1")String pageNo,
			@RequestParam(value="searchKey",required=false)String searchKey,
			@RequestParam(value="searchKey", required=false)String searchVal,
			ModelAndView mav
			){
		logger.info("관리자 메인페이지 에서 넘어온 명령어={}, 페이지넘버={}",command,pageNo);
		switch (command) {
		case "list":
			mav.addObject("memberList", memberService.memberList(CommandFactory.list(pageNo)));
			mav.addObject("count", memberService.memberCountAll(CommandFactory.count()));
			mav.setViewName("admin/main");
			break;

		default:
			break;
		}
		
		return mav;
	}
}
