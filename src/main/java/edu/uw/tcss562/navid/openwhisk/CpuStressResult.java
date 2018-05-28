package edu.uw.tcss562.navid.openwhisk;

import com.google.gson.annotations.JsonAdapter;

public class CpuStressResult {

	
	private Integer inputNumber;
	private Long cpuProcessingStartTime;
	private Long cpuProcessingIntervalTime;
	private Long cpuProcessingStopTime;

	public Integer getInputNumber() {
		return inputNumber;
	}

	public void setInputNumber(Integer inputNumber) {
		this.inputNumber = inputNumber;
	}

	public Long getCpuProcessingStartTime() {
		return cpuProcessingStartTime;
	}

	public void setCpuProcessingStartTime(Long cpuProcessingStartTime) {
		this.cpuProcessingStartTime = cpuProcessingStartTime;
	}

	public Long getCpuProcessingIntervalTime() {
		return cpuProcessingIntervalTime;
	}

	public void setCpuProcessingIntervalTime(Long cpuProcessingIntervalTime) {
		this.cpuProcessingIntervalTime = cpuProcessingIntervalTime;
	}

	public Long getCpuProcessingStopTime() {
		return cpuProcessingStopTime;
	}

	public void setCpuProcessingStopTime(Long cpuProcessingStopTime) {
		this.cpuProcessingStopTime = cpuProcessingStopTime;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpuProcessingIntervalTime == null) ? 0 : cpuProcessingIntervalTime.hashCode());
		result = prime * result + ((cpuProcessingStartTime == null) ? 0 : cpuProcessingStartTime.hashCode());
		result = prime * result + ((cpuProcessingStopTime == null) ? 0 : cpuProcessingStopTime.hashCode());
		result = prime * result + ((inputNumber == null) ? 0 : inputNumber.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CpuStressResult other = (CpuStressResult) obj;
		if (cpuProcessingIntervalTime == null) {
			if (other.cpuProcessingIntervalTime != null)
				return false;
		} else if (!cpuProcessingIntervalTime.equals(other.cpuProcessingIntervalTime))
			return false;
		if (cpuProcessingStartTime == null) {
			if (other.cpuProcessingStartTime != null)
				return false;
		} else if (!cpuProcessingStartTime.equals(other.cpuProcessingStartTime))
			return false;
		if (cpuProcessingStopTime == null) {
			if (other.cpuProcessingStopTime != null)
				return false;
		} else if (!cpuProcessingStopTime.equals(other.cpuProcessingStopTime))
			return false;
		if (inputNumber == null) {
			if (other.inputNumber != null)
				return false;
		} else if (!inputNumber.equals(other.inputNumber))
			return false;
		return true;
	}

}
