package com.example.route.controller;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONArray;
import com.example.route.vo.FromToRelationVo;
import com.example.route.vo.LineVo;
import com.example.route.vo.NodeVo;
import com.example.route.vo.request.GpgRequestVo;
import com.example.route.vo.response.SiouxNetWorkResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: Richerlv
 * @date: 2024/4/15 14:51
 * @description:
 */

@Slf4j
@CrossOrigin
@Controller
public class MapController {

    private String fromToRelationVoStr = "[{\"from\":\"1\",\"to\":\"2\"},{\"from\":\"1\",\"to\":\"3\"},{\"from\":\"2\",\"to\":\"1\"},{\"from\":\"2\",\"to\":\"6\"},{\"from\":\"3\",\"to\":\"1\"},{\"from\":\"3\",\"to\":\"4\"},{\"from\":\"3\",\"to\":\"12\"},{\"from\":\"4\",\"to\":\"3\"},{\"from\":\"4\",\"to\":\"5\"},{\"from\":\"4\",\"to\":\"11\"},{\"from\":\"5\",\"to\":\"4\"},{\"from\":\"5\",\"to\":\"6\"},{\"from\":\"5\",\"to\":\"9\"},{\"from\":\"6\",\"to\":\"2\"},{\"from\":\"6\",\"to\":\"5\"},{\"from\":\"6\",\"to\":\"8\"},{\"from\":\"7\",\"to\":\"8\"},{\"from\":\"7\",\"to\":\"18\"},{\"from\":\"8\",\"to\":\"6\"},{\"from\":\"8\",\"to\":\"7\"},{\"from\":\"8\",\"to\":\"9\"},{\"from\":\"8\",\"to\":\"16\"},{\"from\":\"9\",\"to\":\"5\"},{\"from\":\"9\",\"to\":\"8\"},{\"from\":\"9\",\"to\":\"10\"},{\"from\":\"10\",\"to\":\"9\"},{\"from\":\"10\",\"to\":\"11\"},{\"from\":\"10\",\"to\":\"15\"},{\"from\":\"10\",\"to\":\"16\"},{\"from\":\"10\",\"to\":\"17\"},{\"from\":\"11\",\"to\":\"4\"},{\"from\":\"11\",\"to\":\"10\"},{\"from\":\"11\",\"to\":\"12\"},{\"from\":\"11\",\"to\":\"14\"},{\"from\":\"12\",\"to\":\"3\"},{\"from\":\"12\",\"to\":\"11\"},{\"from\":\"12\",\"to\":\"13\"},{\"from\":\"13\",\"to\":\"12\"},{\"from\":\"13\",\"to\":\"24\"},{\"from\":\"14\",\"to\":\"11\"},{\"from\":\"14\",\"to\":\"15\"},{\"from\":\"14\",\"to\":\"23\"},{\"from\":\"15\",\"to\":\"10\"},{\"from\":\"15\",\"to\":\"14\"},{\"from\":\"15\",\"to\":\"19\"},{\"from\":\"15\",\"to\":\"22\"},{\"from\":\"16\",\"to\":\"8\"},{\"from\":\"16\",\"to\":\"10\"},{\"from\":\"16\",\"to\":\"17\"},{\"from\":\"16\",\"to\":\"18\"},{\"from\":\"17\",\"to\":\"10\"},{\"from\":\"17\",\"to\":\"16\"},{\"from\":\"17\",\"to\":\"19\"},{\"from\":\"18\",\"to\":\"7\"},{\"from\":\"18\",\"to\":\"16\"},{\"from\":\"18\",\"to\":\"20\"},{\"from\":\"19\",\"to\":\"15\"},{\"from\":\"19\",\"to\":\"17\"},{\"from\":\"19\",\"to\":\"20\"},{\"from\":\"20\",\"to\":\"18\"},{\"from\":\"20\",\"to\":\"19\"},{\"from\":\"20\",\"to\":\"21\"},{\"from\":\"20\",\"to\":\"22\"},{\"from\":\"21\",\"to\":\"20\"},{\"from\":\"21\",\"to\":\"22\"},{\"from\":\"21\",\"to\":\"24\"},{\"from\":\"22\",\"to\":\"15\"},{\"from\":\"22\",\"to\":\"20\"},{\"from\":\"22\",\"to\":\"21\"},{\"from\":\"22\",\"to\":\"23\"},{\"from\":\"23\",\"to\":\"14\"},{\"from\":\"23\",\"to\":\"22\"},{\"from\":\"23\",\"to\":\"24\"},{\"from\":\"24\",\"to\":\"13\"},{\"from\":\"24\",\"to\":\"21\"},{\"from\":\"24\",\"to\":\"23\"}]";

    @ResponseBody
    @RequestMapping(value = "/getSiouxNetwork", method = RequestMethod.POST)
    public SiouxNetWorkResponseVo getSiouxNetwork() {
        List<FromToRelationVo> fromToRelationVoList = JSONArray.parseArray(fromToRelationVoStr, FromToRelationVo.class);
//        List<FromToRelationVo> fromToRelationVoList = (List<FromToRelationVo>) JSON.parseObject(fromToRelationVoStr);
        log.info("fromToRelationVoList:{}", fromToRelationVoList.toString());
        SiouxNetWorkResponseVo siouxNetWorkResponseVo = new SiouxNetWorkResponseVo();
        siouxNetWorkResponseVo.setRootId("1");
        List<NodeVo> nodeVos = new LinkedList<>();
        List<LineVo> lineVos = new LinkedList<>();
        for(FromToRelationVo fromToRelationVo : fromToRelationVoList) {
            String from = fromToRelationVo.getFrom();
            String to = fromToRelationVo.getTo();
            NodeVo nodeVo = createNodeVo(from, from);
            if(!nodeVos.contains(nodeVo)) {
                nodeVos.add(nodeVo);
            }
            LineVo lineVo = createLineVo(from, to, null);
            if(!lineVos.contains(lineVo)) {
                lineVos.add(lineVo);
            }
        }
        siouxNetWorkResponseVo.setNodes(nodeVos);
        siouxNetWorkResponseVo.setLines(lineVos);
        System.out.println(siouxNetWorkResponseVo.toString());
        return siouxNetWorkResponseVo;
    }

    private NodeVo createNodeVo(String id, String text) {
        NodeVo nodeVo = new NodeVo();
        nodeVo.setId(id);
        nodeVo.setText(text);
        return nodeVo;
    }

    private LineVo createLineVo(String from, String to, String text) {
        LineVo lineVo = new LineVo();
        lineVo.setFrom(from);
        lineVo.setTo(to);
        lineVo.setText(text);
        return lineVo;
    }
}
