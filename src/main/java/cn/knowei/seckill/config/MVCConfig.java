package cn.knowei.seckill.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * @author knowei
 * @date 2022/12/11 13:58
 */
@Configuration
public class MVCConfig implements WebMvcConfigurer {

	@Autowired
	private UserArgumentResolvers userArgumentResolvers;
	@Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
		resolvers.add(userArgumentResolvers);
	}
}
