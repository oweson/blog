package com.zyd.blog.controller.third_party_service.juhe.book.entity;


import lombok.Data;

import java.util.List;

@Data
public class SyncBookResult {
    private List<SyncBookEntity> data;
    private Integer totalNum;
    private Integer pn;
    private Integer rn;


}
