package com.db.bean;

import lombok.Data;

import java.util.List;

/**
 * DESC:
 *
 * @author DB
 * @create 2020-08-15 16:27
 */
@Data
public class TbItemVo {
    private Integer current;
    private Integer size;
    private Long total;
    private List<TbItem> tbItems;
}
