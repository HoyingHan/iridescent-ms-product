package com.iridescent.ms.product.service.service.impl;

import com.google.common.collect.Lists;
import com.iridescent.ms.product.api.ProductInfoApi;
import com.iridescent.ms.product.common.constants.ProductInfoConstants;
import com.iridescent.ms.product.common.utils.BeanConvertUtils;
import com.iridescent.ms.product.common.vo.ProductInfoVo;
import com.iridescent.ms.product.service.dao.ProductInfoDao;
import com.iridescent.ms.product.service.domain.ProductInfo;
import com.iridescent.ms.product.service.service.ProductInfoService;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Description:
 *
 * @author 陌北有棵树
 * @version 2019/3/11
 */
@Service("ProductInfoService")
public class ProductInfoServiceImpl implements ProductInfoService, ProductInfoApi {

    @Resource
    private ProductInfoDao productInfoDao;

    @Override
    public ProductInfoVo addProductInfo(ProductInfoVo productInfoVo) {
        ProductInfo info = productInfoDao.save(BeanConvertUtils.deepSafeConvertByFastJson(productInfoVo, ProductInfoVo.class, ProductInfo.class));
        return BeanConvertUtils.deepSafeConvertByFastJson(info, ProductInfo.class, ProductInfoVo.class);
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
}
