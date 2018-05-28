package edu.uw.tcss562.navid.openwhisk;

public class ActionCallerResult {

	private String callingAnotherActionResult;

	public String getResult() {
		return callingAnotherActionResult;
	}

	public void setResult(String result) {
		this.callingAnotherActionResult = result;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.callingAnotherActionResult == null) ? 0 : this.callingAnotherActionResult.hashCode());
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
		ActionCallerResult other = (ActionCallerResult) obj;
		if (callingAnotherActionResult == null) {
			if (other.callingAnotherActionResult != null)
				return false;
		} else if (!callingAnotherActionResult.equals(other.callingAnotherActionResult))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		
		return this.getResult();
	}

}
