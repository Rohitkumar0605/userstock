package com.hcl.userstock.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.userstock.entity.UserStockdetails;
import com.hcl.userstock.repository.StockRepository;

import junit.framework.Assert;

@RunWith(MockitoJUnitRunner.class)
public class StockServiceImplTest {

	@Mock
	StockRepository stockRepository;

	@InjectMocks
	StockServiceImpl stockServiceImpl;

	static List<UserStockdetails> expectval1 = null;

	@BeforeClass
	public static void setUp() {
		expectval1 = new ArrayList<UserStockdetails>();
		UserStockdetails UserStockdetails = new UserStockdetails(1, 123, 12, "pendrive", 5, 250, null);
		UserStockdetails.setDateTime(new Date());
		expectval1.add(UserStockdetails);

	}

	@Test
	public void testGetDaily() {
		Mockito.when(stockRepository.getDataDailyBasis("2019-05-21")).thenReturn(expectval1);
		List<UserStockdetails> actval1 = stockServiceImpl.getDaily("2019-05-21");
		Assert.assertEquals(expectval1.size(), actval1.size());
	}

	@Test
	public void testGetMonthlyData() {
		Mockito.when(stockRepository.getDatabasedOnMonth(5)).thenReturn(expectval1);
		List<UserStockdetails> actval2 = stockServiceImpl.getMonthlyData(5);
		Assert.assertEquals(expectval1.size(), actval2.size());
	}

}
