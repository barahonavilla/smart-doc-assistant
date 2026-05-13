package org.ebarahona.smartdoc.service;

import org.ebarahona.smartdoc.client.OpenAiClient;
import org.springframework.stereotype.Service;

@Service
public class DocumentService {

    private final OpenAiClient openAiClient;

    public DocumentService(OpenAiClient openAiClient) {
        this.openAiClient = openAiClient;
    }

    public String processDocument(String fileName) {

        String fakeText = "Documento simulado: " + fileName;

        return openAiClient.analyze(fakeText);
    }
}
