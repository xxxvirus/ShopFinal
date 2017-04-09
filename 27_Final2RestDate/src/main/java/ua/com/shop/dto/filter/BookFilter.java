package ua.com.shop.dto.filter;

import java.util.ArrayList;
import java.util.List;

public class BookFilter {

	private List<Integer> genrIds = new ArrayList<>();

	public List<Integer> getGenrIds() {
		return genrIds;
	}

	public void setGenrIds(List<Integer> genrIds) {
		this.genrIds = genrIds;
	}

}
