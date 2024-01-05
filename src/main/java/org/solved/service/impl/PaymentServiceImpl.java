package org.solved.service.impl;

import org.solved.domain.Payment;

import org.solved.persistence.implementation.GeneralRepositoryImplementation;
import org.solved.persistence.implementation.PaymentRepositoryImplementation;

public class PaymentServiceImpl extends SimpleServiceImpl<Payment> {

    @Override
    public Payment getEntity(String name) {
        return new Payment(name);
    }

    @Override
    public GeneralRepositoryImplementation<Payment> getImplementation() {
        return new PaymentRepositoryImplementation();
    }


}
