package me.tommy;

import javax.swing.*;   //imports Swing package
import java.io.*;   //imports io package

public class Register {     //creating a Register class

    static String[] itemName = new String[0];   //declaring and initializing a global String array
    static double[] itemPrice = new double[0];  //declaring and initializing a global double array
    static int[] itemSupply = new int[0];       //declaring and initializing a global int array
    static int size = 0;       //declaring and initializing a global int
    static double total = 0;    //declaring and initializing a global double

    public static String[] split(String line, char c) {     //defining split method with parameters string and char
        String[] spliter = new String[1];       //declaring and initializing a String array with a size of 1
        int i;      //declaring an int
        int begin = 0;      //declaring and initializing an int variable
        for (i = 0; i < line.length(); i++) {       //for loop from 0 to length of line - 1
            if (line.charAt(i) == c) {      //if the char at i is equal to the char
                String word = "";       //declaring an initializing a String variable
                for (int j = begin; j < i; j++) {       //for loop from begin to i - 1
                    word += line.charAt(j);     //adding the char to the word
                }   //end of for loop
                begin = i + 1;  //reassigning variable to i + 1
                spliter = ArraySizeIncrease(spliter,1);//increases the size of the array by one
                spliter[spliter.length - 2] = word;     //sets the element at second last index to the word
            }   //end of if statement
        }   //end of for loop
        String word = "";       //declaring an initializing a String variable
        for (int j = begin; j < i; j++) {       //for loop from begin to i - 1
            word += line.charAt(j);     //adding the char to the word
        }   //end of for loop
        spliter[spliter.length - 1] = word;     //sets the element at the last index to the word
        return spliter;     //returns the array
    }   //end of split method

    static int index(String str) {      //defining index method with parameter string
        for (int i = 0; i < size; i++) {    //for loop from 0 to size - 1
            if (str != null && str.equalsIgnoreCase(itemName[i])) {     //if the string is not null and equals to the element of itemName at index i
                return i;   //returns i
            }   //end of if statement
        }   //end of for loop
        return 0;   //returns 0
    }   //end of index method
    public static void listReader(File file) {      //defining listReader method
        try {   //tries the following code
            BufferedReader reader = new BufferedReader(new FileReader(file));   //creates a BufferedReader object for reading file
            String line = reader.readLine();    //declaring and initializing a String variable from readline method
            String[] itemClass;     //declaring a String array
            int i;  //declaring an int
            for (i = 1; line != null; i++) {    //for loop until line is equal to null
                itemName = ArraySizeIncrease(itemName, 1);  //increases itemName size by 1
                itemPrice = ArraySizeIncrease(itemPrice, 1);    //increases itemPrice size by 1
                itemSupply = ArraySizeIncrease(itemSupply, 1);  //increases itemSupply size by 1
                itemClass = split(line, '~');   //initializing and populating array with item name, item price, and item supply from the split method of line
                itemName[i - 1] = itemClass[0];     //populates the array at the index with the item name
                itemPrice[i - 1] = Double.parseDouble(itemClass[1]);    //populates the array at the index with the item price
                itemSupply[i - 1] = Integer.parseInt(itemClass[2]);     //populates the array at the index with the item supply
                line = reader.readLine();   //reassigns variable from readline method
            }   //end of try statement
            size = i - 1;   //reassigns variable with the size of the arrays
        } catch (Exception e) {     //catches all exceptions
            e.printStackTrace();       //prints stack
        }   //end of catch statement
    }   //end of listReader method

    public static void swap (String [] arr, int a, int b) {     //defining swap method with parameters String array, int, int
        String temp = arr[a];   //declaring and initializing a String from array at index
        arr[a] = arr[b];    //reassigning the first variable at the index with the second variable
        arr[b] = temp;      //reassigning the second variable at the index with the temp variable
    }   //end of swap method

    public static void swap (double [] arr, int a, int b) {     //overloading swap method with parameters double array, int, int
        double temp = arr[a];   //declaring and initializing a double from array at index
        arr[a] = arr[b];    //reassigning the first variable at the index with the second variable
        arr[b] = temp;      //reassigning the second variable at the index with the temp variable
    }   //end of swap method

