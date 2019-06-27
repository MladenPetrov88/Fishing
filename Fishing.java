import java.util.Scanner;

public class Fishing {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        int fishesPerDay = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();
        int counterFishes = 0;
        double profit = 0;
        double moneyToPay = 0;

        while(!input.equals("Stop"))
        {
            double fishKG = Double.parseDouble(scanner.nextLine());
            counterFishes++;
            int sumSymbols = 0;
            double sum = 0;

            for (int position=0; position < input.length(); position++)
            {
                char symbol = input.charAt(position);
                sumSymbols += symbol;
            }

            sum = sumSymbols / fishKG;

            if(counterFishes%3==0)
            {
                profit += sum;
            }
            else
            {
                moneyToPay += sum;
            }

            if (counterFishes == fishesPerDay)
            {
                System.out.println("Lyubo fulfilled the quota!");
                break;
            }

            input = scanner.nextLine();
        }

        boolean profitOrBill = profit >= moneyToPay;
        if (profitOrBill)
        {
            double leftMoney = profit - moneyToPay;
            System.out.printf("Lyubo's profit from %d fishes is %.2f leva.", counterFishes, leftMoney);
        }
        else
        {
            double lostMoney = moneyToPay - profit;
            System.out.printf("Lyubo lost %.2f leva today.", lostMoney);
        }
    }
}

