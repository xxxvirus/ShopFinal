package ua.com.shop.dto.filter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ShopFilter {

	private String search = "";
	private String max = "";
	private String min = "";
	private BigDecimal maxValue;
	private BigDecimal minValue;

	private List<Integer> languageIds = new ArrayList<>();
	private List<Integer> categoryIds = new ArrayList<>();
	private List<Integer> publisherIds = new ArrayList<>();

	
	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public String getMax() {
		return max;
	}

	public void setMax(String max) {
		this.max = max;
	}

	public String getMin() {
		return min;
	}

	public void setMin(String min) {
		this.min = min;
	}

	public BigDecimal getMaxValue() {
		return maxValue;
	}

	public void setMaxValue(BigDecimal maxValue) {
		this.maxValue = maxValue;
	}

	public BigDecimal getMinValue() {
		return minValue;
	}

	public void setMinValue(BigDecimal minValue) {
		this.minValue = minValue;
	}

	public List<Integer> getLanguageIds() {
		return languageIds;
	}

	public void setLanguageIds(List<Integer> languageIds) {
		this.languageIds = languageIds;
	}

	public List<Integer> getCategoryIds() {
		return categoryIds;
	}

	public void setCategoryIds(List<Integer> categoryIds) {
		this.categoryIds = categoryIds;
	}

	public List<Integer> getPublisherIds() {
		return publisherIds;
	}

	public void setPublisherIds(List<Integer> publisherIds) {
		this.publisherIds = publisherIds;
	}

}
