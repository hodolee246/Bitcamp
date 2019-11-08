package bit.com.bbs.controller;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import bit.com.bbs.model.BbsDto;
import bit.com.bbs.model.BbsParam;
import bit.com.bbs.service.BbsService;

@Controller
public class BbsController {
	
	private static final Logger logger = LoggerFactory.getLogger(BbsController.class);
	
	@Autowired
	private BbsService bbsService;
	
	@RequestMapping(value = "loginSuc.do", method = RequestMethod.GET)
	public String bbsList(Model model) {
		
		logger.info("BbsController bbsList() " + new Date());

		BbsParam param = new BbsParam();
		
		param.setNum(1);
		param.setNum2(10);
		
		List<BbsDto> list = bbsService.bbsPaging(param);
		
		List<BbsDto> allList = bbsService.allList(); 

		model.addAttribute("list", list);
		model.addAttribute("allList", allList);
		
		return "bbs/bbsList";
		
	}
	
	@RequestMapping(value = "bbsDetail.do", method = RequestMethod.GET)
	public String bbsDetail(Model model, int seq) {
		
		logger.info("BbsController BbsDetail() " + new Date());
		logger.info("seq :" + seq);
		BbsDto bbs = new BbsDto();
		
		boolean b = bbsService.upReadcount(seq);

		bbs = bbsService.listDetail(seq);
		
		logger.info("BbsController tostring" + bbs.toString());
		
		
		if(b) {
			logger.info("Readcount Suc");
		}else {
			logger.info("Readcount fail");
		}
		
		model.addAttribute("dto", bbs);
		
		return "bbs/bbsDetail";
		
	}
	
	@RequestMapping(value = "upBbs.do", method = RequestMethod.GET)
	public String upBbs(Model model, BbsDto bbs) {
		
		logger.info("BbsController upBbs() " + new Date());
		logger.info("BbsController tostring" + bbs.toString());
		
		boolean b = bbsService.upBbs(bbs);
		
		if(b) {
			logger.info("BbsController 수정 성공");
		}else {
			logger.info("BbsController 수정 실패");
		}
		
		return "redirect:loginSuc.do";
	
	}
	
	@RequestMapping(value = "delBbs.do", method = RequestMethod.GET)
	public String delBbs(Model model, int seq) {
		
		logger.info("BbsController delBbs() " + new Date());
		logger.info("BbsController seq" + seq);
		
		boolean b = bbsService.delBbs(seq);
		
		if(b) {
			logger.info("BbsController 삭제 성공");
		}else {
			logger.info("BbsController 삭제 실패");
		}
		
		
		
		return "redirect:loginSuc.do";
	
	}
	
	@RequestMapping(value = "writeBbsPage.do", method = RequestMethod.GET)
	public String writeBbsPage() {
		
		logger.info("BbsController writeBbsPage() " + new Date());
		
		return "bbs/writeBbs";
	
	}
	
	@RequestMapping(value = "writeBbs.do", method = RequestMethod.GET)
	public String writeBbsAf(Model model, BbsDto bbs) {
		
		logger.info("BbsController writeBbs() " + new Date());
		logger.info("BbsController tostring() " + bbs.toString() + new Date());
		
		
		boolean b = bbsService.wrtieBbs(bbs);
		
		if(b) {
			logger.info("BbsController 입력 성공");
		}else {
			logger.info("BbsController 입력 실패");
		}

		
		return "redirect:loginSuc.do";
	
	}
	
	@RequestMapping(value = "searchBbs.do", method = RequestMethod.GET)
	public String searchBbs(Model model, BbsParam param) {
		
		logger.info("BbsController searchBbs() " + new Date());
		
		param.setNum(1);
		param.setNum2(10);
		
		logger.info("BbsController tostring() " + param.toString() + new Date());
		
		List<BbsDto> list = bbsService.searchBbs(param);		
		List<BbsDto> allList = bbsService.searchBbsPaging(param);
		
		model.addAttribute("allList", allList);
		model.addAttribute("list", list);
		
		return "bbs/bbsList";
	
	}
	
	@RequestMapping(value = "bbsPaging.do", method = RequestMethod.GET)
	public String bbsPaging(Model model, BbsParam param) {
		
		logger.info("BbsController searchBbs() " + new Date());
		logger.info("BbsController num() " + param.getNum() + new Date());
		
		
		
		param.setNum2(param.getNum() * 10);
		param.setNum(param.getNum2() -9);
		
		logger.info(param.toString());
		
		List<BbsDto> allList = bbsService.searchBbsPaging(param);
		List<BbsDto> list = bbsService.searchBbs(param);
		
		model.addAttribute("list", list);
		model.addAttribute("allList", allList);
		
		return "bbs/bbsList";
	
	}
}