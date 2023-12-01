package com.practice.service;

import java.util.List;

import com.practice.domain.AttachDTO;
import com.practice.domain.BoardDTO;
import com.practice.domain.Criteria;

public interface BoardService {
	//전체 리스트 가져오기
	public List<BoardDTO> getList(Criteria cri);
	//글등록
	public boolean insert(BoardDTO dto);
	//특정 게시글 조회
	public BoardDTO getRow(int postId);
	//글수정
	public boolean update(BoardDTO dto);
	//글삭제
	public boolean delete(int postId);
	//전체 게시물 개수
	public int getTotalCnt(Criteria cri);	
	//첨부 파일 가져오기
	public List<AttachDTO> getAttachList(int postId);
}
