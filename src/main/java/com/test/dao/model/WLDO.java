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
    @TableId(type = IdType.AUTO,value = "WLID")
    private Integer WLID;
    @TableField("WLDH")
    private String WLDH;
    @TableField("WLMC")
    private String WLMC;
    @TableField("WLGG")
    private String WLGG;
    @TableField("WLDW")
    private String WLDW;
    @TableField("TPLJ")
    private String TPLJ;
    @TableField("DM_SHZT")
    private Integer DM_SHZT;
}