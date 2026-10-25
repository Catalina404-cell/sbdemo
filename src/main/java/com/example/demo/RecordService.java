package com.example.demo;


import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class RecordService {
    private final RecordDao recordDao;
    public RecordService(RecordDao recordDao){
        this.recordDao=recordDao;
    }
    //调用Dao记录把记录数据返回给Controller
    public int add(){
        return recordDao.add();
    }

    public Map<String,Object> selectLatest(){
        return recordDao.selectLatest();
    }

    public String updateLatest(){
        if(recordDao.selectLatest()==null){
            return"暂无记录";
        }
        recordDao.updateLatest();//更新数据库
        return "最新记录时间已更新";
    }
    public String deleteLatest(){
        int rows=recordDao.deleteLatest();
        if(rows==0){
            return "暂无记录";
        }
        return "已删除一条最新消息";
    }

}
