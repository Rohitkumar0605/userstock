package com.hcl.userstock.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hcl.userstock.entity.UserStockdetails;

public interface StockRepository extends JpaRepository<UserStockdetails, Integer> {

	@Query(value = "select * from user_stockdetails where month(date_time)=?1 ", nativeQuery = true)
	List<UserStockdetails> getDatabasedOnMonth(int month);

	@Query(value = "SELECT * FROM user_stockdetails WHERE date_time >= ?1 AND date_time <=?2 ", nativeQuery = true)
	List<UserStockdetails> getDataWeeklyBasis(String startDate, String endDate);

	@Query(value = "SELECT * FROM user_stockdetails WHERE date_time = ?1", nativeQuery = true)
	List<UserStockdetails> getDataDailyBasis(String todayDate);

}
