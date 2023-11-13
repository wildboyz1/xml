package XML;

public class Products {
	private String ID;
	private String Name;
	private String manufacture;
	private String description;
	private Supplier supplier;
	private String price;
	
	
	public Products(String ID,String name, String manufacture, String description, Supplier supplier, String price) {
		this.ID = ID;
		this.Name= name;
		this.manufacture = manufacture;
		this.description = description;
		this.supplier = supplier;
		this.price = price;
	}
	
	
	public Products() {
		super();
		// TODO Auto-generated constructor stub
	}


	
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getManufacture() {
		return manufacture;
	}
	public void setManufacture(String manufacture) {
		this.manufacture = manufacture;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Supplier getSupplier() {
		return supplier;
	}
	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	
	
	
}
