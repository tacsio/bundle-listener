package parser.agent;

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
import parser.event.type.InputEvent;
import parser.event.type.OutputEvent;

@XmlType(name = "")
@XmlAccessorType(XmlAccessType.FIELD)
public class Transformer {

	public static final String[] TYPES = {"mapping", "class"};
	
	@XmlAttribute(name = "type")
	private String type;
	
	@XmlElement(name = "input-event")
	private InputEvent inputEvent;
	
	@XmlElement(name = "output-event")
	private OutputEvent outputEvent;
	
	@XmlElementWrapper(name = "mapping")
	@XmlElement(name = "property")
	private List<Property> mapping;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public InputEvent getInputEvent() {
		return inputEvent;
	}

	public void setInputEvent(InputEvent inputEvent) {
		this.inputEvent = inputEvent;
	}

	public OutputEvent getOutputEvent() {
		return outputEvent;
	}

	public void setOutputEvent(OutputEvent outputEvent) {
		this.outputEvent = outputEvent;
	}

	public Map<String, String> getMapping() {
		Map<String, String> props  = new HashMap<String, String>();
		for(Property p : mapping){
			props.put(p.getId(), p.getType());
		}
		
		return props;
	}

	public void setMapping(List<Property> mapping) {
		this.mapping = mapping;
	}

}
