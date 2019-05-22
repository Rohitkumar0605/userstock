package com.hcl.userstock.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hcl.userstock.entity.UserStockdetails;

@Service
public interface StockService {

	public List<UserStockdetails> getMonthlyData(int month);

	public List<UserStockdetails> getDaily(String todayDate);

	public List<UserStockdetails> getWeekly(String startdate, String enddate);

	public void saveStock(List<UserStockdetails> userdetails);

}
