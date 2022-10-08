package com.hyunwoo.mapper;

import java.util.List;

import com.hyunwoo.domain.BoardVO;

public interface BoardMapper {

	/* # 전체 게시글 조회 */
	public List<BoardVO> getList();
	
	/* # 게시글 등록 */
	public void insert(BoardVO vo);
	
	/* # SelectKey를 이용하여 사전에 bno 값 미리보기 (bno 값은 시퀀스로 자동증가 값) */
	public void insertSelectKey(BoardVO vo);
	
	/* # 특정 게시글 조회 */
	public BoardVO read(Long bno);
	
	/* # 게시글 삭제 */
	public int delete(Long bno);
	
	/* # 게시글 수정 */
	public int update(BoardVO vo);
	
}
