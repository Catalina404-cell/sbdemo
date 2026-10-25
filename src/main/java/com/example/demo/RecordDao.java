package com.example.demo;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class RecordDao {

    private final JdbcTemplate jdbcTemplate;
    public RecordDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate=jdbcTemplate;
    }
    //新增记录执行插入语句
    public int add(){
        String sql="INSERT INTO record (visit_time) VALUES (NOW())";
        return jdbcTemplate.update(sql);
    }
    public Map<String, Object> selectLatest(){
        String sql= """
                SELECT id, visit_time
                FROM record
                ORDER BY id DESC
                LIMIT 1
                """;
        List<Map<String, Object>> rows=jdbcTemplate.queryForList((sql));
        if(rows.isEmpty()){
            return null;
        }
        return rows.get(0);//返回查询结果第一条
    }
    public int updateLatest(){
        String sql= """
                UPDATE record
                SET visit_time=NOW()
                ORDER BY id DESC
                LIMIT 1
                """;
        return  jdbcTemplate.update(sql);
    }
    public int deleteLatest(){
        String sql= """
                DELETE FROM record
                ORDER BY id DESC
                LIMIT 1
                """;
        return jdbcTemplate.update(sql);
    }
}
