package br.com.etyllica.network.shutterstock.model;

import com.google.gson.annotations.SerializedName;

public class ShutterStockAssets {

	@SerializedName("preview")
	ShutterStockAsset preview;
	
	@SerializedName("small_thumb")
	ShutterStockAsset smallThumbnail;
	
	@SerializedName("large_thumb")
	ShutterStockAsset largeThumbnail;

	public ShutterStockAsset getPreview() {
		return preview;
	}

	public void setPreview(ShutterStockAsset preview) {
		this.preview = preview;
	}

	public ShutterStockAsset getSmallThumbnail() {
		return smallThumbnail;
	}

	public void setSmallThumbnail(ShutterStockAsset smallThumbnail) {
		this.smallThumbnail = smallThumbnail;
	}

	public ShutterStockAsset getLargeThumbnail() {
		return largeThumbnail;
	}

	public void setLargeThumbnail(ShutterStockAsset largeThumbnail) {
		this.largeThumbnail = largeThumbnail;
	}
	
}
