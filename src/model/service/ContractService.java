package model.service;

import java.util.Calendar;
import java.util.Date;

import model.entities.Contract;
import model.entities.Installment;

public class ContractService {
	
	private OnlinePaymentService onlinePaymentService;
	
	public ContractService(OnlinePaymentService onlinePaymentService) {
		this.onlinePaymentService = onlinePaymentService;
	}

	public void processContract(Contract contract, Integer months) {
		Calendar cal = Calendar.getInstance();
		double amount = contract.getTotalValue()/
		cal.setTime(contract.getDate());
		Date dueDate;
		for (int i=1; i<=months;i++) {
			cal.add(Calendar.MONTH, 1);
			dueDate = cal.getTime();
			onlinePaymentService = new PaypalService();
			double currentInstallment = amount +  onlinePaymentService.paymentFee(contract.getTotalValue()) + onlinePaymentService.interest(contract.getTotalValue(), i);
			System.out.println(sdf.format(dueDate)); //Verificando se a impressao das datas est� correta
			System.out.println(String.format("%.2f", currentInstallment));		
			carne.add(new Installment(dueDate, amount));
	}
}
