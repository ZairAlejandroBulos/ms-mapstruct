package com.example.mappers.mappers;

import com.example.mappers.dtos.BaseDTO;
import com.example.mappers.entities.Base;

import java.util.List;

public interface BaseMapper<E extends Base, D extends BaseDTO> {

    D toDTO(E source);
    E toEntity(D source);
    List<D> toDTOsList(List<E> source);
    List<E> toEntitiesList(List<D> source);
}