    public static void swap (int [] arr, int a, int b) {        //overloading swap method with parameters int array, int, int
        int temp = arr[a];  //declaring and initializing a String from array at index
        arr[a] = arr[b];    //reassigning the first variable at the index with the second variable
        arr[b] = temp;      //reassigning the second variable at the index with the temp variable
    }   //end of swap method

    public static String[] ArraySizeIncrease(String[] arr, int increase) {      //defining ArraySizeIncrease method with parameters String array, int
        String[] temp = arr;      //declaring, initializing, and populating a String array with the input array
        arr = new String[temp.length + increase];   //initializing input array with a size of current size + increase
        for (int i = 0; i < temp.length; i++) {     //for loop from 0 to array length - 1
            arr[i] = temp[i];       //populating at the index with String at the index of temp array
        }   //end of for loop
        return arr;     //returns the array
    }   //end of ArraySizeIncrease method

    public static double[] ArraySizeIncrease(double[] arr, int increase) {      //overloading ArraySizeIncrease method with parameters double array, int
        double[] temp = arr;    //declaring, initializing, and populating a double array with the input array
        arr = new double[temp.length + increase];   //declaring and initializing input array with a size of current size + increase
        for (int i = 0; i < temp.length; i++) {     //for loop from 0 to array length - 1
            arr[i] = temp[i];   //populating at the index with double at the index of temp array
        }   //end of for loop
        return arr;     //returns the array
    }   //end of ArraySizeIncrease method

    public static int[] ArraySizeIncrease(int[] arr, int increase) {        //overloading ArraySizeIncrease method with parameters int array, int
        int[] temp = arr;   //declaring, initializing, and populating an int array with the input array
        arr = new int[temp.length + increase];  //declaring and initializing input array with a size of current size + increase
        for (int i = 0; i < temp.length; i++) {     //for loop from 0 to array length - 1
            arr[i] = temp[i];   //populating at the index with int at the index of temp array
        }   //end of for loop
        return arr;     //returns the array
    }   //end of ArraySizeIncrease method

    public static int loginpage() {     //defining loginpage method
        String user;    //declaring a String
        String[] login = {"admin", "supplier"};     //declaring, initializing, and populating array
        do {    //do while loop for login
            user = JOptionPane.showInputDialog(null, "Please enter your username.");    //initializing the String from input dialog
            if (user != null && user.equals(login[0])) {    //if the user is not null and equal to admin
                String password;    //declaring a String
                do {    //do while loop until correct password is entered
                    password = JOptionPane.showInputDialog(null, "Please enter your password.");    //initializing the String from input dialog
                    if (password.equals("mystore123")) {    //if the password equals mystore123
                        return 0;   //returns 0
                    }   //end of if
                    JOptionPane.showMessageDialog(null, "Incorrect password");  //prints if password is incorrect
                } while (true); //end of do while loop
            }   //end of if
            if (user != null && user.equals(login[1])) {    //if the user is not null and equal to supplier
                String password;    //declaring a String
                do {    //do while loop until correct password is entered
                    password = JOptionPane.showInputDialog(null, "Please enter your password.");    //initializing the String from input dialog
                    if (password.equals("igivestocks")) {   //if the password equals igivestocks
                        return 1;   //returns 1
                    }   //end of if
                    JOptionPane.showMessageDialog(null, "Incorrect password");  //prints if password is incorrect
                } while (true); //end of do while loop
            }   //end of if
        } while (user != null);     //end of do while
        return -1;  //returns -1
    }   //end of loginpage method

    public static int login() {     //defining login method
        String[] administrator = {"Customer", "Supplier", "Administrator"};     //declaring, initializing, and populating a String array
        return JOptionPane.showOptionDialog(null, "I am a", "Login Menu", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, administrator, administrator[0]);     //returns an int from asking user for their level of authority
    }   //end of login method

