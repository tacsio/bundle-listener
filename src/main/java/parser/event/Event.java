package parser.event;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;

import parser.Property;

@XmlType(name= "")
@XmlAccessorType(XmlAccessType.FIELD)
public class Event {

	@XmlAttribute(required = true)
	private String id;

	@XmlElementWrapper(name = "properties")
	@XmlElement(name = "property")
	private List<Property> properties;

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Map<String, String> getProperties() {
		Map<String, String> props  = new HashMap<String, String>();
		for(Property p : properties){
			props.put(p.getId(), p.getType());
		}
		return props;
	}

	public void setProperties(List<Property> properties) {
		this.properties = properties;
	}
	
	public void setProperties(Map<String, String> properties){
		this.properties = new ArrayList<Property>();
		for(String key : properties.keySet()){
			
			Property p = new Property();
			p.setId(key);
			p.setType(properties.get(key));

			this.properties.add(p);
		}
	}

}
