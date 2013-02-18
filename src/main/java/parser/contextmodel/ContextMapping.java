package parser.contextmodel;

import java.util.List;

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

	public List<ContextElement> getContextElements() {
		return contextElements;
	}

	public void setContextElements(List<ContextElement> contextElements) {
		this.contextElements = contextElements;
	}

}
