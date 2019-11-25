package com.chaoxing.safe.safefilter;

import java.util.List;
import java.util.Set;


public interface IPFrequencyFilterMBean {
	public int getMaxCapacityPerIp();

	public int getAvgRatePerIp();

	public int getInterval();
	
	public Set<String> getDeniedIps();
	
	public Set<String> getUnlimitIps();
	
	public long getOnlineIpCount();
	
	public Set<String> getExcludeUrls();
	
//	public List<AccessInfo> getTopAccessInfo();
	
	public void enableFilter(boolean enabled);
	
	public boolean getEnabled();
	
}
