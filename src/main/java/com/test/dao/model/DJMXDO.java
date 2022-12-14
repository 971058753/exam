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
    @TableId(type = IdType.AUTO,value = "MXID")
    private Integer MXID;
    @TableField("DJID")
    private Integer DJID;
    @TableField("KCID")
    private Integer KCID;
    @TableField("WLID")
    private Integer WLID;
    @TableField("PH")
    private String PH;
    @TableField("SL")
    private Integer SL;
    @TableField("DJ")
    private BigDecimal DJ;
    @TableField("JE")
    private BigDecimal JE;
    @TableField("BZ")
    private String BZ;
}