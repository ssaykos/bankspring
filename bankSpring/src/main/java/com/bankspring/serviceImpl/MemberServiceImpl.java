package com.bankspring.serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankspring.domain.MemberDto;
import com.bankspring.factory.Command;
import com.bankspring.mapperImpl.MemberMapperImpl;
import com.bankspring.service.MemberService;


@Service
public class MemberServiceImpl implements MemberService{
	/*===== Field =====*/	
	Map<String,Object> map = new HashMap<String,Object>();
	MemberDto member = new MemberDto();
	
	@Autowired
	MemberMapperImpl memberMapper;

/*===== executeUpdate =====*/
    @Override
    public int joinMember(MemberDto member) {
        return memberMapper.insert(member);
    }
    @Override
	public int updateMember(MemberDto member) {
		return memberMapper.update(member);
	}
	@Override
	public int deleteMember(MemberDto member) {
		return memberMapper.delete(member);
	}
   
/*===== executeQuery =====*/	
	@Override
	public MemberDto memberDetail(Command command) {
		return memberMapper.getElementById(command);
	}
	@Override
	public List<MemberDto> searchByKeyword(Command command) {
		return memberMapper.getElementsByName(command);
	}
	
	@Override
	public String login(Command command) {
		String msg = "";
		
		return msg;
	}
    @Override
    public List<MemberDto> memberList(Command command) {
        return  memberMapper.list(command);
    }
	@Override
	public int memberCount(Command command) {
		return memberMapper.count(command);
	}
}
