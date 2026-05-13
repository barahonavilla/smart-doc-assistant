package org.ebarahona.smartdoc.service;

import org.ebarahona.smartdoc.dto.ExpedienteDto;

import java.util.List;

public interface AiService {

    List<ExpedienteDto> analyze(String text);
}
