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
    
//    @GetMapping("/api/v1/calendar/scadule")
//    public List<DataVO>getAll() {
//    	System.out.println("여기는 컨트롤러 DAO쿼리문 방식" );
//        return dataDAO.getAll();
//    }
//    
//    @PostMapping("/api/v1/calendar/inputdate")
//    public int post(@RequestBody DataVO dataVO) {
//    	System.out.println("여기는 컨트롤러" + dataVO);
//        return dataDAO.insert(dataVO);
//    }
//    
//    @PostMapping("/api/v1/calendar/deletedate")
//    public int postdelete(@RequestBody DataVO dataVO) {
//    	System.out.println("여기는 컨트롤러" + dataVO);
//        return dataDAO.delete(dataVO);
//    }
//    
//    @PostMapping("/api/v1/calendar/updatedate")
//    public int postupdate(@RequestBody DataVO dataVO) {
//    	System.out.println("여기는 컨트롤러" + dataVO);
//        return dataDAO.update(dataVO);
//    }
//    
    
//  컨트롤러 Mapper 방식    
    @GetMapping("/api/v1/calendar/testselect")
    public  ResponseEntity<?> selectScheduleData(){
    	System.out.println("여기는 컨트롤러 mapper방식 testselect" );
		return ResponseEntity.ok(dataService.selectScheduleData());    	
    }
    
    @PostMapping("/api/v1/calendar/testinputdate")
    public ResponseEntity<?> inputScheduleData(@RequestBody  Map<String, Object> bodyParam) {
    	System.out.println(bodyParam);
    	Map<String,Object> param = (Map<String,Object>)bodyParam.get("param");	
     	System.out.println("컨트롤러 파람 : " + param);
    	dataService.inputScheduleData(param);
        return ResponseEntity.ok(bodyParam);
    }
    
    @PostMapping("/api/v1/calendar/testupdatedate")
    public ResponseEntity<?> updateScheduleData(@RequestBody  Map<String, Object> bodyParam) {    
    	Map<String,Object> param = (Map<String,Object>)bodyParam.get("param");	
    	System.out.println("컨트롤러 업데이트 파람 값 : " + param);
    	dataService.updateScheduleData(param);
        return ResponseEntity.ok(bodyParam);
    }
    
    @PostMapping("/api/v1/calendar/testdeletedate")
    public ResponseEntity<?> deleteScheduleData(@RequestBody  Map<String, Object> bodyParam) {
    	Map<String,Object> param = (Map<String,Object>)bodyParam.get("param");	
    	dataService.deleteScheduleData(param);
        return ResponseEntity.ok(bodyParam);
    }
    
    

    
    

}
