package com.zyd.blog.controller.third_party_service.juhe.stock.vo;

import lombok.Data;

@Data
public class StockResponse {
    private String error_code;
    private String reason;
    private StockResult result;


}
