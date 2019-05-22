package com.hcl.userstock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.userstock.entity.UserStockdetails;
import com.hcl.userstock.repository.StockRepository;

@Service
public class StockServiceImpl implements StockService {

	@Autowired
	private StockRepository stockRepository;

	@Override
	public List<UserStockdetails> getMonthlyData(int month) {
		return stockRepository.getDatabasedOnMonth(month);
	}

	@Override
	public List<UserStockdetails> getDaily(String todayDate) {
		return stockRepository.getDataDailyBasis(todayDate);
	}

	@Override
	public List<UserStockdetails> getWeekly(String startdate, String enddate) {
		return stockRepository.getDataWeeklyBasis(startdate, enddate);
	}

	@Override
	public void saveStock(List<UserStockdetails> userdetails) {

		stockRepository.saveAll(userdetails);
	}

}
