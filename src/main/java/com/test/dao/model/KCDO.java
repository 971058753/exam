package com.test.dao.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;

@Data
@TableName("CKGL_KCXX")
public class KCDO {
    @TableId(type = IdType.AUTO,value = "KCID")
    private Integer KCID;
    @TableField("WLID")
    private Integer WLID;
    @TableField("PH")
    private String PH;
    @TableField("SL")
    private Integer SL;
    @TableField("JE")
    private BigDecimal JE;
}