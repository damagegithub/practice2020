package itmo.jph.command;

import org.osgi.framework.BundleContext;

public class HelloCommand {
    BundleContext bundleContext;

    public HelloCommand(BundleContext bundleContext) {
        this.bundleContext = bundleContext;
    }

    public void hello(String str) {
        System.out.println("Hello, " + str);
    }
}
