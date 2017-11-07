package Model;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.List;

public class Model implements Serializable{

	public void buildFromCSV(List<String> fields) throws NumberFormatException, IllegalArgumentException, IllegalAccessException {
		Field[] allFields = this.getClass().getDeclaredFields();
		int i=0;
		if(fields.size() == allFields.length) {
			for (Field field : allFields) {
				if(field.getType().equals(Integer.class)) {
					field.set(this,Integer.parseInt(fields.get(i)));
				}else if(field.getType().equals(Integer.TYPE)) {
					field.set(this,Integer.parseInt(fields.get(i)));
				}else {
					field.set(this, fields.get(i).toString());
				}
					
				i++;
			}
		}
	}
	
}
