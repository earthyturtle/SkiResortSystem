package SkiResort;

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
