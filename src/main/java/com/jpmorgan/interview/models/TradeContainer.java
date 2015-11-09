package com.jpmorgan.interview.models;

import java.util.Date;

import com.jpmorgan.interview.utils.StockTypeEnum;
import com.jpmorgan.interview.utils.TradeTypeEnum;

/**
 * This class is responsible for Trade management
 * @author Balan
 *
 */
public class TradeContainer {

	private Date eventTime = null;
	private Integer quotedQuantity = 0;
	private float quotedPriceValue = 0.0f;
	private TradeTypeEnum containerType = null;
	
public TradeContainer(Date eventTime , Integer quotedQuantity, float quotedPriceValue, TradeTypeEnum containerType) {
		
	this.eventTime = null;
	this.quotedQuantity = quotedQuantity;
	this.quotedPriceValue = quotedPriceValue;
	this.containerType = containerType;
	}

	public TradeTypeEnum getType() {
		return containerType;
	}
	public void setType(TradeTypeEnum type) {
		this.containerType = type;
	}
	public Integer getQuantity() {
		return quotedQuantity;
	}
	public void setQuantity(Integer quotedQuantity) {
		this.quotedQuantity = quotedQuantity;
	}
	public float getPrice() {
		return quotedPriceValue;
	}
	public void setPrice(float quotedPriceValue) {
		this.quotedPriceValue = quotedPriceValue;
	}
	public Date getEventTime() {
		return eventTime;
	}
	public void setEventTime(Date eventTime) {
		this.eventTime = eventTime;
	}
	
	
	/**
	 * Hash code method
	 */
	public int hashCode()
	{
		StringBuffer stringBuffer = new StringBuffer();
		
		stringBuffer.append(eventTime);
		stringBuffer.append(quotedQuantity);
		stringBuffer.append(quotedPriceValue);
		stringBuffer.append(containerType);
		
		return stringBuffer.toString().hashCode();
	}
	
	/**
	 * This method compares the values
	 */
	public boolean equals( Object tradeContainerObject )
	{
		boolean booleanRetunValue = Boolean.FALSE;
		TradeContainer tradeContainerTemp = null;
		
		if( tradeContainerObject != null && 
				tradeContainerObject instanceof TradeContainer) {
			tradeContainerTemp = (TradeContainer) tradeContainerObject;
			
			booleanRetunValue = ( tradeContainerTemp.eventTime.equals(this.eventTime) 
					&& tradeContainerTemp.containerType.equals(this.containerType) 
					&& tradeContainerTemp.quotedQuantity == this.quotedQuantity
					&& tradeContainerTemp.quotedPriceValue == this.quotedPriceValue);
			
		}
			
		return booleanRetunValue;
	}
}
