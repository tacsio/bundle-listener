package parser.agent;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

import parser.event.Event;

@XmlType(name = "")
@XmlAccessorType(XmlAccessType.FIELD)
public class Transformer {

	public static final String[] TYPES = {"mapping", "class", "query"};
	
	@XmlAttribute(name = "type")
	private String type;
	
	@XmlElementWrapper(name = "input-events")
	@XmlElement(name = "event")
	private List<Event> inputEvents;
	
	@XmlElementWrapper(name = "output-events")
	@XmlElement(name = "event")
	private List<Event> outputEvents;
	
	@XmlElementWrapper(name = "mappings")
	@XmlElement(name = "mapping")
	private List<Mapping> mappings;

	@XmlElement(name = "query")
	private String query;
	
	@XmlElement(name = "classname")
	private String classname;
	
	@XmlTransient
	private Map<String, Map<String, String>> eventMappings;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public List<Event> getOutputEvents() {
		return outputEvents;
	}

	public void setOutputEvents(List<Event> outputEvents) {
		this.outputEvents = outputEvents;
	}

	public List<Event> getInputEvents() {
		return inputEvents;
	}

	public void setInputEvents(List<Event> inputEvents) {
		this.inputEvents = inputEvents;
	}

	public Map<String, Map<String, String>> getMapping() {
		if(eventMappings == null){
			eventMappings = new HashMap<String, Map<String, String>>();
			for(Mapping m : mappings) {
				eventMappings.put(m.getEvent(), m.getMapping());
			}
		}
		return eventMappings;
	}

	public void setMapping(Map<String, Map<String, String>>  mapping) {
		this.eventMappings = mapping;
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public String getClassname() {
		return classname;
	}

	public void setClassname(String classname) {
		this.classname = classname;
	}
}
