package com.sst.cryptomiddleware;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;

public class Transaction {

	private String transactionId;
	
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	private LocalDateTime transactionDate;
	
	private String description;
	
	private String accountNumber;

	private Blockchain blockchain;
	
	private TransactionType transactionType;
	
	private CurrencyType currencyType;
	
	private BigDecimal amount;
	
	private String assetId;
	
	private String assetUri;
	
	


	public LocalDateTime getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(LocalDateTime transactionDate) {
		this.transactionDate = transactionDate;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Blockchain getBlockchain() {
		return blockchain;
	}

	public void setBlockchain(Blockchain blockchain) {
		this.blockchain = blockchain;
	}

	public TransactionType getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(TransactionType transactionType) {
		this.transactionType = transactionType;
	}

	public CurrencyType getCurrencyType() {
		return currencyType;
	}

	public void setCurrencyType(CurrencyType currencyType) {
		this.currencyType = currencyType;
	}

	

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getAssetId() {
		return assetId;
	}

	public void setAssetId(String assetId) {
		this.assetId = assetId;
	}

	public String getAssetUri() {
		return assetUri;
	}

	public void setAssetUri(String assetUri) {
		this.assetUri = assetUri;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
