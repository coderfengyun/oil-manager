package org.oil.manager.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class CompositeId implements Serializable {
	private static final long serialVersionUID = -4398386518233729264L;
	private String hostName;
	private String port;

	public String getHostName() {
		return hostName;
	}

	public void setHostName(String hostName) {
		this.hostName = hostName;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	@Override
	public int hashCode() {
		return (this.getHostName() + ":" + this.getPort()).hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof CompositeId)) {
			return false;
		}

		return sameValuesAs((CompositeId) obj);
	}

	private boolean sameValuesAs(CompositeId obj) {
		return this.getHostName().equals(obj.getHostName())
				&& this.getPort().equals(obj.getPort());
	}

	public static CompositeId buildId(String hostsName, String port) {
		CompositeId result = new CompositeId();
		result.setHostName(hostsName);
		result.setPort(port);
		return result;
	}
}
