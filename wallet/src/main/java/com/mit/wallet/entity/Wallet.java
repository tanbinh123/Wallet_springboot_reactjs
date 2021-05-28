package com.mit.wallet.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;




@Entity
public class Wallet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    @NotBlank(message = "Name can't be blank")
    @Size(min = 2,max = 30)
	private String name;
    @Size(min = 2,max = 30)
	private String accountNumber;
    @Size(max = 100)
	private String description;
    @Min(1)
    @Max(3)
	private Integer priority;
	private Double currentBalance;
	
	@OneToMany(cascade = CascadeType.REFRESH,fetch = FetchType.EAGER,mappedBy = "wallet",orphanRemoval = true)
	private List<Transaction> transactions;
	
	public Wallet() {
		super();
		
	}


	public Wallet(Long id,String name, String accountNumber, String description, Integer priority, Double currentBalance) {
		super();
		this.id = id;
		this.name = name;
		this.accountNumber = accountNumber;
		this.description = description;
		this.priority = priority;
		this.currentBalance = currentBalance;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAccountNumber() {
		return accountNumber;
	}


	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Integer getPriority() {
		return priority;
	}


	public void setPriority(Integer priority) {
		this.priority = priority;
	}


	public Double getCurrentBalance() {
		return currentBalance;
	}


	public void setCurrentBalance(Double currentBalance) {
		this.currentBalance = currentBalance;
	}


	@PrePersist
	public void setBalance() {
		this.currentBalance = 0.00 ;
	}


}
