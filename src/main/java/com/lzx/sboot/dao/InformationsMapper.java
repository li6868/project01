package com.lzx.sboot.dao;

import com.lzx.sboot.entity.Informations;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface InformationsMapper {
    //查询全部
    List<Informations> seleInfor();
    //根据id查询咨询
    Informations idseleInfor(@Param("id")Long id);
    //根据id修改查看次数
    int idupdainfor(@Param("id")Long id);
    //修改回复次数
    int updateInforCount(@Param("id")Long id, @Param("lastPostTime")Date lastPostTime);
}
