package Portfolio;

import java.util.logging.Logger;

class Portfolio {
	
	static String[] labels = {"US Stocks", "International Stocks", "Bonds", "REITs", "Cash"};
	double[] balances;
	private static Logger logger = Logger.getLogger("portfolio.portfolioTest");
			
	public Portfolio(double[] balances) {
		logger.entering("Portfolio", "<init>");
		this.balances = balances;
		logger.exiting("Portfolio", "<init>");
	}

	public double[] Allocate(Allocation a) {
		logger.entering("Portfolio", "Allocate", a);
		double[] desiredBalances = new double[5];
		double[] changes = new double[5];
		
		for(int i = 0; i < 5; i++) {
			desiredBalances[i] = TotalBalance()*a.allocation[i]; 
			changes[i] = desiredBalances[i]-balances[i];
		}
		logger.exiting(	"Portfolio", "Allocate");
		return changes;
	}
	
	public double TotalBalance() {
		logger.entering("Portfolio", "TotalBalance", null);
		double sum = 0;
		for(double d : this.balances) {
			sum += d;
		}
		logger.exiting(	"Portfolio", "TotalBalance");
		return sum;
	}
}