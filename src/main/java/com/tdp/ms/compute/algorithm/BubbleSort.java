package com.tdp.ms.compute.algorithm;

import java.util.stream.IntStream;
import org.springframework.stereotype.Service;

@Service("bubbleSort")
public class BubbleSort implements SortCompute {
	@Override
	public void sort(Integer[] arr) {
		int n = arr.length;
		IntStream.range(0, n - 1).flatMap(i -> IntStream.range(1, n - i)).forEach(j -> {
			if (arr[j - 1] > arr[j]) {
				int temp = arr[j];
				arr[j] = arr[j - 1];
				arr[j - 1] = temp;
			}
		});
	}

}
