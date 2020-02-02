class Customer {
	private String _name;
	private Vector _rentals = new Vector();
	public Customer (String name) {
		_name = name;
	};

	public void addRental(Rental arg) {
		_rentals.addElement(arg);
	}
	public String getName () {
		return _name;
	}
	public String statement() {
		double totalAmount = each.getCharge();
		int frequentRenterPoints = 0;
		Enumeration rentals = _rentals.elements();
		String result = "Учет аренды для " + getName() + "\n";
		while (rentals.hasMoreElements()) {
			double thisAmount = 0;
			Rental each = (Rental) rentals.nextElement();
			thisAmount = each.getCharge();
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
		return aRental.getCharge();
	}
}