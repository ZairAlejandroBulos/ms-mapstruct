package com.example.mappers.services;

import com.example.mappers.dtos.BaseDTO;
import com.example.mappers.entities.Base;
import com.example.mappers.mappers.BaseMapper;
import com.example.mappers.repositories.BaseRepository;
import jakarta.transaction.Transactional;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public abstract class BaseServiceImpl<E extends Base, D extends BaseDTO, ID extends Serializable> implements BaseService<E, D, ID> {

    protected BaseRepository<E, ID> baseRepository;

    protected BaseMapper<E, D> baseMapper;

    public BaseServiceImpl(BaseRepository<E, ID> baseRepository, BaseMapper<E, D> baseMapper) {
        this.baseRepository = baseRepository;
        this.baseMapper = baseMapper;
    }

    @Override
    public List<D> findAll() throws Exception {
        try {
            List<E> entities = baseRepository.findAll();
            return baseMapper.toDTOsList(entities);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public D findById(ID id) throws Exception {
        try {
            E entity = baseRepository.findById(id).get();
            return baseMapper.toDTO(entity);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public E save(D entity) throws Exception {
        try {
            return baseRepository.save(baseMapper.toEntity(entity));
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public E update(ID id, D entity) throws Exception {
        try {
            Optional<E> optional = baseRepository.findById(id);

            if (optional.isEmpty()) {
                throw new Exception("No se encontro la entidad a actualizar");
            }

            return baseRepository.save(baseMapper.toEntity(entity));
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public void delete(ID id) throws Exception {
        try {
            baseRepository.deleteById(id);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
