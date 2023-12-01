package com.practice.service;

import java.util.List;

import com.practice.domain.Criteria;
import com.practice.domain.ReplyDTO;
import com.practice.domain.ReplyPageDTO;

public interface ReplyService {
	public ReplyDTO read(int replyId);
	public boolean insert(ReplyDTO dto);
	//댓글 목록만 처리
	//public List<ReplyDTO> getList(Criteria cri, int bno);
	
	//댓글 총 수, 댓글 목록 처리
	public ReplyPageDTO getList(Criteria cri, int postId);
	public boolean update(ReplyDTO dto);
	public boolean delete(int replyId);
}
