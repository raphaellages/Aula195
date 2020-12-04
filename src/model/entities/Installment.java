package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Installment {
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	private Date dueDate;
	private Double amount;
	
	public Installment(Date dueDate, Double amount) {
		this.dueDate = dueDate;
		this.amount = amount;
	}
	
	public Installment () {
	}

	public Date getDueDate() {
		return dueDate;
	}

	public Double getAmount() {
		return amount;
	}
	
	public String toString() {
		return	sdf.format(dueDate)
				+" - "
				+String.format("%.2f", amount);
	}
	
	
	
}
