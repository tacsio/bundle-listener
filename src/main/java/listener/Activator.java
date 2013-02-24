package listener;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import br.ufpe.cin.dsoa.epcenter.EventProcessingCenter;

public class Activator implements BundleActivator{

	private BundleListener listener;
	
	public void start(BundleContext context) throws Exception {
		listener = new BundleListener(context);
		injectEpCenter(context);
		listener.open();
	}

	public void stop(BundleContext context) throws Exception {
		listener.close();
	}
	
	@Deprecated
	private void injectEpCenter(BundleContext context){
		ServiceReference ref = context.getServiceReference("br.ufpe.cin.dsoa.epcenter.EventProcessingCenter");
		EventProcessingCenter epCenter = (EventProcessingCenter) context.getService(ref);
		listener.setEpCenter(epCenter);
		
	}

}
