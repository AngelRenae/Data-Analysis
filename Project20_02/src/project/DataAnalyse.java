package project;

import java.util.Scanner;

public class DataAnalyse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int samSize, j, i;
		double min = 0.0, max = 0.0;


		double[] triAvgs = new double[4];

		double tri1Total = 0;
		double tri2Total = 0;
		double tri3Total = 0;
		double tri4Total = 0;

		Scanner input = new Scanner(System.in);

		System.out.print("Please enter the sample size: ");
		samSize = input.nextInt();

		int[] tri1 = new int[samSize];
		int[] tri2 = new int[samSize];
		int[] tri3 = new int[samSize];
		int[] tri4 = new int[samSize];

		// ----------------------------------------------------------------	RECORDING THE SAMPLES

		for(j = 0; j < 4; j++) {									// loops until j (trials) = 4
			System.out.println("Enter numbers for Trial " + (j+1)); // j+1 is trial number.
			// prints out the trial number
			for(i = 0; i < samSize; i++) {							// loops until i = sample size
				System.out.print("Enter sample #" + (i+1) +": ");   // i+1 is sample number being recorded

				switch (j) {										// takes j (trial number) to check which array to record in
				case 0:												// trial 1 array
					tri1[i] = input.nextInt();						// places sample i number in j (trial #) in i slot
					break;
				case 1:												// trial 2 array
					tri2[i] = input.nextInt();
					break;
				case 2:												// trial 3 array
					tri3[i] = input.nextInt();
					break;
				case 3:												// trial 3 array
					tri4[i] = input.nextInt();
					break;
				}

			}	
			System.out.println("");
		}

		// ----------------------------------------------------------------	CALCULATING AVERAGES

		for(j = 0; j < 4; j++) {									// loops until j (trials) = 4

			for(i = 0; i < samSize; i++) {							// loops until i = sample size

				switch (j) {										// takes j (trial number) to check which array to record in
				case 0:												// trial 1 array
					tri1Total += tri1[i];							// adds sample i number in j (trial #) total trial j total
					break;
				case 1:												// trial 2 array
					tri2Total += tri2[i];
					break;
				case 2:												// trial 3 array
					tri3Total += tri3[i];
					break;
				case 3:												// trial 3 array
					tri4Total += tri4[i];
					break;
				}

			}	
		}

		triAvgs[0] = tri1Total / samSize;
		triAvgs[1] = tri2Total / samSize;
		triAvgs[2] = tri3Total / samSize;
		triAvgs[3] = tri4Total / samSize;

		// ----------------------------------------------------------------	FINDING MIN/MAX

		min = triAvgs[0];
		max = triAvgs[0];
		for(i = 1; i < triAvgs.length; i++) {
			if(triAvgs[i] > max) {
				max = triAvgs[i];
			}

			if(triAvgs[i] < min) {
				min = triAvgs[i];
			}
		}

		// ----------------------------------------------------------------	PRINTING INFORMATION

		System.out.println("\tSample # \tTrial 1 \tTrial 2 \tTrial 3 \tTrial 4");
		for(i = 0; i < samSize; i++) {
			System.out.println("\t" + (i + 1) + " \t\t" + tri1[i] + " \t\t" + tri2[i] + " \t\t" + tri3[i] +" \t\t" + tri4[i]);
		}
		System.out.println("\t------------------------------------------------------------------------");
		System.out.println("Averages:\t\t" + triAvgs[0] + " \t\t" + triAvgs[1] + " \t\t" + triAvgs[2] + " \t\t" + triAvgs[3]);
		System.out.println("");

		System.out.println("Min Average: " + min);
		System.out.println("Max Average: " + max);

		System.out.println("");

		if(min == max) {
			System.out.println("The trials match EXACTLY!");
		} else if((min + 2) >= max) {
			System.out.println("The trials concur with each other!");
		} else {
			System.out.println("The trials do NOT concur!");
		}

		input.close();
	}

}
