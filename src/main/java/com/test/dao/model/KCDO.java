package com.test.dao.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;

@Data
@TableName("CKGL_KCXX")
public class KCDO {
    @TableId(type = IdType.AUTO)
    private Integer KCID;
    private Integer WLID;
    private String PH;
    private Integer SL;
    private BigDecimal JE;
}