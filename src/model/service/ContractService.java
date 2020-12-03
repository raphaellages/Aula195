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

	public void processContract(Contract contract, Integer months) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(contract.getDate());
		double amount = contract.getTotalValue();
		for (int i=1; i<=months;i++) {
			cal.add(Calendar.MONTH, 1);
			dueDate = cal.getTime();
			onlinePaymentService = new PaypalService();
			double currentInstallment = amount/months +  onlinePaymentService.paymentFee(amount) + onlinePaymentService.interest(amount,i);
			//System.out.println(String.format("%.2f", currentInstallment));		
			carne.add(new Installment(dueDate, currentInstallment));
		}
		for (Installment x : carne) {
			System.out.println(x);
		}
	}
}
