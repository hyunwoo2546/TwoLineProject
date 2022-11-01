package com.hyunwoo.service;

import java.util.List;

import com.hyunwoo.domain.Criteria;
import com.hyunwoo.domain.ReplyVO;

public interface ReplyService {

	public int register(ReplyVO vo);
	
	public ReplyVO get(Long rno);
	
	public int modify(ReplyVO vo);
	
	public int remove(Long rno);
	
	public List<ReplyVO> getList(Criteria cri, Long bno);
	
}
