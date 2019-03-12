package com.iridescent.ms.product.api;


import com.iridescent.ms.product.common.vo.ProductInfoVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Description: 商品信息API
 *
 * @author 陌北有棵树
 * @version 2019/3/11
 */

@FeignClient
public interface ProductInfoApi {

    @RequestMapping(value = "/rest/api/v1/product/add", method = RequestMethod.POST)
    Boolean addProductInfo(@RequestBody ProductInfoVo productInfoVo);


    @RequestMapping(value = "/rest/api/v1/product/list", method = RequestMethod.GET)
    List<ProductInfoVo> getProductInfoList(@RequestParam(value = "roleId", required = false) Integer roleId,
                            @RequestParam(value = "productStatus", required = false) Integer productStatus);


    @RequestMapping(value = "/rest/api/v1/product", method = RequestMethod.DELETE)
    String deleteProductInfo(@RequestParam(value = "productId", required = false) String productId);

}
