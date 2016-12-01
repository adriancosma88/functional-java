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
	
	@Test
	public void getListOfAllAvailableSizes() {
		//TODO 2: list of all available sizes
	}
	
	@Test
	public void getListOfFootwearSize41() {
		//TODO 3: list of all 41 size shoes
	}
	
	@Test 
	public void getListOfAllBrandsThatHaveBlueShoesOnStock() {
		//TODO 4: Brands with blue shoes on stock. Use distinct?
	}
	
	@Test 
	public void getTheItemWithBiggestStock() {
		//TODO 5: Get item with the highest stock
	}
	
	@Test
	public void getAllSize42BlackShoes() {
		//TODO 6: Get all items that have size 42 on stock and are black
	}
	
	@Test
	public void countAllBlackShoes() {
		//TODO 7: Count all black shoes.
	}
	
	@Test
	public void getAnyLacosteShoe() {
		//TODO 8: get any lacoste shoe.
	}
	
	@Test
	public void getTop3StockItems() {
		//TODO 9: get the first 3 items with the largest stock quantity.
	}
	
	@Test
	public void test() {
		//TODO 10: write your own test
	}
}
