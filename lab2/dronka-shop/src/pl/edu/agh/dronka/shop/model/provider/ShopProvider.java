package pl.edu.agh.dronka.shop.model.provider;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import pl.edu.agh.dronka.shop.model.*;

public class ShopProvider {

	public static Shop getExampleShop() {
		Shop shop = new Shop();

		shop.addUser(getExampleUser());

		Index itemsIndex = new Index();

		for (Item item : getExampleItems()) {
			itemsIndex.addItem(item);
		}

		registerExampleCategories(itemsIndex);
		shop.setItemsIndex(itemsIndex);

		return shop;
	}

	public static User getExampleUser() {
		return new User("Jan", "Rejnor");
	}

	public static List<Item> getExampleItems() {
		List<Item> items = new ArrayList<>();

		CSVReader booksReader = new CSVReader("resources/books.csv");
		items.addAll(readItems(booksReader, Category.BOOKS));
		
		CSVReader electronicsReader = new CSVReader("resources/electronics.csv");
		items.addAll(readItems(electronicsReader, Category.ELECTRONICS));
		
		CSVReader foodReader = new CSVReader("resources/food.csv");
		items.addAll(readItems(foodReader, Category.FOOD));
		
		CSVReader musicReader = new CSVReader("resources/music.csv");
		items.addAll(readItems(musicReader, Category.MUSIC));
		
		CSVReader sportReader = new CSVReader("resources/sport.csv");
		items.addAll(readItems(sportReader, Category.SPORT));

		return items;
	}

	public static void registerExampleCategories(Index index) {
		for (Category category : Category.values()) {
			index.registerCategory(category);
		}
	}

	private static List<Item> readItems(CSVReader reader, Category category) {
		List<Item> items = new ArrayList<>();

		try {
			reader.parse();
			List<String[]> data = reader.getData();

			for (String[] dataLine : data) {
	
				String name = reader.getValue(dataLine,"Nazwa");
				int price = Integer.parseInt(reader.getValue(dataLine, "Cena"));
				int quantity = Integer.parseInt(reader.getValue(dataLine,
						"Ilość"));

				boolean isPolish = Boolean.parseBoolean(reader.getValue(
						dataLine, "Tanie bo polskie"));
				boolean isSecondhand = Boolean.parseBoolean(reader.getValue(
						dataLine, "Używany"));
				Item item;
				switch (category) {
					case BOOKS:
						int pages = Integer.parseInt(reader.getValue(dataLine, "Liczba stron"));
						boolean hardback = Boolean.parseBoolean(reader.getValue(dataLine, "Twarda oprawa"));
						item = new Book(name, category, price, quantity, pages, hardback);
						item.setPolish(isPolish);
						item.setSecondhand(isSecondhand);

						items.add(item);
						break;
					case ELECTRONICS:
						boolean mobile = Boolean.parseBoolean(reader.getValue(dataLine, "Mobilny"));
						boolean warranty = Boolean.parseBoolean(reader.getValue(dataLine, "Gwarancja"));
						item = new Electronics(name, category, price, quantity, mobile, warranty);
						item.setPolish(isPolish);
						item.setSecondhand(isSecondhand);

						items.add(item);
						break;
					case FOOD:
						int year = Integer.parseInt(reader.getValue(dataLine, "Data przydatności rok"));
						int month = Integer.parseInt(reader.getValue(dataLine, "Data przydatności miesiąc"));
						int day = Integer.parseInt(reader.getValue(dataLine, "Data przydatności dzień"));
						Date date = new GregorianCalendar(year, month, day).getTime();
						item = new Food(name, category, price, quantity, date);
						item.setPolish(isPolish);
						item.setSecondhand(isSecondhand);

						items.add(item);
						break;
					case MUSIC:
						String genre = reader.getValue(dataLine, "Gatunek");
						MusicGenre musicGenre;
						switch (genre) {
							case "Disco Polo":
								musicGenre = MusicGenre.DISCOPOLO;
								break;
							case "Metal":
								musicGenre = MusicGenre.METAL;
								break;
							case "Rap":
								musicGenre = MusicGenre.RAP;
								break;
							default:
								musicGenre = MusicGenre.SERBIANMILITARYMUSIC;
								break;
						}
						boolean videoAdded = Boolean.parseBoolean(reader.getValue(dataLine, "Dołączone wideo"));
						item = new Music(name, category, price, quantity, musicGenre, videoAdded);
						item.setPolish(isPolish);
						item.setSecondhand(isSecondhand);

						items.add(item);
						break;
					default:
						item = new Item(name, category, price, quantity);
						item.setPolish(isPolish);
						item.setSecondhand(isSecondhand);

						items.add(item);
						break;
				}


			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return items;
	}

}
