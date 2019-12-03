package com.chaoxing.safe.safefilter.utils;

import java.lang.management.ManagementFactory;

import javax.management.MBeanServer;
import javax.management.ObjectName;

public class JmxUtil {
	
	public static void registMBean(Object obj,String beanname) {
		MBeanServer server = ManagementFactory.getPlatformMBeanServer();
		try {
			ObjectName name = new ObjectName("Chaoxing_SafeFilter:name=" + beanname);
			server.registerMBean(obj, name);
		} catch (Exception e) {
			System.err.println(e);
		}
	}
}
