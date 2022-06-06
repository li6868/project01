package com.lzx.sboot.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lzx.sboot.entity.Informations;
import com.lzx.sboot.entity.Replies;
import com.lzx.sboot.service.InformationsService;
import com.lzx.sboot.service.RepliesService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class InformationsController {
    @Resource
    private InformationsService informationsService;
    @Resource
    private RepliesService repliesService;
    @RequestMapping(value = "/index.action",method = RequestMethod.POST)
    @ResponseBody
    public Object getInforMations(Integer pageNum){
        if (pageNum==null){
            pageNum=1;
        }
        PageHelper.startPage(pageNum,2,true);
        List<Informations> infoList=informationsService.seleInfor();
        PageInfo<Informations> pageInfo=new PageInfo<>(infoList);

        Map<String,Object> resultMap=new HashMap<>();
        resultMap.put("pageInfo",pageInfo);
        String json=JSON.toJSONStringWithDateFormat(resultMap,"yyyy-MM-dd HH:mm-ss");
        System.out.println(json);
        return json;
    }
    @RequestMapping(value = "/detail.action",method = RequestMethod.POST)
    @ResponseBody
    public Object getInfoAndReplies(Long id){
        Informations info=informationsService.idseleInfor(id);
        List<Replies> rlist=repliesService.idseleReplies(id);
        int n=informationsService.idupdainfor(id);
        if (n>0) {
            System.out.println("修改查看次数成功");
        }
        Map<String,Object>resultMap=new HashMap<>();
        resultMap.put("info",info);
        resultMap.put("rlist",rlist);
        String json=JSON.toJSONStringWithDateFormat(resultMap,"yyyy-MM-dd HH:mm-ss");
        System.out.println(json);
        return json;
    }
    @RequestMapping(value = "/addReplies.action",method = RequestMethod.POST)
    @ResponseBody
    public Object addReplies(Replies replies){
        Map<String,Object>resultMap=new HashMap<>();
        replies.setReplyTime(new Date());
        int n=repliesService.addRelies(replies);
        if (n>0) {
            informationsService.updateInforCount(replies.getInfoId(),new Date());
            resultMap.put("flag","success");
            resultMap.put("replies",replies);
        }

        String json=JSON.toJSONStringWithDateFormat(resultMap,"yyyy-MM-dd HH:mm-ss");
        System.out.println(json);
        return json;
    }
}
