package com.solvd.storeDataBase.persistence.implementation.myBatis;

import com.solvd.storeDataBase.ConnectToDbMyBatis;
import com.solvd.storeDataBase.domain.Client;
import com.solvd.storeDataBase.domain.exceptions.PassportDuplicatedException;
import com.solvd.storeDataBase.persistence.ClientRepository;
import com.solvd.storeDataBase.persistence.GeneralRepository;
import org.apache.ibatis.session.SqlSession;

import java.sql.SQLException;

public class ClientRepositoryImplMB extends GeneralRepositoryImplMB<Client> implements ClientRepository {
    @Override
    public GeneralRepository<Client> getRepository(SqlSession session) {
        return session.getMapper(ClientRepository.class);
    }

    @Override
    public Long create(Client client) throws SQLException {
        try {
            passportExistenceCheck(checkPassport(client.getPassport().getNumber()));
        } catch (PassportDuplicatedException e) {
            throw new RuntimeException(e);
        }
        return super.create(client);
    }

    @Override
    public Client checkPassport(String number) {
        try (SqlSession sqlSession = ConnectToDbMyBatis.getSessionFactory().openSession(true)) {
            ClientRepository repository = sqlSession.getMapper(ClientRepository.class);
            return repository.checkPassport(number);
        }

    }

    private void passportExistenceCheck(Client client) throws PassportDuplicatedException {
        if (client != null) {
            throw new PassportDuplicatedException(String.format("This passport number already exists for client %s %s", client.getFirstName(), client.getLastName()));
        }
    }
}
