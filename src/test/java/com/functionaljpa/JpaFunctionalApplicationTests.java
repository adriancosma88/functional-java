package com.functionaljpa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.functionaljpa.domain.Stock;
import com.functionaljpa.repository.StockRepository;
import com.functionaljpa.service.StockService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JpaFunctionalApplicationTests {
	@Autowired
	private StockRepository stockRepo;
	
	private StockService stockService;
	
	@Before
	public void setup() {
		stockService = new StockService(stockRepo);
	}
	
	@Test
	public void contextLoads() {
	}
	
	@Test
	public void getOutOfStockListOfItems_allShouldHaveZeroQuantity() {
		List<Stock> outOfStockItems = stockService.getAllOutOfStockItems();
		assertEquals(2, outOfStockItems.size());
		
		assertTrue("All out of stock item should have 0 quantity",
				outOfStockItems.stream()
				.allMatch(stock -> stock.getQuantity() == 0));
		//TODO 1: do assert foreach list item
	}
}
