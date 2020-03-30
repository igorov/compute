package com.tdp.ms.compute.algorithm;

import org.springframework.stereotype.Service;

@Service("mergeSort")
public class MergeSort implements SortCompute {

	@Override
	public void sort(Integer[] a) {
		mergeSort(a, a.length);
	}
	
	private void mergeSort(Integer[] a, int n) {
		if (n < 2) {
			return;
		}
		int mid = n / 2;
		Integer[] l = new Integer[mid];
		Integer[] r = new Integer[n - mid];

		for (int i = 0; i < mid; i++) {
			l[i] = a[i];
		}
		for (int i = mid; i < n; i++) {
			r[i - mid] = a[i];
		}
		mergeSort(l, mid);
		mergeSort(r, n - mid);

		merge(a, l, r, mid, n - mid);
	}

	private void merge(Integer[] a, Integer[] l, Integer[] r, Integer left, Integer right) {
		int i = 0, j = 0, k = 0;
		while (i < left && j < right) {
			if (l[i] <= r[j]) {
				a[k++] = l[i++];
			} else {
				a[k++] = r[j++];
			}
		}
		while (i < left) {
			a[k++] = l[i++];
		}
		while (j < right) {
			a[k++] = r[j++];
		}
	}

}
