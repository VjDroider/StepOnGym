package com.stepon.gymapp.model.paid;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ModelCombo {
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("package_name")
    @Expose
    private String packageName;
    @SerializedName("price")
    @Expose
    private String price;
    @SerializedName("package_id")
    @Expose
    private String packageId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPackageId() {
        return packageId;
    }

    public void setPackageId(String packageId) {
        this.packageId = packageId;
    }

}
