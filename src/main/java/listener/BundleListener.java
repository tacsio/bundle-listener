package listener;

import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleEvent;
import org.osgi.util.tracker.BundleTracker;

import parser.agent.AgentList;
import parser.event.EventList;

public class BundleListener extends BundleTracker {

	private BundleContext ctx;
	private Map<String, Unmarshaller> JAXBContexts;
	
	
	public BundleListener(BundleContext context) {
		super(context, Bundle.ACTIVE, null);
		this.ctx = context;
		this.initJAXBContexts();
	}
	
	
	@Override
	public Object addingBundle(Bundle bundle, BundleEvent event) {
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

	private void initJAXBContexts() {
		try {
			this.initEvent();
			this.initAgent();
			this.initContextModel();
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}


	private void initAgent() throws JAXBException {
		JAXBContext context =  JAXBContext.newInstance(AgentList.class);
		JAXBContexts.put(AgentList.CONFIG, context.createUnmarshaller());
	}


	private void initEvent() throws JAXBException {
		JAXBContext context = JAXBContext.newInstance(EventList.class); 
		JAXBContexts.put(EventList.CONFIG, context.createUnmarshaller());
	}
	
	private void initContextModel(){
		//TODO
	}
	
}
