package com.jpmorgan.interview.models;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.jpmorgan.interview.utils.StockTypeEnum;

/**
 * This is a model class for Stock 
 * @author Balan
 *
 */
public class StockContainer {

	
	private Map<Date, TradeContainer> tradeMap = null;
		
	private String symbol = null;	
	private StockTypeEnum type = null;	
	private float lastDividend = 0.0f;	
	private float fixedDividend = 0.0f;	
	private float parValue = 0.0f;
	
	//Constructor
	public StockContainer(String symbol, StockTypeEnum type, float lastDividend, float fixedDividend, float parValue) {
		
		this.symbol = symbol;	
        this.type = type;	
		this.lastDividend = lastDividend;	
		this.fixedDividend = fixedDividend;	
		this.parValue = parValue;
	}
	
	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public StockTypeEnum getType() {
		return type;
	}

	public void setType(StockTypeEnum type) {
		this.type = type;
	}

	public float getLastDividend() {
		return lastDividend;
	}

	public void setLastDividend(float lastDividend) {
		this.lastDividend = lastDividend;
	}

	public float getFixedDividend() {
		return fixedDividend;
	}

	public void setFixedDividend(float fixedDividend) {
		this.fixedDividend = fixedDividend;
	}

	public float getParValue() {
		return parValue;
	}

	public void setParValue(float parValue) {
		this.parValue = parValue;
	}

	
	public Map<Date, TradeContainer> getTradeMap() {
		return tradeMap;
	}

	public void setTradeMap(Map<Date, TradeContainer> tradeMap) {
		this.tradeMap = tradeMap;
	}

	/**
	 * This method add trades to the given Stock
	 * @param date
	 * @param tradeContainerParameter
	 */
	public void addTrade(Date date, TradeContainer tradeContainerParameter) {
		if(tradeMap == null) {
			tradeMap = new HashMap<Date, TradeContainer>();
		}
		
		tradeMap.put(date, tradeContainerParameter);
	}
	/**
	 * Hash code method
	 */
	public int hashCode()
	{
		StringBuffer stringBuffer = new StringBuffer();
		
		stringBuffer.append(symbol);
		stringBuffer.append(type);
		
		return stringBuffer.toString().hashCode();
	}
	
	/**
	 * This method compares the values
	 */
	public boolean equals( Object stockObject )
	{
		boolean booleanRetunValue = Boolean.FALSE;
		StockContainer stockContainerTemp = null;
		
		if( stockObject != null && 
				stockObject instanceof StockContainer) {
			stockContainerTemp = (StockContainer) stockObject;
			
			booleanRetunValue = ( stockContainerTemp.symbol.equals(this.symbol) 
					&& stockContainerTemp.type.equals(this.type) 
					&& stockContainerTemp.fixedDividend == this.fixedDividend
					&& stockContainerTemp.lastDividend == this.lastDividend
					&& stockContainerTemp.parValue == this.parValue);
			
		}
			
		return booleanRetunValue;
	}
	
}
