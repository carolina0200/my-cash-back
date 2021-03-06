package com.caro.mycash.infraestructura.controlador;

import com.caro.mycash.aplicacion.servicio.ServicioAplicacionGenerarReporte;
import com.caro.mycash.dominio.modelo.Reporte;
import com.caro.mycash.infraestructura.aspecto.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/reportes")
public class ControladorReporte {

    private final ServicioAplicacionGenerarReporte servicioGenerarReporte;

    public ControladorReporte(ServicioAplicacionGenerarReporte servicioGenerarReporte) {
        this.servicioGenerarReporte = servicioGenerarReporte;
    }

    @GetMapping(value = "/generar")
    @Secured(roles = {"USER"})
    public Reporte generar() {
        return servicioGenerarReporte.ejecutar();
    }
}
