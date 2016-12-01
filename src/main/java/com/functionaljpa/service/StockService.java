package com.functionaljpa.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.functionaljpa.domain.Stock;
import com.functionaljpa.repository.StockRepository;

public class StockService {
	private final StockRepository stockRepo;
	
	@Autowired
	public StockService(StockRepository stockRepo) {
		this.stockRepo = stockRepo;
	}
	
	public List<Stock> getAllOutOfStockItems() {
		return stockRepo.findAll() //a list
				.stream() //now a stream
				.filter(stock -> stock.getQuantity() == 0) //use a predicate, hold only the ones which return true
				.collect(Collectors.toList()); //use a terminal function to collect the results
	}
}
