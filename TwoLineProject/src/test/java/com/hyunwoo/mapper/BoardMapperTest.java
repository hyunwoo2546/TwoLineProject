package com.hyunwoo.mapper;

import java.util.List;

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
		
		vo.setTitle("���ο� ����");
		vo.setContent("���ο� ����");
		vo.setWriter("���ο� �ۼ���");
		
		mapper.insert(vo);
	}
	
	@Test
	public void testInsertSelectKey() {
		
		BoardVO vo = new BoardVO();
		
		vo.setTitle("���ο� ����");
		vo.setContent("���ο� ����");
		vo.setWriter("���ο� �ۼ���");
		
		mapper.insertSelectKey(vo);
	}
	
	@Test
	public void testRead() {
		
		log.info("��ȸ�� �Խù� : " + mapper.read(1L));
		
	}
	
	@Test
	public void testDelete() {
		
		log.info("������ �Խñ��� ��ȣ : " + mapper.delete(1L));
		
	}
	
	@Test
	public void testUpdate() {
		
		BoardVO vo = new BoardVO();
		
		vo.setBno(3L);
		vo.setTitle("���� ����");
		vo.setContent("���� ����");
		vo.setWriter("�ۼ��� ����");
		
		int count = mapper.update(vo);
		
		log.info("UPDATE COUNT : " + count);
		
	}
	
	@Test
	public void testPaging() {
		
		List<BoardVO> list = mapper.getList();
		
		list.forEach(board -> log.info(board.getBno()));
		
	}
	
}
