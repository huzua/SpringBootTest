package com.huzh.first.service;

import com.huzh.first.domain.Boy;
import com.huzh.first.enums.ResultEnum;
import com.huzh.first.exception.BoyException;
import com.huzh.first.repository.BoyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoyService {

    @Autowired
    private BoyRepository boyRepository;

    public void getName(String name) throws Exception{
        //Boy boy = boyRepository.findOneByName(name);
        if(name.equals("3")){
            throw new BoyException(ResultEnum.PRIMARY_SCHOOL);
        }else if(name.equals("4")){
            throw new BoyException(ResultEnum.MIDDLE_SCHOOL);
        }
    }
}
