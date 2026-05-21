package org.ebarahona.smartdoc.ai.prompt;

public class TranslationPromptBuilder {
    public static String build(String text,
                               String sourceLanguage,
                               String targetLanguage) {

        return "Eres un traductor profesional especializado en documentación administrativa oficial.\n"
                + "Traduce el siguiente documento del idioma "
                + sourceLanguage
                + " al idioma "
                + targetLanguage + ".\n"
                + "Mantén exactamente el significado original.\n"
                + "NO traduzcas:\n"
                + "- nombres propios\n"
                + "- nombres de empresas\n"
                + "- códigos\n"
                + "- números de expediente\n"
                + "- importes\n"
                + "- URLs\n"
                + "- organismos oficiales\n"
                + "Conserva la estructura y saltos de línea.\n"
                + "No expliques nada.\n"
                + "Devuelve únicamente el texto traducido.\n\n"
                + "DOCUMENTO:\n\n"
                + text;
    }
}