    public static void admin(int auth) {    //defining admin method with parameter int
        String[] options = new String[0];   //declaring and initializing a String array with size 0
        String title = "";  //declaring and initializing a String
        if (auth == 0) {    //if the person is an admin
            options = new String[]{"Increase Supply", "Decrease Supply", "Add Item", "Remove Item", "Change Price",};   //reinitializing and populating String array
            title = "Administrator";    //reassigning the String
        } //end of if
        else if (auth == 1) {     //else if the person is a supplier
            options = new String[]{"Increase Supply", "Decrease Supply"};   //reinitializing and populating String array
            title = "Supplier";     //reassigning the String
        }   //end of else if
        else {    //else if the person is neither
            System.exit(1);     //ends the program
        }   //end of if
        int repeat;     //declaring an int
        String special = "";    //declaring and initializing a String
        do {    //do while loop for administrator/supplier controls
            int control = JOptionPane.showOptionDialog(null, "What do you want to do?", title, JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);    //returns an int from asking user for their actions
            if (control == 0) {     //if the action is increasing supply
                String name = (String) JOptionPane.showInputDialog(null, "What do you want to increase the inventory of?", title, JOptionPane.PLAIN_MESSAGE, null, itemName, null); //declaring and initializing a String from input dialog
                int increase = Integer.parseInt(JOptionPane.showInputDialog(null, "How many do you want to add?")); //declaring and initializing an int from input dialog
                int newInv = increaseSupply(name, increase);    //declaring and initializing an int and increases supply from the method
                special = "New inventory of " + name + ": " + newInv;   //reassigning String
            }   //end of if
            if (control == 1) {     //if the action is removing item supply
                String name = (String) JOptionPane.showInputDialog(null, "What do you want to remove the inventory of?", title, JOptionPane.PLAIN_MESSAGE, null, itemName, null);   //declaring and initializing a String from input dialog
                int newInv = delSupply(name);   //declaring and initializing an int and decrease supply from the method
                special = "New inventory of " + name + ": " + newInv;   //reassigning String
            }   //end of if
            if (control == 2) {     //if the action is adding item
                String name = JOptionPane.showInputDialog(null, "What item do you want to add?");   //declaring and initializing a String from input dialog
                double newprice = Double.parseDouble(JOptionPane.showInputDialog(null, "What is the price?"));  //declaring and initializing a double from input dialog
                int newsupply = Integer.parseInt(JOptionPane.showInputDialog(null, "What is the inventory?"));  //declaring and initializing an int from input dialog
                addItem(name, newprice, newsupply); //adds item with addItem method given name, newprice, and newsupply
                special = name + " has been added.\nPrice: " + newprice + "\n" + "Inventory: " + newsupply; //reassigning String
            }   //end of if
            if (control == 3) {     //if the action is removing item
                String name = (String) JOptionPane.showInputDialog(null, "What do you want to remove?", title, JOptionPane.PLAIN_MESSAGE, null, itemName, null);    //declaring and initializing a String from input dialog
                delItem(name);  //removes item wih delItem method given name
                special = name + " has been removed.";  //reassigning String
            }   //end of if
            if (control == 4) {     //if the action is changing price
                String name = (String) JOptionPane.showInputDialog(null, "What item do you want to change the price of?", title, JOptionPane.PLAIN_MESSAGE, null, itemName, null);  //declaring and initializing a String from input dialog
                double newprice = Double.parseDouble(JOptionPane.showInputDialog(null, "What is the new price?"));  //declaring and initializing a double from input dialog
                changePrice(name, newprice);    //changes price of item with changePrice method given name and newprice
                special = "New price of " + name + ": " + newprice; //reassigning String
            }   //end of if
            repeat = JOptionPane.showConfirmDialog(null, special + "\nDo you want to do anything else?", title, JOptionPane.YES_NO_OPTION); //asks the user if they want to continue
        } while (repeat == 0);  //end of do while loop
    }   //end of admin method

