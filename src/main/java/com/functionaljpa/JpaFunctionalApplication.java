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
		Brand lacoste = new Brand("Lacoste");
		Brand geox = new Brand("Geox");
		Brand adibas = new Brand("Adibas");
		Footwear nikeRunningShoes = new Footwear("Running Shoes",
				"Good Running Shoes", nike,	Material.TEXTILE);
		Footwear lacosteSneakers = new Footwear("Sneakers",
				"Casual Sneakers", lacoste, Material.LEATHER);
		Footwear lacosteHighTops = new Footwear("High Tops",
				"Leather High Tops", lacoste, Material.LEATHER);
		Footwear geoxCasualShoes = new Footwear("Casual Shoes",
				"High quality casual shoes", geox, Material.LEATHER);
		Footwear adibasRunningShoes = new Footwear("Running Shoes",
				"Original Fake Running Shoes", adibas, Material.TEXTILE);
		
		List<Stock> stockList = Arrays.asList(
				new Stock(nikeRunningShoes, Color.BLUE, 41, 20),
				new Stock(nikeRunningShoes, Color.BLUE, 42, 15),
				new Stock(nikeRunningShoes, Color.BLUE, 43, 10),
				new Stock(nikeRunningShoes, Color.BLACK, 41, 0),
				new Stock(nikeRunningShoes, Color.BLACK, 42, 15),
				new Stock(lacosteSneakers, Color.BLACK, 41, 6),
				new Stock(lacosteSneakers, Color.WHITE, 42, 6),
				new Stock(lacosteHighTops, Color.GREEN, 41, 12),
				new Stock(geoxCasualShoes, Color.GRAY, 42, 14),
				new Stock(geoxCasualShoes, Color.WHITE, 41, 0),
				new Stock(adibasRunningShoes, Color.ORANGE, 42, 7),
				new Stock(adibasRunningShoes, Color.RED, 41, 16)
				);
		
		stockRepository.save(stockList);
		
		stockRepository.findAll().forEach(System.out::println);
	}
}
