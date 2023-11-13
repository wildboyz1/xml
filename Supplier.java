package XML;

public class Supplier {
	private String Name;
	private String Country;
	private String webSite;
	
	
	public Supplier() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Supplier(String name, String country, String webSite) {
		super();
		Name = name;
		Country = country;
		this.webSite = webSite;
	}

	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getCountry() {
		return Country;
	}
	public void setCountry(String country) {
		Country = country;
	}
	public String getWebSite() {
		return webSite;
	}
	public void setWebSite(String webSite) {
		this.webSite = webSite;
	}
	
	
	

}
