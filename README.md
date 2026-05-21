# Smart Doc Assistant

Spring Boot application for intelligent document processing using local LLMs (Ollama).

---

## Overview

Smart Doc Assistant is a proof-of-concept system for processing and transforming documents using local AI models.  
It focuses on extracting structured information and translating content from unstructured documents such as PDFs.

The goal is to explore how local LLMs can be integrated into document workflows without relying on external AI APIs.

---

## Current Features

- PDF text extraction (Base64 input support)
- Integration with local LLMs via Ollama API
- Document information extraction into structured JSON
- Automatic document translation between languages
- Prompt-based AI orchestration layer
- Configurable model selection via `application.properties`

---

## Architecture

The system follows a lightweight AI processing pipeline:

1. Input document (Base64 PDF)
2. Text extraction (Apache Tika / PDF parser)
3. LLM processing via Ollama
    - Information extraction OR translation (depending on endpoint)
4. Structured response returned as JSON

---

## Tech Stack

- Java 1.8
- Spring Boot
- Maven
- Ollama (local LLM runtime)
- Qwen2.5 / LLaMA 3 / other GGUF-compatible models
- Apache Tika (document extraction)
- Jackson (JSON processing)

---

## Example Endpoints

### Extract document information
POST /api/document

**Description:**  
Extracts structured information from a PDF document using a local LLM.

**Response example:**

```json
{
  "fileName": "test.pdf",
  "numeroRegistro": "REG-1778687350521",
  "fecha": "2026-05-13",
  "entidad": "Documento PDF genérico",
  "expedientes": [
    {
      "numero": "CON-2019/5400006.0",
      "descripcion": "Compra de libros para la tienda del congreso...",
      "empresa": "",
      "importe": "1.450,00 €"
    },
    {
      "numero": "CON-2019/5400001.0",
      "descripcion": "Mantenimiento ascensores...",
      "empresa": "",
      "importe": "2.000,00 €"
    }
  ]
}
```
### Translate document
POST /api/document/translate

Description:
Translates a document between languages while preserving structure as much as possible.

**Response example:**

```json
{
  "fileName": "test.pdf",
  "sourceLanguage": "spanish",
  "targetLanguage": "catalan",
  "translatedText": "..."
}
```

### Notes
- Runs fully locally using Ollama

- No external AI APIs are used

- Designed for experimentation with document AI pipelines