package com.example.demo.Dao;
import org.apache.ibatis.annotations.Param;
import com.example.demo.Entity.RecordEntity;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
@Mapper
public interface RecordDao {
    RecordEntity selectLatest();

    int updateLatest(RecordEntity entity);

    int deleteLatest();

    int add(RecordEntity entity);

    RecordEntity selectById(@Param("id") Long id);
    List<RecordEntity> selectAll();
}