package SkiResort;

public enum ENUMaccomType {
	HOTEL {
		@Override
		public String lowerCase() {
			return HOTEL.toString().toLowerCase();
		}
	},
	LODGE {
		@Override
		public String lowerCase() {
			return LODGE.toString().toLowerCase();
		}
	},
	APARTMENT {
		@Override
		public String lowerCase() {
			return APARTMENT.toString().toLowerCase();
		}
	};

	public abstract String lowerCase();
}
