
import java.util.Scanner;

public class Main{
    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);

        int[] billDenominations = {1000,500,100};
        int[] numOfBillsInATM = {2, 3, 5};

        boolean playing = true;

        while (playing){

            int userInputWithdraw;
            System.out.println("Enter amount to withdraw: ");
            userInputWithdraw = scan.nextInt();
            scan.nextLine();

            int withdrawAmount = 0;

            if(userInputWithdraw <= 0 || userInputWithdraw > 4000){
                System.out.println("Amount must be between 100 and 4000");
            }else if(ATMisEmpty(numOfBillsInATM) == true){
                System.out.println("ATM empty. Can't deposit");
            }else if(userInputWithdraw%100 != 0){
                System.out.println("Can only withdraw amount above 99");
            }
            else{
                for(int i = 0; i < billDenominations.length && userInputWithdraw != 0; i++){
                    if(userInputWithdraw >= billDenominations[i]){

                        if(userInputWithdraw/billDenominations[i] <= numOfBillsInATM[i]){
                            numOfBillsInATM[i] = numOfBillsInATM[i] - userInputWithdraw/billDenominations[i];

                            withdrawAmount = withdrawAmount + billDenominations[i];
                            System.out.println(billDenominations[i] + " notes left: " + numOfBillsInATM[i]);

                            userInputWithdraw = userInputWithdraw - billDenominations[i];

                            if(userInputWithdraw == 0){
                                System.out.println("Withdraw: " + withdrawAmount);
                                break;
                            }

                        }else if( userInputWithdraw/billDenominations[i] > numOfBillsInATM[i] ){
                            System.out.println("Not enough bills in this ATM to withdraw");
                        }
                    }
                }
            }
        }


    }//main end

    private static boolean ATMisEmpty(int[] intArray){

        int counter = 0;

        for (int i = 0; i < intArray.length; i++) {
            if(intArray[i] == 0){
                counter++;
            }
        }

        if(counter >= 3){
            return true;
        }else{
            return false;
        }
    }

}
