package com.example.route.vo.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: Richerlv
 * @date: 2024/4/8 19:50
 * @description:
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GpgRequestVo {

    private Integer start;

    private Integer end;

    private Integer time;
}
