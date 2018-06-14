package Portfolio;

import java.io.IOException;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

class PortfolioTest{
	
	public static void main(String[] args) {
		
		if (System.getProperty("java.util.logging.config.class") == null
	            && System.getProperty("java.util.logging.config.file") == null)
	      {
	         try
	         {
	            Logger.getLogger("portfolio.portfolioTest").setLevel(Level.ALL);
	            final int LOG_ROTATION_COUNT = 5;
	            Handler handler = new FileHandler("%h/LoggingPortfolioTest.log", 0, LOG_ROTATION_COUNT);
	            Logger.getLogger("portfolio.portfolioTest").addHandler(handler);
	         }
	         catch (IOException e)
	         {
	            Logger.getLogger("portfolio.portfolioTest").log(Level.SEVERE,
	                  "Can't create log file handler", e);
	         }
	      }
		
		
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter current balances:");
		double[] balances = new double[5];
			for(int i = 0; i < 5; i++) {
				balances[i] = in.nextDouble();
			}
		
		System.out.println("Enter desired allocation:");
		double[] allocation = new double[5];
			for(int i = 0; i < 5; i++) {
				allocation[i] = in.nextDouble();
			}
			
		Portfolio p = new Portfolio(balances);
		Allocation a = new Allocation(allocation);
				double[] changes = p.Allocate(a);
		NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(Locale.getDefault());
		System.out.println("Necessary Changes to Balance Portfolio:");
		for(int j = 0; j <5; j++) {
			System.out.printf("%-25s%s%n", Portfolio.labels[j], currencyFormatter.format(changes[j]));
		}
		
		System.out.println("---------------------------------");
		System.out.printf("%-25s%s%n", "Total Balance" , currencyFormatter.format(p.TotalBalance()));
		
	}
}