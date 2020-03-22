package com.zyd.blog.controller.third_party_service.juhe.stock.vo;

import lombok.Data;

import java.util.List;

@Data
public class StockResult {
    private String totalCount;
    private String page;
    private String num;
    private List<StockData> data;


}
