package com.water.bengaluru_usage.repository;

import com.water.bengaluru_usage.model.BengaluruWaterUsageModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BengaluruWaterUsageModelRepository extends JpaRepository<BengaluruWaterUsageModel,Integer> {
    // --------- custom queries
    // 1. Highest consumer
    @Query(value = "SELECT * FROM bengaluruwaterusage " +
            "ORDER BY averageUsageML DESC " +
            "LIMIT 1", nativeQuery = true)
    List<BengaluruWaterUsageModel> findHighestConsumer();

    // 2. Top 10 wards (between 230ML and 300ML)
    @Query(value = "SELECT * FROM bengaluruwaterusage " +
                    "ORDER BY averageUsageML DESC " +
                    "LIMIT 10", nativeQuery = true)
    List<BengaluruWaterUsageModel> findTopTen();

    // 3. Between 150ML and 200ML
    @Query(value = "SELECT * FROM bengaluruwaterusage " +
            "WHERE averageUsageML BETWEEN 150 AND 200",
            nativeQuery = true)
    List<BengaluruWaterUsageModel> findBetween150and200();

    // 3. Between 70ML and 130ML
    @Query(value = "SELECT * FROM bengaluruwaterusage " +
            "WHERE averageUsageML BETWEEN 70 AND 130",
            nativeQuery = true)
    List<BengaluruWaterUsageModel> findBetween70and130();

    // 3. Less than = 50ML
    @Query(value = "SELECT * FROM bengaluruwaterusage " +
            "WHERE averageUsageML <= 50",
            nativeQuery = true)
    List<BengaluruWaterUsageModel> findLessThan50();
}
