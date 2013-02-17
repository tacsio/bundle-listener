package parser;

import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Set;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.junit.Before;
import org.junit.Test;

import parser.event.Event;
import parser.event.EventList;

public class EventParserSpec {

	private JAXBContext context;
	private Unmarshaller u;
	private EventList list;

	@Before
	public void setUp() throws JAXBException, FileNotFoundException {
		context = JAXBContext.newInstance(EventList.class);
		u = context.createUnmarshaller();
		
		list = this.getList();
	}

	private EventList getList() throws FileNotFoundException, JAXBException {
		EventList list = (EventList) u.unmarshal(new FileInputStream(
				"src/test/resources/event.xml"));
		return list;
	}
	
	@Test
	public void testConfigPath(){
		assertEquals(EventList.CONFIG, "DSOA-INF/event.xml");
	}
	
	@Test
	public void testEventId(){
		Event e = list.getEvents().get(0);
		assertEquals("xml has modified", "ResponseTimeEvent", e.getId());
	}

	@Test
	public void testEventList() throws JAXBException, FileNotFoundException {
		assertNotNull(list.getEvents());
	}

	@Test
	public void testEvetProperties() throws FileNotFoundException,
			JAXBException {
		for (Event e : list.getEvents()) {
			Map<String, String> props = e.getProperties();
			assertNotNull(props);
		}
	}

	@Test
	public void testEventProperty() throws FileNotFoundException, JAXBException {

		Event e = list.getEvents().get(0);
		assertEquals(3, e.getProperties().size());
		
		Set<String> set = e.getProperties().keySet();
		for(Object id : set){
			assertNotNull(e.getProperties().get(id));
		}
	}

}
