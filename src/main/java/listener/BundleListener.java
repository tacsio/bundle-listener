package listener;

import java.net.URL;
import java.util.Map;
import java.util.logging.Logger;

import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleEvent;
import org.osgi.util.tracker.BundleTracker;

import parser.JAXBInitializer;
import parser.agent.Agent;
import parser.agent.AgentList;
import parser.event.Event;
import parser.event.EventList;

public class BundleListener extends BundleTracker {

	private BundleContext ctx;
	private Map<String, Unmarshaller> JAXBContexts;
	
	private static Logger logger = Logger.getLogger(BundleListener.class.getName());
	
	public BundleListener(BundleContext context) throws JAXBException {
		super(context, Bundle.ACTIVE, null);
		this.ctx = context;
		this.JAXBContexts = JAXBInitializer.initJAXBContexts();
	}
	
	
	@Override
	public Object addingBundle(Bundle bundle, BundleEvent event) {
		try {
			//search for event definitions
			this.handleEventDefinition(bundle);
			this.handleAgentDefinition(bundle);
			//TODO:Context model
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		
		return super.addingBundle(bundle, event);
	}
	
	@Override
	public void remove(Bundle bundle) {
		super.remove(bundle);
	}
	
	@Override
	public void modifiedBundle(Bundle bundle, BundleEvent event, Object object) {
		super.modifiedBundle(bundle, event, object);
	}
	
	
	private void handleEventDefinition(Bundle bundle) throws JAXBException {
		URL url = bundle.getEntry(EventList.CONFIG);
		if(url != null) {
			EventList list = (EventList) JAXBContexts.get(EventList.CONFIG).unmarshal(url);
			logger.info("Event list:");//LOG
			for(Event e : list.getEvents()) {
				logger.info(String.format("Event id: %s", e.getId()));//LOG
			}
		}
	}
	
	private void handleAgentDefinition(Bundle bundle) throws JAXBException {
		URL url = bundle.getEntry(AgentList.CONFIG);
		if(url != null) {
			AgentList list = (AgentList) JAXBContexts.get(AgentList.CONFIG).unmarshal(url);
			logger.info("Agent list:");//LOG
			for(Agent a : list.getAgents()) {
				logger.info(String.format("Agent name: %s", a.getName()));//LOG
			}
		}
	}

}
