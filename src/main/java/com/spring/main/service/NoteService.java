package com.spring.main.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.spring.main.dao.MatchInterface;
import com.spring.main.dao.NoteInterface;
import com.spring.main.dto.MatchDto;
import com.spring.main.dto.NoteDto;

@Service
public class NoteService {

	@Autowired
	SqlSession sqlSession;
	
	NoteInterface inter=null;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	public ModelAndView msgPage(String t_idx) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("idx",t_idx);
		mav.setViewName("msgpage");
		return mav;
	}
	
	
	public Map<String, Object> searchCall(Map<String, String> params) {
		Map<String, ArrayList<NoteDto>> obj = new HashMap<String, ArrayList<NoteDto>>();
		Map<String, Object> json = new HashMap<String, Object>();
		inter=sqlSession.getMapper(NoteInterface.class);
		
		int currPage=Integer.parseInt(params.get("page"));//현재 페이지
		
		int pagePerNum=Integer.parseInt(params.get("pagePerNum"));//페이지에 넣을 데이터 갯수
		
		String input = params.get("input");
		String type = params.get("type");
		
		logger.info(currPage+"/"+pagePerNum+"/"+input);
		
		//게시물 시작과 끝 번호
		int end=pagePerNum*currPage;
		int start=end-pagePerNum+1;
		int allCnt=0;
		if(input!=""){
			allCnt = inter.note_searhCount(input, type);
			obj.put("list", inter.note_searhCall(start, end, input, type));
		}else{
			allCnt = inter.note_allCount();
			obj.put("list", inter.note_listCall(start, end));
		}
		int totalPage=allCnt/pagePerNum;
		System.out.println(totalPage%pagePerNum);
		if(allCnt%pagePerNum!=0){
			totalPage+=1;
		}
		logger.info("전체 개시물:{}",allCnt);
		logger.info("전체 개시물:{}",allCnt);
		logger.info("전체 개시물:{}",allCnt);
		logger.info("전체 개시물:{}",allCnt);
		json.put("jsonList", obj);
		json.put("currPage", currPage);
		json.put("totalCount", allCnt);
		json.put("totalPage", totalPage);
		
		return json;
	}


	public Map<String, Object> search(Map<String, String> params) {
		inter=sqlSession.getMapper(NoteInterface.class);
		Map<String, Object> json = new HashMap<String, Object>();
		String input=params.get("input");
		String type=params.get("type");
		int allCnt = inter.note_searhCount(input, type);
		json.put("count", allCnt);
		return json;
	}


	public Map<String, ArrayList<NoteDto>> newListCall(String idx) {
		inter=sqlSession.getMapper(NoteInterface.class);
		Map<String, ArrayList<NoteDto>> map =  new HashMap<String, ArrayList<NoteDto>>();
		String idx0="0";
		String idx1="0";
		String idx2="0";
		String[] idxs = idx.split(" ");
		for(int i=0; i<idxs.length; i++){
			if(i==0){
				idx0=idxs[i];
			}else if(i==1){
				idx1=idxs[i];
			}else{
				idx2=idxs[i];
			}
		}
		logger.info(idx0+"/"+idx1+"/"+idx2);
		map.put("list", inter.newListCall(idx0, idx1, idx2));
		return map;
	}
}
