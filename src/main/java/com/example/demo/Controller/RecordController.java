package com.example.demo.Controller;
import java.util.List;
import com.example.demo.Dto.RecordDto;
import com.example.demo.Service.RecordService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
//以add为例：我访问到localhost:8080/record/add?name=小红，
//首先被Contorller接收到执行add的那个方法name=小红，
//在Contorller类的add方法里面创建了dto并且获取到了小红的这个名字，
//然后转去执行了recordService.add(dto)，
//但是Service只是个接口，实际转到了ServiceImpl中，
//在ServiceImpl的add方法中new了一个Entity并且把DTO的name传到了Entity中，
//运行Dao类，然后Dao带着获取到的name转到xml执行了sql语句，
//此时MyBatis返回受影响行数1，Dao返回1，Impl返回1，
//Controller的rows=返回的Impl中add方法返回的1


@RestController
@RequestMapping("/record")//公共路径前缀
public class RecordController {
    private final RecordService recordService;
    public RecordController(RecordService recordService){
        this.recordService=recordService;
    }
    @GetMapping("/add")
    public String add(@RequestParam("name") String name){
        RecordDto dto=new RecordDto();
        dto.setName(name);

        int rows=recordService.add(dto);
        return "新增成功，增加了"+rows+"条数据";
    }
    @GetMapping("/select")
    public RecordDto selectLatest() {
        return recordService.selectLatest();
    }
    @GetMapping("/selectById")
    public RecordDto selectById(@RequestParam("id") Long id) {
        RecordDto dto =new RecordDto();
        dto.setId(id);
        return recordService.selectById(dto);
    }
    @GetMapping("/list")
    public List<RecordDto> list(){
        return recordService.list();
    }
    @GetMapping("/update")
    public String updateLatest(@RequestParam("name") String name){
        RecordDto dto=new RecordDto();
        dto.setName(name);
        return recordService.updateLatest(dto);
    }

    @GetMapping("/reduce")
    public String reduce(){
        return recordService.deleteLatest();
    }
}
