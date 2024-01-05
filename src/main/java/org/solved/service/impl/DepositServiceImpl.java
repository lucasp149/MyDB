package org.solved.service.impl;

import org.solved.domain.Address;
import org.solved.domain.Deposit;
import org.solved.persistence.implementation.DepositRepositoryImplementation;
import org.solved.persistence.implementation.GeneralRepositoryImplementation;


public class DepositServiceImpl extends DoubleServiceImpl<Deposit, Address> {


    @Override
    public SimpleServiceImpl<Address> getSecondaryService() {
        return new AddressServiceImpl();
    }

    @Override
    public GeneralRepositoryImplementation<Deposit> getImplementation() {
        return new DepositRepositoryImplementation();
    }
    @Override
    public Deposit getEntity(String name) {
        return new Deposit(name);
    }

}
