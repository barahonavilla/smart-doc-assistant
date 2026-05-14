package org.ebarahona.smartdoc.dto.translation;

public class TranslationResponse {
    private String fileName;
    private String sourceLanguage;
    private String targetLanguage;
    private String translatedText;

    public TranslationResponse() {
    }

    public TranslationResponse(String fileName,
                               String sourceLanguage,
                               String targetLanguage,
                               String translatedText) {
        this.fileName = fileName;
        this.sourceLanguage = sourceLanguage;
        this.targetLanguage = targetLanguage;
        this.translatedText = translatedText;
    }

    public String getFileName() {
        return fileName;
    }

    public String getSourceLanguage() {
        return sourceLanguage;
    }

    public String getTargetLanguage() {
        return targetLanguage;
    }

    public String getTranslatedText() {
        return translatedText;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setSourceLanguage(String sourceLanguage) {
        this.sourceLanguage = sourceLanguage;
    }

    public void setTargetLanguage(String targetLanguage) {
        this.targetLanguage = targetLanguage;
    }

    public void setTranslatedText(String translatedText) {
        this.translatedText = translatedText;
    }
}
