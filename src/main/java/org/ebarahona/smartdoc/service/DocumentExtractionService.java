package org.ebarahona.smartdoc.service;

import org.ebarahona.smartdoc.dto.DocumentResponse;
import org.ebarahona.smartdoc.dto.ExpedienteDto;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class DocumentExtractionService {

    private final LocalAiService localAiService;

    public DocumentExtractionService(LocalAiService localAiService) {
        this.localAiService = localAiService;
    }

    public DocumentResponse extract(String fileName, String rawText) {

        // AQUÍ YA USAS IA REAL
        List<ExpedienteDto> expedientes = localAiService.analyze(rawText);

        return new DocumentResponse(
                fileName,
                "REG-" + System.currentTimeMillis(),
                LocalDate.now().toString(),
                detectEntity(fileName),
                expedientes
        );
    }

    private String detectEntity(String fileName) {

        if (fileName.toLowerCase().contains("pdf")) {
            return "Documento PDF genérico";
        }

        return "Entidad desconocida";
    }
}
