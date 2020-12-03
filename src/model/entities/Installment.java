package model.entities;

import java.util.Date;

public class Installment {
	private Date dueData;
	private Double amount;
	
	public Installment(Date dueData, Double amount) {
		this.dueData = dueData;
		this.amount = amount;
	}
	
	public Installment () {
	}

	public Date getDueData() {
		return dueData;
	}

	public Double getAmount() {
		return amount;
	}
	
	
	
}
