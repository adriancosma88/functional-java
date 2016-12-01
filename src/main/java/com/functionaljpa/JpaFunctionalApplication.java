package com.functionaljpa;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import com.functionaljpa.domain.Footwear;
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
		List<Footwear> footwearList = Arrays.asList(
				new Footwear("Nike Running Shoes", "Good Running Shoes",
						"Blue", "Synthetic", 41),
				new Footwear("Nike Tennis Shoes", "Good Running Shoes",
						"White", "Synthetic", 42)
				);
		
		footwearRepository.save(footwearList);
		
		footwearRepository.findAll().forEach(System.out::println);
	}
}
