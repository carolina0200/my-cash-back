package com.caro.mycash.infraestructura.controlador;

import com.caro.mycash.aplicacion.dto.DtoRegistro;
import com.caro.mycash.aplicacion.dto.DtoRespuesta;
import com.caro.mycash.aplicacion.servicio.ServicioAplicacionGuardarRegistro;
import com.caro.mycash.aplicacion.servicio.ServicioAplicacionListarRegistros;
import com.caro.mycash.dominio.modelo.Registro;
import com.caro.mycash.infraestructura.aspecto.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/registros")
public class ControladorRegistro {

    private final ServicioAplicacionListarRegistros servicioListar;
    private final ServicioAplicacionGuardarRegistro servicioGuardar;

    public ControladorRegistro(ServicioAplicacionListarRegistros servicioListar, ServicioAplicacionGuardarRegistro servicioGuardar) {
        this.servicioListar = servicioListar;
        this.servicioGuardar = servicioGuardar;
    }

    @GetMapping
    @Secured(roles = {"USER"})
    public List<Registro> listar() {
        return servicioListar.ejecutar();
    }

    @PostMapping
    @Secured(roles = {"USER"})
    public DtoRespuesta<Long> crear(@RequestBody DtoRegistro dto) { return servicioGuardar.ejecutar(dto); }
}
