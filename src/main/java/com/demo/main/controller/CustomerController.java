package com.demo.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.main.entity.Bank;
import com.demo.main.entity.Customer;
import com.demo.main.entity.GasBookings;
import com.demo.main.entity.SurrenderCylinder;
import com.demo.main.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	public CustomerService customerService;

	@PostMapping("/addBank")
	public Bank addBank(@RequestParam long userid, @RequestBody Bank bank) {

		Bank t1 = customerService.addBank(userid, bank);
		return t1;
	}

	@PutMapping("/updateBank")
	public Bank updateBank(@RequestParam long bankid, @RequestBody Bank bank) {

		Bank bank_update = customerService.updateBank(bankid, bank);
		return bank_update;
	}

	@DeleteMapping("/deleteBank")
	public String deleteBank(@RequestParam long bankid) {
		String delete_bank = customerService.deleteBank(bankid);

		return delete_bank;
	}

	@PostMapping("/gasBook")
	public GasBookings gasBook(@RequestParam long userid, @RequestBody GasBookings gasBookings, Customer customer) {

		GasBookings t1 = customerService.gasBook(userid, gasBookings, customer);
		return t1;
	}

	@PutMapping("/updateGasBook")
	public GasBookings updateGas(@RequestParam long bookingid, @RequestBody GasBookings gasBookings) {

		GasBookings update_gasBook = customerService.updateGasBook(bookingid, gasBookings);
		return update_gasBook;
	}

	@DeleteMapping("/deleteGasBook")
	public String deleteGasBook(@RequestParam long bookingid) {
		String delete_gasBook = customerService.deleteGasBook(bookingid);

		return delete_gasBook;
	}
	
	@GetMapping("/getBillOfBooking")
	public float getBillOfBooking(@RequestParam long userid, long gasbookingid) {

		float getbill = customerService.getBillOfBooking(userid,gasbookingid);
		return getbill;
	}

	@PostMapping("/insertSurrenderCylinder")
	public SurrenderCylinder insertSurrenderCylinder(@RequestParam long userid, long cylinderid,
			@RequestBody SurrenderCylinder surrenderCylinder) {

		SurrenderCylinder insert_surrenderCylinder = customerService.insertSurrenderCylinder(userid, cylinderid,
				surrenderCylinder);
		return insert_surrenderCylinder;
	}

	@PutMapping("/updateSurrenderCylinder")
	public SurrenderCylinder updateSurrenderCylinder(@RequestParam long surrenderid,
			@RequestBody SurrenderCylinder surrenderCylinder) {

		SurrenderCylinder update_surrenderCylinder = customerService.updateSurrenderCylinder(surrenderid,
				surrenderCylinder);
		return update_surrenderCylinder;
	}

	@DeleteMapping("/deleteSurrenderCylinder")
	public String deleteSurrenderCylinder(@RequestParam long surrenderid) {

		String delete_surrenderCylinder = customerService.deleteSurrenderCylinder(surrenderid);
		return delete_surrenderCylinder;
	}
	
	  @GetMapping("/countOfSurrenderCylinder")
	    public long getCountOfSurrenderedCylinders() {
	        return customerService.getCountOfSurrenderedCylinders();
	    }


}
