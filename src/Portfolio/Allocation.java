package Portfolio;

import java.util.logging.Logger;

class Allocation {
		
	double[] allocation;
	private static Logger logger = Logger.getLogger("portfolio.portfolioTest");
	
	public Allocation(double[] allocation) 	{
		logger.entering("Allocation", "<init>");
		double sum = 0;
		for (double d : allocation)	{
			sum += d;
		}
		if(sum > 0.9999 & sum <1.0001) {
			this.allocation = allocation;
			logger.exiting("Portfolio", "<init>");
		}
		else {
			logger.warning("Error, total percentage must add to 1. Total percentage entered = " + sum);
			System.out.println("Error, total percentage must add to 1");
			System.out.println("Total percentage entered = " + sum);
		}
	}
}