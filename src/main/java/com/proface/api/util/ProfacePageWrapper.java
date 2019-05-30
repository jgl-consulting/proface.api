package com.proface.api.util;

import lombok.Data;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Data
public class ProfacePageWrapper<T> {

	public static <T, K> ProfacePageWrapper<K> of(Page<T> page, Function<T, K> mapper) {
		ProfacePageWrapper<K> pageWrapper = new ProfacePageWrapper<>();
		pageWrapper.content = page.getContent().stream().map(mapper).collect(Collectors.toList());
		pageWrapper.totalElements = page.getTotalElements();
		pageWrapper.totalPages = page.getTotalPages();
		pageWrapper.page = page.getPageable().getPageNumber();
		pageWrapper.size = page.getPageable().getPageSize();
		pageWrapper.isSorted = page.getPageable().getSort().isSorted();
		return pageWrapper;
	}

	private long totalElements;

	private long totalPages;

	private int page;

	private int size;

	private boolean isSorted;

	private List<T> content;

}
