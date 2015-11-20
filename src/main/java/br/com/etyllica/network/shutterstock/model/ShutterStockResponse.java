package br.com.etyllica.network.shutterstock.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class ShutterStockResponse {
	
	@SerializedName("page")
	private int page;

	@SerializedName("per_page")
	private int pageSize;
	
	@SerializedName("total_count")
	private int totalCount;
	
	@SerializedName("search_id")
	private String searchId;
	
	@SerializedName("data")
	private List<ShutterStockDataItem> data;

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public String getSearchId() {
		return searchId;
	}

	public void setSearchId(String searchId) {
		this.searchId = searchId;
	}

	public List<ShutterStockDataItem> getData() {
		return data;
	}

	public void setData(List<ShutterStockDataItem> data) {
		this.data = data;
	}
	
}
