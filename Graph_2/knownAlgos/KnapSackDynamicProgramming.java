package knownAlgos;

import java.util.ArrayList;

public class KnapSackDynamicProgramming {

	public static void knapSackCalc(int[] v, int[] w, int n, int cap) {
		
		//initialize all arrays needed
		
		ArrayList<Integer> keeper = new ArrayList<Integer>();	//array for the items we will keep
		int b[][] = new int[n + 1][cap + 1];	//matrix for calculating the benefit
		int k[][] = new int[n + 1][cap + 1];	//matrix for calculating the keepers

		for (int i = 0; i <= cap; i++) {	//set the first rows in a & b to 0 
			b[0][i] = 0;
			k[0][i] = 0;
		}
		
		//fill in a & b

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= cap; j++) {
				if (w[i - 1] <= j) {
					if ((b[i - 1][j]) < (b[i - 1][j - w[i - 1]] + v[i - 1])) {
						b[i][j] = (b[i - 1][j - w[i - 1]] + v[i - 1]);
						k[i][j] = 1;
					} else {
						b[i][j] = b[i - 1][j];
						k[i][j] = 0;
					}
				} else {
					b[i][j] = b[i - 1][j];
					k[i][j] = 0;
				}
			}
		}

		int item = n;

		for (int i = cap; i > 0; i--) {
			if (k[item][i] == 1) {
				keeper.add(item);
				break;
			}
			if (keeper.isEmpty() && item > 1 && i == 1) {
				item--;
				i = cap;
			}
		}

		int captmp = cap - w[item - 1];

		for (int i = item - 1; i > 0; i--) {
			if (k[i][captmp] == 1) {
				keeper.add(i);
				captmp -= w[i - 1];
			}

		}

		prinTheSack(keeper, v, w);
	}

	public static void prinTheSack(ArrayList<Integer> items, int[] v, int[] w) {

		if (items.isEmpty()) {
			System.out.println("No Solution Found");
		} else {
			int vtot = 0;
			int wtot = 0;
			int itot = items.size();

			System.out.println("Found solution:");
			for (int i = items.size(); i > 0; i--) {
				System.out.println("Item Nr.: " + items.get(i - 1) + " Benefit: " + v[items.get(i - 1) - 1] + " Weight: "
						+ w[items.get(i - 1) - 1]);
				vtot += v[items.get(i - 1) - 1];
				wtot += w[items.get(i - 1) - 1];
				items.remove(i - 1);
			} 

			System.out.println("Total:    " + itot + " Benefit: " + vtot
					+ " Weight: " + wtot);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] v = { 2, 4, 1, 6 };
		int[] w = { 1, 3, 4, 2 };

		int n = 4;
		int cap = 5;

		knapSackCalc(v, w, n, cap);

	}

}

