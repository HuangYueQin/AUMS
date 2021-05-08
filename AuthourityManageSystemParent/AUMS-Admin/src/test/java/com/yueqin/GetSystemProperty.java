package com.yueqin;
import java.util.Iterator;
import java.util.Properties;

import org.junit.jupiter.api.Test;

public class GetSystemProperty {
	
	@Test
	public void getSystemProperty() {
		
		Properties properties = System.getProperties();
		
		Iterator<Object> iterator = properties.keySet().iterator();
		
		while(iterator.hasNext()) {
			Object key = iterator.next();
			System.out.println(key+" : "+properties.get(key));
		}
	}
	

}
