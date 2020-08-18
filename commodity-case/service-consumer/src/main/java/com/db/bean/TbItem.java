package com.db.bean;


import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * DESC:
 *
 * @author DB
 * @create 2020-08-14 10:12
 */
@Data
public class TbItem implements Serializable {
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;//商品id，同时也是商品编号
    private String title;//商品标题
    private String SellPoint;//商品卖点
    private Double price;//商品价格，单位为：分
    private Integer num;//库存数量
    private String barcode;//商品条形码
    private String image;//商品图片
    private Long cid;//所属类目，叶子类目
    private Integer status;//商品状态，1-正常，2-下架，3-删除
    private Date created;//创建时间
    private Date updated;//更新时间
}
