package org.codeus.design_patterns.cor.handler;

import org.codeus.design_patterns.cor.BankRequest;

public class BaseRequestHandler implements RequestHandler {

    private RequestHandler next;

    @Override
    public void setNext(RequestHandler nextHandler) {
        next = nextHandler;
    }

    @Override
    public void handle(BankRequest request) {
        if (next != null) {
            next.handle(request);
        }
    }

}
