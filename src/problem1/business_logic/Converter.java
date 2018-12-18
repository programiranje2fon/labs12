package problem1.business_logic;

public class Converter {
	public double convertDIE(double dinar) {
		return dinar / 120;
	}

	public double convertEID(double euro) {
		return euro * 120;
	}
}