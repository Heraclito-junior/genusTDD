package testes;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import NovasFuncionalidades.FuncionalidadesNovas;
import NovasFuncionalidades.Lotes;

public class TesteFaltasFuncionario {
	
	@Test    
	public void venderLotesTest2() {
		
		Date data=new Date(2016, 11, 06);

		 String input_date="06/11/2016";
		  SimpleDateFormat format1=new SimpleDateFormat("dd/MM/yyyy");
		  Date dt1 = null;
		try {
			dt1 = format1.parse(input_date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  DateFormat format2=new SimpleDateFormat("EEEE"); 
		  String finalDay=format2.format(dt1);
		System.out.println(finalDay);
		
		
    	
    	
		

	}

}
