package com.example.route.controller;

import com.example.route.rpc.GpgModelClient;
import com.example.route.service.ModelService;
import com.example.route.vo.request.GpgRequestVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: Richerlv
 * @date: 2024/4/8 14:53
 * @description:
 */
@Slf4j
@CrossOrigin
@Controller
public class ModelController {

    @Autowired
    private ModelService modelService;

    @ResponseBody
    @RequestMapping(value = "/gpg", method = RequestMethod.POST)
    public List<Integer> gpg(@RequestBody GpgRequestVo gpgRequestVo) {
        validateGpgRequestVo(gpgRequestVo);
        return modelService.gpg(gpgRequestVo.getStart(), gpgRequestVo.getEnd(), gpgRequestVo.getTime());
    }

    private void validateGpgRequestVo(GpgRequestVo gpgRequestVo) {
        if(gpgRequestVo == null) {
            gpgRequestVo = new GpgRequestVo();
        }
        if(gpgRequestVo.getStart() == null) {
            gpgRequestVo.setStart(1);
        }
        if(gpgRequestVo.getEnd() == null) {
            gpgRequestVo.setEnd(15);
        }
        if(gpgRequestVo.getTime() == null) {
            gpgRequestVo.setTime(40);
        }
    }
}
