package com.jpmorgan.interview.processor;

import java.util.Date;
import java.util.List;
import java.util.Set;

import com.jpmorgan.interview.models.StockContainer;
import com.jpmorgan.interview.models.TradeContainer;
import com.jpmorgan.interview.utils.Constants;
import com.jpmorgan.interview.utils.InvalidStockEception;
import com.jpmorgan.interview.utils.TradeTypeEnum;


public class StockProcessorImpl implements IStockProcessor{

	public float getDividendYield(StockContainer stockContainer, float price) {
		
		boolean canThrowError = Boolean.FALSE;
		float retValue = Constants.ZERO_VALUE;
		
		//check for the minimum negative cases
		if(stockContainer == null && price  < Constants. ZERO_VALUE) {
			canThrowError = Boolean.TRUE;
		}
		else {
			//Calculate the Value
			switch (stockContainer.getType()) {			
			case COMMON:
				  retValue = stockContainer.getLastDividend() /price;
				  break;
			case PREFERRED:
				  retValue = stockContainer.getFixedDividend() *stockContainer.getParValue() /price;
				  break;
			   default:
				  canThrowError = Boolean.TRUE;			
				  break;
				
			}
		}
	
		//Raise exception
		if(canThrowError) {
			throw new InvalidStockEception(Constants.INVALID_STOCK_VALUES);
		}
		return retValue;
	
	}

	public float getPERatio(StockContainer stockContainer, float price) {
		
		float retValue = Constants.ZERO_VALUE;
		
		//check for the minimum negative cases
		if( (stockContainer == null || stockContainer.getLastDividend() < Constants. ZERO_VALUE)
				&& price  < Constants. ZERO_VALUE) {
			throw new InvalidStockEception(Constants.INVALID_STOCK_VALUES);
		}
		else {			
				  retValue = price/ stockContainer.getLastDividend();					
			}
	
		return retValue;
	}

	
	public void logTrade(StockContainer stockContainer, Integer quantity ,float price, TradeTypeEnum tradeType) {
	  
		//check for the minimum negative cases
		if( stockContainer == null && price  < Constants. ZERO_VALUE) {
			throw new InvalidStockEception(Constants.INVALID_STOCK_VALUES);
		}
		else {			
				  Date timeStamp = new Date();		
				  TradeContainer tradeContainerParameter = new TradeContainer(timeStamp,
						  quantity, price, tradeType);
				  
				  //Time stamp is added a key as well as in TradeContainer Object to support
				  stockContainer.addTrade(timeStamp, tradeContainerParameter);
			}
	
		
	}

	public float getVolumeWeightedStockPrice(StockContainer stockContainer, float timeInterval) {
		float priceValue = Constants.ZERO_VALUE;
		
		long currentTime = System.currentTimeMillis();
		Date filterDateValue = new Date( currentTime -  15*60*1000 ); // milli seconds
		TradeContainer tradeContainer = null;
		int iteratedQuantity = 0;
		
		//check for the values
		if(stockContainer != null  && stockContainer.getTradeMap().size() > Constants.ZERO_VALUE) {
			
			Set<Date> iterSet = stockContainer.getTradeMap().keySet();
			
			//filter based on the time interval
			for(Date date : iterSet) {
				//neglect values before the time interval
				if(date.before(filterDateValue)) {
					continue;
				}
				else {
					//Buy or sell calculate the quantity and price
					tradeContainer = stockContainer.getTradeMap().get(date);
					iteratedQuantity += tradeContainer.getQuantity();
					
					//return value
					priceValue += tradeContainer.getPrice() * tradeContainer.getQuantity();
				}
			}
			
			//calculate the price
			if(iteratedQuantity > Constants.ZERO_VALUE) {
				priceValue = priceValue/ iteratedQuantity;
			}
		}
		return priceValue;
	}

	public float calculateMeanValueFromStocks(List<StockContainer> stockList) throws Exception {
		float gbceValue = 0.0f;
		
		for(StockContainer stockContainer: stockList) {
			
			//iterate all trade buy and sell and calculate the price
			for(TradeContainer tradeContainer : stockContainer.getTradeMap().values()) {
			gbceValue+=tradeContainer.getPrice();
			}
		}
		return (float)Math.pow(gbceValue, 1.0 / stockList.size());
	}
	

}
