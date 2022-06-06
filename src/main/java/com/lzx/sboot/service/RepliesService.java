package com.lzx.sboot.service;

import com.lzx.sboot.entity.Replies;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RepliesService {
    //根据咨询id查询回复
    List<Replies> idseleReplies(Long infoId);
    //添加回复
    int addRelies(Replies replies);
}
