package pl.edu.agh.dronka.shop.model.filter;

import pl.edu.agh.dronka.shop.model.*; //dodane

public class ItemFilter {

	private Item itemSpec;

	public ItemFilter(Category category) {
		if(category.equals(Category.BOOKS)) {
			this.itemSpec = new Book();
		}
		else if(category.equals(Category.ELECTRONICS)) {
			this.itemSpec = new Electronics();
		}
		else if(category.equals(Category.MUSIC)) {
			this.itemSpec = new Music();
		}
		else this.itemSpec = new Item();
	}

	public Item getItemSpec() {
		return itemSpec;
	}
	public boolean appliesTo(Item item) {
		if (itemSpec.getName() != null
				&& !itemSpec.getName().equals(item.getName())) {
			return false;
		}
		if (itemSpec.getCategory() != null
				&& !itemSpec.getCategory().equals(item.getCategory())) {
			return false;
		}

		// applies filter only if the flag (secondHand) is true)
		if (itemSpec.isSecondhand() && !item.isSecondhand()) {
			return false;
		}

		// applies filter only if the flag (polish) is true)
		if (itemSpec.isPolish() && !item.isPolish()) {
			return false;
		}

		if (itemSpec.getCategory().equals(Category.BOOKS) && ((Book)itemSpec).isHardcover() && !((Book)item).isHardcover()) {
			return false;
		}

		if (itemSpec.getCategory().equals(Category.ELECTRONICS) && ((Electronics)itemSpec).isMobile() && !((Electronics)item).isMobile()) {
			return false;
		}

		if (itemSpec.getCategory().equals(Category.ELECTRONICS) && ((Electronics)itemSpec).isWarranty() && !((Electronics)item).isWarranty()) {
			return false;
		}

		if (itemSpec.getCategory().equals(Category.MUSIC) && ((Music)itemSpec).isVideoAdded() && !((Music)item).isVideoAdded()) {
			return false;
		}

		return true;
	}

}