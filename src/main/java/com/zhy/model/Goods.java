package com.zhy.model;

import lombok.Data;

import java.util.Date;

@Data
public class Goods {
    private static final long serialVersionUID = 1L;
    /**
     * 商品id
     */
    private int id;
    /**
     * 商品所属的商家id
     */
    private long userId;
    /**
     * 商品名称
     */
    private String goodsName;
    /**
     * 商品描述
     */
    private String goodsDes;
    /**
     * 商品规格
     */
    private String goodsUnit;
    /**
     * 商品图片
     */
    private String goodsPic;
    /**
     * 商品价格
     */
    private String goodsPrice;
    /**
     * 商品创建时间
     */
    private String goodsCreateTime;
    /**
     * 商品开售时间
     */
    private Date goodsStartTime;
    /**
     * 商品售卖结束时间
     */
    private Date goodsEndTime;
    /**
     * 更新时间
     */
    private String updateTime;
    /**
     * 商品状态
     */
    private int status;

}
