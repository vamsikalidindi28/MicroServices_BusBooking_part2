package com.rk.bb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rk.bb.entity.Booking;

public interface bookingRepository extends JpaRepository<Booking, Long> {

}
