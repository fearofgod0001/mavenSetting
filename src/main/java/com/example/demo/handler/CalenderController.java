package com.example.demo.handler;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.CalendarService;


@RestController
@CrossOrigin(origins = "http://portal.rayful.com")
public class CalenderController {
 
    
    @Autowired
    private CalendarService calendarService;
    
//  컨트롤러 Mapper 방식    
    @GetMapping("/api/v1/calendar/testselect")
    public  ResponseEntity<?> selectScheduleData(){
    	System.out.println("여기는 컨트롤러 mapper방식 testselect" );
		return ResponseEntity.ok(calendarService.selectScheduleData());    	
    }
    
    @PostMapping("/api/v1/calendar/testinputdate")
    public ResponseEntity<?> inputScheduleData(@RequestBody  Map<String, Object> bodyParam) {
    	System.out.println(bodyParam);
    	Map<String,Object> param = (Map<String,Object>)bodyParam.get("param");	
     	System.out.println("컨트롤러 파람 : " + param);
     	calendarService.inputScheduleData(param);
        return ResponseEntity.ok(bodyParam);
    }
    
    @PostMapping("/api/v1/calendar/testupdatedate")
    public ResponseEntity<?> updateScheduleData(@RequestBody  Map<String, Object> bodyParam) {    
    	Map<String,Object> param = (Map<String,Object>)bodyParam.get("param");	
    	System.out.println("컨트롤러 업데이트 파람 값 : " + param);
    	calendarService.updateScheduleData(param);
        return ResponseEntity.ok(bodyParam);
    }
    
    @PostMapping("/api/v1/calendar/testdeletedate")
    public ResponseEntity<?> deleteScheduleData(@RequestBody  Map<String, Object> bodyParam) {
    	Map<String,Object> param = (Map<String,Object>)bodyParam.get("param");	
    	calendarService.deleteScheduleData(param);
        return ResponseEntity.ok(bodyParam);
    }
    
    

    
    

}
