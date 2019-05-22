package com.hcl.userstock.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.userstock.entity.UserStockdetails;
import com.hcl.userstock.service.StockService;
import com.hcl.userstock.service.StockServiceImpl;

@RestController
@RequestMapping("/stocksapp")
public class StockController {

	@Autowired
	private StockServiceImpl stockServiceImpl;

	@GetMapping("/getmonthlyusers/{month}")
	public List<UserStockdetails> getUsersOnMonthlyBasis(@PathVariable("month") int month) {
		return stockServiceImpl.getMonthlyData(month);

	}

	@GetMapping("/getdailyusers/{todaydate}")
	public List<UserStockdetails> getDailyUsersStockDetails(@PathVariable("todaydate") String todaydate) {
		return stockServiceImpl.getDaily(todaydate);
	}

	@GetMapping("/getweeklyusers/{startdate}/{enddate}")
	public List<UserStockdetails> getWeeklyUserStockDetails(@PathVariable("startdate") String startdate,
			@PathVariable("enddate") String enddate) {
		return stockServiceImpl.getWeekly(startdate, enddate);

	}

	public static final String SAMPLE_XLSX_FILE_PATH = "C:\\Users\\user1\\Desktop\\Test_Git\\userstock\\src\\main\\resources\\sample-xlsx-file.xlsx";

	@Autowired
	StockService service;

	@GetMapping(value = "docstocks")
	public String readSaveStockDate() throws Exception {
		String msg = "Stock Date is read saved in DB";
		Workbook workbook = null;
		List<UserStockdetails> stockList = new ArrayList<UserStockdetails>();
		try {
			workbook = WorkbookFactory.create(new File(SAMPLE_XLSX_FILE_PATH)); // Retrieving the number of
																							// sheets in the
			Sheet sheet = (Sheet) workbook.getSheetAt(0);

			Iterator<Row> rowIterator = sheet.iterator();
			rowIterator.next();
			while (rowIterator.hasNext()) {
				UserStockdetails stock = new UserStockdetails();
				Row row = rowIterator.next();
				Cell cell0 = row.getCell(1);
				int userId = (int) cell0.getNumericCellValue();
				stock.setUserId(userId);

								Cell cell2 = row.getCell(2);
				int productId = (int) cell2.getNumericCellValue();
				stock.setProductId(productId);

				Cell cell3 = row.getCell(3);
				String productName = cell3.getStringCellValue();
				stock.setProductName(productName);
				Cell cell4 = row.getCell(4);
				int quantity = (int) cell4.getNumericCellValue();
				stock.setQuantity(quantity);
				Cell cell5 = row.getCell(5);
				double price = cell5.getNumericCellValue();
				stock.setPrice(price);

				Cell cell6 = row.getCell(5);
				Date dateTime = cell6.getDateCellValue();
				stock.setDateTime(dateTime);
				stockList.add(stock);
			}
			service.saveStock(stockList);
		}  finally {
			if(workbook!=null) {
				workbook.close();
			}
		}

		return msg;

	}

}
