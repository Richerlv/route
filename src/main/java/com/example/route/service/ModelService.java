package com.example.route.service;

import com.example.route.rpc.GpgModelClient;
import com.example.route.vo.request.GpgRequestVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author: Richerlv
 * @date: 2024/4/8 19:55
 * @description:
 */
@Service
public class ModelService {

    @Autowired
    private GpgModelClient gpgModelClient;

    public List<Integer> gpg(int start, int end, int time) {
        return gpgModelClient.invokeGpg(start, end, time);
    }
}
