package com.lzx.sboot.service;

import com.lzx.sboot.dao.RepliesMapper;
import com.lzx.sboot.entity.Replies;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RepliesServiceImpl implements RepliesService {
    @Resource
    private RepliesMapper repliesMapper;

    @Override
    public List<Replies> idseleReplies(Long infoId) {

        return repliesMapper.idseleReplies(infoId);
    }

    @Override
    public int addRelies(Replies replies) {

        return repliesMapper.addRelies(replies);
    }
}
