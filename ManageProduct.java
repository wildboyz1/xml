package XML;

import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ManageProduct {
	private static String filename = "src//XML//Products.xml";
	private DocumentBuilderFactory factory;
	private DocumentBuilder builder;
	private Document document;
	
	public ManageProduct() {
		try {
			factory = DocumentBuilderFactory.newInstance();
			builder = factory.newDocumentBuilder();
			document = builder.parse(filename);
		} catch (ParserConfigurationException e) {
			// TODO: handle exception
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void addProduct(Products p) {
		// root
		Element root = document.getDocumentElement();
		
		// trong root co nhieu con (con la Element)
		Element pNode = document.createElement("Product");
		root.appendChild(pNode);
		pNode.setAttribute("ID",p.getID());
		
		// trong Element co nhieu con( con la node)
		Node Pname = document.createElement("name");
		pNode.appendChild(Pname);
		Pname.setTextContent(p.getName());
		
		
		Node Pmanufacture = document.createElement("manufacture");
		pNode.appendChild(Pmanufacture);
		Pmanufacture.setTextContent(p.getManufacture());
		
		
		Node Pdescription = document.createElement("description");
		pNode.appendChild(Pdescription);
		Pdescription.setTextContent(p.getDescription());
		
		
				Element pSupplier = document.createElement("Supplier");
				pNode.appendChild(pSupplier);
				Node nameSupplier = document.createElement("Supplier name");
				pSupplier.appendChild(nameSupplier);
				nameSupplier.setTextContent(p.getSupplier().getName());
				
				Node countrySupplier = document.createElement("Country");
				pSupplier.appendChild(countrySupplier);
				countrySupplier.setTextContent(p.getSupplier().getCountry());
				

				Node WWWSupplier = document.createElement("website");
				pSupplier.appendChild(WWWSupplier);
				WWWSupplier.setTextContent(p.getSupplier().getWebSite());
			
				
		Node Pprice = document.createElement("price");
		pNode.appendChild(Pprice);
		Pprice.setTextContent(p.getPrice()+"");
				
		
		
	}
	public void writeXMLFile() {
		TransformerFactory factory = null;
		Transformer transformer = null;
		try {

			factory = TransformerFactory.newInstance();
			transformer = factory.newTransformer();
			transformer.setOutputProperty(OutputKeys. INDENT, "yes");
			transformer.transform(new DOMSource(document), new StreamResult(filename));
		}catch(Exception ex) {
			ex.printStackTrace();

		}
	}


	public void printAll() {
		TransformerFactory factory = null;
		Transformer transformer = null;
			try {
				factory = TransformerFactory.newInstance();
				transformer = factory.newTransformer();
				transformer.setOutputProperty(OutputKeys. INDENT, "yes");
				transformer.transform(new DOMSource(document), new StreamResult(System.out));
			}catch(Exception ex) {
				ex.printStackTrace();
	   	}
	}
	public void deleteProduct(String pid) {
		Element root = document.getDocumentElement();
		NodeList plist = root.getElementsByTagName("product");
		for (int i = 0; i < plist.getLength(); i++) {
			Element pNode = (Element) plist.item(i);
			String productID = pNode.getAttribute("id");
			if (productID.equalsIgnoreCase(pid)){
				pNode.getParentNode().removeChild(pNode);
				break;
			}
		}
	}
	public void updatePrice(String pid, double newPrice) {
		Element root = document.getDocumentElement();
		NodeList plist = root.getElementsByTagName("product");
		for (int i = 0; i < plist.getLength(); i++) {
			Element pNode = (Element) plist.item(i);
			String productID = pNode.getAttribute("id");
			if (productID.equalsIgnoreCase(pid)){
				Node priceNode = pNode.getElementsByTagName("price").item(0);
				priceNode.setTextContent(newPrice + "");
				break;
			}
		}
	}
	public ArrayList<Products> getAllProducts(){

		ArrayList<Products> list = new ArrayList<Products>();
		Element root = document.getDocumentElement();
		NodeList plist = root.getElementsByTagName("product");
		int pCount = plist.getLength();
		for (int i = 0; i < pCount; i++) {
			Element pNode = (Element) plist.item(i);
			String productID = pNode.getAttribute("id");
			String name = pNode.getElementsByTagName("productName").item(0).getTextContent();
			String manufacture = pNode.getElementsByTagName("manufacture").item(0).getTextContent();
			String description = pNode.getElementsByTagName("description").item(0).getTextContent();
			Element sNode = (Element) pNode.getElementsByTagName("suplier").item(0);
			String sName = sNode.getElementsByTagName("suplierName").item(0).getTextContent();
			String country = sNode.getElementsByTagName("country").item(0).getTextContent();
			String website = sNode.getElementsByTagName("website").item(0).getTextContent();
			Supplier supplier = new Supplier (sName, country, website);
			String sprice = pNode.getElementsByTagName("price").item(0).getTextContent();
			double price = 0.0;
			try{
				price = Double.valueOf(sprice);
			}catch(NumberFormatException ex) {}
				Products p = new Products(productID, sName, manufacture, description, supplier, sprice);
				list.add(p);
			}
		return list;
		}
}

	
	

		
