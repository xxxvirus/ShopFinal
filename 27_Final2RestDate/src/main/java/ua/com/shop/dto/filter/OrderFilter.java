package ua.com.shop.dto.filter;

public class OrderFilter {

	private String search = "";
	private boolean send;

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public boolean getSend() {
		return send;
	}

	public void setSend(boolean send) {
		this.send = send;
	}

}
