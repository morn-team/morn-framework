package site.timely.message;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Locale;

/**
 * site.timely.message
 *
 * @author timely-rain
 * @version 1.0.0, 2017/9/17
 * @since 1.0-SNAPSHOT
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MessageHolderTest {

    @Resource
    private MessageHolder messageHolder;

    @Test
    public void test() throws Exception {
        Assert.assertEquals(messageHolder.currentLocale(), Locale.CHINESE);
        Assert.assertEquals(messageHolder.getMessage("common.op.success"), "操作成功");
        messageHolder.setLocale(Locale.ENGLISH);
        Assert.assertEquals(messageHolder.getMessage("common.op.success"), "Success");
    }

}