package com.Hmrc.framework.beans;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import org.testng.annotations.Test;


import com.Hmrc.framework.excelHelper.CreateExcelSheet;
import com.Hmrc.framework.excelHelper.ExcelReader;


public class VehcileDescrition extends CreateExcelSheet {

	// TODO Auto-generated constructor stub

	 VehcileDetails vehcileDetails1;
	 VehcileDetails vehcileDetails2;
	 VehcileDetails vehcileDetails;
	 
	 public List<VehcileDetails> VDetailsAll() {
			try {
				
				//Data collected to  pass to Excel sheet.
				List<VehcileDetails> details = new ArrayList<VehcileDetails>();
				
				
				VehcileDetails vehcileDetails = new VehcileDetails();
				VehcileDetails vehcileDetails1 = new VehcileDetails();
				VehcileDetails vehcileDetails2 = new VehcileDetails();

				
				//creating data 
				vehcileDetails.setVechileNumber("LG52 KWN");
				vehcileDetails.setMake("HONDA");
				vehcileDetails.setColor("BLACK");

				vehcileDetails1.setVechileNumber("DY17NVW");
				vehcileDetails1.setMake("VAUXHALL");
				vehcileDetails1.setColor("GREY");

				vehcileDetails2.setVechileNumber("bf08fzt");
				vehcileDetails2.setMake("JAGUAR");
				vehcileDetails2.setColor("GREY");
				
				
				
				details.add(vehcileDetails);
				details.add(vehcileDetails1);
				details.add(vehcileDetails2);

				return details;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;

		}
	


	
	

}