    public static String[] buy(String[] purchase) { //defining buy method with parameter String array
        int pos;    //declaring an int
        String str; //declaring a String
        do {    //do while loop to check for item's supply
            str = (String) JOptionPane.showInputDialog(null, "What do you want to buy?", "Shopping List", JOptionPane.PLAIN_MESSAGE, null, itemName, null); //initializing variable with String from input dialog
            pos = index(str);   //initializing variable with int from index method
            if (itemSupply[pos] == 0) {     //if itemSupply is 0
                JOptionPane.showMessageDialog(null, "Sorry! " + str + " is currently out of stock.");   //prints out of stock message
            }   //end of if
        } while (itemSupply[pos] == 0); //end of do while
        int k = 0;  //declaring and initializing int
        boolean found = false;  //declaring and initializing boolean
        if (purchase.length > 3) {  //if shopping list is less than 1
            for (k = 0; k < purchase.length && !found; k += 3) {    //for loop from 0 to purchase length - 1
                if (purchase[k].contains(str)) {    //if shopping list contains str
                    found = true;   //reassigns boolean
                }   //end of if
            }   //end of for loop
            k -= 3; //decreases int by 3
        }   //end of if
        int a = 0;  //declaring and initializing int
        int b = 1;  //declaring and initializing int
        int c = 2;  //declaring and initializing int
        if (!purchase[a].equals("") && !found) {    //if item is not found in shopping list
            purchase = ArraySizeIncrease(purchase, 3);  //increases shopping list size by 1
            a = purchase.length - 3;    //decreases int by 3
            b = a + 1;  //reassigning int
            c = b + 1;  //reassigning int
        }   //end of if
        purchase[a] = str;  //populating element at last index with str
        int amount; //declaring an int
        do {    //do while loop for inventory
            amount = Integer.parseInt(JOptionPane.showInputDialog(null, "How many do you want to buy?\nThe inventory is: " + itemSupply[pos])); //initializing variable with int from input dialog
            if (amount > itemSupply[pos]) {     //if amount is greater than supply
                JOptionPane.showMessageDialog(null, "Sorry! We do not have that much inventory.");  //prints amount requested is less than inventory
            }   //end of if
        } while (amount > itemSupply[pos]); //end of do while
        double cost = itemPrice[pos] * amount;  //declaring and initializing double

        if (found) {    //if an item is found in shopping list
            int oldAmount = Integer.parseInt(purchase[k + 1]); //declaring and initializing int
            purchase[k + 1] = String.valueOf(amount + oldAmount);   //repopulating element at index with amount
            purchase[k + 2] = String.valueOf((amount + oldAmount) * itemPrice[pos]);     //repopulating element at index with cost
        }   //end of if
        else {  //else
            purchase[b] = String.valueOf(amount);    //populating element at index with amount
            purchase[c] = String.valueOf(cost);      //populating element at index with amount
        }
        total = (double) Math.round((total + cost) * 100) / 100D;   //reassigning global double
        itemSupply[pos] -= amount;  //decreasing item supply at index
        String itemList = "";   //declaring and initializing String
        for (int i = 0; i < purchase.length; i += 3) {  //for loop from 0 to shopping list length - 1
            itemList += purchase[i] + " x " + purchase[i + 1] + "   $" + purchase[i + 2] + "\n";    //adds to itemList
        }   //end of for
        int repeat = JOptionPane.showConfirmDialog(null, "Subtotal: $" + total + "\nWould you like to buy something else?\nYour Shopping List:\n" + itemList, "Shopping List", JOptionPane.YES_NO_OPTION);  //initializing variable with int from input dialog
        if (repeat == 0) {  //if the user want to continue
            return buy(purchase);   //returns recursively
        } //end of if
        else {  //else
            return purchase;    //return purchase
        }   //end of else
    }   //end of buy method

    public static void addItem(String str, double price, int supply) {  //defining addItem method with parameter String, double, and supply
        size += 1;  //increases size by 1
        itemName = ArraySizeIncrease(itemName, 1);
        itemPrice = ArraySizeIncrease(itemPrice, 1);
        itemSupply = ArraySizeIncrease(itemSupply, 1);
        //increases all arrays by 1
        itemName[size - 1] = str;
        itemPrice[size - 1] = price;
        itemSupply[size - 1] = supply;
        //populates the element at the last index with item name, price, and supply
    }   //end of addItem method

