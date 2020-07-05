package itmo.jph.hello.service;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {
    public void start(BundleContext context) {
        context.registerService(SayHelloService.class.getName(), new SayHelloServiceImpl(), null);
        System.out.println("Started Say Hello Service.");
    }

    public void stop(BundleContext context) {
        System.out.println("Stopped Say Hello Service.");
    }
}
