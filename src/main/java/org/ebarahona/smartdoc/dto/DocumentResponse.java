package org.ebarahona.smartdoc.dto;

import java.util.List;

public class DocumentResponse {

    private String fileName;
    private String numeroRegistro;
    private String fecha;
    private String entidad;
    private List<ExpedienteDto> expedientes;

    public DocumentResponse() {
    }

    public DocumentResponse(String fileName, String numeroRegistro, String fecha, String entidad, List<ExpedienteDto> expedientes) {
        this.fileName = fileName;
        this.numeroRegistro = numeroRegistro;
        this.fecha = fecha;
        this.entidad = entidad;
        this.expedientes = expedientes;
    }

    public String getFileName() {
        return fileName;
    }

    public String getNumeroRegistro() {
        return numeroRegistro;
    }

    public String getFecha() {
        return fecha;
    }

    public String getEntidad() {
        return entidad;
    }

    public List<ExpedienteDto> getExpedientes() {
        return expedientes;
    }
}
