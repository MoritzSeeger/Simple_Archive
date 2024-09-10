import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Simple_Archive {
    public static void main(String[] args) {
        String file_path_User_Data = "/Users/moritzseeger/Desktop/Archive/User_Data.txt";
        String file_path_Expenses = "/Users/moritzseeger/Desktop/Archive/Expenses.txt";
        String resetColor = "\u001B[0m";
        String blueColor = "\u001B[34m";

        try {
            FileWriter fileWriter_UserData = new FileWriter(file_path_User_Data, true);
            FileWriter fileWriter_Expenses = new FileWriter(file_path_Expenses, true);

            PrintWriter printWriter_UserData = new PrintWriter(fileWriter_UserData);
            PrintWriter printWriter_Expences = new PrintWriter(fileWriter_Expenses);

            System.out.println("What would you like to store in a file?");
            System.out.println("1. Store Personal Data");
            System.out.println("2. Track Expenses");
            System.out.println();
            System.out.println("Type 1 or 2 to choose an action.");
            Scanner scanner = new Scanner(System.in);
            int action = scanner.nextByte();
            scanner.nextLine();

            switch (action) {
                case 1:
                    String firstName, lastName, adress, email, birthdate, gender, notes;
                    int age;
                    System.out.print("Enter first name: ");
                    firstName = scanner.nextLine();
                    if (firstName.isEmpty()){
                        firstName = "/";
                    }
                    System.out.println();

                    System.out.print("Enter last name: ");
                    lastName = scanner.nextLine();
                    if (lastName.isEmpty()){
                        lastName = "/";
                    }
                    System.out.println();

                    System.out.print("Enter email: ");
                    email = scanner.nextLine();
                    if (email.isEmpty()){
                        email = "/";
                    }
                    System.out.println();

                    System.out.print("Enter adress: ");
                    adress = scanner.nextLine();
                    if (adress.isEmpty()){
                        adress = "/";
                    }
                    System.out.println();

                    System.out.print("Enter birthdate \"dd/mm/yyyy\": ");
                    birthdate = scanner.nextLine();
                    System.out.println();

                    do {
                        System.out.print("Enter gender: ");
                        System.out.println("\"female\" , \"male\" , \"divers\"");
                        gender = scanner.nextLine();
                    } while(!gender.equalsIgnoreCase("female") && !gender.equalsIgnoreCase("male") && !gender.equalsIgnoreCase("divers"));

                    System.out.print("Enter age: ");
                    age = scanner.nextShort();
                    scanner.nextLine();
                    System.out.println();

                    System.out.println("Enter notes: ");
                    notes = scanner.nextLine();
                    if (notes.isEmpty()){
                        notes = "/";
                    }
                    System.out.println();

                    System.out.println(blueColor+firstName+" "+lastName+resetColor+" data overview: ");
                    System.out.println("_____________________________");
                    personal_Data_Overview(firstName,lastName,email,adress,birthdate,gender,age,notes,printWriter_UserData);
                    printWriter_UserData.close();
                    break;
                case 2:
                    double transfer_Amount;
                    String date,iban_Input,name, payer, payee, purpose_of_use, kind_of_Transaction;

                    System.out.print("Name of Bankowner: ");
                    name = scanner.nextLine();
                    System.out.println();
                    char iban = '/';
                    System.out.print("Date of transaction \"dd/mm/yyyy\": ");
                    date = scanner.nextLine();
                    System.out.println();
                    if (date.isEmpty()){
                        System.out.println("Important note, u cant leave the date blank!");
                        System.out.print("Date: ");
                        date = scanner.nextLine();
                    }

                    System.out.print("Payer: ");
                    payer = scanner.nextLine();
                    System.out.println();
                    if (payer.isEmpty()){
                        System.out.println("Important note, u cant leave the date blank!");
                        System.out.print("Payer: ");
                        payer = scanner.nextLine();
                    }

                    System.out.print("Iban: ");
                    iban_Input = scanner.nextLine();
                    System.out.println();
                    if (iban_Input.isEmpty()){
                        System.out.println("Important note, u cant leave the iban blank!");
                        System.out.print("Iban: ");
                        iban_Input = scanner.nextLine();
                    }

                    System.out.print("Purpose of use: ");
                    purpose_of_use = scanner.nextLine();
                    System.out.println();
                    if (date.isEmpty()){
                        purpose_of_use = "/";
                    }

                    System.out.print("Payee: ");
                    payee = scanner.nextLine();
                    System.out.println();
                    if (payee.isEmpty()){
                        System.out.println("Important note, u cant leave the payee blank!");
                        System.out.print("Payee: ");
                        payee = scanner.nextLine();
                    }

                    if (payer.equalsIgnoreCase(name)){
                        kind_of_Transaction = "expense";
                    } else if (payee.equalsIgnoreCase(name)){
                        kind_of_Transaction = "revenue";
                    }else {
                        System.out.println("Did you received or spend money?\nEnter \"Revenue\" or \"expense\":");
                        System.out.println();
                        kind_of_Transaction = scanner.nextLine();
                        System.out.println();
                        if (kind_of_Transaction.equalsIgnoreCase("expense")) {
                            kind_of_Transaction = "expense";
                        } else if (kind_of_Transaction.equalsIgnoreCase("revenue")) {
                            kind_of_Transaction = "revenue";
                        } else {
                            kind_of_Transaction = "N/A";
                        }
                    }

                    System.out.print("Transfer amount: ");
                    transfer_Amount = scanner.nextDouble();
                    scanner.nextLine();

                    printWriter_Expences.println("");
                    expenses_Tracker(iban,name, date, iban_Input, payer, payee, purpose_of_use,kind_of_Transaction, transfer_Amount,printWriter_Expences);
                    printWriter_Expences.close();

                    break;
            }

        } catch (IOException e) {
            System.out.println("Something went wrong!");
        }
    }
    public static void personal_Data_Overview(String firstName, String lastName, String email, String adress, String birthdate,String gender, int age, String notes,PrintWriter printWriter_UserData){
        System.out.println("First name: "+firstName+"\nLast name: "+lastName+"\nE-Mail: "+email+"\nAdress: "+adress+"\nBirthdate: "+birthdate+"\nGender: "+gender+"\nAge: "+adress+"\nNotes: "+notes);
        printWriter_UserData.println("Person: "+firstName+" "+lastName+": ");
        printWriter_UserData.println("__________________________");
        printWriter_UserData.println("Full name: "+firstName+" "+lastName);
        printWriter_UserData.println("First name: "+firstName);
        printWriter_UserData.println("Last name: "+lastName);
        printWriter_UserData.println("E-mail: "+email);
        printWriter_UserData.println("Adress: "+adress);
        printWriter_UserData.println("Birthdate: "+birthdate);
        printWriter_UserData.println("Gender: "+gender);
        printWriter_UserData.println("Age: "+age);
        printWriter_UserData.println("Notes: "+notes);
        printWriter_UserData.println();
        printWriter_UserData.println();
    }

    public static void expenses_Tracker(char iban,String name, String date, String iban_Input, String payer, String payee, String purpose_of_use, String kind_of_Transaction, double transfer_Amount, PrintWriter file_path_Expenses){
        file_path_Expenses.println("New Transaction");
        file_path_Expenses.println("______________________");
        if (kind_of_Transaction.equalsIgnoreCase("revenue")){
            file_path_Expenses.println("You received +"+transfer_Amount+"€"+" from "+payer);
            file_path_Expenses.println("Date: "+date);
            file_path_Expenses.println("Payer: "+payer);
            file_path_Expenses.print("IBAN: ");
            for (int i = 0; i < iban_Input.length(); i++){
                if (i % 4 == 0 && i != 0){
                    file_path_Expenses.print(" ");
                }
                iban = iban_Input.charAt(i);
                file_path_Expenses.print(iban);
            }
            file_path_Expenses.println();
            file_path_Expenses.println("Purpose: "+purpose_of_use);
        } else if (kind_of_Transaction.equalsIgnoreCase("expense")) {
            file_path_Expenses.println("You send -"+transfer_Amount+"€"+" to "+payee);
            file_path_Expenses.println("Date: "+date);
            file_path_Expenses.println("Payer: "+payer);
            file_path_Expenses.print("IBAN: ");
            for (int i = 0; i < iban_Input.length(); i++){
                if (i % 4 == 0 && i != 0){
                    file_path_Expenses.print(" ");
                }
                iban = iban_Input.charAt(i);
                file_path_Expenses.print(iban);
            }
            file_path_Expenses.println();
            file_path_Expenses.println("Purpose: "+purpose_of_use);
        }
        file_path_Expenses.println();
        file_path_Expenses.println();
    }
}
