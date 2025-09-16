package org.codeus.design_patterns.cor.handler;

import org.codeus.design_patterns.cor.BankRequest;

import static org.codeus.design_patterns.cor.Constants.AML_THRESHOLD;
import static org.codeus.design_patterns.cor.Constants.DAILY_LIMIT;

public class DailyLimitRequestHandler extends BaseRequestHandler {

    @Override
    public void handle(BankRequest request) {
        System.out.println("DailyLimitRequestHandler: Handling request " + request);

        var amount = request.getAmount();
        if (amount > DAILY_LIMIT && amount < AML_THRESHOLD) {
            throw new IllegalArgumentException("Daily limit exceeded: " + request.getAmount());
        }

        super.handle(request);
    }
}
