package com.davy.reservation_system.reservation_service.repository;

import com.davy.reservation_system.reservation_service.entities.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long> {

    List<Reserva> findTipoAndDataInicioBetween(String tipo, LocalDateTime inicio, LocalDateTime fim);
    List<Reserva> findByUserId(Long userID);
}
