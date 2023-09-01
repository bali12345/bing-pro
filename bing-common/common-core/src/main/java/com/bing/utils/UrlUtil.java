package com.bing.utils;


import cn.hutool.core.exceptions.UtilException;
import com.bing.constant.Constants;
import com.bing.exception.SimpleHttpException;
import lombok.experimental.UtilityClass;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;


/**
 * <p>
 * Url 工具类
 * </p>
 *
 * @author yangkai.shen
 * @date Created in 2019/12/24 22:27
 */
@UtilityClass
public class UrlUtil {
	/**
	 * 编码
	 *
	 * @param value str
	 * @return encode str
	 */
	public String urlEncode(String value) {
		if (value == null) {
			return "";
		}
		try {
			String encoded = URLEncoder.encode(value, Constants.DEFAULT_ENCODING.displayName());
			return encoded.replace("+", "%20").replace("*", "%2A").replace("~", "%7E").replace("/", "%2F");
		} catch (UnsupportedEncodingException e) {
			throw new SimpleHttpException("Failed To Encode Uri", e);
		}
	}

	/**
	 * 解码URL<br>
	 * 将%开头的16进制表示的内容解码。
	 *
	 * @param url URL
	 * @return 解码后的URL
	 * @throws UtilException UnsupportedEncodingException
	 */
	public String urlDecode(String url) throws UtilException {
		if (StringUtils.isEmpty(url)) {
			return url;
		}
		try {
			return URLDecoder.decode(url, Constants.DEFAULT_ENCODING.displayName());
		} catch (UnsupportedEncodingException e) {
			throw new SimpleHttpException("Unsupported encoding", e);
		}
	}
}
