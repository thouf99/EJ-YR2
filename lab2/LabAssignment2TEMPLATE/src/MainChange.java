import java.util.*;

public class MainChange {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean biggerPaid = false;

        double price = 0.00, paid= 0.00;

        while(!biggerPaid) {
            price = getMoneyInput("Enter the price in pounds and pence", in);
            paid = getMoneyInput("Enter the amount paid in pounds and pence", in);
            if(price > paid){
                System.out.println("You haven't paid enough!");
            }
            else{
                biggerPaid = true;
            }
        }

        System.out.println("price " + price);
        TreeMap<NotesAndCoins, Integer> changeComposition = calcChange(price, paid);

        for(NotesAndCoins n: changeComposition.keySet()){
            if(changeComposition.get(n) != 0){
                System.out.println(n.getName() + ": " + changeComposition.get(n));
            }
        }

    }

    //takes input from the user and ensures it is a double and returns a double with 2 decimal places
    //Question(String) is the prompt for user input and (in)scanner is collecting user input
    public static double getMoneyInput(String question, Scanner in) {
        boolean validInput = false;
        double amount = 0.00;
        //do this until the user enters a valid double
        while (!validInput) {
            System.out.println(question);
            try {
                amount = in.nextDouble();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input try again");
                in.next();
            }
        }
        //return the value entered fixed to 2dp
        return (double) ((int) (amount * 100)) / 100;
    }

    public static TreeMap<NotesAndCoins, Integer> calcChange(double price, double paid) {

        //COMPLETE THIS METHOD!!!
        //This method will return a TreeMap where the key is NotesAndCoins and the value is the number of each denomination to make up the change
        TreeMap<NotesAndCoins, Integer> a = new TreeMap<>(Collections.reverseOrder());
        double change = (paid - price) * 100;
        boolean flag = true;

        System.out.println("your change is: ");
        int count = 0;
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;
        int count4 = 0;
        int count5 = 0;
        int count6 = 0;
        int count7 = 0;
        int count8 = 0;
        int count9 = 0;
        int count10 = 0;

        //if change is 0 to return the tree otherwise create the change
        if (change != 0) {

            while (flag) {
                //flag will turn on and off for when different checks are needed and add that to the tree
                flag = false;
                if (change >= NotesAndCoins.POUND50.getValueInP()) {
                    flag = true;
                    count++;
                    change -= NotesAndCoins.POUND50.getValueInP();

                    a.put(NotesAndCoins.POUND50, count);
                }
                if (change >= NotesAndCoins.POUND20.getValueInP() && change < NotesAndCoins.POUND50.getValueInP()) {
                    flag = true;
                    count1++;
                    change -= NotesAndCoins.POUND20.getValueInP();
                    a.put(NotesAndCoins.POUND20, count1);
                }
                if (change >= NotesAndCoins.POUND10.getValueInP() && change < NotesAndCoins.POUND20.getValueInP()) {
                    flag = true;
                    count2++;
                    change -= NotesAndCoins.POUND10.getValueInP();
                    a.put(NotesAndCoins.POUND10, count2);
                }
                if (change >= NotesAndCoins.POUND5.getValueInP() && change < NotesAndCoins.POUND10.getValueInP()) {
                    flag = true;
                    count3++;
                    change -= NotesAndCoins.POUND5.getValueInP();
                    a.put(NotesAndCoins.POUND5, count3);
                }
                if (change >= NotesAndCoins.POUND2.getValueInP() && change < NotesAndCoins.POUND5.getValueInP()) {
                    flag = true;
                    count3++;
                    change -= NotesAndCoins.POUND2.getValueInP();
                    a.put(NotesAndCoins.POUND2, count3);
                }
                if (change >= NotesAndCoins.POUND1.getValueInP() && change < NotesAndCoins.POUND2.getValueInP()) {
                    flag = true;
                    count4++;
                    change -= NotesAndCoins.POUND1.getValueInP();
                    a.put(NotesAndCoins.POUND1, count4);
                }
                if (change >= NotesAndCoins.PENCE50.getValueInP() && change < NotesAndCoins.POUND1.getValueInP()) {
                    flag = true;
                    count5++;
                    change -= NotesAndCoins.PENCE50.getValueInP();
                    a.put(NotesAndCoins.PENCE50, count5);
                }
                if (change >= NotesAndCoins.PENCE20.getValueInP() && change < NotesAndCoins.PENCE50.getValueInP()) {
                    flag = true;
                    count6++;
                    change -= NotesAndCoins.PENCE20.getValueInP();
                    a.put(NotesAndCoins.PENCE20, count6);
                }
                if (change >= NotesAndCoins.PENCE10.getValueInP() && change < NotesAndCoins.PENCE20.getValueInP()) {
                    flag = true;
                    count7++;
                    change -= NotesAndCoins.PENCE10.getValueInP();
                    a.put(NotesAndCoins.PENCE10, count7);
                }
                if (change >= NotesAndCoins.PENCE5.getValueInP() && change < NotesAndCoins.PENCE10.getValueInP()) {
                    flag = true;
                    count8++;
                    change -= NotesAndCoins.PENCE5.getValueInP();
                    a.put(NotesAndCoins.PENCE5, count8);
                }
                if (change >= NotesAndCoins.PENCE2.getValueInP() && change < NotesAndCoins.PENCE5.getValueInP()) {
                    flag = true;
                    count9++;
                    change -= NotesAndCoins.PENCE2.getValueInP();
                    a.put(NotesAndCoins.PENCE2, count9);
                }
                if (change >= NotesAndCoins.PENCE1.getValueInP() && change < NotesAndCoins.PENCE2.getValueInP()) {
                    flag = true;
                    count10++;
                    change -= NotesAndCoins.PENCE1.getValueInP();
                    a.put(NotesAndCoins.PENCE1, count10);
                }
            }
        }
        return a;
    }

}




