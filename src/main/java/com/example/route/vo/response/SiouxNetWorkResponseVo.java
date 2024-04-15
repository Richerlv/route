package com.example.route.vo.response;

import com.example.route.vo.LineVo;
import com.example.route.vo.NodeVo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author: Richerlv
 * @date: 2024/4/15 14:58
 * @description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SiouxNetWorkResponseVo {

    private String rootId;

    private List<NodeVo> nodes;

    private List<LineVo> lines;
}
