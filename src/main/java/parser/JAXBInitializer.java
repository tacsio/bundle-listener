package parser;

import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import parser.agent.AgentList;
import parser.contextmodel.ContextModel;
import parser.event.EventList;

public class JAXBInitializer {

	public static Map<String, Unmarshaller> initJAXBContexts() throws JAXBException {

		Map<String, Unmarshaller> contexts = new HashMap<String, Unmarshaller>();

		contexts.put(EventList.CONFIG, JAXBInitializer.initEvent());
		contexts.put(AgentList.CONFIG, JAXBInitializer.initAgent());
		contexts.put(ContextModel.CONFIG, JAXBInitializer.initContextModel()); 

		return contexts;
	}

	private static Unmarshaller initAgent() throws JAXBException {
		JAXBContext context = JAXBContext.newInstance(AgentList.class);
		return context.createUnmarshaller();
	}

	private static Unmarshaller initEvent() throws JAXBException {
		JAXBContext context = JAXBContext.newInstance(EventList.class);
		return context.createUnmarshaller();
	}

	private static Unmarshaller initContextModel() throws JAXBException {
		JAXBContext context = JAXBContext.newInstance(ContextModel.class);
		return context.createUnmarshaller();
	}
}
