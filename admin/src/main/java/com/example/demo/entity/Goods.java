package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class Goods {

    @TableId
    private Integer Id;

    private String goodsName;

    private BigDecimal goodsPrice;

    private Integer goodsNumber;

    private Double goodsWeight;

    private String goodsIntroduce;

    private String goodsLogo;

    private Date addTime;

    private Date upd_time;

}
