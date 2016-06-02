package restaurant;
	
public class rest {

	
		private int id;
		private String RName;
		private String addr;
		private int zip;
		private String cuisine;
		private Double rating;
		private String range;
		
		public rest(String RName, String cuisine, String addr, int zip, Double rating,String range){
				
			this(0, RName, cuisine,addr,zip,rating,range);
		}
		
		public  rest(int id, String RName,String cuisine, String addr, int zip,  Double rating, String range) {
			
			super();
			this.id = id;
			this.RName = RName;
			this.addr = addr;
			this.zip = zip;
			this.cuisine = cuisine;
			this.rating = rating;
			this.range = range;
		}

		public int getId() {
			
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getRName() {
			return RName;
		}

		public void setRName(String RName) {
			this.RName = RName;
		}
		
		
		public String getcuisine() {
			return cuisine;
		}

		public void setcuisine(String cuisine) {
			this.cuisine = cuisine;
		}

		public String getaddr() {
			return addr;
		}

		public void setaddr(String addr) {
			this.addr = addr;
		}

		

		public int  getzip() {
			return zip;
		}

		public void setzip(int zip) {
			this.zip = zip;
		}
		
		
		
		public Double  getrating() {
			return rating;
		}

		public void setrating(Double rating) {
			this.rating = rating;
		}


		public String getrange() {
			return range;
		}

		public void setrange(String range) {
			this.range = range;
		}

		@Override
		public String toString() {
			return String
					.format("Restaurant [id=%d, RName=%s, addr=%s, cuisine=%s, zip= %d, rating=%f,range =%s]",
							id, RName, cuisine,addr,zip,rating,range);
		}

		
		
		
			
	}


