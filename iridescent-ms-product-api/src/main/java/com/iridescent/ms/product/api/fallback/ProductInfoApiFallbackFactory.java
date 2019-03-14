package com.iridescent.ms.product.api.fallback;

import com.iridescent.ms.product.api.ProductInfoApi;
import com.iridescent.ms.product.common.vo.ProductInfoVo;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Description:
 *
 * @author hanhongying@corp.netease.com
 * @version 2019/3/14
 */
@Component
@Slf4j
public class ProductInfoApiFallbackFactory implements FallbackFactory<ProductInfoApi> {

    @Override
    public ProductInfoApi create(Throwable throwable) {
        return new ProductInfoApi() {
            @Override
            public Boolean addProductInfo(ProductInfoVo productInfoVo) {
                log.error("addProductInfo方法异常：异常信息：" + throwable);
                return null;
            }

            @Override
            public List<ProductInfoVo> getProductInfoList(Integer roleId, Integer productStatus) {
                log.error("getProductInfoList方法异常：异常信息：" + throwable);
                return null;
            }

            @Override
            public List<ProductInfoVo> getProductListByIds(List<String> productIds) {
                log.error("getProductListByIds方法异常：异常信息：" + throwable);
                return null;
            }

            @Override
            public String deleteProductInfo(String productId) {
                log.error("deleteProductInfo方法异常：异常信息：" + throwable);
                return null;
            }
        };
    }
}
