package com.chaoxing.safe.safefilter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import com.chaoxing.safe.safefilter.limiter.TokenBucket;
import com.chaoxing.safe.safefilter.utils.JmxUtil;
import com.chaoxing.safe.safefilter.utils.StringUtil;

//@WebFilter(urlPatterns="*.htm")
public class GlobalFrequencyFilter implements Filter,GlobalFrequencyFilterMBean {


	TokenBucket bucket;
	
	int maxCapacity;
	int avgRate;
	int intervalInSec;
	String contextName = "";
	
	public void init(FilterConfig conf) throws ServletException {
//		System.out.println("*************************Init Filter*****************");
		String maxCapacityStr = conf.getInitParameter("maxCapacity");
		String avgRateStr = conf.getInitParameter("avgRate");
		String intervalStr = conf.getInitParameter("intervalInSec");
		maxCapacity = StringUtil.parseInt(maxCapacityStr, 10000);
		avgRate = StringUtil.parseInt(avgRateStr, 100);
		intervalInSec = StringUtil.parseInt(intervalStr, 1);
		bucket = new TokenBucket(maxCapacity, avgRate, intervalInSec);
	}
	
	
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		if (contextName == "") {
			contextName = req.getServletContext().getServletContextName();
			JmxUtil.registMBean(this, "GlobalFrequencyFilter-" + contextName);
		}
		boolean allowed = bucket.getTokens(1);
		if(allowed) {
			chain.doFilter(req, resp);
		}else {
			resp.getWriter().write("访问过于频繁，请稍后重试");
			return;
		}
	}


	public int getMaxCapacity() {
		return maxCapacity;
	}


	public int getAvgRatePerIp() {
		return avgRate;
	}


	public int getInterval() {
		return intervalInSec;
	}

}
