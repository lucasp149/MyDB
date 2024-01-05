package org.solved.service;

import org.solved.domain.Address;
import org.solved.domain.Deposit;

public interface DepositService {
    public Deposit create (String name, Address address);

    public Deposit find (Long id);
}
