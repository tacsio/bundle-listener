package parser.event;

import static org.junit.Assert.*;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.junit.Before;
import org.junit.Test;


public class EventParserSpec {

	private JAXBContext context;
	private Unmarshaller u;
	
	@Before
	public void setUp() throws JAXBException{
		context = JAXBContext.newInstance(EventList.class, Event.class, Property.class);
		u = context.createUnmarshaller();
	}
	
	@Test
	public void testEventList() throws JAXBException {
		EventList list = (EventList) u.unmarshal(new File("src/test/resources/events.xml"));
		assertNotNull(list.getEvents());
	}

}
