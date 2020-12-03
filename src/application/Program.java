package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Contract;
import model.service.OnlinePaymentService;

public class Program {
	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		OnlinePaymentService ops = null;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println("Enter contract data:");
		System.out.print("Number: ");
		int number = sc.nextInt();
		sc.nextLine();
		System.out.print("Date (dd/MM/yyyy): ");
		Date date = sdf.parse(sc.nextLine());
		System.out.print("Contract value: ");
		double totalValue = sc.nextDouble();
		System.out.print("Enter number of installments: ");
		int installments = sc.nextInt();
		Contract contract = new Contract(number, date, totalValue);
		double amount = totalValue / installments;
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		for (int i=1; i<=installments;i++) {
			cal.add(Calendar.MONTH, 1);
			Date dueDate = cal.getTime();
			//System.out.println(sdf.format(dueDate)); //Verificando se a impressao das datas está correta
			double currentInstallment = amount + ops.paymentFee(amount)+ops.interest(amount, i);
			
			
		}
		
		
	}
}
