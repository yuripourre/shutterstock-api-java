package br.com.etyllica.network.shutterstock.model;

import com.google.gson.annotations.SerializedName;

public class ShutterStockDataItem {
	
	@SerializedName("id")
	String id;
		
	@SerializedName("aspect")
	double aspect;

	@SerializedName("description")
	String description;
	
	@SerializedName("image_type")
	String imageType;
	
	@SerializedName("media_type")
	String mediaType;
	
	@SerializedName("contributor")
	ShutterStockContributor contributor;
	
	@SerializedName("assets")
	ShutterStockAssets assets;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public double getAspect() {
		return aspect;
	}

	public void setAspect(double aspect) {
		this.aspect = aspect;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImageType() {
		return imageType;
	}

	public void setImageType(String imageType) {
		this.imageType = imageType;
	}

	public String getMediaType() {
		return mediaType;
	}

	public void setMediaType(String mediaType) {
		this.mediaType = mediaType;
	}

	public ShutterStockContributor getContributor() {
		return contributor;
	}

	public void setContributor(ShutterStockContributor contributor) {
		this.contributor = contributor;
	}

	public ShutterStockAssets getAssets() {
		return assets;
	}

	public void setAssets(ShutterStockAssets assets) {
		this.assets = assets;
	}
	
}
