package com.example.mappers.services;

import com.example.mappers.dtos.DomicilioDTO;
import com.example.mappers.dtos.PersonaDTO;
import com.example.mappers.entities.Domicilio;
import com.example.mappers.entities.Persona;
import com.example.mappers.mappers.BaseMapper;
import com.example.mappers.mappers.DomicilioMapper;
import com.example.mappers.mappers.PersonaMapper;
import com.example.mappers.repositories.BaseRepository;
import com.example.mappers.repositories.PersonaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonaServiceImpl extends BaseServiceImpl<Persona, PersonaDTO, Long> implements PersonaService {

    @Autowired
    private PersonaRepository personaRepository;

    @Autowired DomicilioService domicilioService;

    private final PersonaMapper personaMapper = PersonaMapper.getInstance();

    public PersonaServiceImpl(BaseRepository<Persona, Long> baseRepository, BaseMapper<Persona, PersonaDTO> baseMapper) {
        super(baseRepository, baseMapper);
    }

    @Transactional
    public Persona savePersona(PersonaDTO dto) throws Exception {
        try {
            Persona persona = personaMapper.toEntity(dto);

            DomicilioDTO domicilioDTO = dto.getDomicilio();
            if (domicilioDTO != null && domicilioDTO.getId() == null) {
                Domicilio domicilio = domicilioService.save(domicilioDTO);
                persona.setDomicilio(domicilio);
            }

            return personaRepository.save(persona);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public Persona updatePersona(Long id, PersonaDTO dto) throws Exception {
        try {
            Optional<Persona> optional = personaRepository.findById(id);

            if (optional.isEmpty()) {
                throw new Exception("No se encontró la entidad a actualizar");
            }

            Persona persona = personaMapper.toEntity(dto);

            DomicilioDTO domicilioDTO = dto.getDomicilio();
            if (domicilioDTO.getId() == null) {
                Domicilio domicilio = domicilioService.save(domicilioDTO);
                persona.setDomicilio(domicilio);
            } else {
                Domicilio domicilio = domicilioService.update(domicilioDTO.getId(), domicilioDTO);
                persona.setDomicilio(domicilio);
            }

            return personaRepository.save(persona);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
