1 http://localhost:1949/honor/popularity?articleId=16&number=101
#### 人气生成器,输入文章id和需要的数量；
2 修改时间（2017-2019建议手动解决！！！），批量修改浏览的数量，随机的大批量的！

## 还没有访客的文章！！！

SELECT a.id from biz_article a where 
 a.id not in(select b.article_id from biz_article_look b where b.article_id  );
 ## 访客的文章的数量少于60的；
 select article_id,count(*)  from biz_article_look where 1=1   GROUP BY article_id 
