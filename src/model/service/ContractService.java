package model.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import model.entities.Contract;
import model.entities.Installment;

public class ContractService {
	private Date dueDate;
	private OnlinePaymentService onlinePaymentService;
	public List<Installment> carne = new ArrayList<>();

	
	public ContractService(OnlinePaymentService onlinePaymentService) {
		this.onlinePaymentService = onlinePaymentService;
	}

	public void processContract(Contract contract, int months) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(contract.getDate());
		double amount = contract.getTotalValue();
		for (int i=1; i<=months;i++) {
			cal.add(Calendar.MONTH, 1);
			dueDate = cal.getTime();
			onlinePaymentService = new PaypalService();
			double basicInstallment = amount/months;
			double partialInstallment = basicInstallment  +  onlinePaymentService.interest(basicInstallment,i);  
			double finalInstallment = partialInstallment + onlinePaymentService.paymentFee(partialInstallment);	
			carne.add(new Installment(dueDate, finalInstallment));			
		}
		for (Installment x : carne) {
			System.out.println(x);
		}
	}
}
