package com.example.mappers.services;

import com.example.mappers.dtos.DomicilioDTO;
import com.example.mappers.entities.Domicilio;
import com.example.mappers.mappers.BaseMapper;
import com.example.mappers.mappers.DomicilioMapper;
import com.example.mappers.repositories.BaseRepository;
import com.example.mappers.repositories.DomicilioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DomicilioServiceImpl extends BaseServiceImpl<Domicilio, DomicilioDTO, Long> implements DomicilioService {

    @Autowired
    private DomicilioRepository domicilioRepository;

    private final DomicilioMapper domicilioMapper = DomicilioMapper.getInstance();

    public DomicilioServiceImpl(BaseRepository<Domicilio, Long> baseRepository, BaseMapper<Domicilio, DomicilioDTO> baseMapper) {
        super(baseRepository, baseMapper);
    }
}
