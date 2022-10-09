package com.hyunwoo.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hyunwoo.domain.BoardVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardServiceTests {

	@Autowired
	private BoardService service;
	
	@Test
	public void testExist() {
		log.info("서비스 객체 : " + service);
	}
	
	@Test
	public void testRegister() {
		BoardVO vo = new BoardVO();
		
		vo.setTitle("서비스 테스트");
		vo.setContent("서비스 테스트");
		vo.setWriter("강현우");
		
		log.info("Service...... 등록!" + vo);
		
		service.register(vo);

	}
	
	@Test
	public void testGet() {
		BoardVO vo = service.get(21L);
		
		log.info(vo);
		
	}
	
	@Test
	public void testModify() {
		BoardVO vo = service.get(21L);
		
		if(vo == null) {
			return;
		}
		
		vo.setTitle("수정 서비스 테스트");
		vo.setContent("수정 서비스 테스트");
		vo.setWriter("수정 강현우");
		
		log.info("게시글 수정 : " + service.modify(vo));
		
	}
	
	@Test
	public void testRemove() {
		
		BoardVO vo = service.get(21L);
		
		if(vo == null) {
			return;
		}
		
		log.info("게시글 삭제 번호 : " + service.remove(21L));
	}
	
}
