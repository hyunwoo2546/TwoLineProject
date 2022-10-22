package com.hyunwoo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hyunwoo.domain.BoardVO;
import com.hyunwoo.domain.Criteria;
import com.hyunwoo.mapper.BoardMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@AllArgsConstructor
@Log4j
public class BoardServiceImpl implements BoardService{

	@Autowired
	private BoardMapper mapper;
	
	/* # �Խñ� ��� */
	@Override
	public void register(BoardVO vo) {
		
		log.info("�Խñ� ��� : " + vo);
		
		mapper.insertSelectKey(vo);
		
	}

	/* # �Խñ� ��ȸ */
	@Override
	public BoardVO get(Long bno) {
		
		log.info("��ȸ �Խñ� ��ȣ : " + bno);
		
		return mapper.read(bno);
	}

	/* # �Խñ� ���� */
	@Override
	public boolean modify(BoardVO vo) {
		
		log.info("�Խñ� ���� : " + vo);
		
		return mapper.update(vo) == 1;
	}

	/* # �Խñ� ���� */
	@Override
	public boolean remove(Long bno) {
		
		log.info("�Խñ� ���� ��ȣ : " + bno);		
		
		return mapper.delete(bno) == 1;
		
	}

	/* # ��ü �Խñ� ��ȸ */
	@Override
	public List<BoardVO> getList(Criteria cri) {
		
		log.info("�Խñ� ��ü ��ȸ.....");
		
		return mapper.getListWithPaging(cri);
	}
	
	@Override
	public int getTotal(Criteria cri) {
		return mapper.getTotalCount(cri);
	}
	
}
