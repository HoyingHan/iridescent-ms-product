package com.iridescent.iridescent.ms.product.service.dao;

import com.iridescent.iridescent.ms.product.service.domain.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductInfoDao extends JpaRepository<ProductInfo, String> {

}
