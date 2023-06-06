package com.example.mappers.services;

import com.example.mappers.dtos.BaseDTO;
import com.example.mappers.entities.Base;

import java.io.Serializable;
import java.util.List;

public interface BaseService<E extends Base, D extends BaseDTO, ID extends Serializable> {

    List<D> findAll() throws Exception;
    D findById(ID id) throws Exception;
    E save(D dto) throws Exception;
    E update(ID id, D dto) throws Exception;
    void delete(ID id) throws Exception;
}
