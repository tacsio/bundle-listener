package parser.contextmodel;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "")
@XmlAccessorType(XmlAccessType.FIELD)
public class ContextMapping {
	
	@XmlAttribute(name = "category")
	private String category;
	
	@XmlElement(name = "context-element")
	private List<ContextElement> contextElements;

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Map<String, String> getContextElements() {
		Map<String, String> conElemts = new HashMap<String, String>();
		for (ContextElement ce : contextElements) {
			conElemts.put(ce.getId(), ce.getEventProperty());
		}
		return conElemts;
	}

	public void setContextElements(List<ContextElement> contextElements) {
		this.contextElements = contextElements;
	}

}
