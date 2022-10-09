package com.hyunwoo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hyunwoo.domain.BoardVO;
import com.hyunwoo.mapper.BoardMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@AllArgsConstructor
@Log4j
public class BoardServiceImpl implements BoardService{

	@Autowired
	private BoardMapper mapper;
	
	/* # 게시글 등록 */
	@Override
	public void register(BoardVO vo) {
		
		log.info("게시글 등록 : " + vo);
		
		mapper.insertSelectKey(vo);
		
	}

	/* # 게시글 조회 */
	@Override
	public BoardVO get(Long bno) {
		
		log.info("조회 게시글 번호 : " + bno);
		
		return mapper.read(bno);
	}

	/* # 게시글 수정 */
	@Override
	public boolean modify(BoardVO vo) {
		
		log.info("게시글 수정 : " + vo);
		
		return mapper.update(vo) == 1;
	}

	/* # 게시글 삭제 */
	@Override
	public boolean remove(Long bno) {
		
		log.info("게시글 삭제 번호 : " + bno);		
		
		return mapper.delete(bno) == 1;
		
	}

	/* # 전체 게시글 조회 */
	@Override
	public List<BoardVO> getList() {
		
		log.info("게시글 전체 조회.....");
		
		return mapper.getList();
	}
	
}
