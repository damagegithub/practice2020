package itmo.jph.hello.client;

import itmo.jph.hello.service.SayHelloService;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

public class Activator implements BundleActivator {
    public void start(BundleContext context) {
        ServiceReference ref = context.getServiceReference(SayHelloService.class.getName());
        ((SayHelloService) context.getService(ref)).hello();
    }

    public void stop(BundleContext context) {
    }
}
