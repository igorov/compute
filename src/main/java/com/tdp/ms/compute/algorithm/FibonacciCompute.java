package com.tdp.ms.compute.algorithm;

import org.springframework.stereotype.Service;

@Service
public class FibonacciCompute {
	public Long fibonacci(Long number) {
		Long a = 0L;
		Long b = 1L;
		Long c;
		
		for (Long i = 0L; i < number; i++) {
			c = b + a;
			a = b;
			b = c;
		}
		return a;
	}
}
