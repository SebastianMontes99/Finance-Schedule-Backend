package com.finanzas.trabajoFinanzas.services.impl;

import com.finanzas.trabajoFinanzas.entities.Users;
import com.finanzas.trabajoFinanzas.repositories.IUsersRepository;
import com.finanzas.trabajoFinanzas.services.IUsersService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly=false)
public class UsersServiceImpl implements IUsersService {

    private final IUsersRepository usersRepository;

    public UsersServiceImpl(IUsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }


    @Override
    public Users save(Users users) throws Exception {
        return usersRepository.save(users);
    }

    @Override
    public void delete(Long id) throws Exception {
    usersRepository.deleteById(id);
    }

    @Override
    public List<Users> getAll() throws Exception {
        return usersRepository.findAll();
    }

    @Override
    public Optional<Users> getById(Long id) throws Exception {
        return usersRepository.findById(id);
    }
}
