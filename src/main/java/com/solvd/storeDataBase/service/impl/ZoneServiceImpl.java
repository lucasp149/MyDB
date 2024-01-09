package com.solvd.storeDataBase.service.impl;

import com.solvd.storeDataBase.domain.Zone;
import com.solvd.storeDataBase.persistence.implementation.myBatis.GeneralRepositoryImplMB;
import com.solvd.storeDataBase.persistence.implementation.myBatis.ZoneRepositoryImplMB;
import com.solvd.storeDataBase.service.GeneralServiceImpl;

public class ZoneServiceImpl extends GeneralServiceImpl<Zone> {

     public GeneralRepositoryImplMB<Zone> getRepository(){
        return new ZoneRepositoryImplMB();
     }


}
