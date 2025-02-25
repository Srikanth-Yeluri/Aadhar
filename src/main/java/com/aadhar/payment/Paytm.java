package com.aadhar.payment;

import org.springframework.stereotype.Service;

import com.aadhar.common.PaymentService;
@Service
public class Paytm implements PaymentService {

	@Override
	public String doPayment() {
		return "Paytm";
	}

}
