package org.solved.service.impl;

import org.solved.domain.Address;
import org.solved.domain.Store;
import org.solved.persistence.implementation.GeneralRepositoryImplementation;
import org.solved.persistence.implementation.StoreRepositoryImplementation;

public class StoreServiceImpl extends DoubleServiceImpl<Store, Address>{

    @Override
    public SimpleServiceImpl<Address> getSecondaryService() {
        return new AddressServiceImpl();
    }

    @Override
    public GeneralRepositoryImplementation<Store> getImplementation() {
        return new StoreRepositoryImplementation();
    }

    @Override
    public Store getEntity(String name) {
        return new Store(name);
    }
}
