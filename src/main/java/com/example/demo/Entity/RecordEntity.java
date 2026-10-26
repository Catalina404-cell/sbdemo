package com.example.demo.Entity;

import java.time.LocalDateTime;

public class RecordEntity {
    private Long id;
    private String name;
    private LocalDateTime visitTime;//LocalDateTime表示不带时区的时间
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
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
}
