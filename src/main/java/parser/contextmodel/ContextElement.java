package parser.contextmodel;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "")
@XmlAccessorType(XmlAccessType.FIELD)
public class ContextElement {
	
	@XmlAttribute(name = "id")
	private String id;
	
	@XmlAttribute(name = "event-property")
	private String eventProperty;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEventProperty() {
		return eventProperty;
	}

	public void setEventProperty(String eventProperty) {
		this.eventProperty = eventProperty;
	}

}
