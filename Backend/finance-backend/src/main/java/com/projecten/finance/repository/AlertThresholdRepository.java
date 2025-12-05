package com.projecten.finance.repository;

import com.projecten.finance.entity.AlertThreshold;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlertThresholdRepository extends JpaRepository<AlertThreshold, Long> {
}
