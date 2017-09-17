package site.timely.message;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * site.timely.message
 *
 * @author timely-rain
 * @verion 1.0.0, 2017/9/16
 * @since 1.8
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MessageConfigurationTest {

    @Resource
    private MessageConfiguration configuration;

    @Test
    public void localeResolver() throws Exception {
        configuration.localeResolver();
    }

    @Test
    public void getResolver() throws Exception {
        String resolver = configuration.getResolver();
        Assert.assertEquals(resolver, Constant.RESOLVER_COOKIE);
    }

    @Test
    public void setResolver() throws Exception {
    }

    @Test
    public void getCookieMaxAge() throws Exception {
        Integer cookieMaxAge = configuration.getCookieMaxAge();
        Assert.assertEquals(cookieMaxAge, Constant.COOKIE_MAX_AGE);
    }

    @Test
    public void setCookieMaxAge() throws Exception {
    }

}