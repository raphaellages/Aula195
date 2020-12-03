package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Contract;
import model.entities.Installment;
import model.service.ContractService;
import model.service.OnlinePaymentService;
import model.service.PaypalService;

public class Program {
	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		OnlinePaymentService ops = null;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println("Enter contract data:");
		System.out.println("Number: 8028");
//		System.out.println(8028);
//		int number = sc.nextInt();
		int number = 8028;
//		sc.nextLine();
		System.out.println("Date (dd/MM/yyyy): 25/06/2018");
//		System.out.println("25/06/2018");
		Date date = sdf.parse("25/06/2018");
		System.out.println("Contract value: 600");
//		double totalValue = sc.nextDouble();
		double totalValue = 600;
		System.out.println("Enter number of installments: 3");
//		int installments = sc.nextInt();
		int installments = 3;
		Contract contract = new Contract(number, date, totalValue);
		double amount = totalValue / installments;
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		ContractService cs = new ContractService(new PaypalService());		
		cs.processContract(contract, installments);;
			
		
	}
}
