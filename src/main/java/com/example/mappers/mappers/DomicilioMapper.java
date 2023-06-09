package com.example.mappers.mappers;

import com.example.mappers.dtos.DomicilioDTO;
import com.example.mappers.entities.Domicilio;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;


@Mapper(componentModel = "spring")
public interface DomicilioMapper extends BaseMapper<Domicilio, DomicilioDTO> {

    static DomicilioMapper getInstance() {
        return Mappers.getMapper(DomicilioMapper.class);
    }

    DomicilioDTO toDTO(Domicilio source);
    Domicilio toEntity(DomicilioDTO source);
    List<DomicilioDTO> toDTOsList(List<Domicilio> source);
    List<Domicilio> toEntitiesList(List<DomicilioDTO> source);
}
