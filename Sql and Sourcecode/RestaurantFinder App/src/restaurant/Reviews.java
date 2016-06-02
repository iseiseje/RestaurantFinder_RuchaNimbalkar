package restaurant;
public class Reviews {
	
	private String userId;
	private int rId;
	
	private String review;
	
	public Reviews(int rid2,String userid,String sr) {
		// TODO Auto-generated constructor stub
		
		super();
		this.rId = rid2;
		this.userId=userid;
		this.review=sr;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getrId() {
		return rId;
	}
	public void setrId(int rId) {
		this.rId = rId;
	}
	
	public String getreview() {
		return review;
	}
	public void setreview(String review) {
		this.review = review;
	}
	@Override
	public String toString() {
		return String
				.format("Restaurants [review=%s, rId=%d]",review,rId);
	}
	
}
