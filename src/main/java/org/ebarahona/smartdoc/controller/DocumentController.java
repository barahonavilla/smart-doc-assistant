package org.ebarahona.smartdoc.controller;

import org.ebarahona.smartdoc.dto.DocumentRequest;
import org.ebarahona.smartdoc.dto.DocumentResponse;
import org.ebarahona.smartdoc.dto.translation.TranslationRequest;
import org.ebarahona.smartdoc.dto.translation.TranslationResponse;
import org.ebarahona.smartdoc.service.DocumentExtractionService;
import org.ebarahona.smartdoc.service.PdfExtractorService;
import org.ebarahona.smartdoc.service.TranslationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DocumentController {

    private final DocumentExtractionService extractionService;
    private final PdfExtractorService pdfExtractorService;
    private final TranslationService translationService;

    public DocumentController(DocumentExtractionService extractionService,
                              PdfExtractorService pdfExtractorService,
                              TranslationService translationService) {
        this.extractionService = extractionService;
        this.pdfExtractorService = pdfExtractorService;
        this.translationService = translationService;
    }

    @PostMapping("/document")
    public DocumentResponse receive(@RequestBody DocumentRequest request) {

        // Extracción del texto del pdf
        String extractedText = pdfExtractorService.extractTextFromBase64(
                request.getFileBase64()
        );
        System.out.println(extractedText);
        return extractionService.extract(
                request.getFileName(),
                extractedText
        );
    }

    @PostMapping("/document/translate")
    public TranslationResponse translate(@RequestBody TranslationRequest request) {

        String translatedText = translationService.translateDocument(
                request.getFileBase64(),
                request.getFileName(),
                request.getSourceLanguage(),
                request.getTargetLanguage()
        );

        return new TranslationResponse(
                request.getFileName(),
                request.getSourceLanguage(),
                request.getTargetLanguage(),
                translatedText
        );
    }
}
