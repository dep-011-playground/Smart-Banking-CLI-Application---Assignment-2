import java.nio.charset.CharacterCodingException;
import java.util.Scanner;

public class BankingApp {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        final String CLEAR = "\033[H\033[2J";
        final String COLOUR_BLUE_BOLD = "\033[34;1m";
        final String COLOUR_GREEN_BOLD = "\033[32;1m";
        final String COLOUR_RED_BOLD = "\033[31;1m";
        final String RESET = "\033[0m";

        final String DASHBOARD = "💰 Welcome to Smart Banking App ";
        final String NEW_ACCOUNT = "Create New Account";
        final String DEPOSIT ="Deposit Money";
        final String WITHDRAW = "Withdraw Money";
        final String TRANSFER = "Transfer Money";
        final String CHECK_BALANCE = "Check Account Balance";
        final String DROP_ACCOUNT = "Drop Existing Account";


        String screen = DASHBOARD;

        String id="";
        String name;
        double deposit;

        String[][] bankDetails = new String[0][3];
        String yesNoOpp;

        loopMain:
        do{

            final String APP_TITLE = String.format("%s%s%s",
            COLOUR_BLUE_BOLD, screen, RESET);

            System.out.println(CLEAR);
            System.out.println("-".repeat(40));
            System.out.println(" ".repeat((40 - APP_TITLE.length() + 7)/2).concat(APP_TITLE));
            System.out.println("-".repeat(40));

            switch(screen){
                case DASHBOARD:
                System.out.println("\n[1]. Create new account");
                System.out.println("[2]. Deposit Money");
                System.out.println("[3]. Withdraw Money");
                System.out.println("[4]. Transfer Money");
                System.out.println("[5]. Check Account Balance");
                System.out.println("[6]. Drop existing account");
                System.out.println("[7]. Exit\n");
                System.out.print("Enter an option to continue > ");
                String option = scanner.nextLine().strip();
               

                if(option.isBlank()|| !Character.isDigit(option.charAt(0))){
                    System.out.printf("%sEnter a valied option%s", COLOUR_RED_BOLD,RESET);
                    break;
                }
                int optionInt = Integer.valueOf(option);
                yesNoOpp = scanner.nextLine().strip().toUpperCase();
                switch (optionInt){
                    case 1: screen = NEW_ACCOUNT; break;
                    case 2: screen = DEPOSIT; break;
                    case 3: screen = WITHDRAW; break;
                    case 4: screen = TRANSFER; break;
                    case 5: screen = CHECK_BALANCE; break;
                    case 6: screen = DROP_ACCOUNT; break;
                    case 7: System.exit(0); break;
                    default: continue;
                }
                break;

                case NEW_ACCOUNT:

                    // add id
                
                    System.out.printf("ID : SDB - %s\n", bankDetails.length+1);

                    // add name
                    loopAddname:
                    do{
                        System.out.print("Enter account holder's name: ");
                        name = scanner.nextLine();
                        if(name.isBlank()){
                            System.out.printf("%s%s%s",COLOUR_RED_BOLD,"Name can't be empty",RESET);
                            System.out.print("Do you want to enter name again? > Y/N: ");
                            yesNoOpp = scanner.nextLine().strip().toUpperCase();

                            if(yesNoOpp.equals("Y")){
                                System.out.println();
                                System.out.printf("ID : SDB - %s\n", bankDetails.length+1);
                                continue loopAddname;
                            }else{
                                screen = DASHBOARD;
                                continue loopMain;
                            }
                        }

                        for (int i = 0; i < name.length(); i++) {
                            if(!Character.isLetter(name.charAt(i))){
                                System.out.printf("%sInvalied name%s", COLOUR_RED_BOLD,RESET);
                                System.out.println();
                                System.out.printf("ID : SDB - %s\n", bankDetails.length+1);
                                continue loopAddname;
                            }
                        }
                        break;

                    }while(true);

                    //add deposit
                    loopAddDeposit:
                    do{
                    System.out.print("Enter Deposit amount: ");
                    deposit = scanner.nextDouble();
                    scanner.nextLine();

                    String depositString = String.valueOf(deposit);

                    for (int i = 0; i < depositString.length(); i++) {
                      if(Character.isLetter(depositString.charAt(i))){
                        System.out.printf("\"%sInvalied Entry%s\\n", COLOUR_RED_BOLD,RESET);
                        continue loopAddDeposit;
  
                    }else if(deposit<5000){
                        System.out.printf("%sInitial minimum deposit = 5000%s\n", COLOUR_RED_BOLD,RESET);
                        System.out.printf("ID : SDB - %s\n", bankDetails.length+1);
                        System.out.println("Name: "+ name);
                        continue loopAddDeposit;

                        }
                    
                    }
                     break;
                    } while(true);

                    //create temp array with +1 length
                    String[][] temp = new String[bankDetails.length+1][3];
                    
                    //enter data in new array
                    for (int i = 0; i < bankDetails.length; i++) {
                        temp[i][0]=bankDetails[i][0];
                        temp[i][1]=bankDetails[i][1];
                        temp[i][2]=bankDetails[i][2];
                    }

                    temp[temp.length-1][0]=id;
                    temp[temp.length-1][0]=name;
                    temp[temp.length-1][0]=String.valueOf(deposit);

                    bankDetails=temp;
                    System.out.println();
                    System.out.printf("%s%sAdded Successfully%s", COLOUR_GREEN_BOLD,name,RESET);
                    System.out.println("");
                    System.out.println("Do you want to add another account? Y/N");
                    yesNoOpp = scanner.nextLine().strip().toUpperCase();

                    if(yesNoOpp.equals("Y")){
                        screen=NEW_ACCOUNT;
                        continue;
                    }else{
                        screen=DASHBOARD;
                        continue;
                    }

                case DEPOSIT:


                case WITHDRAW:


                case TRANSFER:


                case CHECK_BALANCE:


                case DROP_ACCOUNT:


            

                
            }


        } while (true);

    }
}
