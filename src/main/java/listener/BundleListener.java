package listener;

import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleEvent;
import org.osgi.util.tracker.BundleTracker;

public class BundleListener extends BundleTracker {

	private BundleContext ctx;
	private Map<String, Unmarshaller> jaxbContexts;
	
	
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
		this.initEvent();
		//this.initAgent();
		//this.initContextModel();
	}


	private void initEvent() {
		//JAXBContext context = JAXBContext.newInstance(classesToBeBound) 
	}
	
}
