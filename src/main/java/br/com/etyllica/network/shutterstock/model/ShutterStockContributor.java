package br.com.etyllica.network.shutterstock.model;

import com.google.gson.annotations.SerializedName;

public class ShutterStockContributor {

	@SerializedName("id")
	String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
}
