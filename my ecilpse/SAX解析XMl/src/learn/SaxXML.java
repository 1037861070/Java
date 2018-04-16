package learn;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


public class SaxXML extends DefaultHandler{
	
	private List<book> list;
	
	private book onebook;
	
	private String tagName;

	public List<book> getList() {
		return list;
	}

	public void setList(List<book> list) {
		this.list = list;
	}

	public book getOnebook() {
		return onebook;
	}

	public void setOnebook(book onebook) {
		this.onebook = onebook;
	}

	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}
	
	@Override
	public void startDocument() throws SAXException {
		list = new ArrayList<book>();
	}
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		if(qName.equals("book")){
			onebook = new book();
			onebook.setId(attributes.getValue(0));
			onebook.setBookcategory(attributes.getValue(1));
			onebook.setAmount(Integer.parseInt(attributes.getValue(2)));
			onebook.setRemain(Integer.parseInt(attributes.getValue(3)));
			onebook.setDiscount(Double.parseDouble(attributes.getValue(4)));
		}
		this.tagName = qName;
	}
	
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if(qName.equals("book")){
			this.list.add(this.onebook);
		}
		this.tagName = null;
	}
	
	@Override
	public void endDocument() throws SAXException {
	}
	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		
		if(this.tagName!=null){
			String data = new String(ch, start, length);
			if(this.tagName.equals("title")){
				this.onebook.setTitle(data);
			}else if(this.tagName.equals("author")){
				this.onebook.setAuthor(data);
			}else if(this.tagName.equals("publisher")){
				this.onebook.setPublisher(data);
			}else if(this.tagName.equals("ISBN")){
				this.onebook.setISBN(data);
			}else if(this.tagName.equals("price")){
				this.onebook.setPrice(Double.parseDouble(data));
			}
		}
	}
	
	public static void main(String[] args) {
		SAXParser parser = null;
		try {
			parser = SAXParserFactory.newInstance().newSAXParser();
			SaxXML parseXML = new SaxXML();
			InputStream stream = new FileInputStream(new File("src/book.xml"));
			parser.parse(stream, parseXML);
			List<book> list = parseXML.getList();
			String format = "%-10s %-10s %-10s %-10s %-10s %-10s %-10s %-10s %-10s %-10s\n";
			String format1 = "%-10s %-28s %-10s %-10s %-10s %-20s %-20s %-20s %-20s %-20s\n";
			System.out.format(format, "id","category","amount","remain","discount","title","author","publisher","ISBN","price");
			for(book onebook : list){
				System.out.format(format1,onebook.getId(),onebook.getBookcategory(),onebook.getAmount(),onebook.getRemain(),
				                   onebook.getDiscount(),onebook.getTitle(),onebook.getAuthor(),
				                   onebook.getPublisher(),onebook.getISBN(),onebook.getPrice());
			}
			System.out.println("--------------------------²éÑ¯½á¹û------------------------");
			for(book onebook : list){
				if("p0002".equals(onebook.getId())){
					System.out.format(format1,onebook.getId(),onebook.getBookcategory(),onebook.getAmount(),onebook.getRemain(),
			                   onebook.getDiscount(),onebook.getTitle(),onebook.getAuthor(),
			                   onebook.getPublisher(),onebook.getISBN(),onebook.getPrice());
				}
			}
		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}
		
	}
}

