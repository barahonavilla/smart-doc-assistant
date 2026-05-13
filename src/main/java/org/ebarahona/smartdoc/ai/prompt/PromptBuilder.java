package org.ebarahona.smartdoc.ai.prompt;

public class PromptBuilder {
    private static final int MAX_CHARS = 6000;
    public static String buildExpedientePrompt(String text) {

        String safeText = text.length() > MAX_CHARS
                ? text.substring(0, MAX_CHARS)
                : text;

        return "Extrae los expedientes del siguiente texto.\n\n" +
                "Devuelve SOLO un JSON válido.\n" +
                "NO añadas texto antes ni después.\n" +
                "NO expliques nada.\n\n" +
                "Formato:\n" +
                "[{\"numero\":\"\",\"descripcion\":\"\",\"empresa\":\"\",\"importe\":\"\"}]\n\n" +
                "Texto:\n" + safeText;
    }
}
