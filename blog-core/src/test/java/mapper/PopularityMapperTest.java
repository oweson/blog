package mapper;

import com.zyd.blog.persistence.mapper.BizArticleMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * the class is create by @Author:oweson
 *
 * @Date：2020/1/7 21:15
 */
public class PopularityMapperTest extends SpringbootMapperTest{
    @Autowired
    private BizArticleMapper bizArticleMapper;
    @Test
    public void tastMapperTest(){
        System.out.println(bizArticleMapper.getArticleIds());
    }
}
