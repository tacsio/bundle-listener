package parser.contextmodel;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;

@XmlType(name ="")
@XmlAccessorType(XmlAccessType.FIELD)
public class Context {
	
	@XmlAttribute(name = "category")
	private String category;
	
	@XmlElementWrapper(name = "elements")
	@XmlElement(name = "element")
	private List<Element> elements;

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Map<String, String> getElements() {
		Map<String, String> elemts = new HashMap<String, String>();
		for(Element e : elements) {
			elemts.put(e.getId(), e.getType());
		}
		return elemts;
	}

	public void setElements(List<Element> elements) {
		this.elements = elements;
	}

}
