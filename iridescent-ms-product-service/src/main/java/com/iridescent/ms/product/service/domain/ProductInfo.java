package com.iridescent.ms.product.service.domain;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * Description: 商品信息
 *
 * @author 陌北有棵树
 * @version 2019/3/11
 */
@Entity
@Data
@DynamicUpdate
public class ProductInfo {


    @Id
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
