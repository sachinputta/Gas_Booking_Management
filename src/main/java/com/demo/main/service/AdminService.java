package com.demo.main.service;

import java.time.LocalDate;
import java.util.List;

import com.demo.main.entity.Admin;
import com.demo.main.entity.Customer;
import com.demo.main.entity.Cylinder;
import com.demo.main.entity.GasBookings;

public interface AdminService {

	public Admin addAdmin(Admin admin);

	public Admin updateAdmin(long userid, Admin admin);

	public String deleteAdmin(long userid);

	public Customer addCustomer(long cylinderid, Cylinder cylinder, Customer customer);

	public Customer updateCustomer(long userid, Customer customer);

	public String deleteCustomer(long userid);

	public List<Customer> viewAllCustomers();

	public Customer viewCustomer(long userid);

	public List<GasBookings> getAllBookings(long userid);
	
	public List<GasBookings> getAllBookingsByBookingDate(long userid, 
			LocalDate fromDate, LocalDate toDate);

	public Cylinder insertCylinder(long userid, Cylinder cylinder);

	public Cylinder updateCylinder(long cylinderid, Cylinder cylinder);

	public String deleteCylinder(long cylinderid);

	public List<Cylinder> viewAllCylinders();

	public List<Cylinder> viewAllCylinderByType(String type);
	
	

}
