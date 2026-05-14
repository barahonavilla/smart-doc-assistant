package org.ebarahona.smartdoc.ai.prompt;

public class TranslationPromptBuilder {
    public static String build(String text,
                               String sourceLanguage,
                               String targetLanguage) {

        return "Traduce el siguiente documento del idioma "
                + sourceLanguage
                + " al idioma "
                + targetLanguage
                + ". Mantén el significado exacto y conserva la estructura del texto.\n\n"
                + "DOCUMENTO:\n"
                + text;
    }
}
