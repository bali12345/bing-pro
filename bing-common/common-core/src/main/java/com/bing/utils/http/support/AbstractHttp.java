package com.bing.utils.http.support;

import com.bing.utils.http.HttpConfig;

/**
 * <p>
 * HTTP 抽象类
 * </p>
 *
 * @author yangkai.shen
 * @date Created in 2020-04-29 14:45
 */
public abstract class AbstractHttp implements Http {
	protected HttpConfig httpConfig;

	public AbstractHttp(HttpConfig httpConfig) {
		this.httpConfig = httpConfig;
	}

	public void setHttpConfig(HttpConfig httpConfig) {
		this.httpConfig = httpConfig;
	}
}
