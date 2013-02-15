package parser.event;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name= "")
@XmlAccessorType(XmlAccessType.FIELD)
public class Event {

	@XmlAttribute(required = true)
	private String id;

	@XmlElement(name = "properties")
	private List<Property> properties;

	private Map<String, String> props = null;

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Map<String, String> getProperties() {
		if (props == null) {
			props = new HashMap<String, String>();

			for (Property p : properties) {
				props.put(p.getId(), p.getType());
			}
		}
		
		return props;
	}

	public void setProperties(List<Property> properties) {
		this.properties = properties;
	}

}
