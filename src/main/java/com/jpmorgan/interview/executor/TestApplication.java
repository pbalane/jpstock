package com.jpmorgan.interview.executor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.jpmorgan.interview.models.StockContainer;
import com.jpmorgan.interview.models.TradeContainer;
import com.jpmorgan.interview.processor.IStockProcessor;
import com.jpmorgan.interview.processor.StockProcessorImpl;
import com.jpmorgan.interview.utils.Constants;
import com.jpmorgan.interview.utils.StockTypeEnum;
import com.jpmorgan.interview.utils.TradeTypeEnum;

public class TestApplication {


	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		IStockProcessor iStockProcessor = new StockProcessorImpl();
		
		//Add Stocks
		
		//Stock Symbol Type Last Dividend Fixed Dividend Par Value
		StockContainer stockContainer1 = new StockContainer
				(Constants.STOCK_SYMBOL_TEA, StockTypeEnum.COMMON, 
						Constants.ZERO_VALUE, Constants.ZERO_VALUE, 100);	
		
		StockContainer stockContainer2 = new StockContainer
				(Constants.STOCK_SYMBOL_POP, StockTypeEnum.COMMON, 
						8, Constants.ZERO_VALUE, 100);	
		
		StockContainer stockContainer3 = new StockContainer
				(Constants.STOCK_SYMBOL_ALE, StockTypeEnum.COMMON, 
						23, Constants.ZERO_VALUE, 60);	
		
		StockContainer stockContainer4 = new StockContainer
				(Constants.STOCK_SYMBOL_GIN, StockTypeEnum.PREFERRED, 
						8, 2, 100);	
		
		StockContainer stockContainer5 = new StockContainer
				(Constants.STOCK_SYMBOL_JOE, StockTypeEnum.PREFERRED, 
						13, Constants.ZERO_VALUE, 250);	
		
		try {
			
			//Throw Exception
			//System.out.println( iStockProcessor.getDividendYield(stockContainer, 20));
			
			//
			stockContainer1.setLastDividend(4);
			System.out.println( "Calc Dividend yield : ====>" + iStockProcessor.getDividendYield(stockContainer1, 20));
			
			Date date1 = new Date();
			TradeContainer tradeContainerParameter1 = new TradeContainer(date1, 200, 700, TradeTypeEnum.BUYING);
			
			
			Date date2 = new Date();
			TradeContainer tradeContainerParameter2 = new TradeContainer(date2, 100, 300, TradeTypeEnum.SELLING);
			stockContainer1.addTrade(date1, tradeContainerParameter1);
			stockContainer1.addTrade(date2, tradeContainerParameter2);
			
			
			System.out.println( "Calc getVolumeWeightedStockPrice : ====>" + iStockProcessor.getVolumeWeightedStockPrice(stockContainer1, 15));
			
			//PeRatio
			System.out.println( "Calc getPERatio : ====>" + iStockProcessor.getPERatio(stockContainer1, 21));
			
			//Preferred Dividend
			System.out.println( "Calc Dividend yield : ====>" + iStockProcessor.getDividendYield(stockContainer4, 33));
			
			
			//Calculate Mean
			Date date3 = new Date();
			TradeContainer tradeContainerParameter3 = new TradeContainer(date3, 24, 7400, TradeTypeEnum.BUYING);
			
			
			Date date4 = new Date();
			TradeContainer tradeContainerParameter4 = new TradeContainer(date4, 10440, 1000, TradeTypeEnum.SELLING);
			stockContainer4.addTrade(date3, tradeContainerParameter3);
			stockContainer4.addTrade(date4, tradeContainerParameter4);
			
			//
			List<StockContainer> stockContainerList = new ArrayList<StockContainer>();
			stockContainerList.add(stockContainer1);
			stockContainerList.add(stockContainer4);
			System.out.println( "calculateMeanValueFromStocks : ====>" + iStockProcessor.calculateMeanValueFromStocks(stockContainerList));
			
		}
		catch(Exception exp) {
			exp.printStackTrace();
		}
		
		
		}

}
