package com.zyd.blog.controller.third_party_service.juhe.stock.vo;

import lombok.Data;

@Data
public class StockData {
    private String symbol;//股票编码
    private String name;//股票名称
    private String engname;
    private String tradetype;
    private String lasttrade;
    private String prevclose;
    private String high_52week;
    private String low_52week;
    private String eps;
    private String dividend;
    private String stocks_sum;
    private Integer currentvolume;//成交量


    private String trade;//成交价
    private String pricechange;//涨跌额
    private String changepercent;//涨跌幅
    private String buy;//
    private String sell;//
    private String settlement;//昨收
    private String open;//今开
    private String high;//最高
    private String low;//最低
    private Integer volume;//成交量
    private Integer amount;//成交额
    private String code;//股票代码
    private String ticktime;//


    private String cname;
    private String category;
    private String price;
    private String diff;
    private String chg;
    private String preclose;
    private String amplitude;
    private String mktcap;
    private String market;


}
