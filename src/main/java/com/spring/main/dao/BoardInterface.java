package com.spring.main.dao;


import java.util.ArrayList;

import com.spring.main.dto.LoginDto;
import com.spring.main.dto.SelectTeamDto;
import com.spring.main.dto.UserDto;


public interface BoardInterface {

	//로그인
	LoginDto login(String u_id, String u_pass);

	//중복체크
	String overlay(String u_id);
	
	//회원가입
	int userJoin(UserDto info);

	//유저 정보
	UserDto userSearch(String u_id);

	//유저가 속한 팀 정보
	ArrayList<SelectTeamDto> selectTeam(String idx);

	int userModify(UserDto udt);


}
