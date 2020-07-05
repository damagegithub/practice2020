package itmo.jph.hello.serviceSCR;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;

@Component(name = "Say Hello Service SCR", immediate = true, service = SayHelloServiceSCR.class)
public class SayHelloServiceSCRImpl implements SayHelloServiceSCR {

    public void hello() {
        System.out.println("Hello OSGi World!");
    }

    @Activate
    protected void activate() {
        System.out.println("activate service SCR");
    }

    @Deactivate
    protected void deactivate() {
        System.out.println("deactivate service SCR");
    }
}
