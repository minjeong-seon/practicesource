package com.practice.mapper;
//게시글 첨부파일 쿼리 매핑

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.practice.domain.AttachDTO;

@Mapper
public interface AttachMapper {
	public int insert(AttachDTO dto);	//첨부파일 등록
	public List<AttachDTO> select(int postId);	//첨부파일 목록 조회
	public int deleteAll(int postId);	//첨부파일 전체 삭제
	
	public List<AttachDTO> oldFiles();	//어제 날짜 첨부파일 목록 조회
}
