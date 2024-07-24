package com.demo.main.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demo.main.entity.GasBookings;

@Repository
public interface GasBookingsRepository extends JpaRepository<GasBookings, Long> {

	List<GasBookings> findByCustomerUserid(long userid);

	@Query("SELECT b FROM GasBookings b WHERE b.bookingdate >= :fromDate AND b.bookingdate <= :toDate")
	List<GasBookings> findByBookingdate(@Param("fromDate") LocalDate fromDate, @Param("toDate") LocalDate toDate);


	

	@Query("SELECT gb FROM GasBookings gb WHERE gb.customer.userid = :userid AND gb.gasbookingid = :gasbookingid")
	GasBookings findByUserIdAndGasBookingId(@Param("userid") Long userid, @Param("gasbookingid") Long gasbookingid);

}
