package com.bing.swagger.annotation;

import com.bing.swagger.config.SwaggerAutoConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import({ SwaggerAutoConfiguration.class })
public @interface EnableCustomSwagger2
{

}
