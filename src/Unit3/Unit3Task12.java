package Unit3;

import java.util.Random;
import java.util.Scanner;

public class Unit3Task12 {
    public static void main(String[] args) {
        Random random=new Random();
        Scanner scanner=new Scanner(System.in);
        int n=0;
        double sum=0;
        int count=0;
        do{
            System.out.printf("Введите размер массива: ");
            if(scanner.hasNextInt()){
                n=scanner.nextInt();
            }
            else{
                System.out.println("Введено недопустимое значение!");
                scanner.next();
            }
        }while(n<=0);
        int ms[]=new int[n];
        for(int i=0;i<n;i++){
            ms[i]=random.nextInt(10);
            System.out.printf(ms[i]+" ");
            if(i%2!=0||i==0){
                sum+=(double) ms[i];
                count++;
            }
        }
        if(sum!=0){
            sum/=(double) count;
        }

        System.out.println("\n"+sum);
    }
}
