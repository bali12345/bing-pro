package com.bing.exception;


import com.bing.utils.StringUtils;

/**
 * 工具类异常
 *
 * @author ruoyi
 */
public class UtilException extends RuntimeException
{
    private static final long serialVersionUID = 8247610319171014183L;

    public UtilException(Throwable e)
    {
        super(e.getMessage(), e);
    }
    public UtilException(String messageTemplate, Object... params) {
        super(StringUtils.format(messageTemplate, params));
    }


    public UtilException(String message)
    {
        super(message);
    }

    public UtilException(String message, Throwable throwable)
    {
        super(message, throwable);
    }
    public UtilException(Throwable throwable, String messageTemplate, Object... params) {
        super(StringUtils.format(messageTemplate, params), throwable);
    }
}
