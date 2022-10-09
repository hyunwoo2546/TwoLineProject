package com.hyunwoo.service;

import java.util.List;

import com.hyunwoo.domain.BoardVO;

public interface BoardService {

	/* # 게시글 등록 */
	public void register(BoardVO vo);
	
	/* # 게시글 조회*/
	public BoardVO get(Long bno);
	
	/* # 게시글 수정 */
	public boolean modify(BoardVO vo);
	
	/* # 게시글 삭제 */
	public boolean remove(Long bno);
	
	/* # 전체 게시글 조회 */
	public List<BoardVO> getList();
	
}
