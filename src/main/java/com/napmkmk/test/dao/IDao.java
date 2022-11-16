package com.napmkmk.test.dao;

import java.util.ArrayList;

import com.napmkmk.test.dto.MemberDto;

public interface IDao {
	 public void memberJoin(String mid, String mpw, String mname, String memail); //void는 반환값없어요. DB에만 넣어주기
	 public ArrayList<MemberDto> memberList(); //ArrayList 모든회원 리스트 가져오기( 무조건 가져오기) //MemberDto 이건 db 한줄
	 public MemberDto searchIdOk(String mid);//회원아이디로 검색하여 한줄중 id로 검색
	

}

