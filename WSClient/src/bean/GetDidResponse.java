package bean;

import java.util.List;

public class GetDidResponse  {
	
	private Result result;
	private List<DID> DIDs;//	array	手機門號配對之DID


	public Result getResult() {
		return result;
	}

	public void setResult(Result result) {
		this.result = result;
	}

	public List<DID> getDIDs() {
		return DIDs;
	}

	public void setDIDs(List<DID> dIDs) {
		DIDs = dIDs;
	}


}
