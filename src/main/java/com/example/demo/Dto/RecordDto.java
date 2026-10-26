package com.example.demo.Dto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDateTime;
@JsonInclude(JsonInclude.Include.NON_NULL)//隐藏值为null的变量
public class RecordDto {
    private Long id;
    private LocalDateTime visitTime;
    private String name;
    private String message;
    public Long getId(){
        return id;

    }
    public void setId(Long id){
        this.id=id;
    }
    public LocalDateTime getVisitTime(){
        return visitTime;
    }
    public void setVisitTime(LocalDateTime visitTime){
        this.visitTime=visitTime;
    }
    public String getMessage(){
        return message;
    }
    public void setMessage(String message){
        this.message=message;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;

    }

}
