package org.codeus.design_patterns.cor;

import org.codeus.design_patterns.cor.handler.*;

public class BankRequestProcessor {

    public void process(BankRequest request) {
        RequestHandler handlerChain = getHandlerChain(request);
        handlerChain.handle(request);
    }

    private RequestHandler getHandlerChain(BankRequest bankRequest) {
        RequestType type = bankRequest.getType();
        if (type == null) {
            throw new IllegalArgumentException("Request type is null");
        }
        if (type == RequestType.TRANSFER || type == RequestType.BILL_PAYMENT) {
            return buildTransferChain();
        } else if (type == RequestType.CREDIT_APPLICATION) {
            return buildCreditApplicationChain();
        }
        throw new IllegalArgumentException("Unsupported request type: " + type);
    }

    private RequestHandler buildTransferChain() {
        return buildChain(
                new DailyLimitRequestHandler(),
                new AmlRequestHandler(),
                new TransferRequestHandler(),
                new LoggingRequestHandler()
        );
    }

    private RequestHandler buildCreditApplicationChain() {
        return buildChain(
                new AmlRequestHandler(),
                new LoggingRequestHandler()
        );
    }

    private RequestHandler buildChain(RequestHandler requestHandler, RequestHandler... nextHandlers) {
        RequestHandler current = requestHandler;
        for (RequestHandler next : nextHandlers) {
            current.setNext(next);
            current = next;
        }
        return requestHandler;
    }

}
