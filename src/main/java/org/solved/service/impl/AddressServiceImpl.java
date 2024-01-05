package org.solved.service.impl;

import org.solved.domain.Address;
import org.solved.domain.City;
import org.solved.persistence.implementation.AddressRepositoryImplementation;
import org.solved.persistence.implementation.GeneralRepositoryImplementation;

public class AddressServiceImpl extends DoubleServiceImpl<Address, City>{
    AddressRepositoryImplementation addressRep = new AddressRepositoryImplementation();


   /* public Address create(String streetNameAndNumber, City city) {
        City checkedCity = new CityServiceImpl().create(city.getName(), city.getZone());
        Long id = addressRep.findByName(streetNameAndNumber);
        Address address;
        if (id == 0L) {

            try {
                Long addressId = addressRep.create(new Address(streetName, number), city.getId());
                address = addressRep.getById(addressId);
                address.setId(addressId);
                address.setCity(checkedCity);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        } else {
            try {
                address = addressRep.getById(id);
                address.setCity(checkedCity);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return address;
    }
*/
    @Override
    public GeneralRepositoryImplementation<Address> getImplementation() {
        return new AddressRepositoryImplementation();
    }

    @Override
    public Address getEntity(String name) {
        return new Address(addressRep.separateStreetName(name),addressRep.separateStreetNumber(name));
    }

    @Override
    public SimpleServiceImpl<City> getSecondaryService() {
        return new CityServiceImpl();
    }

}
