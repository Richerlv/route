package com.example.route.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: Richerlv
 * @date: 2024/4/15 14:58
 * @description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LineVo {
//    { "from": "1", "to": "2", "text": "line1", "color": "#43a2f1" },

    private String from;

    private String to;

    private String color = "#43a2f1";

    private String text;
}
