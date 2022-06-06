package com.lzx.sboot.service;

import com.lzx.sboot.dao.InformationsMapper;
import com.lzx.sboot.entity.Informations;
import com.lzx.sboot.utils.RedisUtil;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class InformationsServiceImpl implements InformationsService {
    @Resource
    private InformationsMapper informationsMapper;
    @Resource
    private RedisUtil redisUtil;

    @Override
    public List<Informations> seleInfor() {

        return informationsMapper.seleInfor();
    }
    //@Cacheable(value = "mykey")
    @Override
    public Informations idseleInfor(Long id) {
        //System.out.println("222222222222222222");
        //System.out.println("从数据中查询(第一次查询时)");
        Informations info=null;
        if (redisUtil.get("info:"+id)!=null){
            System.out.println("从缓存获取数据");
            info=(Informations)redisUtil.get("info:"+id);
        }else {
            System.out.println("从数据库获取数据");
            info=informationsMapper.idseleInfor(id);
            redisUtil.set("info:"+id,info);
        }
        return info;
    }

    @Override
    public int idupdainfor(Long id) {

        return informationsMapper.idupdainfor(id);
    }

    @Override
    public int updateInforCount(Long id, Date lastPostTime) {
        return informationsMapper.updateInforCount(id,lastPostTime);
    }
}
