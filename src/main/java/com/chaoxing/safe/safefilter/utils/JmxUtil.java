package com.chaoxing.safe.safefilter.utils;

import java.lang.management.ManagementFactory;
import java.util.concurrent.TimeUnit;

import javax.management.MBeanServer;
import javax.management.ObjectName;

import com.chaoxing.safe.safefilter.IPFrequencyFilter;

public class JmxUtil{
	
	public static void registMBean(Object obj,String beanname) {
		MBeanServer server = ManagementFactory.getPlatformMBeanServer();
		try {
			ObjectName name = new ObjectName("Chaoxing_SafeFilter:name=" + beanname);
			server.registerMBean(obj, name);
		} catch (Exception e) {
			System.err.println(e);
		}
	}
	
	public static void main(String[] args) throws Exception{
		MBeanServer server = ManagementFactory.getPlatformMBeanServer();
		ObjectName name = new ObjectName(":dd=xxx,dd1=dd1,type=tpe,name=name1");
		Object obj = new IPFrequencyFilter();
		server.registerMBean(obj, name);
		TimeUnit.MINUTES.sleep(1);
	}
}
