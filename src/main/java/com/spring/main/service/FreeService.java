package com.spring.main.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import com.spring.main.dao.BoardInterface;
import com.spring.main.dto.freelistDTO;

@Service
public class FreeService {
	
	@Autowired
	SqlSession sqlSession;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	BoardInterface inter = null;

	//리스트 보여주기
	   public Map<String, Object> f_listCall(Map<String, String> params) {
	         Map<String, ArrayList<freelistDTO>> obj = 
	        		 new HashMap<String, ArrayList<freelistDTO>>();
	         Map<String, Object> json = new HashMap<String, Object>();
	         inter=sqlSession.getMapper(BoardInterface.class);
	         
	         int currPage=Integer.parseInt(params.get("page"));//현재 페이지
	         
	         int pagePerNum=Integer.parseInt(params.get("pagePerNum"));//페이지에 넣을 데이터 갯수
	         logger.info("자유리스트뛰움");
	         logger.info(currPage+"/"+pagePerNum);
	         
	         //게시물 시작과 끝 번호
	         int end=pagePerNum*currPage;
	         int start=end-pagePerNum+1;
	         int allCnt = inter.f_allCount();
	         
	         int totalPage=allCnt/pagePerNum;
	         System.out.println(totalPage%pagePerNum);
	         if(allCnt%pagePerNum!=0){
	            totalPage+=1;
	         }
	         logger.info("전체 개시물:{}",allCnt);
	         
	         obj.put("list", inter.f_listCall(start, end));
	         json.put("jsonList", obj);
	         json.put("currPage", currPage);
	         json.put("totalCount", allCnt);
	         json.put("totalPage", totalPage);
	         logger.info("자유리스트뛰움");
	         return json;
	      }

	   
	//리스트 검색
	public Map<String, Object> f_search(
			Map<String, String> params) {
		 Map<String, ArrayList<freelistDTO>> obj = 
				 new HashMap<String, ArrayList<freelistDTO>>();
         Map<String, Object> json = new HashMap<String, Object>();
         inter=sqlSession.getMapper(BoardInterface.class);
         
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
            allCnt = inter.f_searhCount(input, type);
            obj.put("list", inter.f_searhCall(start, end, input, type));
         }else{
            allCnt = inter.allCount();
            obj.put("list", inter.f_listCall(start, end));
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
	
	
		public Map<String, Object> f_searchCall(Map<String, String> params) {
			inter=sqlSession.getMapper(BoardInterface.class);
	         Map<String, Object> json = new HashMap<String, Object>();
	         String input=params.get("input");
	         String type=params.get("type");
	         int allCnt = inter.f_searhCount(input, type);
	         json.put("count", allCnt);

       
         return json;
      } 
		
		//상세보기
		@Transactional
		public ModelAndView contentView(String j_idx) {		
			inter = sqlSession.getMapper(BoardInterface.class);
			ModelAndView mav = new ModelAndView();
			
			//조회수
			inter.j_vcount(j_idx);
			//불러오기
			logger.info("상세보기");
			mav.addObject("content", inter.contentView(j_idx));
			mav.setViewName("contentView");		
			return mav;
		}
		
		//글쓰기(일반)
		public ModelAndView write(Map<String, String> params) {		
			inter = sqlSession.getMapper(BoardInterface.class);
			ModelAndView mav = new ModelAndView();		
			String j_title = params.get("j_title");
			String j_name = params.get("j_name");
			String j_content = params.get("j_content");		
			int success = inter.write(j_title, j_name, j_content);	
			String page = "freeList";
			String msg = "등록에 실패하였습니다.";	
			if(success == 1){
				msg = "등록에 성공 하였습니다.";
			}
			mav.addObject("msg", msg);
			mav.setViewName(page);		
			return mav;
		}
		
}

