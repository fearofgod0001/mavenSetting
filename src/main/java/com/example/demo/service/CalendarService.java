package com.example.demo.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.CalendarDAO;
import com.mongodb.DBObject;

@Service("com.example.demo.service.DataService")
public class CalendarService {
	@Autowired
	private CalendarDAO calendarDAO;
	
	public List<DBObject> selectScheduleData(){
		System.out.println(calendarDAO.selectScheduleData());
		return calendarDAO.selectScheduleData();
	}
	
	public int inputScheduleData(Map<String, Object> param){
		int ret = calendarDAO.inputScheduleData(param);
		return ret;
	}
		
	public int updateScheduleData(Map<String, Object> param){
		int ret = calendarDAO.updateScheduleData(param);
		return ret;
	}
	
	public int deleteScheduleData(Map<String, Object> param){
		int ret = calendarDAO.deleteScheduleData(param);
		return ret;
	}
	

}
