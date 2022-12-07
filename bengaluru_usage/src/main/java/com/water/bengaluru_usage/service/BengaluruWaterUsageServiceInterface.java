package com.water.bengaluru_usage.service;

import com.water.bengaluru_usage.model.BengaluruWaterUsageModel;

import java.util.List;

public interface BengaluruWaterUsageServiceInterface {
    List<BengaluruWaterUsageModel> findAll();
    List<BengaluruWaterUsageModel> findHighestConsumer();
    List<BengaluruWaterUsageModel> findTopTen();
    List<BengaluruWaterUsageModel> findBetween150and200();
    List<BengaluruWaterUsageModel> findBetween70and130();
    List<BengaluruWaterUsageModel> findLessThan50();
}
