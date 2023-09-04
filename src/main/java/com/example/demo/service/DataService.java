package com.example.demo.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.DataDAO;
import com.mongodb.DBObject;
@Service("com.example.demo.service.DataService")
public class DataService {
	@Autowired
	private DataDAO dataDAO;
	
	public List<DBObject> selectScheduleData(){
		return dataDAO.selectScheduleData();
	}
	
	public int inputScheduleData(Map<String, Object> param){
		int ret = dataDAO.inputScheduleData(param);
		return ret;
	}
		
	public int updateScheduleData(Map<String, Object> param){
		int ret = dataDAO.updateScheduleData(param);
		return ret;
	}
	
	public int deleteScheduleData(Map<String, Object> param){
		int ret = dataDAO.deleteScheduleData(param);
		return ret;
	}
	

}
