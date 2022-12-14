package com.test.dao.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("CKGL_DJZD")
public class DJZDDO {
    @TableId(type = IdType.AUTO)
    private Integer DJID;
    private String DJBH;
    @TableField("DM_CZLX")
    private Integer DM_CZLX;
    private String BZR;
    private Date BZRQ;
    @TableField("DM_YJBZ")
    private Integer DM_YJBZ;
}