package com.Self_Practice;

public class Main {

	public static void main(String[] args) {
		int[] num= {1,4,89,156,1400,78};

		int highest=num[0];
for(int i=0;i<num.length;i++) {
	if(num[i]>highest) {
	highest=num[i];
	}
}
System.out.println(highest);

	}

}
