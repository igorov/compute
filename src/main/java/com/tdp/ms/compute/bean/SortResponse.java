package com.tdp.ms.compute.bean;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SortResponse {
	private Integer[] list;
	private long time;
}
