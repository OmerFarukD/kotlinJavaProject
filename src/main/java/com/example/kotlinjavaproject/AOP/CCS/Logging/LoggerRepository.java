package com.example.kotlinjavaproject.AOP.CCS.Logging;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoggerRepository extends JpaRepository<LogDetails,Integer> {
}
