package com.tdp.ms.compute;

import java.time.ZonedDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.tdp.ms.compute.algorithm.FibonacciCompute;
import com.tdp.ms.compute.algorithm.SortCompute;
import com.tdp.ms.compute.bean.FibonacciResponse;
import com.tdp.ms.compute.bean.SortResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/compute")
public class ComputeController {
	@Autowired
	private FibonacciCompute fibonacciCompute;
	
	@Autowired
	@Qualifier("mergeSort")
	private SortCompute mergeSort;
	
	@Autowired
	@Qualifier("bubbleSort")
	private SortCompute bubbleSort;
	
	@GetMapping("/fibonacci/{number}")
	public ResponseEntity<FibonacciResponse> fibonacci(@PathVariable Long number) {
		log.info("Inicio del controller fibonacci");

		long iniTime = ZonedDateTime.now().toInstant().toEpochMilli();
		Long fibonacci = fibonacciCompute.fibonacci(number);
		long diff = ZonedDateTime.now().toInstant().toEpochMilli() - iniTime;
		
		FibonacciResponse response = new FibonacciResponse();
		response.setFibonacci(fibonacci);
		response.setTime(diff);
		
		return new ResponseEntity<FibonacciResponse>(response, HttpStatus.OK);
	}
	
	@PostMapping("/sort/merge")
	public ResponseEntity<SortResponse> mergeSort(@RequestBody Integer[] list) {
		log.info("Inicio del controller mergeSort");
		
		long iniTime = ZonedDateTime.now().toInstant().toEpochMilli();
		mergeSort.sort(list);
		long diff = ZonedDateTime.now().toInstant().toEpochMilli() - iniTime;
		
		SortResponse response = new SortResponse();
		response.setList(list);
		response.setTime(diff);
		
		return new ResponseEntity<SortResponse>(response, HttpStatus.OK);
	}
	
	@PostMapping("/sort/bubble")
	public ResponseEntity<SortResponse> bubbleSort(@RequestBody Integer[] list) {
		log.info("Inicio del controller bubbleSort");
		
		long iniTime = ZonedDateTime.now().toInstant().toEpochMilli();
		bubbleSort.sort(list);
		long diff = ZonedDateTime.now().toInstant().toEpochMilli() - iniTime;
		
		SortResponse response = new SortResponse();
		response.setList(list);
		response.setTime(diff);
		
		return new ResponseEntity<SortResponse>(response, HttpStatus.OK);
	}
}
