package com.zyd.blog.controller.third_party_service.juhe.stock.service;


import com.zyd.blog.controller.third_party_service.juhe.stock.vo.StockResult;

public interface StockService {
    StockResult getStockListByType(Integer page, String type);
}
