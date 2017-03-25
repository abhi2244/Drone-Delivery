package version_1;

/**
 * @author Abhishek
 *
 */


public class Item {
	
	private String Address;
	private String Name;
//	private int Price;

	
	/**
	 * @param  set Address to Item
	 */
	public String getItemAddress() {
		return Address;
	}
	/**
	 * @param  set Address to Item
	 */
	public void setItemAddress(String Address) {
		this.Address = Address;
	}
	
	/**
	 * @return Item name
	 */
	public String getItemName() {
		return Name;
	}
	/**
	 * @param set Item name
	 */
	public void setItemName(String ItemName) {
		this.Name = ItemName;
	}
	
//	/**
//	 * @return Item price
//	 */
//	public int getItemPrice() {
//		return Price;
//	}
//	/**
//	 * @param set Item name
//	 */
//	public void setItemPrice(int Price) {
//		this.Price = Price;
//	}
//	
	
}
