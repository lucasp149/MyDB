package org.solved.service.impl;

import org.solved.domain.Address;
import org.solved.domain.Client;
import org.solved.domain.Passport;
import org.solved.persistence.implementation.ClientRepositoryImplementation;
import org.solved.persistence.implementation.GeneralRepositoryImplementation;

public class ClientServiceImpl extends TripleServiceImpl<Client, Address, Passport> {

    ClientRepositoryImplementation clientRep = new ClientRepositoryImplementation();


    @Override
    public GeneralRepositoryImplementation<Client> getImplementation() {
        return new ClientRepositoryImplementation();
    }

    @Override
    public Client getEntity(String name) {
        return new Client(clientRep.separateFirstName(name), clientRep.separateLastName(name));
    }

    @Override
    public SimpleServiceImpl<Address> getSecondaryService() {
        return new AddressServiceImpl();
    }

    @Override
    public SimpleServiceImpl<Passport> getThirdService() {
        return new PassportServiceImpl();
    }
}
