package com.hyunwoo.mapper;

import java.util.List;

import com.hyunwoo.domain.BoardVO;

public interface BoardMapper {

	/* # ��ü �Խñ� ��ȸ */
	public List<BoardVO> getList();
	
	/* # �Խñ� ��� */
	public void insert(BoardVO vo);
	
	/* # SelectKey�� �̿��Ͽ� ������ bno �� �̸����� (bno ���� �������� �ڵ����� ��) */
	public void insertSelectKey(BoardVO vo);
	
	/* # Ư�� �Խñ� ��ȸ */
	public BoardVO read(Long bno);
	
	/* # �Խñ� ���� */
	public int delete(Long bno);
	
	/* # �Խñ� ���� */
	public int update(BoardVO vo);
	
}
