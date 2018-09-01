package codytest;

import java.util.Scanner;

public class driver {

    public static void main(String args[]){


        int counter = 1;
        int flag = 0;
        int numberChoices[];
        int uniqueNumbers[];
        Scanner input;


        numberChoices = new int[4];
        uniqueNumbers = new int[5];
        input = new Scanner(System.in);

        for(int i=0; i<=4; i++){


            System.out.println("Enter an integer between 10 and 100:");
            numberChoices[i] = input.nextInt();
            if(i == 0){
                uniqueNumbers[counter] = numberChoices[i];
                
                System.out.println("This is the first time "+numberChoices[i]+" has been entered");
            }
            if(i !=0){

            for(int j=0; j<i; j++){
               flag = 0;
            	if(numberChoices[i] == numberChoices[j]){
                    flag=0;
            		break;
                }
                else{
                    uniqueNumbers[counter] = numberChoices[i];
                    flag = 1;
                   
                    
            }

            
            }
            if (flag == 1){
                System.out.println("This is the first time "+numberChoices[i]+" has been entered");
                counter++;
                
            }
           

        }
    }

        System.out.println("The complete set of unique values entered is: ");
        for(int k = 0; k < counter; k++)
            System.out.println("Unique Value "+(k+1)+": is " +uniqueNumbers[k]); 
    }
}