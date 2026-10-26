package com.example.demo.Dto;
import java.time.LocalDateTime;
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
    public String getmessage(){
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
