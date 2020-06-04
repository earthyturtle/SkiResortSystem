package mtbuller;

/*
 * I did a lot of research into the power of enumerable variables and fell in love with their versatility, stability and functionality.
 * I wanted to fully utilise them to the best of my abilities in this assessment, Honestly I am seeing so many practical uses for them and regret not
 * using them in this fashion sooner. 
 */

public enum ENUMliftPassValues {
	NOPASS(0) {
		@Override
		public String lowerCase() {
			return NOPASS.toString().toLowerCase();
		}
	},
	DAYPASS(26) {
		@Override
		public String lowerCase() {
			return DAYPASS.toString().toLowerCase();
		}
	},
	FIVEDAY(117) {
		@Override
		public String lowerCase() {
			return FIVEDAY.toString().toLowerCase();
		}
	},
	SEASON(200) {
		@Override
		public String lowerCase() {
			return SEASON.toString().toLowerCase();
		}
	};

	private int liftCost;
	private ENUMliftPassValues(int liftCost) {
		this.liftCost = liftCost;
	}
	public double getLiftPassValues() {
		return liftCost;
	}

	public abstract String lowerCase();
}
