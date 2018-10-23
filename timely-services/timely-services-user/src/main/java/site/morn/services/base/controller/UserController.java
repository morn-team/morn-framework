package site.morn.services.base.controller;

import java.util.HashMap;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import site.morn.boot.rest.RestPage;
import site.morn.rest.RestMessage;
import site.morn.rest.Rests;
import site.morn.services.base.domain.User;
import site.morn.services.base.service.UserService;

/**
 * 用户控制器
 *
 * @author timely-rain
 * @version 1.0.0, 2017/9/28
 * @since 1.0-SNAPSHOT
 */
@RestController
@RequestMapping("/user")
public class UserController extends BaseController<UserService> {

  public UserController(UserService service) {
    super(service);
  }

  @PostMapping
  public Object add(@Validated User user) {
//        if (result.hasErrors()) {
//            List<FieldError> fieldErrors = result.getFieldErrors();
//            List<String> messages = new ArrayList<>();
//            for (FieldError fieldError : fieldErrors) {
//                String message = messageSource.getMessage(fieldError, messageHolder.currentLocale());
//                String fieldPath = fieldError.getObjectName() + "." + fieldError.getField();
//                String fieldName = messageSource.getMessage(fieldPath, null, fieldPath, messageHolder.currentLocale());
//                messages.add(fieldName + message);
//            }
//            String s = StringUtils.collectionToCommaDelimitedString(messages);
//            return Rests.error().message(s);
//        }
    return new HashMap<>();
  }

  @PostMapping("datatable")
  public RestMessage datatable(RestPage<User> restPage) {
    Page<User> page = getService().search(restPage);
    return Rests.ok(page);
  }
}
