package com.bj.restarauntreservations.repository;

import org.springframework.data.repository.CrudRepository;

import com.bj.restarauntreservations.model.Reservation;

public interface ReservationRepository extends CrudRepository<Reservation, Integer> {

}
