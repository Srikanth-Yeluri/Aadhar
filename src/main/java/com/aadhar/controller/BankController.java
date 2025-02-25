package com.aadhar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aadhar.common.PaymentService;

@RestController
@RequestMapping("/bank")
public class BankController {

	PaymentService paymentService;
	@Autowired
	ApplicationContext applicationContext;

	@GetMapping("/payment/{bean}")
	public String doPayment(@PathVariable String bean) {
		paymentService = (PaymentService) applicationContext.getBean(bean);

		return paymentService.doPayment();

	}

}
