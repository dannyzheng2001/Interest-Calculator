import java.text.NumberFormat;

public class Interest {
	
	double principal, rate, years;
	
	public Interest(double principal, double rate, double years) {
		this.principal=principal;
		this.rate=rate;
		this.years=years;
	}
	
	public String simpleInterest(double principal, double rate, double years) {
		double simpleInt = 0;
		String result = "";
		result += "Principal: "+NumberFormat.getCurrencyInstance().format(principal)+", Rate: "+rate+"\n";
		result += "Year, Simple Interest Amount"+"\n";
		for (int yearNum = 1; yearNum <= years; yearNum++) {
			simpleInt = principal + (principal * (rate / 100) * yearNum);
			result += yearNum + "-->" + NumberFormat.getCurrencyInstance().format(simpleInt)+"\n";
		}
		return result;
	}
	
	public String compoundInterest(double principal, double rate, double years) {
		double compoundInt = 0;
		String result = "";
		result += "Principal: "+NumberFormat.getCurrencyInstance().format(principal)+", Rate: "+rate+"\n";
		result += "Year, Compound Interest Amount"+"\n";
		for (int yearNum = 1; yearNum <= years; yearNum++) {
			compoundInt = Math.pow(1 + rate / 100, yearNum)*principal;
			result += yearNum + "-->" + NumberFormat.getCurrencyInstance().format(compoundInt)+"\n";
		}
		return result;
	}
	
	public String bothInterest(double principal, double rate, double years) {
		String result = "";
		result += "Principal: "+NumberFormat.getCurrencyInstance().format(principal)+", Rate: "+rate+"\n";
		result += "Year, Simple Interest Amount, Compound Interest Amount"+"\n";
		double compoundInt = 0;
		double simpleInt = 0;
		for (int yearNum = 1; yearNum <= years; yearNum++) {
			simpleInt = principal + (principal * (rate / 100) * yearNum);
			compoundInt = Math.pow(1 + rate / 100, yearNum)*principal;
			result += yearNum + "-->" + NumberFormat.getCurrencyInstance().format(simpleInt)+"-->"+ NumberFormat.getCurrencyInstance().format(compoundInt)+"\n";
		}
		return result;
	}
}