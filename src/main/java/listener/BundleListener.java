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

import br.ufpe.cin.dsoa.epcenter.EventConsumer;
import br.ufpe.cin.dsoa.epcenter.EventProcessingCenter;

import parser.JAXBInitializer;
import parser.agent.Agent;
import parser.agent.AgentList;
import parser.contextmodel.Context;
import parser.contextmodel.ContextElement;
import parser.contextmodel.ContextMapping;
import parser.contextmodel.ContextModel;
import parser.contextmodel.Element;
import parser.event.Event;
import parser.event.EventList;

public class BundleListener extends BundleTracker {

	private BundleContext ctx;
	private Map<String, Unmarshaller> JAXBContexts;
	private EventProcessingCenter epCenter;
	
	private static Logger logger = Logger.getLogger(BundleListener.class.getName());
	
	public BundleListener(BundleContext context) throws JAXBException {
		super(context, Bundle.ACTIVE, null);
		this.ctx = context;
		this.JAXBContexts = JAXBInitializer.initJAXBContexts();
	}
	
	
	@Override
	public Object addingBundle(Bundle bundle, BundleEvent event) {
		try {
			this.handleEventDefinition(bundle);
			this.handleAgentDefinition(bundle);
			this.handleContextDefinition(bundle);
		} catch (JAXBException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
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
	
	
	private void handleEventDefinition(Bundle bundle) throws JAXBException, ClassNotFoundException {
		URL url = bundle.getEntry(EventList.CONFIG);
		if(url != null) {
			EventList list = (EventList) JAXBContexts.get(EventList.CONFIG).unmarshal(url);
			
			for(Event e : list.getEvents()) {
				this.epCenter.defineEvent(e.getType(), e.getProperties());
			}
		}
	}
	
	private void handleAgentDefinition(Bundle bundle) throws JAXBException {
		URL url = bundle.getEntry(AgentList.CONFIG);
		if(url != null) {
			AgentList list = (AgentList) JAXBContexts.get(AgentList.CONFIG).unmarshal(url);
			
			for(Agent a : list.getAgents()) {
				EventConsumer consumer = new EventConsumer() {
					
					public void receive(Map result, Object userObject, String statementName) {
						
					}
				};
				
				for(Event e : a.getTransformer().getInputEvents()){
					epCenter.subscribe(e.getType(), consumer);
				}
				logger.info(String.format("Agent name: %s", a.getName()));//LOG
			}
		}
	}
	
	private void handleContextDefinition(Bundle bundle) throws JAXBException {
		URL url = bundle.getEntry(ContextModel.CONFIG);
		if(url != null) {
			ContextModel contextModel = (ContextModel) JAXBContexts.get(ContextModel.CONFIG).unmarshal(url);
			logger.info("Context :");//LOG
			for(Context c : contextModel.getContexts()) {
				logger.info(String.format("Context Category: %s", c.getCategory()));//LOG
				
				for(Element e : c.getElements()) {
					logger.info(String.format("Element id: %s", e.getId()));
				}
			}
			
			for(ContextMapping cm : contextModel.getContextMappings()) {
				logger.info(String.format("Context Mapping: %s", cm.getCategory()));
				
				for(ContextElement ce : cm.getContextElements()) {
					logger.info(String.format("Event Property: %s", ce.getEventProperty()));
				}
			}
		}
	}


}
