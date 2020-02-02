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
	public String statement() {
		double totalAmount = amountFor(each);
		int frequentRenterPoints = 0;
		Enumeration rentals = _rentals.elements();
		String result = "Учет аренды для " + getName() + "\n";
		while (rentals.hasMoreElements()) {
			double thisAmount = 0;
			Rental each = (Rental) rentals.nextElement();

 // добавить очки для активного арендатора
			frequentRenterPoints ++;
 // бонус за аренду новинки на два дня
			if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) &&
				each.getDaysRented() > 1) frequentRenterPoints ++;
 //показать результаты для этой аренды
				result += "\t" + each.getMovie().getTitle()+ "\t" +
			String.valueOf(thisAmount) + "\n";
			totalAmount += thisAmount;
		}
 //добавить нижний колонтитул
		result += "Сумма задолженности составляет " +
		String.valueOf(totalAmount) + "\n";
		result += "Вы заработали " + String.valueOf(frequentRenterPoints) +
		" очков за активность";
		return result;
	}
	private double amountFor(Rental aRental){
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