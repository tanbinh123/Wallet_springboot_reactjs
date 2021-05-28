package com.mit.wallet.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
    @Min(1)
    @NotNull(message = "amount can't be null")
	private Double amount;
	private String description;
	@Min(1)
	@Max(3)
	private int type;//1 for Income,2 for expense,3 for transfer
	@JsonFormat(pattern = "yyyy-mm-dd")
	private Date transactionDate;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "wallet_id",nullable = false)
	private Wallet wallet;
	


	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Transaction(Long id, @Min(1) @NotBlank(message = "amount can't be null") Double amount, String description,
			@Min(1) @Max(3) int type, Date transactionDate, Wallet wallet) {
		super();
		this.id = id;
		this.amount = amount;
		this.description = description;
		this.type = type;
		this.transactionDate = transactionDate;
		this.wallet = wallet;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public Double getAmount() {
		return amount;
	}



	public void setAmount(Double amount) {
		this.amount = amount;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public int getType() {
		return type;
	}



	public void setType(int type) {
		this.type = type;
	}



	public Date getTransactionDate() {
		return transactionDate;
	}



	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}



	public Wallet getWallet() {
		return wallet;
	}



	public void setWallet(Wallet wallet) {
		this.wallet = wallet;
	}



	@PrePersist
	public void setTransactionDate() {
		this.transactionDate = new Date();
	}
}
