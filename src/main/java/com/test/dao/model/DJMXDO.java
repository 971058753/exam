package com.test.dao.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;

@Data
@TableName("CJGK_DJMX")
public class DJMXDO {
    @TableId(type = IdType.AUTO)
    private Integer MXID;
    private Integer DJID;
    private Integer KCID;
    private Integer WLID;
    private String PH;
    private Integer SL;
    private BigDecimal DJ;
    private BigDecimal JE;
    private String BZ;
}