    public static void delItem(String str) {    //defining delItem method with parameter String
        size -= 1;  //decreases size by 1
        int pos = index(str);   //declaring and initializing an int by index method
        String[] nameTemp = itemName;   //declaring, initializing and populating a String array
        double[] priceTemp = itemPrice; //declaring, initializing and populating a double array
        int[] supplyTemp = itemSupply;  //declaring, initializing and populating a int array
        itemName = new String[size];    //reinitializing a String array
        itemPrice = new double[size];   //reinitializing a double array
        itemSupply = new int[size]; //reinitializing a int array
        for (int i = 0; i < pos; i++) { //for loop from 0 to pos - 1
            itemName[i] = nameTemp[i];
            itemPrice[i] = priceTemp[i];
            itemSupply[i] = supplyTemp[i];
            //copies each element from temporary arrays to itemName, itemPrice, and itemSupply arrays
        }   //end of for loop
        for (int i = pos + 1; i < size + 1; i++) {  //for loop from pos + 1 to size
            itemName[i - 1] = nameTemp[i];
            itemPrice[i - 1] = priceTemp[i];
            itemSupply[i - 1] = supplyTemp[i];
            //moves all the elements down one index by populating those indexes
        }   //end of for loop
    }   //end of delItem method

    public static void changePrice(String str, double price) {  //defining changePrice method with parameters String and double
        int pos = index(str);   //declaring and initializing an int from index method
        itemPrice[pos] = price; //reassigning  element ath the index with double
    }   //end of changePrice method

    public static int increaseSupply(String str, int increase) {    //defining increaseSupply method with parameters String and int
        int pos = index(str);    //declaring and initializing an int from index method
        itemSupply[pos] += increase;    //increases element at the index by the int
        return itemSupply[pos]; //returns the item supply
    }   //end of increaseSupply method

    public static int delSupply(String str) {    //defining increaseSupply method with parameter String
        int pos = index(str);    //declaring and initializing an int from index method
        itemSupply[pos] = 0;    //reassigning element at the index to 0
        return itemSupply[pos]; //returns the item supply
    }   //end of delSupply method

    public static void updateFile(File file) {  //defining updateFile method with parameter file
        try {   //tries the following code
            FileWriter reset = new FileWriter(file);    //creates FileWriter object
            BufferedWriter writer = new BufferedWriter(new FileWriter(file, true)); //creates BufferedWriter object
            reset.write("");    //clears the file
            reset.close();  //closes the writer
            for (int i = 0; i < size; i++) {    //for loop from 0 to size - 1
                for (int j = 0; j < size - 1; j++) {    //for loop for 0 to size - 2
                    if (itemName[j].compareToIgnoreCase(itemName[j + 1]) > 0) { //if itemName at j is greater than itemName at j + 1 by lexicographical order
                        swap(itemName,j,j+1);   //swap elements at j and j + 1 in itemName
                        swap(itemPrice,j,j+1);  //swap elements at j and j + 1 in itemPrice
                        swap(itemSupply,j,j+1); //swap elements at j and j + 1 in itemSupply
                    }   //end of if
                }   //end of for loop

            }   //end of for loop

            for (int i = 0; i < size; i++) {    //for loop from 0 to size -1
                writer.write(itemName[i] + "~" + itemPrice[i] + "~" + itemSupply[i] + "\n");    //writes the item name, price, and supply in a format
            }
            writer.close(); //closes the writer
        } catch (Exception e) { //catches all exceptions
            e.printStackTrace();    //prints stack
        }
    }

    public static void main(String[] args) {    //defining main method
        File items = new File("items.txt"); //creating File object with pathname items.txt
        listReader(items);  //reads from original .txt and prints onto new .txt
        int id = login();   //declaring and initializing an int from login method
        if (id == 0 || id == JOptionPane.CLOSED_OPTION) {   //if the user is a customer or closes program
            String[] initial = {"", "0", "0"};  //declaring, initializing, and populating a String array
            String[] finalList = buy(initial);  //declaring, initializing, and populating a String array from buy method with inital method
            String list = "";   //declaring and initializing a String
            for (int i = 0; i < finalList.length; i += 3) {     //for loop from 0 to shopping list length - 1
                list += finalList[i] + " x " + finalList[i + 1] + "   $" + finalList[i + 2] + "\n"; //adds String to the String
            }
            total = total * 1.13;   //reassigning global double
            JOptionPane.showMessageDialog(null, "Your Shopping List:\n" + list + "\nYour total is: $" + (double) Math.round(total * 100) / 100D);   //prints final shopping list
        } //end of if
        else {  //else
            admin(loginpage()); //opens control panel with the login page method
        }   //end of else
        updateFile(items);  //updates item list
    }   //end of main method
}   //end of class