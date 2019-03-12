package com.iridescent.ms.product.common.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;

import com.alibaba.fastjson.JSON;
import java.util.ArrayList;

import java.util.List;

/**
 * Description:
 *
 * @author 陌北有棵树
 * @version 2019/3/12
 */
@Slf4j
public class BeanConvertUtils {



    public static <FROM, TO> TO deepSafeConvertByFastJson(FROM dto, Class<FROM> fromClass, Class<TO> toClass) {
        try {
            if (dto == null) {
                return null;
            } else {
                String json = JSON.toJSONString(dto);
                return JSON.parseObject(json, toClass);
            }
        } catch (Exception var4) {
            log.error(var4.getMessage(), var4);
            throw new RuntimeException(var4.getMessage(), var4);
        }
    }



    public static <FROM, TO> List<TO> deepSafeConvertByFastJson(List<FROM> dtos, Class<FROM> fromClass, Class<TO> toClass) {
        try {
            if (CollectionUtils.isEmpty(dtos)) {
                return new ArrayList(0);
            } else {
                String json = JSON.toJSONString(dtos);
                return JSON.parseArray(json, toClass);
            }
        } catch (Exception var4) {
            throw new RuntimeException("can not convert", var4);
        }
    }



}
