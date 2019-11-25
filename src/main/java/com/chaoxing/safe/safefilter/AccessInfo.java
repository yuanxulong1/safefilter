package com.chaoxing.safe.safefilter;

import java.util.concurrent.atomic.AtomicLong;


public class AccessInfo implements Comparable<AccessInfo>{
	private String ip;
	private long lastAccessTime;
	private AtomicLong accessTotal;
	
	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public AccessInfo(String ip,long lastAccessTime){
		this.lastAccessTime = lastAccessTime;
		this.ip = ip;
		accessTotal = new AtomicLong(0);
	}

	public long getLastAccessTime() {
		return lastAccessTime;
	}

	public void setLastAccessTime(long lastAccessTime) {
		this.lastAccessTime = lastAccessTime;
	}

	public long getAccessTotal() {
		return accessTotal.get();
	}
	
	public void addAccess(long count) {
		accessTotal.getAndAdd(count);
	}

	public int compareTo(AccessInfo o) {
		if(o == null){
			return -1;
		}
		AccessInfo other = (AccessInfo)o;
		if(other.getAccessTotal() > this.accessTotal.get()) {
			return 1;
		}else if(other.getAccessTotal() > this.accessTotal.get()) {
			return 0;
		}else {
			return -1;
		}
	}
}
