package com.example.demo.Dao;

import com.example.demo.Entity.RecordEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RecordDao {
    RecordEntity selectLatest();
    int updateLatest(RecordEntity entity);
    int deleteLatest();
    int add(RecordEntity entity);
}
