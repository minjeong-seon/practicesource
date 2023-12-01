package com.practice.service;

import java.util.List;

import com.practice.domain.Criteria;
import com.practice.domain.RegisterRstrntDTO;

public interface RegisterRstrntService {
	public boolean sendRequest(RegisterRstrntDTO dto);
	public RegisterRstrntDTO readRequest(int reqId);
	public List<RegisterRstrntDTO> listRequest();
	public boolean deleteRequest(int reqId);

}
