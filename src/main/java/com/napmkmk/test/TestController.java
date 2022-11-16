package com.napmkmk.test;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.napmkmk.test.dao.IDao;
import com.napmkmk.test.dto.MemberDto;

@Controller
public class TestController {

	@Autowired
	private SqlSession sqlSession;
	
	@RequestMapping("join")
	public String joinPage() {
		

		return "join";
	}
	
	@RequestMapping(value ="joinMember")
	public String joinMember(HttpServletRequest request, Model model) {
		
		 IDao dao = sqlSession.getMapper(IDao.class); //IDao 와 쓸수 있도록 하려면 @Autowired 써주고  private SqlSession sqlSession;
		
		 String mid = request.getParameter("mid"); //  String  mid 이거 다르게 해도 됨.
		 String mpw = request.getParameter("mpw");
		 String mname = request.getParameter("mname");
		 String memail = request.getParameter("memail");
				 
		 dao.memberJoin(mid, mpw, mname, memail); //DB에 넣기 성공
		 
		 model.addAttribute("memberID" , mid); //memberID 는 mid로 써도됨.
		 
		return "joinOk";
	}

	@RequestMapping(value = "memberList")
	public String memberList(Model model) {
		
		IDao dao = sqlSession.getMapper(IDao.class);
		
		//memberDtos.get(0).getMname(); //첫번째 가입회원의 이름 추출
		ArrayList<MemberDto> dtos = dao.memberList();
		model.addAttribute("mbList", dtos) ;
		
		return "memberList";
		
	}
	
	@RequestMapping(value = "searchId")
	public String searchId() {
		

		
		return "idSearch";
	}
	
	@RequestMapping(value = "idOk")
	public String idOk(HttpServletRequest request, Model model) {
		
		String searchId = request.getParameter("searchId");
		
		IDao dao = sqlSession.getMapper(IDao.class);
		
		MemberDto idok= dao.searchIdOk(searchId);
		model.addAttribute("searchRs" , idok);
		
		return "idOk";
	}
}
