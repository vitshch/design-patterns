package org.codeus.design_patterns.cor.handler;

import org.codeus.design_patterns.cor.BankRequest;
import org.codeus.design_patterns.cor.Constants;

public class AmlRequestHandler extends BaseRequestHandler {

    @Override
    public void handle(BankRequest request) {
        if (request.getAmount() > Constants.AML_THRESHOLD) {
            throw new IllegalArgumentException("Blocked by AML");
        }

        super.handle(request);
    }

}
