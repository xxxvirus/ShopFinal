package ua.com.shop.dto.filter;

import java.util.ArrayList;
import java.util.List;

public class SeriaPubFilter {

	List<Integer> publisherIds = new ArrayList<>();

	public List<Integer> getPublisherIds() {
		return publisherIds;
	}

	public void setPublisherIds(List<Integer> publisherIds) {
		this.publisherIds = publisherIds;
	}
	
}
