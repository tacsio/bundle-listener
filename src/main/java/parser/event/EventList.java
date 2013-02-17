package parser.event;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "events")
@XmlType(name = "")
@XmlAccessorType(XmlAccessType.FIELD)
public class EventList {

	@XmlElement(name = "event")
	private List<Event> events;

	public static final String CONFIG = "DSOA-INF/event.xml";
	
	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}
}
