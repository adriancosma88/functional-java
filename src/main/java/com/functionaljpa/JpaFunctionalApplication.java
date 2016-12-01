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
import com.functionaljpa.repository.FootwearRepository;

@EntityScan({"com.functionaljpa.domain"})
@SpringBootApplication
public class JpaFunctionalApplication implements CommandLineRunner{
	@Autowired
	private FootwearRepository footwearRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(JpaFunctionalApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		Brand nike = new Brand("Nike");
		List<Footwear> footwearList = Arrays.asList(
				new Footwear("Running Shoes", "Good Running Shoes", nike,
						Color.BLUE, Material.TEXTILE, 41),
				new Footwear("Tennis Shoes", "Good Running Shoes", nike,
						Color.BLUE, Material.TEXTILE, 42)
				);
		
		footwearRepository.save(footwearList);
		
		footwearRepository.findAll().forEach(System.out::println);
	}
}
