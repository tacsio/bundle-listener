package listener;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator{

	private BundleListener listener;
	
	public void start(BundleContext context) throws Exception {
		listener = new BundleListener(context);
		listener.open();
	}

	public void stop(BundleContext context) throws Exception {
		listener.close();
	}

}
