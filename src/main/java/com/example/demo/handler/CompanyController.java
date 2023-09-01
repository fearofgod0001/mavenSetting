package com.example.demo.handler;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.DataDAO;
import com.example.demo.service.DataService;
import com.example.demo.vo.DataVO;

@RestController
@CrossOrigin(origins = "http://portal.rayful.com")
public class CompanyController {
    @Autowired
    private DataDAO dataDAO;
    
    @Autowired
    private DataService dataService;
    
    @GetMapping("/api/v1/calendar/scadule")
    public List<DataVO>getAll() {
    	System.out.println("여기는 컨트롤러 전체 가져오기" );
        return dataDAO.getAll();
    }
    
    @PostMapping("/api/v1/calendar/inputdate")
    public int post(@RequestBody DataVO dataVO) {
    	System.out.println("여기는 컨트롤러" + dataVO);
        return dataDAO.insert(dataVO);
    }
    
    @PostMapping("/api/v1/calendar/deletedate")
    public int postdelete(@RequestBody DataVO dataVO) {
    	System.out.println("여기는 컨트롤러" + dataVO);
        return dataDAO.delete(dataVO);
    }
    
    @PostMapping("/api/v1/calendar/updatedate")
    public int postupdate(@RequestBody DataVO dataVO) {
    	System.out.println("여기는 컨트롤러" + dataVO);
        return dataDAO.update(dataVO);
    }
    
    @GetMapping("/api/v1/calendar/testselect")
    public List<DataVO> selectScheduleData(){
		return dataService.selectScheduleData();
    	
    }

}
