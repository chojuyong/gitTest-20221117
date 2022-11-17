package com.gyojincompany.test;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gyojincompany.test.dao.IDao;
import com.gyojincompany.test.dto.MemberDto;

@Controller
public class TestController {
	
	@Autowired
	private SqlSession sqlSession;
	
	@RequestMapping(value = "/join")
	public String joinPage() {
		
		return "join";
	}
	
	@RequestMapping(value = "/joinMember")
	public String joinMember(HttpServletRequest request, Model model) {
		
		IDao dao = sqlSession.getMapper(IDao.class);
		
		String mid = request.getParameter("mid");
		String mpw = request.getParameter("mpw");
		String mname = request.getParameter("mname");
		String memail = request.getParameter("memail");
		
		dao.memberJoin(mid, mpw, mname, memail);//DB�� ȸ������ ����
		model.addAttribute("mid", mid);
		
		return "joinOk";
	}
	
	@RequestMapping(value ="/memberList")
	public String memberList(HttpServletRequest request, Model model) {
		
		IDao dao = sqlSession.getMapper(IDao.class);
		
		ArrayList<MemberDto> memberList = dao.memberList();
		
		//dtos.get(0).getMname(); //ù��° ����ȸ���� �̸� ����
		
		model.addAttribute("memberList", memberList);
		
		return "memberList";
	}
	
	@RequestMapping(value = "/searchId")
	public String searchId() {
		
		return "idSearch";
	}
	
	@RequestMapping(value = "idOk")
	public String idOk(HttpServletRequest request, Model model) {
		
		String searchId = request.getParameter("searchId");
		IDao dao = sqlSession.getMapper(IDao.class);		
		MemberDto mdto = dao.searchIdOk("searchId");
		
		model.addAttribute("searchRs", mdto);
		
		return "idOk";
	}
}
