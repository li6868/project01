package com.lzx.sboot.service;

import com.lzx.sboot.entity.Informations;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface InformationsService {
    //查询全部
    List<Informations> seleInfor();
    //根据id查询咨询
    Informations idseleInfor(Long id);
    //根据id修改查看次数
    int idupdainfor(Long id);
    //修改回复次数
    int updateInforCount(Long id,Date lastPostTime);
}
