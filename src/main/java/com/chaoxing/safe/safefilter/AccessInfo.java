package com.chaoxing.safe.safefilter;

import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;


public class AccessInfo implements Comparable<AccessInfo>{
	private String ip;
	private long lastAccessTime;
	private AtomicLong accessTotal;
	private long firstAccessTime;
	private Date lastAccessDateTime;
	private Date firstAccessDateTime;
	
	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public AccessInfo(String ip,long lastAccessTime){
		this.lastAccessTime = lastAccessTime;
		this.firstAccessTime = lastAccessTime;
		this.ip = ip;
		accessTotal = new AtomicLong(0);
		this.firstAccessDateTime = new Date(firstAccessTime);
	}

	public long getLastAccessTime() {
		return lastAccessTime;
	}

	public void setLastAccessTime(long lastAccessTime) {
		this.lastAccessTime = lastAccessTime;
		this.lastAccessDateTime = new Date(lastAccessTime);
	}

	public long getAccessTotal() {
		return accessTotal.get();
	}
	
	public void addAccess(long count) {
		accessTotal.getAndAdd(count);
	}

	
	public long getFirstAccessTime() {
		return firstAccessTime;
	}

	public void setFirstAccessTime(long firstAccessTime) {
		this.firstAccessTime = firstAccessTime;
		this.firstAccessDateTime = new Date(firstAccessTime);
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
	
	public Date getLastAccessDateTime() {
		return lastAccessDateTime;
	}

	public Date getFirstAccessDateTime() {
		return firstAccessDateTime;
	}

	public static void main(String[] args) {
		AccessInfo info = new AccessInfo("1", 1L);
		info.addAccess(1);
		info.addAccess(1);
		System.out.println(info.getAccessTotal());
	}
}
