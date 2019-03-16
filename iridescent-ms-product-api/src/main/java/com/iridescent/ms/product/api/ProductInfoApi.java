package com.iridescent.ms.product.api;


import com.iridescent.ms.product.api.fallback.ProductInfoApiFallbackFactory;
import com.iridescent.ms.product.common.vo.ProductInfoVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Description: 商品信息API
 *
 * @author 陌北有棵树
 * @version 2019/3/11
 */

@FeignClient(value = "product",fallbackFactory = ProductInfoApiFallbackFactory.class)
public interface ProductInfoApi {

    @PostMapping(value = "/rest/api/v1/product/add")
    Boolean addProductInfo(@RequestBody ProductInfoVo productInfoVo);


    @GetMapping(value = "/rest/api/v1/product/list")
    List<ProductInfoVo> getProductInfoList(@RequestParam(value = "roleId", required = false) Integer roleId,
                            @RequestParam(value = "productStatus", required = false) Integer productStatus);


    @GetMapping(value = "/rest/api/v1/product/getListByIds")
    List<ProductInfoVo> getProductListByIds(@RequestParam(value = "productIds", required = false) List<String> productIds);


    @DeleteMapping(value = "/rest/api/v1/product")
    String deleteProductInfo(@RequestParam(value = "productId", required = false) String productId);

}
