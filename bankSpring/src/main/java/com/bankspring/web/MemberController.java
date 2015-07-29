
package com.bankspring.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

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
	@Autowired
	MemberDto member;
	
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
		String searchKey="userid",searchVal=userid;
		member=memberService.memberDetail(CommandFactory.search(searchKey, searchVal));
		
		if (member!=null) {
			
			if(password.equals(member.getPassword())){
				
				logger.info("=====로그인성공=====");
				model.addAttribute("user", member);
				model.addAttribute("member", member);
				return "member/main";
			
			} else{
				
				logger.info("=====비밀번호가 일치 하지 않습니다.=====");
				model.addAttribute("msg","비밀번호가 일치하지 않습니다.");
				return "member/redirect";
				
			}
			
		} else {
			
			logger.info("=====아이디가 존재하지 않습니다.=====");
			model.addAttribute("msg","아이디가 존재하지 않습니다.");
			return "member/redirect";
			
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
	@RequestMapping(value="/logout.do")
	public String logout(@ModelAttribute("user")MemberDto user,
			SessionStatus status){
		status.setComplete();//세션을 비워서 로그아웃 처리
		logger.info("로그아웃 처리 완료");
		return "home/frame";
	}
	@RequestMapping(value="/detail.do")
	public String detail(@ModelAttribute("user")MemberDto user,Model model){
		model.addAttribute("member", user);
		logger.info("상세정보페이지");
		return "member/detail";
	}
	@RequestMapping(value="/update.do",method=RequestMethod.GET)
	public String updateForm(@ModelAttribute("user")MemberDto user,Model model){
		model.addAttribute("member", user);
		logger.info("정보수정페이지");
		return "member/update";
	}
	@RequestMapping(value="/update.do",method=RequestMethod.POST)
	public String update(@ModelAttribute("user")MemberDto user,Model model,SessionStatus status, 
			@RequestParam(value="email",required=false)String email,
			@RequestParam(value="password")String password
			){
		logger.info("memberDto값={}",user);
		model.addAttribute("member", user);
		/*if (password!=null) {
			user.setPassword(password);
		} else {
			user.setPassword(user.getPassword());
		}*/
		user.setEmail(email);
		user.setPassword(password);
		int result=memberService.updateMember(user);
		logger.info("수정 후 결과보기result값={}",result);
		String searchKey="userid";
		String searchVal=user.getUserid();
		if (result!=0) {
			member=memberService.memberDetail(CommandFactory.search(searchKey, searchVal));
			//status.setComplete();//업데이트 이전의 세션 비우기
			//model.addAttribute("user", member);//비워진 세션에 업데이트 후 정보 다시 담기.
			model.addAttribute("member", member);
			return "member/detail";
		} else {
			return "member/update";
		}
		
	}
}
