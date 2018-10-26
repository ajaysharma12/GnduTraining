package com.gndu.islabs0002.intro;

public class HelloWorld {

	static public void main(String args[]){
		System.out.println("Hello World");
		

		String str1 = "amritsar";
		String str2 = "amritsar";
		
//		if(str1.equals(str2)){
		
		if(str1 == str2){
			System.out.println("equals");
		}else{
			System.out.println("not equals");
		}
		
//		int tableOf2 = 2;
//		for(int i=1; i<=10; i++){
//			System.out.println("");
//			printTable(tableOf2, i);
//			System.out.println("");
//		}	
	}
	
	private static void printTable(int i, int j){
		System.out.println(i*j);
		
		
	}
}
