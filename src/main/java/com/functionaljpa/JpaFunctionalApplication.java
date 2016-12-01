package com.functionaljpa;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import com.functionaljpa.domain.Brand;
import com.functionaljpa.domain.Color;
import com.functionaljpa.domain.Footwear;
import com.functionaljpa.domain.Material;
import com.functionaljpa.domain.Stock;
import com.functionaljpa.repository.StockRepository;

@EntityScan({"com.functionaljpa.domain"})
@SpringBootApplication
public class JpaFunctionalApplication implements CommandLineRunner{
	@Autowired
	private StockRepository stockRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(JpaFunctionalApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		Brand nike = new Brand("Nike");
		Footwear nikeRunningShoes = new Footwear("Running Shoes",
				"Good Running Shoes", nike,	Material.TEXTILE);
		List<Stock> stockList = Arrays.asList(
				new Stock(nikeRunningShoes, Color.BLUE, 41, 20),
				new Stock(nikeRunningShoes, Color.BLUE, 42, 15),
				new Stock(nikeRunningShoes, Color.BLUE, 43, 10),
				new Stock(nikeRunningShoes, Color.BLACK, 41, 12),
				new Stock(nikeRunningShoes, Color.BLACK, 42, 15)
				);
		
		stockRepository.save(stockList);
		
		stockRepository.findAll().forEach(System.out::println);
	}
}
