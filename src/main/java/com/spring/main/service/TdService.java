package com.spring.main.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.spring.main.dao.TdInterface;
import com.spring.main.dao.TeamInterface;
import com.spring.main.dto.MemberDto;
import com.spring.main.dto.TdDto;
import com.spring.main.util.FileUpload;

@Service
public class TdService {

	@Autowired
	SqlSession sqlSession;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	TdInterface inter = null;
	TeamInterface team = null;
	
	//팀일지 리스트 팀정보
	public ModelAndView tdList(String t_idx) {
		
		team = sqlSession.getMapper(TeamInterface.class);
		ModelAndView mav = new ModelAndView();

		mav.addObject("team",team.teamDetail(t_idx));
		mav.addObject("evalue",team.evalueCall(t_idx));
		mav.addObject("ent",team.entCall(t_idx));
		mav.addObject("member",team.memberCall(t_idx));
		mav.addObject("meCnt",team.memberCount(t_idx));
		mav.setViewName("tdList");
		
		return mav;
	}
	
	//리스트 불러오기
	public Map<String, Object> listCall(Map<String, String> params) {
		inter = sqlSession.getMapper(TdInterface.class);
		Map<String, Object> json = new HashMap<String, Object>();
		Map<String, ArrayList<TdDto>> obj = new HashMap<String, ArrayList<TdDto>>();
		
		//현재 페이지
		int currPage = Integer.parseInt(params.get("page"));
		//페이지당 보여 줄 게시물 갯수
		int pagePerNum = Integer.parseInt(params.get("pagePerNum"));
		logger.info("현재 페이지: {}",currPage);
		logger.info("페이지 당 보여줄 수: {}",pagePerNum);
		int end = currPage*pagePerNum;	//게시물 끝번호
		int start = end-pagePerNum+1;	//게시물 시작번호
		int allCnt = 0;
		String j_category = params.get("j_category");
		String type = params.get("type");
		String value = params.get("value");
		logger.info(value);
		if(value!=""){
			allCnt = inter.searchCount(j_category,type,value); //전체 게시물 수
			obj.put("list", inter.search(start,end,j_category,type,value));
			logger.info("검색");
		}else{
			allCnt = inter.allCount(j_category);			//전체 게시물 수
			obj.put("list", inter.listCall(start,end,j_category));
			logger.info("리스트");
		}
		logger.info("전체게시물 수: {}",allCnt);
		int page = allCnt%pagePerNum >0 ?
				Math.round(allCnt/pagePerNum)+1:Math.round(allCnt/pagePerNum);//생성 할 수 있는 페이지
		
		json.put("jsonList", obj);
		json.put("currPage", currPage);
		json.put("allCnt", allCnt);
		json.put("page", page);
		return json;
	}
	
	/*//파일 업로드
	public  Map<String, Object> fileUP(MultipartHttpServletRequest multi) {
		inter = sqlSession.getMapper(TdInterface.class);
		Map<String, Object> json = new HashMap<String, Object>();
		String j_category = multi.getParameter("idx");
		String fileName = multi.getParameter("fileName");
		logger.info(fileName);
		String newFileName = null;
		if(fileName !=null){
			//파일 업로드
			FileUpload upload = new FileUpload();
			newFileName = upload.fileUp(multi);
		}
		int success = inter.fileUp(j_category,fileName,newFileName);
		
		
		json.put("file", success);
		return json;
	}*/

	//글쓰기(파일 업로드)
		public ModelAndView write(MultipartHttpServletRequest multi) {
			inter = sqlSession.getMapper(TdInterface.class);
			ModelAndView mav = new ModelAndView();
			String u_idx = multi.getParameter("u_idx");
			String j_category = multi.getParameter("j_category");
			String j_title = multi.getParameter("j_title");
			String j_content = multi.getParameter("j_content");
			String j_name = multi.getParameter("j_name");
			String fileName = multi.getParameter("fileName");
			String tf = multi.getParameter("tf");
			if(tf!=""){
				String p_date = multi.getParameter("p_date");
				String[] p_goal = multi.getParameterValues("p_goal[]");
				String[] p_assist = multi.getParameterValues("p_assist[]");
				String[] p_shoot = multi.getParameterValues("p_shoot[]");
				String[] p_poul = multi.getParameterValues("p_poul[]");
				String[] p_warning = multi.getParameterValues("p_warning[]");
				String[] p_off = multi.getParameterValues("p_off[]");
				String[] p_ck = multi.getParameterValues("p_ck[]");
				String[] p_pk = multi.getParameterValues("p_pk[]");
				String[] p_offside = multi.getParameterValues("p_offside[]");
				String[] p_effectshot = multi.getParameterValues("p_effectshot[]");
				String[] chk = multi.getParameterValues("chk[]");
				for(int i=0; i<chk.length; i++){
				StringTokenizer tokens = new StringTokenizer(chk[i]);
		        String m_idx = tokens.nextToken("/") ;
		        String u_idxm = tokens.nextToken("/") ;
		        int p_atkpoint = Integer.parseInt(p_goal[i])+Integer.parseInt(p_assist[i]);
		        logger.info(m_idx+"/"+u_idxm);
				inter.record(m_idx,p_offside[i],p_effectshot[i],p_goal[i],p_assist[i],p_atkpoint,p_shoot[i],p_poul[i],p_warning[i],p_off[i],p_ck[i],p_pk[i],p_date);
				inter.point(p_atkpoint,u_idxm);
				}
			}
			Map<String, ArrayList<String>> newFile = new HashMap<String, ArrayList<String>>();
			if(fileName !=null){
				//파일 업로드
				FileUpload upload = new FileUpload();
				newFile = upload.fileUp(multi);
			}
			ArrayList<String> oldName = newFile.get("oldName");
			ArrayList<String> newName = newFile.get("newName");
			int idx = inter.idxCall();
			logger.info(j_title+"/"+j_content+"/"+j_name+"/"+fileName);
			inter.write(idx,u_idx,j_category,j_name, j_title, j_content);
			for(int i=0; i<newName.size(); i++){
				inter.fileUp(idx,j_category, oldName.get(i),newName.get(i));
			}
			String t_idx = j_category.substring(1);
			mav.setViewName("redirect:../td/tdList?t_idx="+t_idx);
			return mav;
		}

		//멤버정보 가져오기
		public Map<String, Object> member(String t_idx) {
			inter = sqlSession.getMapper(TdInterface.class);
			Map<String, Object> json = new HashMap<String, Object>();
			Map<String, ArrayList<MemberDto>> obj = new HashMap<String, ArrayList<MemberDto>>();


			obj.put("list", inter.member(t_idx));
			json.put("jsonList", obj);
			return json;
		}

		


}
