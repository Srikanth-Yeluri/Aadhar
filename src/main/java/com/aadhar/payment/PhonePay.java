package com.aadhar.payment;

import org.springframework.stereotype.Service;

import com.aadhar.common.PaymentService;
@Service
public class PhonePay implements PaymentService {

	@Override
	public String doPayment() {
		return "PhonePay";
		
	}

}
