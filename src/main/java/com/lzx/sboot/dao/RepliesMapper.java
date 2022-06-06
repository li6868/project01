package com.lzx.sboot.dao;

import com.lzx.sboot.entity.Replies;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface RepliesMapper {
    //根据咨询id查询回复
    List<Replies> idseleReplies(@Param("infoId")Long infoId);
    //添加回复
    int addRelies(Replies replies);
}
