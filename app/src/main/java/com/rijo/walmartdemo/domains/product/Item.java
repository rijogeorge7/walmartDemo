package com.rijo.walmartdemo.domains.product;

/**
 * Created by rijogeorge on 8/18/17.
 */

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Item implements Parcelable {

    @SerializedName("itemId")
    @Expose
    private Integer itemId;
    @SerializedName("parentItemId")
    @Expose
    private Integer parentItemId;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("msrp")
    @Expose
    private Double msrp;
    @SerializedName("salePrice")
    @Expose
    private Double salePrice;
    @SerializedName("upc")
    @Expose
    private String upc;
    @SerializedName("categoryPath")
    @Expose
    private String categoryPath;
    @SerializedName("shortDescription")
    @Expose
    private String shortDescription;
    @SerializedName("longDescription")
    @Expose
    private String longDescription;
    @SerializedName("brandName")
    @Expose
    private String brandName;
    @SerializedName("thumbnailImage")
    @Expose
    private String thumbnailImage;
    @SerializedName("mediumImage")
    @Expose
    private String mediumImage;
    @SerializedName("largeImage")
    @Expose
    private String largeImage;
    @SerializedName("productTrackingUrl")
    @Expose
    private String productTrackingUrl;
    @SerializedName("ninetySevenCentShipping")
    @Expose
    private Boolean ninetySevenCentShipping;
    @SerializedName("standardShipRate")
    @Expose
    private Double standardShipRate;
    @SerializedName("twoThreeDayShippingRate")
    @Expose
    private Double twoThreeDayShippingRate;
    @SerializedName("overnightShippingRate")
    @Expose
    private Double overnightShippingRate;
    @SerializedName("size")
    @Expose
    private String size;
    @SerializedName("color")
    @Expose
    private String color;
    @SerializedName("marketplace")
    @Expose
    private Boolean marketplace;
    @SerializedName("shipToStore")
    @Expose
    private Boolean shipToStore;
    @SerializedName("freeShipToStore")
    @Expose
    private Boolean freeShipToStore;
    @SerializedName("modelNumber")
    @Expose
    private String modelNumber;
    @SerializedName("productUrl")
    @Expose
    private String productUrl;
    @SerializedName("customerRating")
    @Expose
    private String customerRating;
    @SerializedName("numReviews")
    @Expose
    private Integer numReviews;
    @SerializedName("variants")
    @Expose
    private List<Integer> variants = null;
    @SerializedName("customerRatingImage")
    @Expose
    private String customerRatingImage;
    @SerializedName("bestMarketplacePrice")
    @Expose
    private BestMarketplacePrice bestMarketplacePrice;
    @SerializedName("categoryNode")
    @Expose
    private String categoryNode;
    @SerializedName("bundle")
    @Expose
    private Boolean bundle;
    @SerializedName("clearance")
    @Expose
    private Boolean clearance;
    @SerializedName("preOrder")
    @Expose
    private Boolean preOrder;
    @SerializedName("stock")
    @Expose
    private String stock;
    @SerializedName("attributes")
    @Expose
    private Attributes attributes;
    @SerializedName("addToCartUrl")
    @Expose
    private String addToCartUrl;
    @SerializedName("affiliateAddToCartUrl")
    @Expose
    private String affiliateAddToCartUrl;
    @SerializedName("freeShippingOver50Dollars")
    @Expose
    private Boolean freeShippingOver50Dollars;
    @SerializedName("maxItemsInOrder")
    @Expose
    private Integer maxItemsInOrder;
    @SerializedName("availableOnline")
    @Expose
    private Boolean availableOnline;

    public Item(){

    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Integer getParentItemId() {
        return parentItemId;
    }

    public void setParentItemId(Integer parentItemId) {
        this.parentItemId = parentItemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getMsrp() {
        return msrp;
    }

    public void setMsrp(Double msrp) {
        this.msrp = msrp;
    }

    public Double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(Double salePrice) {
        this.salePrice = salePrice;
    }

    public String getUpc() {
        return upc;
    }

    public void setUpc(String upc) {
        this.upc = upc;
    }

    public String getCategoryPath() {
        return categoryPath;
    }

    public void setCategoryPath(String categoryPath) {
        this.categoryPath = categoryPath;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getThumbnailImage() {
        return thumbnailImage;
    }

    public void setThumbnailImage(String thumbnailImage) {
        this.thumbnailImage = thumbnailImage;
    }

    public String getMediumImage() {
        return mediumImage;
    }

    public void setMediumImage(String mediumImage) {
        this.mediumImage = mediumImage;
    }

    public String getLargeImage() {
        return largeImage;
    }

    public void setLargeImage(String largeImage) {
        this.largeImage = largeImage;
    }

    public String getProductTrackingUrl() {
        return productTrackingUrl;
    }

    public void setProductTrackingUrl(String productTrackingUrl) {
        this.productTrackingUrl = productTrackingUrl;
    }

    public Boolean getNinetySevenCentShipping() {
        return ninetySevenCentShipping;
    }

    public void setNinetySevenCentShipping(Boolean ninetySevenCentShipping) {
        this.ninetySevenCentShipping = ninetySevenCentShipping;
    }

    public Double getStandardShipRate() {
        return standardShipRate;
    }

    public void setStandardShipRate(Double standardShipRate) {
        this.standardShipRate = standardShipRate;
    }

    public Double getTwoThreeDayShippingRate() {
        return twoThreeDayShippingRate;
    }

    public void setTwoThreeDayShippingRate(Double twoThreeDayShippingRate) {
        this.twoThreeDayShippingRate = twoThreeDayShippingRate;
    }

    public Double getOvernightShippingRate() {
        return overnightShippingRate;
    }

    public void setOvernightShippingRate(Double overnightShippingRate) {
        this.overnightShippingRate = overnightShippingRate;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Boolean getMarketplace() {
        return marketplace;
    }

    public void setMarketplace(Boolean marketplace) {
        this.marketplace = marketplace;
    }

    public Boolean getShipToStore() {
        return shipToStore;
    }

    public void setShipToStore(Boolean shipToStore) {
        this.shipToStore = shipToStore;
    }

    public Boolean getFreeShipToStore() {
        return freeShipToStore;
    }

    public void setFreeShipToStore(Boolean freeShipToStore) {
        this.freeShipToStore = freeShipToStore;
    }

    public String getModelNumber() {
        return modelNumber;
    }

    public void setModelNumber(String modelNumber) {
        this.modelNumber = modelNumber;
    }

    public String getProductUrl() {
        return productUrl;
    }

    public void setProductUrl(String productUrl) {
        this.productUrl = productUrl;
    }

    public String getCustomerRating() {
        return customerRating;
    }

    public void setCustomerRating(String customerRating) {
        this.customerRating = customerRating;
    }

    public Integer getNumReviews() {
        return numReviews;
    }

    public void setNumReviews(Integer numReviews) {
        this.numReviews = numReviews;
    }

    public List<Integer> getVariants() {
        return variants;
    }

    public void setVariants(List<Integer> variants) {
        this.variants = variants;
    }

    public String getCustomerRatingImage() {
        return customerRatingImage;
    }

    public void setCustomerRatingImage(String customerRatingImage) {
        this.customerRatingImage = customerRatingImage;
    }

    public BestMarketplacePrice getBestMarketplacePrice() {
        return bestMarketplacePrice;
    }

    public void setBestMarketplacePrice(BestMarketplacePrice bestMarketplacePrice) {
        this.bestMarketplacePrice = bestMarketplacePrice;
    }

    public String getCategoryNode() {
        return categoryNode;
    }

    public void setCategoryNode(String categoryNode) {
        this.categoryNode = categoryNode;
    }

    public Boolean getBundle() {
        return bundle;
    }

    public void setBundle(Boolean bundle) {
        this.bundle = bundle;
    }

    public Boolean getClearance() {
        return clearance;
    }

    public void setClearance(Boolean clearance) {
        this.clearance = clearance;
    }

    public Boolean getPreOrder() {
        return preOrder;
    }

    public void setPreOrder(Boolean preOrder) {
        this.preOrder = preOrder;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public Attributes getAttributes() {
        return attributes;
    }

    public void setAttributes(Attributes attributes) {
        this.attributes = attributes;
    }

    public String getAddToCartUrl() {
        return addToCartUrl;
    }

    public void setAddToCartUrl(String addToCartUrl) {
        this.addToCartUrl = addToCartUrl;
    }

    public String getAffiliateAddToCartUrl() {
        return affiliateAddToCartUrl;
    }

    public void setAffiliateAddToCartUrl(String affiliateAddToCartUrl) {
        this.affiliateAddToCartUrl = affiliateAddToCartUrl;
    }

    public Boolean getFreeShippingOver50Dollars() {
        return freeShippingOver50Dollars;
    }

    public void setFreeShippingOver50Dollars(Boolean freeShippingOver50Dollars) {
        this.freeShippingOver50Dollars = freeShippingOver50Dollars;
    }

    public Integer getMaxItemsInOrder() {
        return maxItemsInOrder;
    }

    public void setMaxItemsInOrder(Integer maxItemsInOrder) {
        this.maxItemsInOrder = maxItemsInOrder;
    }

    public Boolean getAvailableOnline() {
        return availableOnline;
    }

    public void setAvailableOnline(Boolean availableOnline) {
        this.availableOnline = availableOnline;
    }


    public Item(Parcel in) {
        itemId = in.readByte() == 0x00 ? null : in.readInt();
        parentItemId = in.readByte() == 0x00 ? null : in.readInt();
        name = in.readString();
        msrp = in.readByte() == 0x00 ? null : in.readDouble();
        salePrice = in.readByte() == 0x00 ? null : in.readDouble();
        upc = in.readString();
        categoryPath = in.readString();
        shortDescription = in.readString();
        longDescription = in.readString();
        brandName = in.readString();
        thumbnailImage = in.readString();
        mediumImage = in.readString();
        largeImage = in.readString();
        productTrackingUrl = in.readString();
        byte ninetySevenCentShippingVal = in.readByte();
        ninetySevenCentShipping = ninetySevenCentShippingVal == 0x02 ? null : ninetySevenCentShippingVal != 0x00;
        standardShipRate = in.readByte() == 0x00 ? null : in.readDouble();
        twoThreeDayShippingRate = in.readByte() == 0x00 ? null : in.readDouble();
        overnightShippingRate = in.readByte() == 0x00 ? null : in.readDouble();
        size = in.readString();
        color = in.readString();
        byte marketplaceVal = in.readByte();
        marketplace = marketplaceVal == 0x02 ? null : marketplaceVal != 0x00;
        byte shipToStoreVal = in.readByte();
        shipToStore = shipToStoreVal == 0x02 ? null : shipToStoreVal != 0x00;
        byte freeShipToStoreVal = in.readByte();
        freeShipToStore = freeShipToStoreVal == 0x02 ? null : freeShipToStoreVal != 0x00;
        modelNumber = in.readString();
        productUrl = in.readString();
        customerRating = in.readString();
        numReviews = in.readByte() == 0x00 ? null : in.readInt();
        if (in.readByte() == 0x01) {
            variants = new ArrayList<Integer>();
            in.readList(variants, Integer.class.getClassLoader());
        } else {
            variants = null;
        }
        customerRatingImage = in.readString();
        bestMarketplacePrice = (BestMarketplacePrice) in.readValue(BestMarketplacePrice.class.getClassLoader());
        categoryNode = in.readString();
        byte bundleVal = in.readByte();
        bundle = bundleVal == 0x02 ? null : bundleVal != 0x00;
        byte clearanceVal = in.readByte();
        clearance = clearanceVal == 0x02 ? null : clearanceVal != 0x00;
        byte preOrderVal = in.readByte();
        preOrder = preOrderVal == 0x02 ? null : preOrderVal != 0x00;
        stock = in.readString();
        attributes = (Attributes) in.readValue(Attributes.class.getClassLoader());
        addToCartUrl = in.readString();
        affiliateAddToCartUrl = in.readString();
        byte freeShippingOver50DollarsVal = in.readByte();
        freeShippingOver50Dollars = freeShippingOver50DollarsVal == 0x02 ? null : freeShippingOver50DollarsVal != 0x00;
        maxItemsInOrder = in.readByte() == 0x00 ? null : in.readInt();
        byte availableOnlineVal = in.readByte();
        availableOnline = availableOnlineVal == 0x02 ? null : availableOnlineVal != 0x00;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (itemId == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(itemId);
        }
        if (parentItemId == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(parentItemId);
        }
        dest.writeString(name);
        if (msrp == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeDouble(msrp);
        }
        if (salePrice == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeDouble(salePrice);
        }
        dest.writeString(upc);
        dest.writeString(categoryPath);
        dest.writeString(shortDescription);
        dest.writeString(longDescription);
        dest.writeString(brandName);
        dest.writeString(thumbnailImage);
        dest.writeString(mediumImage);
        dest.writeString(largeImage);
        dest.writeString(productTrackingUrl);
        if (ninetySevenCentShipping == null) {
            dest.writeByte((byte) (0x02));
        } else {
            dest.writeByte((byte) (ninetySevenCentShipping ? 0x01 : 0x00));
        }
        if (standardShipRate == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeDouble(standardShipRate);
        }
        if (twoThreeDayShippingRate == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeDouble(twoThreeDayShippingRate);
        }
        if (overnightShippingRate == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeDouble(overnightShippingRate);
        }
        dest.writeString(size);
        dest.writeString(color);
        if (marketplace == null) {
            dest.writeByte((byte) (0x02));
        } else {
            dest.writeByte((byte) (marketplace ? 0x01 : 0x00));
        }
        if (shipToStore == null) {
            dest.writeByte((byte) (0x02));
        } else {
            dest.writeByte((byte) (shipToStore ? 0x01 : 0x00));
        }
        if (freeShipToStore == null) {
            dest.writeByte((byte) (0x02));
        } else {
            dest.writeByte((byte) (freeShipToStore ? 0x01 : 0x00));
        }
        dest.writeString(modelNumber);
        dest.writeString(productUrl);
        dest.writeString(customerRating);
        if (numReviews == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(numReviews);
        }
        if (variants == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(variants);
        }
        dest.writeString(customerRatingImage);
        dest.writeValue(bestMarketplacePrice);
        dest.writeString(categoryNode);
        if (bundle == null) {
            dest.writeByte((byte) (0x02));
        } else {
            dest.writeByte((byte) (bundle ? 0x01 : 0x00));
        }
        if (clearance == null) {
            dest.writeByte((byte) (0x02));
        } else {
            dest.writeByte((byte) (clearance ? 0x01 : 0x00));
        }
        if (preOrder == null) {
            dest.writeByte((byte) (0x02));
        } else {
            dest.writeByte((byte) (preOrder ? 0x01 : 0x00));
        }
        dest.writeString(stock);
        dest.writeValue(attributes);
        dest.writeString(addToCartUrl);
        dest.writeString(affiliateAddToCartUrl);
        if (freeShippingOver50Dollars == null) {
            dest.writeByte((byte) (0x02));
        } else {
            dest.writeByte((byte) (freeShippingOver50Dollars ? 0x01 : 0x00));
        }
        if (maxItemsInOrder == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(maxItemsInOrder);
        }
        if (availableOnline == null) {
            dest.writeByte((byte) (0x02));
        } else {
            dest.writeByte((byte) (availableOnline ? 0x01 : 0x00));
        }
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Item> CREATOR = new Parcelable.Creator<Item>() {
        @Override
        public Item createFromParcel(Parcel in) {
            return new Item(in);
        }

        @Override
        public Item[] newArray(int size) {
            return new Item[size];
        }
    };
}