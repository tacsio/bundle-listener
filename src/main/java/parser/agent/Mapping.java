package parser.agent;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import parser.Property;

@XmlType(name = "")
@XmlAccessorType(XmlAccessType.FIELD)
public class Mapping {

	@XmlAttribute(name = "event")
	private String event;

	@XmlElement(name = "property")
	private List<Property> mapping;

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	public Map<String, String> getMapping() {
		Map<String, String> props = new HashMap<String, String>();

		for (Property p : mapping) {
			props.put(p.getId(), p.getType());
		}
		return props;
	}

	public void setMapping(String event, List<Property> mapping) {
		this.event = event;
		this.mapping = mapping;
	}
}
