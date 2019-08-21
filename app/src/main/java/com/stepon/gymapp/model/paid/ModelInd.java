package com.stepon.gymapp.model.paid;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ModelInd {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("package_name")
    @Expose
    private String packageName;
    @SerializedName("package_detail")
    @Expose
    private String packageDetail;
    @SerializedName("price")
    @Expose
    private String price;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("flag")
    @Expose
    private String flag;

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

    public String getPackageDetail() {
        return packageDetail;
    }

    public void setPackageDetail(String packageDetail) {
        this.packageDetail = packageDetail;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }
}
