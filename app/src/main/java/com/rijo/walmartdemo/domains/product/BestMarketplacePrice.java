package com.rijo.walmartdemo.domains.product;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BestMarketplacePrice implements Parcelable {

    @SerializedName("price")
    @Expose
    private Double price;
    @SerializedName("sellerInfo")
    @Expose
    private String sellerInfo;
    @SerializedName("standardShipRate")
    @Expose
    private Double standardShipRate;
    @SerializedName("availableOnline")
    @Expose
    private Boolean availableOnline;
    @SerializedName("clearance")
    @Expose
    private Boolean clearance;

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getSellerInfo() {
        return sellerInfo;
    }

    public void setSellerInfo(String sellerInfo) {
        this.sellerInfo = sellerInfo;
    }

    public Double getStandardShipRate() {
        return standardShipRate;
    }

    public void setStandardShipRate(Double standardShipRate) {
        this.standardShipRate = standardShipRate;
    }

    public Boolean getAvailableOnline() {
        return availableOnline;
    }

    public void setAvailableOnline(Boolean availableOnline) {
        this.availableOnline = availableOnline;
    }

    public Boolean getClearance() {
        return clearance;
    }

    public void setClearance(Boolean clearance) {
        this.clearance = clearance;
    }


    protected BestMarketplacePrice(Parcel in) {
        price = in.readByte() == 0x00 ? null : in.readDouble();
        sellerInfo = in.readString();
        standardShipRate = in.readByte() == 0x00 ? null : in.readDouble();
        byte availableOnlineVal = in.readByte();
        availableOnline = availableOnlineVal == 0x02 ? null : availableOnlineVal != 0x00;
        byte clearanceVal = in.readByte();
        clearance = clearanceVal == 0x02 ? null : clearanceVal != 0x00;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (price == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeDouble(price);
        }
        dest.writeString(sellerInfo);
        if (standardShipRate == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeDouble(standardShipRate);
        }
        if (availableOnline == null) {
            dest.writeByte((byte) (0x02));
        } else {
            dest.writeByte((byte) (availableOnline ? 0x01 : 0x00));
        }
        if (clearance == null) {
            dest.writeByte((byte) (0x02));
        } else {
            dest.writeByte((byte) (clearance ? 0x01 : 0x00));
        }
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<BestMarketplacePrice> CREATOR = new Parcelable.Creator<BestMarketplacePrice>() {
        @Override
        public BestMarketplacePrice createFromParcel(Parcel in) {
            return new BestMarketplacePrice(in);
        }

        @Override
        public BestMarketplacePrice[] newArray(int size) {
            return new BestMarketplacePrice[size];
        }
    };
}