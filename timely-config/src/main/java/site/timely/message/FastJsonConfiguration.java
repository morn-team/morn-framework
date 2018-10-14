package site.timely.message;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import site.timely.config.ApplicationConstant;

/**
 * FastJson配置
 *
 * @author timely-rain
 * @version 1.0.0, 2018/5/9
 * @since 1.0-SNAPSHOT
 */
@Configuration
public class FastJsonConfiguration {

  @Bean
  @ConfigurationProperties(prefix = ApplicationConstant.JSON_PROPERTIES)
  public FastJsonProperties getProperties() {
    return new FastJsonProperties();
  }

  @Bean
  public HttpMessageConverters fastjsonHttpMessageConverter() {
    //定义一个转换消息的对象
    FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();

    //添加fastjson的配置信息 比如 ：是否要格式化返回的json数据
    FastJsonConfig fastJsonConfig = new FastJsonConfig();

    fastJsonConfig
        .setSerializerFeatures(SerializerFeature.PrettyFormat, SerializerFeature.WriteMapNullValue);

    //在转换器中添加配置信息
    fastConverter.setFastJsonConfig(fastJsonConfig);

    return new HttpMessageConverters(fastConverter);

  }

}
