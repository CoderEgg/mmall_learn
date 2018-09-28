package com.mmall.vo;

import java.math.BigDecimal;
import java.util.List;

public class CartVo {
    List<CartProductVo> cartProductVoList;
    private BigDecimal cartTotlePrice;
    private boolean allChecked; //是否已经都勾选

    private String imageHost;

    public String getImageHost() {
        return imageHost;
    }

    public void setImageHost(String imageHost) {
        this.imageHost = imageHost;
    }

    public List<CartProductVo> getCartProductVoList() {
        return cartProductVoList;
    }

    public void setCartProductVoList(List<CartProductVo> cartProductVoList) {
        this.cartProductVoList = cartProductVoList;
    }

    public BigDecimal getCartTotlePrice() {
        return cartTotlePrice;
    }

    public void setCartTotlePrice(BigDecimal cartTotlePrice) {
        this.cartTotlePrice = cartTotlePrice;
    }

    public boolean isAllChecked() {
        return allChecked;
    }

    public void setAllChecked(boolean allChecked) {
        this.allChecked = allChecked;
    }
}
