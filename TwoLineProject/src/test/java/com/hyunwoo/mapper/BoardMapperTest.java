package com.hyunwoo.mapper;

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
public class BoardMapperTest {

	@Autowired
	private BoardMapper mapper;
	
	@Test
	public void testGetList() {
		mapper.getList().forEach(board -> log.info(board));
	}
	
	@Test
	public void testInsert() {
		
		BoardVO vo = new BoardVO();
		
		vo.setTitle("새로운 제목");
		vo.setContent("새로운 내용");
		vo.setWriter("새로운 작성자");
		
		mapper.insert(vo);
	}
	
	@Test
	public void testInsertSelectKey() {
		
		BoardVO vo = new BoardVO();
		
		vo.setTitle("새로운 제목");
		vo.setContent("새로운 내용");
		vo.setWriter("새로운 작성자");
		
		mapper.insertSelectKey(vo);
	}
	
	@Test
	public void testRead() {
		
		log.info("조회한 게시물 : " + mapper.read(1L));
		
	}
	
	@Test
	public void testDelete() {
		
		log.info("삭제한 게시글의 번호 : " + mapper.delete(1L));
		
	}
	
	@Test
	public void testUpdate() {
		
		BoardVO vo = new BoardVO();
		
		vo.setBno(3L);
		vo.setTitle("제목 수정");
		vo.setContent("내용 수정");
		vo.setWriter("작성자 변경");
		
		int count = mapper.update(vo);
		
		log.info("UPDATE COUNT : " + count);
		
		
	}
	
}
