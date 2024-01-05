package org.solved.service;

import org.solved.domain.City;

public interface CityService {

    public City create (String name, String zone);
    public City find (Long id);
}
