package org.solved.service.impl;

import org.solved.domain.City;
import org.solved.domain.Zone;
import org.solved.persistence.implementation.CityRepositoryImplementation;
import org.solved.persistence.implementation.GeneralRepositoryImplementation;

public class CityServiceImpl extends DoubleServiceImpl<City,Zone> {

    @Override
    public SimpleServiceImpl<Zone> getSecondaryService() {
        return  new ZoneServiceImp();
    }
 /*
    public City create(String name, Zone zone) {
        Long id = cityRep.findByName(name);
        Zone checkedZone = zoneService.create(zone.getName());
        City city;
        if (id == 0L) {
            try {
                city = new City(name, zone);
                Long cityId = cityRep.create(city);
                city.setId(cityId);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } else {
            try {
                city = cityRep.getById(id);
                city.setZone(zoneService.find(cityRep.getZoneName(id)));
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }
        return city;
    }
*/

    @Override
    public GeneralRepositoryImplementation<City> getImplementation() {
        return new CityRepositoryImplementation();
    }

    @Override
    public City getEntity(String name) {
        return new City(name);
    }

}
