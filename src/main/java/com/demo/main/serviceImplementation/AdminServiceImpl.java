package com.demo.main.serviceImplementation;

import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.demo.main.entity.Admin;
import com.demo.main.entity.Customer;
import com.demo.main.entity.Cylinder;
import com.demo.main.entity.GasBookings;
import com.demo.main.exception.ResourceNotFoundException;
import com.demo.main.repository.AdminRepository;
import com.demo.main.repository.BankRepository;
import com.demo.main.repository.CustomerRepository;
import com.demo.main.repository.CylinderRepository;
import com.demo.main.repository.GasBookingsRepository;
import com.demo.main.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
	public AdminRepository adminRepository;

	@Autowired
	public CustomerRepository customerRepository;

	@Autowired
	public CylinderRepository cylinderRepository;

	@Autowired
	public BankRepository bankRepository;

	@Autowired
	public GasBookingsRepository gasBookingsRepository;

	@Override
	public Admin addAdmin(Admin admin) {
		Admin a1 = adminRepository.findById(admin.getUserid()).orElse(new Admin());
		a1.setUserid(admin.getUserid());
		a1.setUsername(admin.getUsername());
		a1.setPassword(admin.getPassword());
		a1.setAddress(admin.getAddress());
		a1.setPhoneno(admin.getPhoneno());
		a1.setEmail(admin.getEmail());
		a1.setAdminname(admin.getUsername());

		return adminRepository.save(a1);
	}

	@Override
	public Admin updateAdmin(long userid, Admin admin) {
		Admin t1 = adminRepository.findById(userid)
				.orElseThrow(() -> new ResourceNotFoundException("AdminUser-ID is not found...!! : " + userid));

		t1.setAddress(admin.getAddress());
		t1.setPhoneno(admin.getPhoneno());

		t1.setEmail(admin.getEmail());
		return adminRepository.save(t1);
	}

	@Override
	public String deleteAdmin(long userid) {
		Admin d1 = adminRepository.findById(userid)
				.orElseThrow(() -> new ResourceNotFoundException("AdminUser-ID is not found...!! : " + userid));
		adminRepository.delete(d1);
		return "Admin Deleted Succesfully....!!! (AdminId : " + userid + ").";
	}

	@Override
	public Customer addCustomer(long cylinderid, Cylinder cylinder, Customer customer) {
		Customer c1 = customerRepository.findById(customer.getUserid()).orElse(new Customer());
		Cylinder d1 = cylinderRepository.findById(cylinderid)
				.orElseThrow(() -> new ResourceNotFoundException("Cylinder-ID is not found...!! : " + cylinderid));

		c1.setUserid(customer.getUserid());
		c1.setUsername(customer.getUsername());
		c1.setPassword(customer.getPassword());
		c1.setAddress(customer.getAddress());
		c1.setPhoneno(customer.getPhoneno());
		c1.setEmail(customer.getEmail());
		c1.setAccountnumber(customer.getAccountnumber());
		c1.setCylinder(d1);

		return customerRepository.save(c1);

	}

	@Override
	public Customer updateCustomer(long userid, Customer customer) {
		Customer t1 = customerRepository.findById(userid)
				.orElseThrow(() -> new ResourceNotFoundException("CustomerUser-ID is not found...!! : " + userid));

		t1.setAddress(customer.getAddress());
		t1.setPhoneno(customer.getPhoneno());
		;
		t1.setEmail(customer.getEmail());
		t1.setAccountnumber(customer.getAccountnumber());
		return customerRepository.save(t1);
	}

	@Override
	public String deleteCustomer(long userid) {
		Customer d1 = customerRepository.findById(userid)
				.orElseThrow(() -> new ResourceNotFoundException("CustomerUser-ID is not found...!! : " + userid));
		customerRepository.delete(d1);
		return "Customer Deleted Succesfully....!!! (CustomerId : " + userid + ").";
	}

	@Override
	public List<Customer> viewAllCustomers() {

		return customerRepository.findAll();
	}

	@Override
	public Customer viewCustomer(long userid) {

		return customerRepository.findById(userid)
				.orElseThrow(() -> new ResourceNotFoundException("CustomerID is not found...!!"));
	}

	@Override
	public List<GasBookings> getAllBookings(long userid) {

		Customer d1 = customerRepository.findById(userid)
				.orElseThrow(() -> new ResourceNotFoundException("CustomerUser-ID is not found...!! : " + userid));

		List<GasBookings> g4 = gasBookingsRepository.findByCustomerUserid(userid);
		return g4;
	}

	@Override
	public List<GasBookings> getAllBookingsByBookingDate(long userid, LocalDate fromDate, LocalDate toDate) {
		Customer d2 = customerRepository.findById(userid)
				.orElseThrow(() -> new ResourceNotFoundException("CustomerUser-ID is not found...!! : " + userid));
		List<GasBookings> g5 = gasBookingsRepository.findByBookingdate(fromDate, toDate);
		return g5;

	}

	@Override
	public Cylinder insertCylinder(long userid, Cylinder cylinder) {
		Admin t3 = adminRepository.findById(userid)
				.orElseThrow(() -> new ResourceNotFoundException("AdminUser-ID is not found...!! : " + userid));

		Cylinder c2 = cylinderRepository.findById(cylinder.getCylinderid()).orElse(new Cylinder());

		c2.setCylinderagency(cylinder.getCylinderagency());
		c2.setType(cylinder.getType());
		c2.setWeight(cylinder.getWeight());
		c2.setStrapcolor(cylinder.getStrapcolor());
		c2.setPrice(cylinder.getPrice());

		return cylinderRepository.save(c2);

	}

	@Override
	public Cylinder updateCylinder(long cylinderid, Cylinder cylinder) {
		Cylinder c3 = cylinderRepository.findById(cylinderid)
				.orElseThrow(() -> new ResourceNotFoundException("CustomerUser-ID is not found...!! : " + cylinderid));
		c3.setType(cylinder.getType());
		c3.setStrapcolor(cylinder.getStrapcolor());
		c3.setWeight(cylinder.getWeight());
		c3.setPrice(cylinder.getPrice());
		return cylinderRepository.save(c3);
	}

	@Override
	public String deleteCylinder(long cylinderid) {
		Cylinder d1 = cylinderRepository.findById(cylinderid)
				.orElseThrow(() -> new ResourceNotFoundException("Cylinder-ID is not found...!! : " + cylinderid));
		cylinderRepository.delete(d1);
		return "Cylinder Deleted Succesfully....!!! (CylinderId : " + cylinderid + ").";
	}

	@Override
	public List<Cylinder> viewAllCylinders() {

		return cylinderRepository.findAll();
	}

	@Override
	public List<Cylinder> viewAllCylinderByType(String type) {

		if ("Commercial".equalsIgnoreCase(type) || "Domestic".equalsIgnoreCase(type)) {
			List<Cylinder> cylindertype = cylinderRepository.findByType(type);

			return cylindertype;
		} else {
			throw new ResourceNotFoundException("CylinderType is not found...!! : " + type);
		}

	} 

}
