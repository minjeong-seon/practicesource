package com.practice.mapper;
//게시판 관련 쿼리 매핑
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.practice.domain.BoardDTO;
import com.practice.domain.Criteria;

@Mapper
public interface BoardMapper {
	public List<BoardDTO> list(Criteria cri);
	public int insert(BoardDTO dto);
	public BoardDTO get(int postId);
	public int update(BoardDTO dto);
	public int delete(int postId);
	public int totalCnt(Criteria cri);
	public int updateReplyCnt(@Param("postId")int postId, @Param("amount")int amount);
	
	//상세조회 + 파일정보
	public BoardDTO readAttach(int postId);
}
