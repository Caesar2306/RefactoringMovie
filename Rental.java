class Rental {
	private Movie _movie;
	private int _daysRented;
	public Rental(Movie movie, int daysRented) {
		_movie = movie;
		_daysRented = daysRented;
	}
	public int getDaysRented() {
		return _daysRented;
	}
	public Movie getMovie() {
		return _movie;
	}
	private double getCharge(){
		//определить сумму для каждой строки
		double result  = 0;
			switch (aRental.getMovie().getPriceCode()) {
				case Movie.REGULAR:
				result  += 2;
				if (aRental.getDaysRented() > 2)
					result  += (aRental.getDaysRented()  2) * 1.5;
				break;
				case Movie.NEW_RELEASE:
				result  += aRental.getDaysRented() * 3;
				break;
				case Movie.CHILDRENS:
				result  += 1.5;
				if (aRental.getDaysRented() > 3)
					result  += (aRental.getDaysRented()  3) * 1.5;
				break;
			}
		return result;
	}
}