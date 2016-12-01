package com.functionaljpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.functionaljpa.domain.Stock;

public interface StockRepository extends JpaRepository<Stock, Integer>{

}
