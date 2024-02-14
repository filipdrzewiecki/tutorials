package com.drzewiecki.pattern.proxy;

import org.junit.jupiter.api.Test;

public class ProxyServiceTest {

    @Test
    void testProxyService() {
        Service service = new ObjectServiceProxy();
        service.process();
    }
}
