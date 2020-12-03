package model.service;

public class PaypalService implements OnlinePaymentService{
	
	private static final double INTEREST=0.01,FEE = 0.02;
	
	@Override
	public Double paymentFee (Double amount) {
		return amount * FEE;
	}
	@Override
	public Double interest (Double amount, Integer months) {
		return amount * INTEREST * months;
	}
}
