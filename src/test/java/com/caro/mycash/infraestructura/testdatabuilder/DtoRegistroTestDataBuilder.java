package com.caro.mycash.infraestructura.testdatabuilder;

import com.caro.mycash.aplicacion.dto.DtoRegistro;

import java.time.LocalDateTime;

public class DtoRegistroTestDataBuilder {

    private String tipo;
    private String concepto;
    private String descripcion;
    private Double cuanto;
    private String icono;
    private LocalDateTime cuando;

    public DtoRegistroTestDataBuilder() {
        this.tipo = "IN";
        this.concepto = "OB";
        this.descripcion = "Pagos";
        this.cuanto = 10000D;
        this.icono = "payments";
        this.cuando = LocalDateTime.of(2022, 3, 2, 5, 0,0);
    }

    public DtoRegistroTestDataBuilder conCuanto(Double cuanto) {
        this.cuanto = cuanto;
        return this;
    }

    public DtoRegistroTestDataBuilder conTipo(String tipo) {
        this.tipo = tipo;
        return this;
    }

    public DtoRegistroTestDataBuilder conConcepto(String concepto) {
        this.concepto = concepto;
        return this;
    }

    public DtoRegistro build() {
        return new DtoRegistro(tipo, concepto, descripcion, cuanto, icono, cuando);
    }
}
