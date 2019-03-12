package com.iridescent.ms.product.common.vo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * Description:
 *
 * @author 陌北有棵树
 * @version 2019/3/11
 */
@Data
public class ProductInfoVo {
    /**
     * id
     */
    private String productId;

    /**
     * 名字
     */
    private String productName;

    /**
     * 单价
     */
    private BigDecimal productPrice;

    /**
     * 摘要
     */
    private String productAbstract;

    /**
     * 描述
     */
    private String productDescription;

    /**
     * 图片
     */
    private String productImage;

    /**
     * 已出售数量
     */
    private Integer productSoldQuantity;


}
