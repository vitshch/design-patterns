package org.codeus.design_patterns.cor.handler;

import org.codeus.design_patterns.cor.BankRequest;

public interface RequestHandler {

    void setNext(RequestHandler nextHandler);
    void handle(BankRequest request);

}
