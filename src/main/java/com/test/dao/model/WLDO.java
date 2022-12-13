package com.test.dao.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;

@Data
@TableName("BAS_WLJCXXSZ")
public class WLDO {
    @TableId(type = IdType.AUTO)
    private Integer WLID;
    private String WLDH;
    private String WLMC;
    private String WLGG;
    private String WLDW;
    private String TPLJ;
    @TableField("DM_SHZT")
    private Integer DM_SHZT;
}