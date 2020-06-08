package com.nilrach.dsa.dynamicprog;

public class Knapsack
{

    // A utility function that returns maximum of two integers
    static int max(int a, int b) { return (a > b)? a : b; }

    // Returns the maximum value that can be put in a knapsack of capacity W
    static int knapSack(int W, int wt[], int val[]){
        int n = val.length;
        int i, w;
        int K[][] = new int[n+1][W+1];

        // Build table K[][] in bottom up manner
        for (i = 0; i <= n; i++)
        {
            for (w = 0; w <= W; w++)
            {
                if (i==0 || w==0)
                    K[i][w] = 0;
                else if (wt[i-1] <= w)
                    K[i][w] = max(val[i-1] + K[i-1][w-wt[i-1]], K[i-1][w]);
                else
                    K[i][w] = K[i-1][w];
            }
        }

        printMatrix(K);

        return K[n][W];
    }

    private static void printMatrix(int[][] k) {
        for (int[] rows : k) {

            for (int col : rows) {

                System.out.format("%5d", col);
            }
            System.out.println();
        }
    }


    public static void main(String args[])
    {
        int val[] = {10, 40, 30, 50};
        int wt[] = {5, 4, 6, 3};
        int W = 10;

        System.out.println(knapSack(W, wt, val));
    }
}

