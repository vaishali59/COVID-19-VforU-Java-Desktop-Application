package application;

public class RequestDescriptionData {
	
	private String reqId;
	private String requesterEmail;
	private String reqTitle;
	private String reqDescription;
	
	public String getReqId() {
		return reqId;
	}

	public String getRequesterEmail() {
		return requesterEmail;
	}

	public String getReqTitle() {
		return reqTitle;
	}

	public String getReqDescription() {
		return reqDescription;
	}
	
	private RequestDescriptionData(RequestDescriptionBuilder requestDescriptionBuilder) {
		this.reqId = requestDescriptionBuilder.reqId;
		this.requesterEmail = requestDescriptionBuilder.requesterEmail;
		this.reqTitle = requestDescriptionBuilder.reqTitle;
		this.reqDescription = requestDescriptionBuilder.reqDescription;
	}
	
	public String toString() {
		StringBuilder builder = new StringBuilder();
        builder.append("\n" + this.requesterEmail + ",")
                .append(this.reqId + ',')
                .append(this.reqTitle +'\n')
                .append(this.reqDescription);
        return builder.toString();
	}
	
	static class RequestDescriptionBuilder{
		private String reqId;
		private String requesterEmail;
		private String reqTitle;
		private String reqDescription;
		
			
		public RequestDescriptionBuilder withReqId() {
			int id;
			id =this.hashCode();
			this.reqId = "R"+Integer.toString(id);
			return this;
		}
		
		public RequestDescriptionBuilder withRequesterEmail(String email) {
			this.requesterEmail = email;
			return this;
		}
		
		public RequestDescriptionBuilder withReqTitle(String title) {
			this.reqTitle = title;
			return this;
		}
		
		public RequestDescriptionBuilder withReqDescription(String description) {
			this.reqDescription = description;
			return this;
		}
		
		public RequestDescriptionData build() {
			withReqId();
			return new RequestDescriptionData(this);
		}			
	}
	
}
