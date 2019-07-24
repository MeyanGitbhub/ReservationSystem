package com.bj.restarauntreservations.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bj.restarauntreservations.model.Reservation;
import com.bj.restarauntreservations.repository.ReservationRepository;

@Controller
@RequestMapping(path="/reservation")
public class ReservationController {

	@Autowired
	private ReservationRepository reservationRepository;
	
	@GetMapping(path="/add")
	public @ResponseBody String addNewReservation (@RequestParam String firstName,
			@RequestParam String lastName, @RequestParam String email,
			@RequestParam String phoneNumber, 
			@RequestParam LocalDateTime reservationDateTime) {
		Reservation reservation = new Reservation();
		reservation.setFirstName(firstName);
		reservation.setLastName(lastName);
		reservation.setEmail(email);
		reservation.setPhoneNumber(phoneNumber);
		reservation.setReservationDateTime(reservationDateTime);
		reservationRepository.save(reservation);
		return "Saved";
	}
}
