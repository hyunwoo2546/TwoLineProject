package com.hyunwoo.service;

import java.util.List;

import com.hyunwoo.domain.BoardVO;
import com.hyunwoo.domain.Criteria;

public interface BoardService {

	public void register(BoardVO vo);
	
	public BoardVO get(Long bno);
	
	public boolean modify(BoardVO vo);
	
	public boolean remove(Long bno);
	
	public List<BoardVO> getList(Criteria cri);
	
	public int getTotal(Criteria cri);
	
}
