package org.ebarahona.smartdoc.util;

import java.util.ArrayList;
import java.util.List;

public class TextChunker {
    private static final int MAX_CHARS = 1000;

    public static List<String> chunk(String text) {
        List<String> chunks = new ArrayList<>();
        int start = 0;
        while (start < text.length()) {
            int end = Math.min(start + MAX_CHARS, text.length());
            chunks.add(text.substring(start, end));
            start = end;
        }
        return chunks;
    }

    public static List<String> chunkByParagraph(String text) {

        String[] paragraphs = text.split("\\n\\s*\\n");

        List<String> chunks = new ArrayList<>();

        StringBuilder currentChunk = new StringBuilder();

        for (String paragraph : paragraphs) {

            if (currentChunk.length() + paragraph.length() > MAX_CHARS) {
                chunks.add(currentChunk.toString());
                currentChunk = new StringBuilder();
            }

            currentChunk
                    .append(paragraph)
                    .append("\n\n");
        }

        if (currentChunk.length() > 0) {
            chunks.add(currentChunk.toString());
        }

        return chunks;
    }
}
