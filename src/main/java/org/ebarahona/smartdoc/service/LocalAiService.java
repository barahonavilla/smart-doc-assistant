package org.ebarahona.smartdoc.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.ebarahona.smartdoc.ai.prompt.PromptBuilder;
import org.ebarahona.smartdoc.dto.ExpedienteDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class LocalAiService implements AiService{
    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    @Value("${ollama.url}")
    private String ollamaUrl;

    @Value("${ollama.model}")
    private String model;

    public LocalAiService(RestTemplate restTemplate, ObjectMapper objectMapper) {
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
    }

    @Override
    public List<ExpedienteDto> analyze(String text) {

        String prompt = PromptBuilder.buildExpedientePrompt(text);

        System.out.println("PROMPT:\n" + prompt);

        Map<String, Object> options = new HashMap<>();
        //Añadimos este parámetro para acotar la creatividad del modelo
        options.put("temperature", 0);

        Map<String, Object> request = new HashMap<>();
        request.put("model", model);
        request.put("prompt", prompt);
        request.put("stream", false);
        request.put("options", options);

        try {
            String rawResponse = restTemplate.postForObject(
                    ollamaUrl,
                    request,
                    String.class
            );

            System.out.println("RAW RESPONSE:\n" + rawResponse);

            Map<String, Object> json = objectMapper.readValue(rawResponse, Map.class);
            String responseText = (String) json.get("response");

            //Cogemos solo el JSON por si Ollama mete texto extra en su respuesta
            responseText = responseText.substring(
                    responseText.indexOf("["),
                    responseText.lastIndexOf("]") + 1
            );

            // AQUÍ ESTÁ LA MAGIA
            return objectMapper.readValue(
                    responseText,
                    new TypeReference<List<ExpedienteDto>>() {}
            );

        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }
}
