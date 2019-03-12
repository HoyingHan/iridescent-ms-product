package com.iridescent.ms.product.service.service.impl;

import com.iridescent.ms.product.common.dto.ProductInfoDto;
import com.iridescent.ms.product.common.utils.BeanConvertUtils;
import com.iridescent.ms.product.service.dao.ProductInfoDao;
import com.iridescent.ms.product.service.domain.ProductInfo;
import com.iridescent.ms.product.service.service.ProductInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Description:
 *
 * @author 陌北有棵树
 * @version 2019/3/11
 */
@Service("ProductInfoService")
public class ProductInfoServiceImpl implements ProductInfoService {

    @Resource
    private ProductInfoDao productInfoDao;

    @Override
    public ProductInfoDto save(ProductInfo productInfo) {
        ProductInfo info = productInfoDao.save(productInfo);
        return BeanConvertUtils.deepSafeConvertByFastJson(info, ProductInfo.class, ProductInfoDto.class);
    }
}
