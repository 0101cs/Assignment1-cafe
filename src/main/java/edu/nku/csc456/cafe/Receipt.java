package edu.nku.csc456.cafe;


import javax.swing.JTable;
import java.lang.String;
import java.util.Arrays;
import java.lang.StringBuilder;

public class Receipt implements Order{
	
	int taxRate;
	String[] order;
	String[][] receipt;
	double subtotal;
	double tax;
	double total;
	JTable table;
	
	//Constructor
	public Receipt( String[] order, int taxRate){
		this.taxRate = taxRate;
		computeOrder(order);		
		computeSubtotal();
		computeTax();
		computeTotal();
		buildTable(buildReceipt());
	}
	//displays table receipt
	public String displayReceipt(){
		StringBuilder sb = new StringBuilder();		
		sb.append(table);
		return sb.toString();
	}
	//places receipt into a pretty table
	public void buildTable(String[][] rec){		
		String[] test = {"", ""};
		table = new JTable( rec , test);
	}
	
	//appends subtotal, tax, and total to items ordered.
	//returns complete 2d receipt
	public String[][] buildReceipt(){ 
		String[][] temp = {{"",""},{"subtotal", "$"+subtotal}, {"tax", "$"+tax}, {"total", "$"+total}};				
        String[][] result = new String[receipt.length + temp.length][];
        System.arraycopy(receipt, 0, result, 0, receipt.length);
        System.arraycopy(temp, 0, result, receipt.length, temp.length);
        return result;
    }
	
	public void computeSubtotal(){
		int i = 0;		


		
		while(i < order.length-1){
			if( order[i] == "coffee")
				subtotal += 2.00;
			else if( order[i] == "cheese cake" )
				subtotal += 2.00;
			else if( order[i] == "donut" )
				subtotal += 1.00;
			else if( order[i] == "sandwich" )
				subtotal += 5.00;
			else if( order[i] == "tea" )
				subtotal += 1.00;
			i++;
		}
	}
	public void computeTax(){
		tax = subtotal * taxRate;
	}
	public void computeTotal(){
		total = subtotal + tax;
	}
	//computes what was ordered 
	public void computeOrder(String[] order){
		int n = 0;
		receipt = new String[order.length][2];
		while(n < order.length){
			switch(order[n].toString()){
				case "coffee": receipt[n][0] = "coffee";
								receipt[n][1] = "$2.00";
								n++;
								break;
				case "cheese_cake": receipt[n][0] = "cheese cake";
									receipt[n][1] = "$2.00";
									n++;
									break;
				case "donut": receipt[n][0] = "donut";
								receipt[n][1] = "$1.00";
								n++;
								break;
				case "sandwich": receipt[n][0] = "sandwich";
								receipt[n][1] = "$5.00";
								n++;
								break;
				case "tea": receipt[n][0] = "tea";
							receipt[n][1] = "$1.00";
							n++;
							break;
			}
		}
	}
}