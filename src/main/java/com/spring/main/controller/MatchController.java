package com.spring.main.controller;

import java.util.ArrayList;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.spring.main.dto.AreaDto;
import com.spring.main.dto.RepleDto;
import com.spring.main.service.MatchService;

@Controller("MatchController")
@RequestMapping(value="/match")
public class MatchController {
	
	@Autowired
	MatchService service;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private static boolean modFlag = false;
	//매칭게시판
	@RequestMapping(value = "/matchList")
	public String matchList() {
		
		return "matchList";
	}
	
	//리스트 요청
		@RequestMapping(value="/listCall")
		public @ResponseBody Map<String, Object> listCall(@RequestParam Map<String, String> params){
			logger.info("리스트 요청");
			return service.listCall(params);
		}
		
		//검색 요청
		@RequestMapping(value="/search")
		public @ResponseBody Map<String, Object> search(@RequestParam Map<String, String> params){
			logger.info("검색 요청");
			return service.search(params);
		}
		
		//검색 후 리스트 요청
		@RequestMapping(value="/searchCall")
		public @ResponseBody Map<String, Object> searchCall(@RequestParam Map<String, String> params){
			logger.info("리스트 요청");
			return service.searchCall(params);
		}
	
	
	//매칭상세
	@RequestMapping(value = "/matchDetail")
	public ModelAndView matchDetail(@RequestParam("idx") int idx) {
		logger.info("매칭상세");
		modFlag=false;
		return service.detail(idx, modFlag);
	}
	
	
	//댓글 등록
	@RequestMapping(value = "/replyRegist")
	public @ResponseBody Map<String, String> replyRegist(@RequestParam Map<String, String> params) {
		logger.info("매칭댓글등록");
		return service.replyRegist(params);
	}
	
	//댓글 요청	
	@RequestMapping(value="/replyList")
	public @ResponseBody Map<String, ArrayList<RepleDto>> replyList(@RequestParam Map<String, String> params){
		logger.info("리스트 요청");
		return service.replyList(params);
	}
	
	
	//댓글 요청	
	@RequestMapping(value="/replyDel")
	public @ResponseBody Map<String, String> replyDel(@RequestParam Map<String, String> params){
		logger.info("삭제 요청");
		return service.replyDel(params);
	}
	
	//매칭쓰기페이지 이동
	@RequestMapping(value = "/matchWrite")
	public String matchWrite() {
		logger.info("매칭쓰기");
		return "matchWrite";
	}
	
	//매칭쓰기
	@RequestMapping(value = "/write")
	public ModelAndView write(@RequestParam Map<String, String> params) {
		logger.info("매칭쓰기");
		return service.write(params);
	}
	
	//매칭목록
	@RequestMapping(value = "/areaList")
	public @ResponseBody Map<String, ArrayList<AreaDto>> areaList(@RequestParam Map<String, String> params) {
		logger.info("매칭목록");
		return service.areaList(params);
	}
	
	//매칭쓰기
	@RequestMapping(value = "/areaMap")
	public ModelAndView areaMap(@RequestParam("lat") String lat) {
		logger.info("장소 결정");
		return service.areaMap(lat);
	}
	
	
	//매칭수정
	@RequestMapping(value = "/matchModify")
	public ModelAndView matchModify(@RequestParam("idx") int idx) {
		logger.info("매칭수정");
		modFlag=true;
		return service.detail(idx, modFlag);
	}
	//경기일정
	@RequestMapping(value = "/calendar")
	public String calendar() {
		
		return "calendar";
	}
}
