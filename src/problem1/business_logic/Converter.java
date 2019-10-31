package problem1.business_logic;

public class Converter {
	public double convertDinarsToEuros(double dinar) {
		return dinar / 120;
	}

	public double convertEurosToDinars(double euro) {
		return euro * 120;
	}
}