package com.water.bengaluru_usage.controller;

import com.water.bengaluru_usage.model.BengaluruWaterUsageModel;
import com.water.bengaluru_usage.service.impl.BengaluruWaterUsageServiceInterfaceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/waterusage")
public class BengaluruWaterUsageController {

    @Autowired
    BengaluruWaterUsageServiceInterfaceImpl serviceIntImpl;

    @GetMapping
    public List<BengaluruWaterUsageModel> showAll(){
        return serviceIntImpl.findAll();
    }

    @GetMapping(path = "/highest")
    public List<BengaluruWaterUsageModel> showHighest(){
        return serviceIntImpl.findHighestConsumer();
    }

    @GetMapping(path = "/topten")
    public List<BengaluruWaterUsageModel> showTopTen(){
        return serviceIntImpl.findTopTen();
    }

    @GetMapping(path = "/range150-200")
    public List<BengaluruWaterUsageModel> showBetween150and200(){
        return serviceIntImpl.findBetween150and200();
    }

    @GetMapping(path = "/range70-130")
    public List<BengaluruWaterUsageModel> showBetween70and130(){
        return serviceIntImpl.findBetween70and130();
    }

    @GetMapping(path = "/least")
    public List<BengaluruWaterUsageModel> showLeast(){
        return serviceIntImpl.findLessThan50();
    }
}
