package com.example.demo.dao;



import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.example.demo.vo.DataVO;
import com.mongodb.DBObject;

@Repository("com.example.demo.dao.DataDAO")
@Mapper
public interface DataDAO {
    @Insert("INSERT INTO scheduleinfo(user_id, todo_memo, todo_date) VALUES(#{dataVO.user_id}, #{dataVO.todo_memo}, #{dataVO.todo_date})")
    int insert(@Param("dataVO") DataVO dataVO); 

    @Select("SELECT user_id, todo_memo, TO_CHAR(todo_date, 'YYYY-MM-DD') AS todo_date FROM scheduleinfo")
    @Results({
            @Result(property = "user_id", column = "user_id"),
            @Result(property = "todo_memo", column = "todo_memo"),
            @Result(property = "todo_date", column = "todo_date")
    })
    List<DataVO> getAll();
    
    @Delete("DELETE FROM scheduleinfo WHERE user_id=#{dataVO.user_id} and DBMS_LOB.COMPARE(todo_memo, #{dataVO.todo_memo}) = 0 and todo_date=#{dataVO.todo_date}")
    int delete(@Param("dataVO") DataVO dataVO);
    
    @Update("UPDATE scheduleinfo SET todo_memo=#{dataVO.todo_memo} WHERE user_id=#{dataVO.user_id} and todo_date=#{dataVO.todo_date}")
    int update(@Param("dataVO") DataVO dataVO);
    
    //xml방식
    
    public List<DBObject> selectScheduleData();
    
    public int inputScheduleData(Map<String,Object> param);
    
    public int deleteScheduleData(Map<String,Object> param);
    
    public int updateScheduleData(Map<String,Object> param);
    
    
    
   
}

