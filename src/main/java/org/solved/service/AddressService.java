package org.solved.service;

import org.solved.domain.Address;
import org.solved.domain.City;

public interface AddressService {

    public Address create (String streetName, Integer number, City city);

}
