package com.demo.main.serviceImplementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.main.entity.Bank;
import com.demo.main.entity.Customer;
import com.demo.main.entity.Cylinder;
import com.demo.main.entity.GasBookings;
import com.demo.main.entity.SurrenderCylinder;
import com.demo.main.exception.ResourceNotFoundException;
import com.demo.main.repository.BankRepository;
import com.demo.main.repository.CustomerRepository;
import com.demo.main.repository.CylinderRepository;
import com.demo.main.repository.GasBookingsRepository;
import com.demo.main.repository.SurrenderCylinderRepository;
import com.demo.main.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	public CustomerRepository customerRepository;

	@Autowired
	public BankRepository bankRepository;

	@Autowired
	public GasBookingsRepository gasBookingsRepository;

	@Autowired
	public CylinderRepository cylinderRepository;

	@Autowired
	public SurrenderCylinderRepository surrenderCylinderRepository;

	@Override
	public Bank addBank(long userid, Bank bank) {
		Customer t1 = customerRepository.findById(userid)
				.orElseThrow(() -> new ResourceNotFoundException("CustomerUser-ID is not found...!! : " + userid));
		Bank c2 = bankRepository.findById(bank.getBankid()).orElse(new Bank());
		c2.setBankname(bank.getBankname());
		c2.setAddress(bank.getAddress());
		t1.setBank(c2);
		return bankRepository.save(c2);

	}

	@Override
	public Bank updateBank(long bankid, Bank bank) {
		Bank b1 = bankRepository.findById(bankid)
				.orElseThrow(() -> new ResourceNotFoundException("Bank-ID is not found...!! : " + bankid));
		b1.setBankname(bank.getBankname());
		b1.setAddress(bank.getAddress());

		return bankRepository.save(b1);

	}

	@Override
	public String deleteBank(long bankid) {
		Bank d1 = bankRepository.findById(bankid)
				.orElseThrow(() -> new ResourceNotFoundException("Bank-ID is not found...!! : " + bankid));
		bankRepository.delete(d1);
		return "Admin Deleted Succesfully....!!! (BankId : " + bankid + ")";

	}

	@Override
	public GasBookings gasBook(long userid, GasBookings gasBookings, Customer customer) {
		Customer t1 = customerRepository.findById(userid)
				.orElseThrow(() -> new ResourceNotFoundException("CustomerUser-ID is not found...!! : " + userid));

		GasBookings g1 = gasBookingsRepository.findById(gasBookings.getGasbookingid()).orElse(new GasBookings());
		g1.setBookingdate(gasBookings.getBookingdate());
		g1.setStatus(true);
//		g1.setBill(gasBookings.getBill());
		g1.setCustomer(t1);
		g1.setBill(t1.getCylinder().getPrice());

		return gasBookingsRepository.save(g1);

	}

	@Override
	public GasBookings updateGasBook(long gasbookingid, GasBookings gasBookings) {
		GasBookings g2 = gasBookingsRepository.findById(gasbookingid)
				.orElseThrow(() -> new ResourceNotFoundException("GasBooking-ID is not found...!! : " + gasbookingid));

		g2.setBookingdate(gasBookings.getBookingdate());
		g2.setStatus(false);
		return gasBookingsRepository.save(g2);
	}

	@Override
	public String deleteGasBook(long gasbookingid) {
		GasBookings g3 = gasBookingsRepository.findById(gasbookingid)
				.orElseThrow(() -> new ResourceNotFoundException("GasBooking-ID is not found...!! : " + gasbookingid));
		gasBookingsRepository.delete(g3);
		return "GasBooking Deleted Succesfully.(GasBookingId : " + gasbookingid + ")";
	}

	@Override
	public float getBillOfBooking(long userid, long gasbookingid) {

		GasBookings gasBooking = gasBookingsRepository.findByUserIdAndGasBookingId(userid, gasbookingid);
		if (gasBooking == null) {
			throw new ResourceNotFoundException("UserId and GasBookingid is not matching...!! : ");
		}
		return gasBooking.getBill();

	}

	@Override
	public SurrenderCylinder insertSurrenderCylinder(long userid, long cylinderid,
			SurrenderCylinder surrenderCylinder) {
		Customer t1 = customerRepository.findById(userid)
				.orElseThrow(() -> new ResourceNotFoundException("CustomerUser-ID is not found...!! : " + userid));

		Cylinder t2 = cylinderRepository.findById(cylinderid)
				.orElseThrow(() -> new ResourceNotFoundException("Cylinder-ID is not found...!! : " + cylinderid));

		SurrenderCylinder s1 = surrenderCylinderRepository.findById(surrenderCylinder.getSurrenderid())
				.orElse(new SurrenderCylinder());
		s1.setSurrenderdate(surrenderCylinder.getSurrenderdate());
		s1.setCylinder(t2);
		s1.setCustomer(t1);

		return surrenderCylinderRepository.save(s1);

	}

	@Override
	public SurrenderCylinder updateSurrenderCylinder(long surrenderid, SurrenderCylinder surrenderCylinder) {
		SurrenderCylinder s2 = surrenderCylinderRepository.findById(surrenderid).orElseThrow(
				() -> new ResourceNotFoundException("SurrenderCylinder-ID is not found...!! : " + surrenderid));
		s2.setSurrenderdate(surrenderCylinder.getSurrenderdate());

		return surrenderCylinderRepository.save(s2);
	}

	@Override
	public String deleteSurrenderCylinder(long surrenderid) {
		SurrenderCylinder s3 = surrenderCylinderRepository.findById(surrenderid).orElseThrow(
				() -> new ResourceNotFoundException("SurrenderCylinder-ID is not found...!! : " + surrenderid));
		surrenderCylinderRepository.delete(s3);
		return "Surrender Cylinder Deleted Successfully.(SurrenderCylinderId : " + surrenderid + ")";
	}

	@Override
	public long getCountOfSurrenderedCylinders() {
		return surrenderCylinderRepository.countSurrenderedCylinders();
	}

}
