package itmo.jph.hello.service;

public class SayHelloServiceImpl implements SayHelloService {
    @Override
    public void hello() {
        System.out.println("Hello OSGi World!");
    }
}
