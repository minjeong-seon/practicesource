package com.practice.mapper;
//댓글 쿼리 매핑

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.practice.domain.Criteria;
import com.practice.domain.ReplyDTO;

@Mapper
public interface ReplyMapper {
	public ReplyDTO read(int replyId);
	public int insert(ReplyDTO dto);
	public List<ReplyDTO> listAll(@Param("cri") Criteria cri,@Param("postId") int postId);
	public int getCountBypostId(int postId);
	public int update(ReplyDTO dto);
	public int delete(int replyId);
	public int deleteAll(int postId);
}
