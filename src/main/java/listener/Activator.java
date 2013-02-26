package listener;

import javax.xml.bind.JAXBException;

import org.osgi.framework.BundleContext;

import br.ufpe.cin.dsoa.epcenter.EventProcessingCenter;

public class Activator {

	private BundleListener listener;
	private EventProcessingCenter epCenter;
	private BundleContext context;

	public Activator(BundleContext context) {
		this.context = context;
	}

	public void start() {
		try {
			listener = new BundleListener(context);
			listener.setEpCenter(epCenter);
			listener.open();
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

	public void stop(BundleContext context) throws Exception {
		listener.close();
	}
}
