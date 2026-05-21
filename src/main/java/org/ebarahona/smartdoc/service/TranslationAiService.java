package org.ebarahona.smartdoc.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.ebarahona.smartdoc.ai.prompt.TranslationPromptBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class TranslationAiService {

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;
    @Value("${ollama.url}")
    private String ollamaUrl;

    @Value("${ollama.translation.model}")
    private String translationModel;

    public TranslationAiService(RestTemplate restTemplate,
                                ObjectMapper objectMapper) {
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
    }

    public String translate(String text,
                            String sourceLanguage,
                            String targetLanguage) {

        String prompt = TranslationPromptBuilder.build(
                text,
                sourceLanguage,
                targetLanguage
        );

        System.out.println("PROMPT:\n" + prompt);

        Map<String, Object> options = new HashMap<>();
        options.put("temperature", 0);

        Map<String, Object> request = new HashMap<>();
        request.put("model", translationModel);
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

            Map<String, Object> json = objectMapper.readValue(
                    rawResponse,
                    Map.class
            );
            String response = (String) json.get("response");

            System.out.println("RESPONSE:\n" + response);
            return response;

        } catch (Exception e) {
            e.printStackTrace();
            return "Error translating document";
        }
    }
}
