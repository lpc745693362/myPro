package com.lpc.struts;

import java.io.Serializable;

/**
 * sku µÃÂ¿‡
 * Created by liupengcheng1 on 2017/4/18.
 */
public class Sku implements Serializable {

    private Long skuId;
    private String name;
    private double jdPrice;
    private double proPrice;

    public Long getSkuId() {
        return skuId;
    }

    public void setSkuId(Long skuId) {
        this.skuId = skuId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getJdPrice() {
        return jdPrice;
    }

    public void setJdPrice(double jdPrice) {
        this.jdPrice = jdPrice;
    }

    public double getProPrice() {
        return proPrice;
    }

    public void setProPrice(double proPrice) {
        this.proPrice = proPrice;
    }

    @Override
    public String toString() {
        return "Sku{" +
                "skuId=" + skuId +
                ", name='" + name + '\'' +
                ", jdPrice=" + jdPrice +
                ", proPrice=" + proPrice +
                '}';
    }
}
