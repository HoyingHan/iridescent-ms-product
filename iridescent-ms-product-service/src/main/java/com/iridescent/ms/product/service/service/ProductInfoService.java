package com.iridescent.ms.product.service.service;



import com.iridescent.ms.product.common.vo.ProductInfoVo;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Description:
 *
 * @author  陌北有棵树
 * @version 2019/3/11
 */


public interface ProductInfoService{

    Boolean addProductInfo(@RequestBody ProductInfoVo productInfoVo);

    List<ProductInfoVo> getProductInfoList(@RequestParam(value = "roleId", required = false) Integer roleId,
                                           @RequestParam(value = "productStatus", required = false) Integer productStatus);

    List<ProductInfoVo> getProductListByIds(@RequestParam(value = "productIds", required = false) List<String> productIds);

    String deleteProductInfo(@RequestParam(value = "productId", required = false) String productId);



}
