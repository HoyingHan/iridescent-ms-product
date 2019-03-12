package com.iridescent.ms.product.common.constants;

/**
 * Description:
 *
 * @author hanhongying@corp.netease.com
 * @version 2019/3/13
 */
public class ProductInfoConstants {

    public enum ProductStatusEnmu {
        ALL(1),

        NOT_SOLD(2)
        ;

        private Integer value;

        ProductStatusEnmu(Integer value) {
            this.value = value;
        }

        public Integer getValue() {
            return value;
        }
    }


}
