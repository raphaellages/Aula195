package model.service;

public class PaypalService implements OnlinePaymentService{
	
	private static final double INTEREST=0.01;
	private static final double	FEE = 0.02;
	@Override
	public Double paymentFee (Double amount) {
		return amount * FEE;
	}
	@Override
	public Double interest (Double amount, int months) {
		return amount * INTEREST * months;
	}
}
