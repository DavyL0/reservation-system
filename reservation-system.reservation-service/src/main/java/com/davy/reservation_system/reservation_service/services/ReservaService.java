package com.davy.reservation_system.reservation_service.services;

import com.davy.reservation_system.reservation_service.entities.Reserva;
import com.davy.reservation_system.reservation_service.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
@Service
public class ReservaService {
    @Autowired
    private ReservaRepository reservationRepository;

    public Reserva criarReserva(Reserva reserva)throws Exception{
        if(!disponivel(reserva.getTipo(), reserva.getDataInicio(), reserva.getDataFim())){
            throw new Exception("Periodo Indisponivel para reserva");
        }
        reserva.setStatus("CONFIRMADA");
        return reservationRepository.save(reserva);
    }

    public Boolean disponivel(String tipo, LocalDateTime dataInicio, LocalDateTime dataFim){
        List<Reserva> existentes = reservationRepository.findTipoAndDataInicioBetween(tipo, dataInicio, dataFim);
        return existentes.isEmpty();
    }

    public List<Reserva> listarReservas(){
        return reservationRepository.findAll();
    }

    public List<Reserva> listarReservasByUserId(Long id){
        return reservationRepository.findByUserId(id);
    }

    public Reserva cancelarReserva(Long id) throws Exception{
        Reserva reserva = reservationRepository.findById(id).orElseThrow(() -> new Exception("Reserva not found"));
        reserva.setStatus("CANCELADA");
        return reservationRepository.save(reserva);
    }

}
