package org.ebarahona.smartdoc.dto.translation;

public class TranslationRequest {
    private String fileName;
    private String fileBase64;
    private String sourceLanguage;
    private String targetLanguage;

    public TranslationRequest() {
    }

    public TranslationRequest(String fileName,
                              String fileBase64,
                              String sourceLanguage,
                              String targetLanguage) {
        this.fileName = fileName;
        this.fileBase64 = fileBase64;
        this.sourceLanguage = sourceLanguage;
        this.targetLanguage = targetLanguage;
    }

    public String getFileName() {
        return fileName;
    }

    public String getFileBase64() {
        return fileBase64;
    }

    public String getSourceLanguage() {
        return sourceLanguage;
    }

    public String getTargetLanguage() {
        return targetLanguage;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setFileBase64(String fileBase64) {
        this.fileBase64 = fileBase64;
    }

    public void setSourceLanguage(String sourceLanguage) {
        this.sourceLanguage = sourceLanguage;
    }

    public void setTargetLanguage(String targetLanguage) {
        this.targetLanguage = targetLanguage;
    }
}
