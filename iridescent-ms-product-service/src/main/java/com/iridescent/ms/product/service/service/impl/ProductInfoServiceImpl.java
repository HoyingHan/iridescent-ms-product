package com.iridescent.ms.product.service.service.impl;

import com.google.common.collect.Lists;
import com.iridescent.ms.product.api.ProductInfoApi;
import com.iridescent.ms.product.common.constants.ProductInfoConstants;
import com.iridescent.ms.product.common.utils.BeanConvertUtils;
import com.iridescent.ms.product.common.vo.ProductInfoVo;
import com.iridescent.ms.product.service.dao.ProductInfoDao;
import com.iridescent.ms.product.service.domain.ProductInfo;
import com.iridescent.ms.product.service.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Description: 商品服务实现
 *
 * @author 陌北有棵树
 * @version 2019/3/11
 */
@RestController
public class ProductInfoServiceImpl implements ProductInfoService, ProductInfoApi {

    @Resource
    private ProductInfoDao productInfoDao;

    @Override
    @PostMapping(value = "/rest/api/v1/product/add")
    public Boolean addProductInfo(@RequestBody ProductInfoVo productInfoVo) {
        productInfoDao.save(BeanConvertUtils.deepSafeConvertByFastJson(productInfoVo, ProductInfoVo.class, ProductInfo.class));
        return true;
    }


    @Override
    @GetMapping(value = "/rest/api/v1/product/list")
    public List<ProductInfoVo> getProductInfoList(@RequestParam(value = "roleId", required = false) Integer roleId,
                                           @RequestParam(value = "productStatus", required = false) Integer productStatus) {

        List<ProductInfo> productInfoList = productInfoDao.findAll();
        if (CollectionUtils.isEmpty(productInfoList)) {
            return Lists.newArrayList();
        }
        if (ProductInfoConstants.ProductStatusEnmu.NOT_SOLD.getValue().equals(productStatus)) {
            productInfoList =  productInfoList.stream().filter(info -> info.getProductSoldQuantity() > 0).collect(Collectors.toList());
        }

        return BeanConvertUtils.deepSafeConvertByFastJson(productInfoList, ProductInfo.class, ProductInfoVo.class);

    }


    @Override
    @GetMapping(value = "/rest/api/v1/product/getListByIds")
    public List<ProductInfoVo> getProductListByIds(@RequestParam(value = "productIds", required = false) List<String> productIds) {

        List<ProductInfo> productInfoList = productInfoDao.findAllById(productIds);
        if (CollectionUtils.isEmpty(productInfoList)) {
            return Lists.newArrayList();
        }
        return BeanConvertUtils.deepSafeConvertByFastJson(productInfoList,ProductInfo.class,ProductInfoVo.class);
    }


    @Override
    @DeleteMapping(value = "/rest/api/v1/product")
    public String deleteProductInfo(@RequestParam(value = "productId", required = false) String productId) {
        productInfoDao.deleteById(productId);
        return productId;
    }
}
