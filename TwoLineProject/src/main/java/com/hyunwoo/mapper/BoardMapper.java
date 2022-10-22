package com.hyunwoo.mapper;

import java.util.List;

import com.hyunwoo.domain.BoardVO;
import com.hyunwoo.domain.Criteria;

public interface BoardMapper {

	public List<BoardVO> getList();
	
	public List<BoardVO> getListWithPaging(Criteria cri);

	public void insert(BoardVO vo);
	
	public void insertSelectKey(BoardVO vo);
	
	public BoardVO read(Long bno);
	
	public int delete(Long bno);
	
	public int update(BoardVO vo);
	
	public int getTotalCount(Criteria cri);
	
}
