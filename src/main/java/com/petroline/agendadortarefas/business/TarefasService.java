package com.petroline.agendadortarefas.business;

import com.petroline.agendadortarefas.business.dto.TarefasDTO;
import com.petroline.agendadortarefas.business.mapper.TarefaConverter;
import com.petroline.agendadortarefas.infrastructure.entity.TarefasEntity;
import com.petroline.agendadortarefas.infrastructure.enums.StatusNotificacaoEnum;
import com.petroline.agendadortarefas.infrastructure.repository.TarefasRepository;
import com.petroline.agendadortarefas.infrastructure.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class TarefasService {

    private final TarefasRepository tarefasRepository;
    private final TarefaConverter tarefaConverter;
    private final JwtUtil jwtUtil;


    public TarefasDTO gravarTarefa(String token, TarefasDTO dto){
        String email = jwtUtil.extrairEmailToken(token.substring( 7));
        dto.setDataCriacao(LocalDateTime.now());
        dto.setStatusNotificacaoEnum(StatusNotificacaoEnum.PENDENTE);
        dto.setEmailUsuario(email);
        TarefasEntity entity = tarefaConverter.paraTarefaEntity(dto);

        return tarefaConverter.paraTarefaDTO(
                tarefasRepository.save(entity));
    }
}
