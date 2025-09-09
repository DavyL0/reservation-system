package com.davy.reservation_system.reservation_service.controller;

import com.davy.reservation_system.reservation_service.entities.Reserva;
import com.davy.reservation_system.reservation_service.services.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservas")
public class ReservaControlller {
    @Autowired
    private ReservaService reservaService;

    @PostMapping
    public ResponseEntity<?>  criarReserva(@RequestBody Reserva reserva)throws Exception {
        try {
            return  ResponseEntity.ok(reservaService.criarReserva(reserva));
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/usuario/{userID}")
    public List<Reserva> findByUserId(@PathVariable Long userID){
        return reservaService.listarReservasByUserId(userID);
    }

    @GetMapping("/all")
    public List<Reserva> findAll(){
        return reservaService.listarReservas();
    }

    @PutMapping("/cancelar/{id}")
    public ResponseEntity<?>  cancelarReserva(@PathVariable("id") Long id){
        try {
            return ResponseEntity.ok(reservaService.cancelarReserva(id));
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
