package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.DataDAO;
import com.example.demo.vo.DataVO;

@Service("com.example.demo.service.DataService")
public class DataService {
	@Autowired
	private DataDAO dataDAO;
	
	public List<DataVO> selectScheduleData(){
		return dataDAO.selectScheduleData();
	}
}
