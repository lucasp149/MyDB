package org.solved.service.impl;

import org.solved.domain.Zone;
import org.solved.persistence.implementation.GeneralRepositoryImplementation;
import org.solved.persistence.implementation.ZoneRepositoryImplementation;


public class ZoneServiceImp extends SimpleServiceImpl<Zone> {

    @Override
    public GeneralRepositoryImplementation<Zone> getImplementation() {
        return new ZoneRepositoryImplementation();
    }

    @Override
    public Zone getEntity(String name) {
        return new Zone(name);
    }


}