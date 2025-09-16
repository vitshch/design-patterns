package org.codeus.design_patterns.cor.handler;

import org.codeus.design_patterns.cor.BankRequest;
import org.codeus.design_patterns.cor.Constants;
import org.codeus.design_patterns.cor.RequestType;

public class TransferRequestHandler extends BaseRequestHandler {

    @Override
    public void handle(BankRequest request) {
        System.out.println("TransferRequestHandler: Handling request " + request);

        RequestType type = request.getType();
        if (type == RequestType.TRANSFER || type == RequestType.BILL_PAYMENT) {
            request.setAmount(request.getAmount() * (1 + Constants.COMMISSION_TRANSFER_RATE));
        }

        super.handle(request);
    }

}
