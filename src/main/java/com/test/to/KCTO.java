package com.test.to;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class KCTO {
    /**
     * 物料ID
     */
    private Integer WLID;
    /**
     * 数量
     */
    private Integer SL;
    /**
     * 坯号
     */
    private String PH;
    /**
     * 单价
     */
    private String DJ;
    /**
     * 操作类型
     * 201 入
     * 202 出
     */
    private Integer DM_CZLX;
    /**
     * 编制人
     */
    private String BZR;

    public BigDecimal getDJ() {
        return new BigDecimal(DJ);
    }
}