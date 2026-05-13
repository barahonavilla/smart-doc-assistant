package org.ebarahona.smartdoc.service;

import org.apache.tika.Tika;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.util.Base64;

@Service
public class PdfExtractorService {

    private final Tika tika = new Tika();

    public String extractTextFromBase64(String base64) {

        try {
            byte[] decodedBytes = Base64.getDecoder().decode(base64);

            ByteArrayInputStream inputStream = new ByteArrayInputStream(decodedBytes);

            return tika.parseToString(inputStream);

        } catch (Exception e) {
            throw new RuntimeException("Error extrayendo texto del PDF", e);
        }
    }
}
