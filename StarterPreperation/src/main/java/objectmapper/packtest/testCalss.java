package objectmapper.packtest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class testCalss {

	public static void main(String[] args) {
		Car caar = new Car();
		caar.setColor("Green");
		caar.setType("Porsche");
		
		ObjectMapper omapper = new ObjectMapper();
		try {
			String jSonString = omapper.writeValueAsString(caar);
			System.out.println(jSonString);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
