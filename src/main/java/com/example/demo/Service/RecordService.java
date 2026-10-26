package com.example.demo.Service;

import com.example.demo.Dto.RecordDto;

import java.util.Map;
public interface RecordService {
    int add(RecordDto dto);
    RecordDto selectLatest();
    String updateLatest(RecordDto dto);
    String deleteLatest();
}