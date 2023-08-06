package com.bolsadeideas.springboot.datajpa.app.springbootdatajpa.services;

import com.bolsadeideas.springboot.datajpa.app.springbootdatajpa.models.entity.Cliente;
import com.bolsadeideas.springboot.datajpa.app.springbootdatajpa.models.entity.dao.IClienteDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class ClienteServiceImpl implements IClienteService {

    @Autowired
    private IClienteDao clienteDao;

    @Transactional(readOnly = true)
    @Override
    public List<Cliente> findAll() {
        try {
            return (List<Cliente>) this.clienteDao.findAll();
        } catch (Exception error) {
            throw error;
        }

    }

    @Transactional
    @Override
    public void save(Cliente cliente) {
        try {

            this.clienteDao.save(cliente);

        } catch (Exception error) {
            throw error;
        }

    }

    @Transactional(readOnly = true)
    @Override
    public Cliente findOne(Long id) {

        try {
            return this.clienteDao.findById(id).orElse(null);
        } catch (Exception error) {
            throw error;
        }


    }

    @Transactional
    @Override
    public void delete(Long id) {
        try {
            this.clienteDao.deleteById(id);
        } catch (Exception error) {
            throw error;
        }
    }
}
