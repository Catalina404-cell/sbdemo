package com.example.demo.Controller;
import java.util.Map;
import com.example.demo.RecordService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/record")//公共路径前缀
public class RecordController {
    private final RecordService recordService;
    public RecordController(RecordService recordService){
        this.recordService=recordService;
    }
    @GetMapping("/add")
    public String add(){
        int rows=recordService.add();
        return "新增成功，增加了"+rows+"条数据";
    }

    @GetMapping("/select")
    public Map<String, Object> selectLatest() {
        //定义record，接受查询结果
        Map<String, Object> record = recordService.selectLatest();
        if (record == null) {
            return Map.of("message", "暂无记录");
        }

        // 返回查到的记录
        return record;
    }
    @GetMapping("/update")
    public String updateLatest(){
        return recordService.updateLatest();
    }

    @GetMapping("/reduce")
    public String reduce(){
        return recordService.deleteLatest();
    }



}
