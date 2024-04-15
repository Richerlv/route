package com.example.route.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: Richerlv
 * @date: 2024/4/15 14:57
 * @description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NodeVo {
//    { "id": "1", "text": "1", "color": "#43a2f1", "fontColor": "yellow" },
    private String id;

    private String text;

    private String color = "#43a2f1";

    private String fontColor = "yellow";
}
