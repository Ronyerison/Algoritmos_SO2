/**
 * 
 */
package br.ufpi.rony.model;

/**
 * @author Ronyerison
 *
 */
public class Process {
	private Integer finishTime;
	private Integer durationTime;
	private Integer returnTime;
	private Integer responseTime;
	private Integer standbyTime;
	private Integer executedTime;
	
	/**
	 * @param finishTime
	 * @param durationTime
	 */
	public Process(Integer finishTime, Integer durationTime) {
		this.finishTime = finishTime;
		this.durationTime = durationTime;
		this.executedTime = 0;
	}

	/**
	 * @return the finishTime
	 */
	public Integer getFinishTime() {
		return finishTime;
	}

	/**
	 * @param finishTime the finishTime to set
	 */
	public void setFinishTime(Integer finishTime) {
		this.finishTime = finishTime;
	}

	/**
	 * @return the durationTime
	 */
	public Integer getDurationTime() {
		return durationTime;
	}

	/**
	 * @param durationTime the durationTime to set
	 */
	public void setDurationTime(Integer durationTime) {
		this.durationTime = durationTime;
	}

	/**
	 * @return the returnTime
	 */
	public Integer getReturnTime() {
		return returnTime;
	}

	/**
	 * @param returnTime the returnTime to set
	 */
	public void setReturnTime(Integer returnTime) {
		this.returnTime = returnTime;
	}

	/**
	 * @return the responseTime
	 */
	public Integer getResponseTime() {
		return responseTime;
	}

	/**
	 * @param responseTime the responseTime to set
	 */
	public void setResponseTime(Integer responseTime) {
		this.responseTime = responseTime;
	}

	/**
	 * @return the standbyTime
	 */
	public Integer getStandbyTime() {
		return standbyTime;
	}

	/**
	 * @param standbyTime the standbyTime to set
	 */
	public void setStandbyTime(Integer standbyTime) {
		this.standbyTime = standbyTime;
	}
	
	/**
	 * @return the executedTime
	 */
	public Integer getExecutedTime() {
		return executedTime;
	}

	/**
	 * @param executedTime the executedTime to set
	 */
	public void setExecutedTime(Integer executedTime) {
		this.executedTime = executedTime;
	}
	
	public boolean isExecuted(){
		if(this.executedTime == this.durationTime){
			return true;
		}
		return false;
	}
	

	public Process clone(){
		Process clone = new Process(this.finishTime, this.durationTime);
		clone.setResponseTime(this.responseTime);
		clone.setReturnTime(this.returnTime);
		clone.setStandbyTime(this.standbyTime);
		clone.setExecutedTime(this.executedTime);
		
		return clone;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Process\nfinishTime=" + finishTime + "\ndurationTime="
				+ durationTime + "\nreturnTime=" + returnTime
				+ "\nresponseTime=" + responseTime + "\nstandbyTime="
				+ standbyTime + "\nTimeExecuted=" + executedTime;
	}
	
	
	
}
