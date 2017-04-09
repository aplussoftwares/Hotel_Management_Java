import java.io.*;
import java.util.*;

class BreakFast{
	private int break_items[][] = {
		{50,25},
		{20,10},
		{40,67},
		{45,67}
	};

	private String items_name[] = {
		"Idly",
		"Vada",
		"Dosa",
		"Puri"
	};

	private int total;

	void BreakFast() {
		total = 0; 
	}

	public void print_items(){
		System.out.println("      Items Available For BreakFast      ");
		System.out.println("=========================================");
		System.out.println("S.no   |   Item   |  Price  |  Available |");
		System.out.println("=========================================");
		for(int i=0;i< items_name.length;i++){
			System.out.println((i+1)+"      | "+items_name[i]+"     | "+break_items[i][1]+"      | "+break_items[i][0]+"         |");
			if(i< items_name.length-1){
				System.out.println("-----------------------------------------|");
			}
		}
		System.out.println("=========================================");
	}

	public void purchase() throws Exception{
		int sno,qty;
		Scanner M = new Scanner(System.in);
		System.out.println("Enter the Serial Number:");
		sno = M.nextInt();
		if(sno > items_name.length || sno < 1){
			throw new ArithmeticException("The Serial Number Is Not A Valid One");
		}
		System.out.println("Enter the Quantity:");
		qty = M.nextInt();
		if(break_items[sno-1][0] < qty){
			throw new ArrayIndexOutOfBoundsException("Stock Is Very Less");
		}
		break_items[sno-1][0] -= qty;
		total+=(break_items[sno-1][1]*qty);
		System.out.println("Item Added :)\n\n");
	}

	public void generate_bill(){
		System.out.println("Amount :"+total);
	}
}

class Hotel{
	public static void main(String as[]){
		BreakFast b = new BreakFast();
		int ch=1;
		Scanner M = new Scanner(System.in);
		b.print_items();
		while(ch != 4){
			System.out.println("1.Add Item\n2.Bill\n3.Stock\n4.Exit");
			ch = M.nextInt();
			switch(ch){
				case 1:
					try{
						b.purchase();
					}
					catch(ArithmeticException e){
						System.out.println("The Serial Number Is Not A Valid One");
					}
					catch(ArrayIndexOutOfBoundsException e){
						System.out.println("Stock Is Very Less");
					}
					catch(Exception e){
						System.out.println("Some Error Occured In Our System");
					}
					break;
				case 2:
					System.out.println("Generating Bill");
					b.generate_bill();
					break;
				case 3:
					b.print_items();
					break;
				case 4:
					System.out.println("Thanks For Using Our System");
					break;
				default:
					System.out.println("Enter A Valid Choice");
			}
		}
	}
}