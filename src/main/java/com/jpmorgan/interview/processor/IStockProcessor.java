package com.jpmorgan.interview.processor;

import java.util.List;

import com.jpmorgan.interview.models.StockContainer;
import com.jpmorgan.interview.utils.TradeTypeEnum;

public interface IStockProcessor {

	/**
	 * This method calculates the Dividend Yield for Common and Preferred types
	 * @param stockContainer
	 * @return
	 */
	public float getDividendYield(StockContainer stockContainer, float price) throws Exception;
	
	
	/**
	 * This method calculates the PE Ratio
	 * @param stockContainer
	 * @return
	 */
	public float getPERatio(StockContainer stockContainer, float price) throws Exception;
	
	/**
	 * This method responsible for buying and selling of stocks
	 * @param stockContainer
	 * @return
	 */
	public void logTrade(StockContainer stockContainer,Integer quantity , float price, TradeTypeEnum tradeType) throws Exception;
	
	/**
	 * This method calculates the volumeWeighted Stock Price
	 * @param timeInterval
	 * @return
	 */
	public float getVolumeWeightedStockPrice(StockContainer stockContainer, float timeInterval) throws Exception;
	
	/**
	 * This calculate the mean value of Stocks
	 * @param stockList
	 * @return
	 * @throws Exception
	 */
	public float calculateMeanValueFromStocks(List<StockContainer> stockList) throws Exception;
}
