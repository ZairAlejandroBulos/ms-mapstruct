package com.example.mappers.services;

import com.example.mappers.dtos.PersonaDTO;
import com.example.mappers.entities.Persona;
import com.example.mappers.mappers.BaseMapper;
import com.example.mappers.mappers.PersonaMapper;
import com.example.mappers.repositories.BaseRepository;
import com.example.mappers.repositories.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaServiceImpl extends BaseServiceImpl<Persona, PersonaDTO, Long> implements PersonaService {

    @Autowired
    private PersonaRepository personaRepository;

    private final PersonaMapper personaMapper = PersonaMapper.getInstance();

    public PersonaServiceImpl(BaseRepository<Persona, Long> baseRepository, BaseMapper<Persona, PersonaDTO> baseMapper) {
        super(baseRepository, baseMapper);
    }
}
