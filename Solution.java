import java.util.*;
public class Solutions {

    public static void main(String[] args) {

        int[][][] dice = new int[6][6][2];
        int totalCombinations = 0;

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                dice[i][j][0] = i + 1;
                dice[i][j][1] = j + 1;
                totalCombinations++;
            }
        }
        System.out.println("The total no of combinations are : "+totalCombinations);

        System.out.println("The combinations are : ");
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                    System.out.print(Arrays.toString(dice[i][j])+" ");
            }
            System.out.println();
        }


        int[][] sumMatrix= new int[6][6];
        for(int i=0;i<6;i++){
            for(int j=0;j<6;j++){
                sumMatrix[i][j] = dice[i][j][0] + dice[i][j][1];
            }
        }

//        Code to print the sum Matrix
//        for(int i=0;i<6;i++) {
//            System.out.println(Arrays.toString(sumMatrix[i]));
//        }


        for(int sum=2;sum<=12;sum++){
            int count =0;
            for(int i=0;i<6;i++){
                for(int j=0;j<6;j++){
                    if(sumMatrix[i][j]==sum){
                        count++;
                    }
                }
            }
            String prob = String.valueOf(count)+"/"+String.valueOf(totalCombinations);
            System.out.println("Probability of dice having the sum "+sum+" is "+prob);
        }

    }
}
