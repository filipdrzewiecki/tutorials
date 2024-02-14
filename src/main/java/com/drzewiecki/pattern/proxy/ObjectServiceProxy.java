package com.drzewiecki.pattern.proxy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ObjectServiceProxy implements Service {

    private static Service proxy;
    @Override
    public void process() {
        if (proxy == null) {
            proxy = new ObjectService();
        }

        log.info("Additional proxy logic");

        proxy.process();
    }
}
