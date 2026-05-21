package org.ebarahona.smartdoc.service;

import org.ebarahona.smartdoc.util.TextChunker;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TranslationService {

    private final TranslationAiService translationAiService;
    private final PdfExtractorService pdfExtractorService;

    public TranslationService(TranslationAiService translationAiService,
                              PdfExtractorService pdfExtractorService) {
        this.translationAiService = translationAiService;
        this.pdfExtractorService = pdfExtractorService;
    }

    public String translateDocument(String base64,
                                    String fileName,
                                    String sourceLanguage,
                                    String targetLanguage) {

        String extractedText = pdfExtractorService.extractTextFromBase64(base64);

        return translationAiService.translate(
                extractedText,
                sourceLanguage,
                targetLanguage
            );

    }

    public String translateDocumentByChunks(String base64,
                               String fileName,
                               String sourceLanguage,
                               String targetLanguage) {

        String extractedText = pdfExtractorService.extractTextFromBase64(base64);

        List<String> chunks = TextChunker.chunk(extractedText);

        StringBuilder translatedDocument =
                new StringBuilder();

        System.out.println("CHUNKS: " + chunks.size());

        for (String chunk : chunks) {

            System.out.println("--------- CHUNK ---------");
            System.out.println(chunk);

            String translatedChunk =
                    translationAiService.translate(
                            chunk,
                            sourceLanguage,
                            targetLanguage
                    );

            translatedDocument
                    .append(translatedChunk)
                    .append("\n\n");
        }

        return translatedDocument.toString();
    }

}
