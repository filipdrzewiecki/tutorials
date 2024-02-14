package com.drzewiecki.pattern.proxy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ObjectService implements Service {

    public ObjectService() {
        someConfiguration();
    }

    @Override
    public void process() {
        log.info("processing");
    }

    private void someConfiguration() {
        log.info("Loading initial configuration...");
    }
}
