package org.solved.service.impl;

import org.solved.domain.Passport;
import org.solved.persistence.implementation.GeneralRepositoryImplementation;
import org.solved.persistence.implementation.PassportRepositoryImplementation;


public class PassportServiceImpl extends SimpleServiceImpl<Passport> {


    @Override
    public GeneralRepositoryImplementation<Passport> getImplementation() {
        return new PassportRepositoryImplementation();
    }

    @Override
    public Passport getEntity(String name) {
        return new Passport(name);
    }
}
