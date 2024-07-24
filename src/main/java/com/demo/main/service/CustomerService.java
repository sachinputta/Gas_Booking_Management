package com.demo.main.service;

import com.demo.main.entity.Bank;
import com.demo.main.entity.Customer;
import com.demo.main.entity.GasBookings;
import com.demo.main.entity.SurrenderCylinder;

public interface CustomerService {

	public Bank addBank(long userid, Bank bank);

	public Bank updateBank(long bankid, Bank bank);

	public String deleteBank(long bankid);

	public GasBookings gasBook(long userid, GasBookings gasBookings, Customer customer);

	public GasBookings updateGasBook(long gasbookingid, GasBookings gasBookings);

	public String deleteGasBook(long gasbookingid);
	
	public float getBillOfBooking(long userid,long gasbookingid);

	public SurrenderCylinder insertSurrenderCylinder(long userid, long cylinderid, SurrenderCylinder surrenderCylinder);

	public SurrenderCylinder updateSurrenderCylinder(long surrenderid, SurrenderCylinder surrenderCylinder);

	public String deleteSurrenderCylinder(long surrenderid);
	
	public long getCountOfSurrenderedCylinders();

	
}
