package com.test.practice;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {
	
	public void convertDate() throws ParseException
	{
		SimpleDateFormat format1 = new SimpleDateFormat("MM/dd/yyyy");
	    SimpleDateFormat format2 = new SimpleDateFormat("dd-MMM-yyyy");
	    Date date = format1.parse("05/01/1999");
	    System.out.println(format2.format(date));
	}

	public static void main(String[] args) throws ParseException {
		
   Test t=new Test();
   t.convertDate();
	}

}
