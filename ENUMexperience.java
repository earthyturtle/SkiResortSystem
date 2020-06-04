package mtbuller;

public enum ENUMexperience {
	BEGINNER(20) {
		@Override
		public String lowerCase() {
			return BEGINNER.toString().toLowerCase();
		}
	},
	INTERMEDIATE(15) {
		@Override
		public String lowerCase() {
			return INTERMEDIATE.toString().toLowerCase();
		}
	},
	EXPERT(10) {
		@Override
		public String lowerCase() {
			return EXPERT.toString().toLowerCase();
		}
	};

	private int expCost;
	
	private ENUMexperience(int expCost) {
		this.expCost = expCost;
	}
	public int getExperienceCost() {
		return expCost;
	}

	public abstract String lowerCase();
}
