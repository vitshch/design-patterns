package org.codeus.design_patterns.cor.handler;

import org.codeus.design_patterns.cor.BankRequest;

public class LoggingRequestHandler extends BaseRequestHandler {

    @Override
    public void handle(BankRequest request) {
        System.out.println("Processed: " + request);
        super.handle(request);
    }

}
