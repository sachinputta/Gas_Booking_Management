package com.demo.main.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.main.entity.Admin;
import com.demo.main.entity.Customer;
import com.demo.main.entity.Cylinder;
import com.demo.main.entity.GasBookings;
import com.demo.main.service.AdminService;
import com.demo.main.service.CustomerService;

@RestController
public class AdminController {

	@Autowired
	public AdminService adminService;

	@Autowired
	public CustomerService customerService;

	@PostMapping("/addAdmin")
	public Admin addAdmin(@RequestBody Admin admin) {

		Admin t1 = adminService.addAdmin(admin);
		return t1;
	}

	@PutMapping("/updateAdmin")
	public Admin updateAdmin(@RequestParam long userid, @RequestBody Admin admin) {

		Admin admin_update = adminService.updateAdmin(userid, admin);
		return admin_update;
	}

	@DeleteMapping("/deleteAdmin")
	public String deleteAdmin(@RequestParam long userid) {
		String delete_admin = adminService.deleteAdmin(userid);

		return delete_admin;
	}

	@PostMapping("/addCustomer")
	public Customer addCustomer(@RequestParam long cylinderid, Cylinder cylinder, @RequestBody Customer customer) {

		Customer t1 = adminService.addCustomer(cylinderid, cylinder, customer);
		return t1;
	}

	@PutMapping("/updateCustomer")
	public Customer updateAdmin(@RequestParam long userid, @RequestBody Customer customer) {

		Customer admin_update = adminService.updateCustomer(userid, customer);
		return admin_update;
	}

	@DeleteMapping("/deleteCustomer")
	public String deleteCustomer(@RequestParam long userid) {
		String delete_Customer = adminService.deleteCustomer(userid);

		return delete_Customer;
	}

	@GetMapping("/viewCustomer")

	public Customer viewCustomer(@RequestParam long userid) {
		Customer viewCustomer = adminService.viewCustomer(userid);

		return viewCustomer;

	}

	@GetMapping("/viewAllCustomers")

	public List<Customer> viewAllCustomers() {
		List<Customer> view_All_Customers = adminService.viewAllCustomers();

		return view_All_Customers;

	}

	@GetMapping("/getAllBookings")
	public List<GasBookings> getAllBookings(long userid) {

		List<GasBookings> get_all_bookings = adminService.getAllBookings(userid);

		return get_all_bookings;

	}
	
	@GetMapping("/getAllBookingsByBookingDate")
	public List<GasBookings> getAllBookingsByBookingDate(@RequestParam long userid, @RequestParam  LocalDate fromDate,
			@RequestParam	LocalDate toDate) {

		List<GasBookings> get_all_bookings_date = adminService.getAllBookingsByBookingDate(userid, fromDate, toDate);

		return get_all_bookings_date;

	}

	@PostMapping("/insertCylinder")
	public Cylinder insertCylinder(@RequestParam long userid, @RequestBody Cylinder cylinder) {

		Cylinder t1 = adminService.insertCylinder(userid, cylinder);
		return t1;
	}

	@PutMapping("/updateCylinder")
	public Cylinder updateCylinder(@RequestParam long cylinderid, @RequestBody Cylinder cylinder) {

		Cylinder cylinder_update = adminService.updateCylinder(cylinderid, cylinder);
		return cylinder_update;
	}

	@DeleteMapping("/deleteCylinder")
	public String deleteCylinder(@RequestParam long cylinderid) {
		String delete_Cylinder = adminService.deleteCylinder(cylinderid);

		return delete_Cylinder;
	}

	@GetMapping("/viewAllCylinders")

	public List<Cylinder> viewAllCylinders() {
		List<Cylinder> view_All_Cylinders = adminService.viewAllCylinders();

		return view_All_Cylinders;

	}

	@GetMapping("/viewAllCylinderByType")

	public List<Cylinder> viewAllCylinderByType(@RequestParam String type) {
		List<Cylinder> view_All_Cylinder_By_Type = adminService.viewAllCylinderByType(type);

		return view_All_Cylinder_By_Type;

	}

	

}
