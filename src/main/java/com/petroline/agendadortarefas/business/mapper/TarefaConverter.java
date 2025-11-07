package com.petroline.agendadortarefas.business.mapper;

import com.petroline.agendadortarefas.business.dto.TarefasDTO;
import com.petroline.agendadortarefas.infrastructure.entity.TarefasEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TarefaConverter {

    TarefasEntity paraTarefaEntity(TarefasDTO dto);

    TarefasDTO paraTarefaDTO(TarefasEntity entity);

}
