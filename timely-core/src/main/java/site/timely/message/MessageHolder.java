package site.timely.message;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Locale;
import java.util.Objects;

/**
 * 国际化信息
 *
 * @author timely-rain
 * @verion 1.0.0, 2017/9/16
 * @since 1.0-SNAPSHOT
 */
@Component
public class MessageHolder {
    @Resource
    private MessageSource source;

    private Locale locale;

    /**
     * 当前语言环境
     * 切换语言环境参考timely-config
     *
     * @return 语言环境
     */
    public Locale currentLocale() {
        if (Objects.isNull(locale))
            locale = new Locale(LocaleContextHolder.getLocale().getLanguage());
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    /**
     * 获取国际化信息
     *
     * @param code 国际化编码
     * @return 国际化信息
     */
    public String getMessage(String code) {
        return source.getMessage(code, null, code, currentLocale());
    }


    /**
     * 获取国际化信息
     *
     * @param code 国际化编码
     * @param args 参数
     * @return 国际化信息
     */
    public String getMessage(String code, String... args) {
        return source.getMessage(code, args, code, currentLocale());
    }
}
