package com.hyunwoo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hyunwoo.domain.BoardVO;
import com.hyunwoo.domain.Criteria;
import com.hyunwoo.domain.PageDTO;
import com.hyunwoo.service.BoardService;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/board/*")
public class BoardController {
	
	@Autowired
	private BoardService service;

	/* # 전체 게시글 조회 */
	@GetMapping("/list")
	public void list(Model model, Criteria cri) {
		log.info("전체 게시글 조회...");
		
		int total = service.getTotal(cri);
		
		model.addAttribute("list", service.getList(cri));
		model.addAttribute("pageMaker", new PageDTO(cri, total));
		
	}
	
	/* # 등록 페이지 */
	@GetMapping("/register")
	public void register() {
		log.info("등록 페이지 이동...");
	}
	
	/* # 게시글 등록 */
	@PostMapping("/register")
	public String register(BoardVO vo, RedirectAttributes rttr) {
		
		log.info("게시글 등록 : " + vo);
		
		service.register(vo);
		
		rttr.addFlashAttribute("result", vo.getBno());
		
		return "redirect:/board/list";
	}
	
	/* # 게시글 수정 페이지 */
	@GetMapping({"/get","/modify"})
	public void modify(@RequestParam("bno") Long bno, @ModelAttribute("cri") Criteria cri, Model model) {
		log.info("게시글 수정 페이지 이동...");
		
		model.addAttribute("board", service.get(bno));
	}
	
	/* # 게시글 수정 */
	@PostMapping("/modify")
	public String modify(BoardVO vo, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) {
		
		log.info("게시글 수정 : " + vo);
		
		if(service.modify(vo)) {
			rttr.addFlashAttribute("result", "success");
		}
		
		rttr.addAttribute("pageNum", cri.getPageNum());
		rttr.addAttribute("amount", cri.getAmount());
		
		return "redirect:/board/list";
	}
	
	/* # 게시글 삭제 */
	@PostMapping("/remove")
	public String remove(@RequestParam("bno") Long bno, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) {
		
		log.info("게시글 삭제 : " + bno);
		
		if(service.remove(bno)) {
			rttr.addFlashAttribute("result", "success");
		}
		
		rttr.addAttribute("pageNum", cri.getPageNum());
		rttr.addAttribute("amount", cri.getAmount());

		return "redirect:/board/list";
		
	}
	
	/* # 이미지 게시판 */
	@GetMapping("/img-board")
	public void test() {
		log.info("이미지 게시판 이동...");
	}

	
}
