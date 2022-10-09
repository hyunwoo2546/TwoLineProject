package com.hyunwoo.service;

import java.util.List;

import com.hyunwoo.domain.BoardVO;

public interface BoardService {

	/* # �Խñ� ��� */
	public void register(BoardVO vo);
	
	/* # �Խñ� ��ȸ*/
	public BoardVO get(Long bno);
	
	/* # �Խñ� ���� */
	public boolean modify(BoardVO vo);
	
	/* # �Խñ� ���� */
	public boolean remove(Long bno);
	
	/* # ��ü �Խñ� ��ȸ */
	public List<BoardVO> getList();
	
}
