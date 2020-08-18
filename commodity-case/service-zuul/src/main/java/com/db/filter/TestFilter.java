package com.db.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * DESC:
 *
 * @author DB
 * @create 2020-08-15 11:25
 */

@Component
public class TestFilter extends ZuulFilter {

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 10;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        //获取地址
        RequestContext context = RequestContext.getCurrentContext();
        //获取对象
        HttpServletRequest request = context.getRequest();
        //获取参数
        String token = request.getParameter("token");
        if (StringUtils.isBlank(token)) {
            //拦截 发送zuul响应
            context.setSendZuulResponse(false);
            //设置状态码
            context.setResponseStatusCode(HttpStatus.SC_UNAUTHORIZED);
            //设置提示
            context.setResponseBody("request error");
        }
        return null;
    }
}
