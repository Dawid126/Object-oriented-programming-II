package pl.edu.agh.dronka.shop.model.util;

import java.util.LinkedHashMap;
import java.util.Map;

import pl.edu.agh.dronka.shop.model.*;

public class PropertiesHelper {


	public static Map<String, Object> getPropertiesMap(Item item) {
		Map<String, Object> propertiesMap = new LinkedHashMap<>();
		
		propertiesMap.put("Nazwa", item.getName());
		propertiesMap.put("Cena", item.getPrice());
		propertiesMap.put("Kategoria", item.getCategory().getDisplayName()); 
		propertiesMap.put("Ilość", Integer.toString(item.getQuantity()));
		propertiesMap.put("Tanie bo polskie", item.isPolish());
		propertiesMap.put("Używany", item.isSecondhand());
		if(item.getCategory() == Category.BOOKS) {
			propertiesMap.put("Liczba stron", ((Book)item).getPages());
			propertiesMap.put("Twarda oprawa", ((Book)item).isHardcover());
		}
		if(item.getCategory() == Category.ELECTRONICS) {
			propertiesMap.put("Mobilny", ((Electronics)item).isMobile());
			propertiesMap.put("Gwarancja", ((Electronics)item).isWarranty());
		}
		if(item.getCategory() == Category.FOOD) {
			propertiesMap.put("Data ważności", ((Food)item).getExpirationDate());
		}
		if(item.getCategory() == Category.MUSIC) {
			propertiesMap.put("Gatunek muzyczny", ((Music)item).getGenre().getDisplayName());
			propertiesMap.put("Z teledyskiem", ((Music)item).isVideoAdded());
		}
		
		return propertiesMap;
	}

}
