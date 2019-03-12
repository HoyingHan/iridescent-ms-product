package com.iridescent.ms.product.api;


import com.iridescent.ms.product.common.vo.ProductInfoVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Description:
 *
 * @author 陌北有棵树
 * @version 2019/3/11
 */

@FeignClient
public interface ProductInfoApi {

    @RequestMapping(value = "/rest/api/v1/product/add", method = RequestMethod.POST)
    Boolean acceptApplicationForm(@RequestBody ProductInfoVo productInfoVo);
}
