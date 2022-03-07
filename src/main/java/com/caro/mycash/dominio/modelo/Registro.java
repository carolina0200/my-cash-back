package com.caro.mycash.dominio.modelo;

import java.time.LocalDateTime;

public class Registro {

    private static final String MENSAJE_TIPO_OBLIGATORIO = "El tipo de registro es obligatorio";
    private static final String MENSAJE_CONCEPTO_OBLIGATORIO = "El concepto del registro es obligatorio";
    private static final String MENSAJE_DESCRIPCION_OBLIGATORIA = "La descripcion del registro es obligatorio";
    private static final String MENSAJE_CUANTO_OBLIGATORIO = "El valor del registro es obligatorio";
    private static final String MENSAJE_TIPO_RESTRICCION = "El tipo debe ser IN (Ingreso) EG (Egreso)";
    private static final String MENSAJE_CONCEPTO_RESTRICCION = "El concepto debe ser OT (Otro) OB (Obligatorio)";
    private static final String MENSAJE_CUANTO_RESTRICCION = "El valor debe ser mayor a cero(0)";
    private static final String MENSAJE_DESCRIPCION_RESTRICCION = "La descripcion debe tener como maximo 100 caracteres y como minimo 4";
    private static final int DESCRIPCION_CARACTERES_MINIMO = 100;
    private static final int CUANTO_MAXIMO = 4;
    private static final int DESCRIPCION_CARACTERES_MAXIMO = CUANTO_MAXIMO;
    private static final String MENSAJE_CUANDO_OBLIGATORIO = "La fecha en la que se hizo el ingreso o egreso es obligatoria";

    private String tipo;
    private String concepto;
    private String descripcion;
    private Double cuanto;
    private String icono;
    private LocalDateTime cuando;

    public static Registro of(String tipo, String concepto, String descripcion, Double cuanto, LocalDateTime cuando, String icono) {
        validarObligatorio(tipo, MENSAJE_TIPO_OBLIGATORIO);
        validarTipo(tipo);
        validarObligatorio(concepto, MENSAJE_CONCEPTO_OBLIGATORIO);
        validarConcepto(concepto);
        validarObligatorio(descripcion, MENSAJE_DESCRIPCION_OBLIGATORIA);
        validarDescripcion(descripcion);
        validarObligatorio(cuanto, MENSAJE_CUANTO_OBLIGATORIO);
        validarCuanto(cuanto);
        validarObligatorio(cuando, MENSAJE_CUANDO_OBLIGATORIO);
        return new Registro(tipo, concepto, descripcion, cuanto, cuando, icono);
    }

    private Registro(String tipo, String concepto, String descripcion, Double cuanto, LocalDateTime cuando, String icono) {
        this.tipo = tipo;
        this.concepto = concepto;
        this.descripcion = descripcion;
        this.cuanto = cuanto;
        this.cuando = cuando;
        this.icono = icono;
    }

    public String getTipo() {
        return tipo;
    }

    public String getConcepto() {
        return concepto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Double getCuanto() {
        return cuanto;
    }

    public LocalDateTime getCuando() {
        return cuando;
    }

    public String getIcono() {
        return icono;
    }

    private static void validarObligatorio(Object valor, String mensaje) {
        if (valor == null || valor.equals("")) {
            throw new IllegalArgumentException(mensaje);
        }
    }

    private static void validarTipo(String tipo) {
        if (!(tipo.equals("IN") || tipo.equals("EG"))) {
            throw new IllegalArgumentException(MENSAJE_TIPO_RESTRICCION);
        }
    }

    private static void validarConcepto(String concepto) {
        if (!(concepto.equals("OT") || concepto.equals("OB"))) {
            throw new IllegalArgumentException(MENSAJE_CONCEPTO_RESTRICCION);
        }
    }

    private static void validarCuanto(Double cuanto) {
        if (cuanto <= 0) {
            throw new IllegalArgumentException(Registro.MENSAJE_CUANTO_RESTRICCION);
        }
    }

    private static void validarDescripcion(String descripcion) {
        if(descripcion.length() > DESCRIPCION_CARACTERES_MINIMO || descripcion.length() < DESCRIPCION_CARACTERES_MAXIMO) {
            throw new IllegalArgumentException(MENSAJE_DESCRIPCION_RESTRICCION);
        }
    }
}
