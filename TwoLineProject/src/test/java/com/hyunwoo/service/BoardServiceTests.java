package com.hyunwoo.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hyunwoo.domain.BoardVO;
import com.hyunwoo.domain.Criteria;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardServiceTests {

	@Autowired
	private BoardService service;
	
	@Test
	public void testExist() {
		log.info("���� ��ü : " + service);
	}
	
	@Test
	public void testRegister() {
		BoardVO vo = new BoardVO();
		
		vo.setTitle("���� �׽�Ʈ");
		vo.setContent("���� �׽�Ʈ");
		vo.setWriter("������");
		
		log.info("Service...... ���!" + vo);
		
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
		
		vo.setTitle("���� ���� �׽�Ʈ");
		vo.setContent("���� ���� �׽�Ʈ");
		vo.setWriter("���� ������");
		
		log.info("�Խñ� ���� : " + service.modify(vo));
		
	}
	
	@Test
	public void testRemove() {
		
		BoardVO vo = service.get(21L);
		
		if(vo == null) {
			return;
		}
		
		log.info("�Խñ� ���� ��ȣ : " + service.remove(21L)); 
	}
	
	@Test
	public void testGetList() {
//		service.getList().forEach(board -> log.info(board));
		service.getList(new Criteria(2,10)).forEach(board -> log.info(board));
	}
	
}
