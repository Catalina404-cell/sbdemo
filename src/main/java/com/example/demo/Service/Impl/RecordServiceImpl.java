package com.example.demo.Service.Impl;
import com.example.demo.Entity.RecordEntity;
import com.example.demo.Dto.RecordDto;
import com.example.demo.Dao.RecordDao;
import com.example.demo.Service.RecordService;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
@Service
public class RecordServiceImpl implements RecordService {
        private final RecordDao recordDao;
        public RecordServiceImpl(RecordDao recordDao){
            this.recordDao=recordDao;
        }
        //调用Dao记录把记录数据返回给Controller
        @Override//实现对应接口的方法
        public int add(RecordDto dto){
            RecordEntity entity=new RecordEntity();
            entity.setName(dto.getName());
            return recordDao.add(entity);
        }


        @Override
        public RecordDto selectLatest(){
            RecordEntity entity= recordDao.selectLatest();
            RecordDto dto=new RecordDto();
            if(entity==null){
                dto.setMessage("暂无记录");
            return dto;
            }
            dto.setId(entity.getId());
            dto.setVisitTime(entity.getVisitTime());
            dto.setName(entity.getName());
            return dto;
        }
        @Override
        public RecordDto selectById(RecordDto dto){
            RecordEntity entity=recordDao.selectById(dto.getId());
            RecordDto result=new RecordDto();
            if(entity==null){
                result.setMessage("记录不存在");
                return result;
            }

            result.setId(entity.getId());
            result.setName(entity.getName());
            result.setVisitTime(entity.getVisitTime());
            return result;
        }
        @Override
        public String updateLatest(RecordDto dto){
            if(recordDao.selectLatest()==null){
                return"暂无记录";
            }
            RecordEntity entity=new RecordEntity();
            entity.setName(dto.getName());
            recordDao.updateLatest(entity);//更新数据库
            return "最新记录已更新";
        }
        @Override
        public String deleteLatest(){
            int rows=recordDao.deleteLatest();
            if(rows==0){
                return "暂无记录";
            }
            return "已删除一条最新消息";
        }
        @Override
        public List<RecordDto> list(){
            List<RecordEntity> entities=recordDao.selectAll();
            List<RecordDto> results=new ArrayList<>();
            for(RecordEntity entity : entities){
                RecordDto dto=new RecordDto();
                dto.setId(entity.getId());
                dto.setVisitTime(entity.getVisitTime());
                dto.setName(entity.getName());
                results.add(dto);
            }
            return results;
        }

}
