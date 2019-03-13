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
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Description: 商品服务实现
 *
 * @author 陌北有棵树
 * @version 2019/3/11
 */
@Service("ProductInfoService")
public class ProductInfoServiceImpl implements ProductInfoService, ProductInfoApi {

    @Autowired
    private ProductInfoDao productInfoDao;

    @Override
    public Boolean addProductInfo(ProductInfoVo productInfoVo) {
        ProductInfo info = productInfoDao.save(BeanConvertUtils.deepSafeConvertByFastJson(productInfoVo, ProductInfoVo.class, ProductInfo.class));
        return true;
    }


    @Override
    public List<ProductInfoVo> getProductInfoList(Integer roleId, Integer productStatus) {

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
    public List<ProductInfoVo> getProductListByIds(List<String> productIds) {

        List<ProductInfo> productInfoList = productInfoDao.findAllById(productIds);
        if (CollectionUtils.isEmpty(productInfoList)) {
            return Lists.newArrayList();
        }
        return BeanConvertUtils.deepSafeConvertByFastJson(productInfoList,ProductInfo.class,ProductInfoVo.class);
    }


    @Override
    public String deleteProductInfo(String productId) {
        productInfoDao.deleteById(productId);
        return productId;
    }
}
