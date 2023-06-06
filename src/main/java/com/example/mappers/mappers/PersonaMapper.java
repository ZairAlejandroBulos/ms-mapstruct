package com.example.mappers.mappers;

import com.example.mappers.dtos.PersonaDTO;
import com.example.mappers.entities.Persona;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PersonaMapper extends BaseMapper<Persona, PersonaDTO> {

    static PersonaMapper getInstance() {
        return Mappers.getMapper(PersonaMapper.class);
    }

    PersonaDTO toDTO(Persona source);
    Persona toEntity(PersonaDTO source);
    List<PersonaDTO> toDTOsList(List<Persona> source);
    List<Persona> toEntitiesList(List<PersonaDTO> source);
}
