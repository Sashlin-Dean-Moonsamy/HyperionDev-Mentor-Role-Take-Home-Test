// Import Modules
import java.util.HashMap;
import java.util.Scanner;

// Declare Class
public class SayTheNumber {

    // Declare Hash Map Variables
    static HashMap<Integer, String> units = new HashMap<>();
    static HashMap<Integer, String> tens = new HashMap<>();
    static HashMap<Integer, String> teens = new HashMap<>();

    // Declare Main
    public static void main(String[] args) {

        // Declare Scanner Variable
        Scanner sc = new Scanner(System.in);

        // Declare Variable
        String userInput = null;

        // Declare Integer Arrays
        int[] singleDigit = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] doubleDigitTeens = {11, 12, 13, 14, 15, 16, 17, 18, 19};

        // Declare String Arrays
        String[] singleDigitWord = {"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
        String[] teensList = {"Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        String[] tensList = {"Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

        // Create For Loop To Loop Through String And Int Arrays
        for (int i = 0; i < singleDigit.length; i++) {
            units.put(singleDigit[i], singleDigitWord[i]);
            tens.put(singleDigit[i], tensList[i]);
            teens.put(doubleDigitTeens[i], teensList[i]);
        }

        // Create While Loop To Allow User To Repetitively Enter Values
        while (true){

            // Get Information From User, Store In Variable, Call sayNumber(userInput) And Print String To User.
            // Create Try Catch To Account For User Entering Incorrect Value.
            try {
                System.out.print("Enter A Number And I Shall Say It Back To You (Or Type 'stop' To Exit): ");
                userInput = sc.nextLine();
                System.out.println(sayNumber(userInput) + "\n");
            } catch (NumberFormatException e) {

                // If User Enters "stop" Break Out Of Loop
                // Else Display Appropriate Message To User
                if (userInput.equalsIgnoreCase("stop")){
                    break;
                }else{
                    System.out.println("You Have Entered An Incorrect Value, Please Try Again!\n");
                }
            }
        }
    }

    // Define sayNumber Function That Will Take In User Input As A Parameter And Return's The Number Entered In Word Form.
    private static String sayNumber(String number) {

        // Declare Variables
        String statement = null;

        // Convert The number Variable To A Long Value Then Convert It Back To A String To Remove "0" at beginning of string.
        number = String.valueOf(Long.parseLong(number));

        // Based On User's Input, Parse number Variable Into Appropriate Functions That Will Return The Appropriate String.
        if (number.length() == 1 || String.valueOf(Long.parseLong(number)).length() == 1) {
            statement = getSingleDigit(number);
        } else if (number.length() == 2) {
            statement = getDoubleDigits(number);
        } else if (number.length() == 3) {
            statement = getTripleDigits(number);
        } else if (number.length() == 4) {
            statement = getQuadruple(number);
        } else if (number.length() == 5) {
            statement = getPentuple(number);
        } else if (number.length() == 6) {
            statement = getSestuple(number);
        } else if (number.length() == 7) {
            statement = getSeptuple(number);
        } else if (number.length() == 8) {
            statement = getOctuple(number);
        } else if (number.length() == 9) {
            statement = getNonuple(number);
        } else if (number.length() == 10) {
            statement = getDecuple(number);
        } else if (number.length() == 11) {
            statement = getHendecuple(number);
        } else if (number.length() == 12) {
            statement = getDuoDecuple(number);
        } else if (number.length() == 13) {
            statement = getTreDecuple(number);
        } else if (number.length() == 14) {
            statement = getFourteenDigits(number);
        } else if (number.length() == 15) {
            statement = getFifteenthDigit(number);
        } else {
            statement = "Sorry This Program Can Only Accommodate Numbers That Are Up To 15 Digits long";
        }

        // Return statement Variable
        return statement;
    }

    // Define A Function That Takes In A Single Digit Of The String DataType And Returns The Number In Words.
    private static String getSingleDigit(String number) {

        // Declare variable
        String value = null;

        // If The Length Of The number is 1 Then get The Value From The units HashMap Data Structure And Return It
        if (number.length() == 1) {
            value = units.get(Integer.parseInt(number)) + ".";
        }
        return value;
    }

    // Define function That Will Take In A Double Digit Number Of The String Data Type And Returns The Number In Word Form.
    private static String getDoubleDigits(String number) {

        // If The First Value In The Sting Is Equal To 1
        if (number.indexOf("1") == 0) {

            // If The String Entered Is Equal To 10 Return Its Value In Word Form, From tens HashMap Data Structure
            // Else, Return The Value Of The Number That Was Parsed In teens HashMap Data Structure
            if (number.equals("10")) {
                return tens.get(1) + ".";
            } else {
                return teens.get(Integer.parseInt(number)) + ".";
            }
        }

        // Else, Return Value Of The Number That Was Parsed, In tens HashMap Data Structure
        else {

            // Define A Variable For The First Number In The String
            int numberTens = Integer.parseInt(String.valueOf(number.charAt(0)));

            // If 0 Is The Second Number In The String Is Equal TO "0", Return The Value Parsed In tens HashMao Data Structure
            // Else, Return Number And Units
            if (number.indexOf("0") == 1) {
                return tens.get(numberTens) + ".";
            } else {
                return tens.get(numberTens) + " " + units.get(Integer.parseInt(String.valueOf(number.charAt(1)))) + ".";
            }
        }
    }

    // Define Function That Will Take In A 3-Digit Number Of The String Data Type And Returns A Number In Words
    private static String getTripleDigits(String number) {

        // Define Variables
        int firstValue = Integer.parseInt(String.valueOf(number.charAt(0)));
        int lastValue = Integer.parseInt(String.valueOf(number.charAt(2)));
        String middle = String.valueOf(number.charAt(1));
        String lastTwo = number.charAt(1) + String.valueOf(number.charAt(2));
        String statement = null;

        // If Last Two Numbers Of String Is Equal To "00", Change Value Of Statement To The Appropriate Response
        // Else If The Middle Number Is "0", Change Value Of Statement To The Appropriate Response
        // ELse, Change Value Of Statement To The Appropriate Response With A Recursive Call
        if (lastTwo.equals("00")) {
            statement = units.get(firstValue) + " Hundred.";
        } else if (middle.equals("0")) {
            statement = units.get(firstValue) + " Hundred And " + units.get(lastValue) + ".";
        } else {
            statement = units.get(firstValue) + " Hundred And " + sayNumber(lastTwo);
        }

        // Return statement
        return statement;
    }

    // Define A Function That Takes In A 4-Digit Number Of The String Data Type And Returns That Number In Word Form.
    private static String getQuadruple(String number) {

        // Define Variables
        int firstValue = Integer.parseInt(String.valueOf(number.charAt(0)));
        String secondValue = String.valueOf(number.charAt(1));
        String lastTwo = number.charAt(2) + String.valueOf(number.charAt(3));
        String lastThree = number.charAt(1) + String.valueOf(number.charAt(2)) + number.charAt(3);
        String middle = number.charAt(1) + String.valueOf(number.charAt(2));
        String statement = null;

        // If The Last Three Numbers Of The String Are Equal To "000", Change Value Of Statement To The Appropriate Response.
        // Else If The Middle Numbers Are Equal To "00", Change Value Of Statement To The Appropriate Response With Recursive Call.
        // Else If The SecondValue Is Equal To "0", Change Value Of Statement To The Appropriate Response With Recursive Call.
        // Else, Change Value Of Statement To The Appropriate Response With Recursive Call.
        if (lastThree.equals("000")) {
            statement = units.get(firstValue) + " Thousand.";
        } else if (middle.equals("00")) {
            statement = units.get(firstValue) + " Thousand And " + sayNumber(lastThree);
        } else if (secondValue.equals("0")) {
            statement = units.get(firstValue) + " Thousand And " + sayNumber((lastTwo));
        } else {
            statement = units.get(firstValue) + " Thousand " + sayNumber((lastThree));
        }

        // Return Statement
        return statement;
    }

    // Define A Function That Takes in A 5-Digit Number And Returns The Number In Word Form.
    private static String getPentuple(String number) {

        // Declare Variables
        int firstValue = Integer.parseInt(String.valueOf(number.charAt(0)));
        String secondValue = String.valueOf(number.charAt(1));
        String firstTwo = number.charAt(0) + secondValue;
        String thirdValue = String.valueOf(number.charAt(2));
        String lastFour = number.charAt(1) + String.valueOf(number.charAt(2));
        lastFour += number.charAt(3) + String.valueOf(number.charAt(4));
        String lastThree = number.charAt(2) + String.valueOf(number.charAt(3)) + number.charAt(4);
        String statement = null;

        // If The Last Four Digits Of The String Data Type Are Equal To "0000", Change Value Of Statement To The Appropriate Response.
        // Else If The First Value Of The String Data Type Is Equal To 0, Change Value Of Statement To The Appropriate Response.
        // Else If The Second Value Of The String Data Type Is Equal To "0", Change Value Of Statement To The Appropriate Response With Recursive Call.
        if (lastFour.equals("0000")) {
            statement = tens.get(firstValue) + " Thousand.";
        } else if (firstValue == 0) {
            statement = sayNumber(lastFour);
        } else if (secondValue.equals("0")) {
            statement = tens.get(firstValue) + " Thousand And " + sayNumber(lastFour);
        }

        // Else If The Last Three Numbers From The String Data Type Are Equal To "000"
        else if (lastThree.equals("000")) {

            // If The First Value Of The Numbers From The String Data Type Is Equal To 1, Change Value Of Statement To The Appropriate Response.
            // Else, Change Value Of Statement To The Appropriate Response.
            if (firstValue == 1) {
                statement = teens.get(Integer.parseInt(firstTwo)) + " Thousand.";
            } else {
                statement = tens.get(firstValue) + " " + units.get(Integer.parseInt(secondValue)) + " Thousand.";
            }
        }

        // Else If The Third Number From The String Data Type Is Equal To "0", Change Value Of Statement To The Appropriate Response With Recursive Call.
        // Else If The First Value From The String Data Type Is Equal To 1, Change Value Of Statement To The Appropriate Response With Recursive Call.
        // Else, Change Value Of Statement To The Appropriate Response With Recursive Call.
        else if (thirdValue.equals("0")) {
            statement = tens.get(firstValue) + " " + units.get(Integer.parseInt(secondValue)) + " Thousand And " + sayNumber(lastThree);
        } else if (firstValue == 1) {
            statement = teens.get(Integer.parseInt(firstTwo)) + " Thousand, " + sayNumber(lastThree);
        } else {
            statement = tens.get(firstValue) + " " + units.get(Integer.parseInt(secondValue)) + " Thousand, " + sayNumber(lastThree);
        }

        // Return Statement
        return statement;
    }

    // Define Function That Takes In A 6-Digit Number As A Parameter And Returns The Number In Word Form
    private static String getSestuple(String number) {

        // Declare Variables
        int firstValue = Integer.parseInt(String.valueOf(number.charAt(0)));
        int secondValue = Integer.parseInt(String.valueOf(number.charAt(1)));
        int thirdValue = Integer.parseInt(String.valueOf(number.charAt(2)));
        int lastValue = Integer.parseInt(String.valueOf(number.charAt(5)));
        int thirdLast = Integer.parseInt(String.valueOf(number.charAt(3)));
        String secondAndThird = String.valueOf(number.charAt(1)) + number.charAt(2);
        String lastTwo = number.charAt(4) + String.valueOf(number.charAt(5));
        String forthAndFifth = number.charAt(3) + String.valueOf(number.charAt(4));
        String lastThree = forthAndFifth + number.charAt(5);
        String lastFour = number.charAt(2) + lastThree;
        String lastFive = number.charAt(1) + lastFour;
        String statement = null;

        // If The Second Number And The Third Number From The String Data Type And The Last Five Numbers Are Equal To "00000
        if ((secondValue == 0 && thirdValue == 0) && !lastFive.equals("00000")) {

            // If The Last 3 Numbers != 0  And The Forth And Fifth Numbers Are Equal To "0" Or The Last Two Values Are Equal To "0"
            // Change Value Of Statement To The Appropriate Response With Recursive Call.
            if (!lastThree.equals("000") && forthAndFifth.equals("00") || lastTwo.equals("10")) {
                statement = units.get(firstValue) + " Hundred Thousand And " + sayNumber(lastThree);
            }

            // If The Last 3 Numbers Of The String Data type == "000" And The Last Number == 0,
            else if (!lastThree.equals("000") && lastValue == 0) {

                // If The Third Last Number Of The String Data Type == 0, Change Value Of Statement To The Appropriate Response With Recursive Call.
                // ELse, Change Value Of Statement To The Appropriate Response With Recursive Call.
                if (thirdLast == 0) {
                    statement = units.get(firstValue) + " Hundred Thousand And " + sayNumber(lastThree);
                } else {
                    statement = units.get(firstValue) + " Hundred Thousand, " + sayNumber(lastThree);
                }
            }

            // Else If The Last 3 Numbers Of The String Data Type == "000" And The Last value Is Not Equal TO 0
            else if (!lastThree.equals("000") && lastValue != 0) {

                // If The Third Last Number Of The String Data Type == 0, Change Value Of Statement To The Appropriate Response With Recursive Call.
                // ELse, Change Value Of Statement To The Appropriate Response With Recursive Call.
                if (thirdLast == 0) {
                    statement = units.get(firstValue) + " Hundred Thousand And " + sayNumber(lastThree);
                } else {
                    statement = units.get(firstValue) + " Hundred Thousand, " + sayNumber(lastThree);
                }
            }
        }

        // Else If The Last Five Numbers Of The String Data Type == "00000", Change Value Of Statement To The Appropriate Response.
        else if (lastFive.equals("00000")) {
            statement = units.get(firstValue) + " Hundred Thousand.";
        }

        // Else If The Second Number Of The String Data Type == 0 and The last Three Numbers of The String Data Type == "000"
        else if (secondValue == 0 && lastThree.equals("000")) {
            statement = units.get(firstValue) + " Hundred And " + units.get(thirdValue) + " Thousand.";
        }

        // Else If The Second Number Of The String Data Type == 0, Change Value Of Statement To The Appropriate Response With Recursive Call.
        else if (secondValue == 0) {
            statement = units.get(firstValue) + " Hundred And " + units.get(thirdValue) + " Thousand, " + sayNumber(lastThree);
        }

        // Else If The Last Four Numbers Of The String Data Type == "0000", Change Value Of Statement To The Appropriate Response.
        else if (lastFour.equals("0000")) {
            statement = units.get(firstValue) + " Hundred And " + tens.get(secondValue) + " Thousand.";
        }

        // Else If The Third Number From The String Data Type == 0 And The Last Number From The String Data Type != 0
        // Change Value Of Statement To The Appropriate Response With Recursive Call.
        else if (thirdValue == 0 && lastValue != 0) {
            statement = units.get(firstValue) + " Hundred And " + tens.get(secondValue) + " Thousand, " + sayNumber(lastThree);
        }

        // Else If The Last Three Numbers Of The String Data Type == "000", Change Value Of Statement To The Appropriate Response.
        else if (lastThree.equals("000")) {
            statement = units.get(firstValue) + " Hundred And " + tens.get(secondValue) + " " + units.get(thirdValue) + " Thousand.";
        }

        // Else,
        else {

            // If The Second Value Of The String Data Type == 1, Change Value Of Statement To The Appropriate Response With Recursive Call.
            if (secondValue == 1) {
                statement = units.get(firstValue) + " Hundred And " + teens.get(Integer.parseInt(secondAndThird)) + " Thousand, " + sayNumber(lastThree);
            }

            // ELse If The Third Number From The String Data Type == 0, Change Value Of Statement To The Appropriate Response With Recursive Call.
            // Else, Change Value Of Statement To The Appropriate Response With Recursive Call.
            else if (thirdValue == 0) {
                statement = units.get(firstValue) + " Hundred And " + tens.get(secondValue) + " Thousand, " + sayNumber(lastThree);
            } else {
                statement = units.get(firstValue) + " Hundred And " + tens.get(secondValue) + " " + units.get(thirdValue) + " Thousand, " + sayNumber(lastThree);
            }
        }

        // Return Statement
        return statement;
    }

    // Define Function That Takes In A 7-Digit Number And Returns The Number In Word Form.
    private static String getSeptuple(String number) {

        // Declare Variables
        int firstValue = Integer.parseInt(String.valueOf(number.charAt(0)));
        String lastSix = number.charAt(1) + String.valueOf(number.charAt(2)) + number.charAt(3);
        lastSix += number.charAt(4) + String.valueOf(number.charAt(5)) + number.charAt(6);
        String statement = null;

        // If The Last 6 Numbers From The String Data Type == "000000", Change Value Of Statement To The Appropriate Response.
        // Else, Change Value Of Statement To The Appropriate Response With Recursive Call.
        if (lastSix.equals("000000")) {
            statement = units.get(firstValue) + " Million. ";
        } else {
            statement = units.get(firstValue) + " Million, " + sayNumber(lastSix);
        }

        // Return statement
        return statement;
    }

    // Define Function That Takes In A 8-Digit Number Of The String Data Type And Returns The Number In Word Form.
    private static String getOctuple(String number) {

        // Define Variables
        int firstValue = Integer.parseInt(String.valueOf(number.charAt(0)));
        int secondValue = Integer.parseInt(String.valueOf(number.charAt(1)));
        int firstTwo = Integer.parseInt(number.charAt(0) + String.valueOf(number.charAt(1)));
        String threeToSix = number.charAt(2) + String.valueOf(number.charAt(3)) + number.charAt(4) + number.charAt(5);
        String lastSix = String.valueOf(number.charAt(2)) + number.charAt(3);
        lastSix += number.charAt(4) + String.valueOf(number.charAt(5)) + number.charAt(6) + number.charAt(7);
        String lastSeven = number.charAt(1) + lastSix;
        String statement = null;

        // If The Last 7 Numbers From The String Data Type == "0000000", Change Value Of Statement To The Appropriate Response.
        if (lastSeven.equals("0000000")) {
            statement = tens.get(firstValue) + " Million.";
        }

        // Else If The Last Six Numbers From The String Data Type == "000000"
        else if (lastSix.equals("000000")) {

            // If The First Number From The Parameter == 1, Change Value Of Statement To The Appropriate Response.
            // Else, Change Value Of Statement To The Appropriate Response.
            if (firstValue == 1) {
                statement = teens.get(firstTwo) + " Million.";
            } else {
                statement = tens.get(firstValue) + " " + units.get(secondValue) + " Million.";
            }
        }

        // Else If The Second Number From The Parameter == 0,
        else if (secondValue == 0) {

            // if The Third Number Of The Parameter To The Sixth Number Of The Parameter == "0000", Change Value Of Statement To The Appropriate Response.
            // Else, Change Value Of Statement To The Appropriate Response.
            if (threeToSix.equals("0000")) {
                statement = tens.get(firstValue) + " Million And " + sayNumber(lastSix);
            } else {
                statement = tens.get(firstValue) + " Million, " + sayNumber(lastSix);
            }
        }

        // Else If The First Number In The Parameter == 1, Change Value Of Statement To The Appropriate Response.
        // ELse, Change Value Of Statement To The Appropriate Response.
        else if (firstValue == 1) {
            statement = teens.get(firstTwo) + " Million, " + sayNumber((lastSix));
        } else {
            statement = tens.get(firstValue) + " " + units.get(secondValue) + " Million, " + sayNumber(lastSix);
        }

        // Return Statement
        return statement;
    }

    // Define Function that Takes In A 9-Digit Number Of The String Data Type And Returns The Number In Word Form.
    private static String getNonuple(String number) {

        // Define Variables
        int firstValue = Integer.parseInt(String.valueOf(number.charAt(0)));
        int secondValue = Integer.parseInt(String.valueOf(number.charAt(1)));
        int thirdValue = Integer.parseInt(String.valueOf(number.charAt(2)));
        String secondTwo = number.charAt(1) + String.valueOf(number.charAt(2));
        String lastSix = number.charAt(3) + String.valueOf(number.charAt(4)) + number.charAt(5);
        lastSix += number.charAt(6) + String.valueOf(number.charAt(7)) + number.charAt(8);
        String lastEight = String.valueOf(number.charAt(1)) + number.charAt(2) + lastSix;
        String statement = null;

        // If Last Eight Numbers Of Parameter == "00000000", Change Value Of Statement To The Appropriate Response.
        // Else if The Second Two Numbers Of The Parameter == "00", Change Value Of Statement To The Appropriate Response With Recursive Call.
        if (lastEight.equals("00000000")) {
            statement = units.get(firstValue) + " Hundred Million.";
        } else if (secondTwo.equals("00")) {
            statement = units.get(firstValue) + " Hundred Million, " + sayNumber(lastSix);
        }

        // Else if The Third Number == 0,
        else if (thirdValue == 0) {

            // If The Last 6 Numbers == "000000", Change Value Of Statement To The Appropriate Response
            // Else, Change Value Of Statement To The Appropriate Response With Recursive Call.
            if (lastSix.equals("000000")) {
                statement = units.get(firstValue) + " Hundred And " + tens.get(secondValue) + " Million.";
            } else {
                statement = units.get(firstValue) + " Hundred And " + tens.get(secondValue) + " Million, " + sayNumber(lastSix);
            }
        }

        // Else If The Second Number Of The Parameter == 1 And The Last Six Numbers != "000000",
        // Change Value Of Statement To The Appropriate Response With Recursive Call
        else if (secondValue == 1 && !lastSix.equals("000000")) {
            statement = units.get(firstValue) + " Hundred And " + teens.get(Integer.parseInt(secondTwo)) + " Million, " + sayNumber(lastSix);
        }

        // Else If The Second Number Of The Parameter == 1 and The Last Six Numbers == "000000", Change Value Of Statement To The Appropriate Response
        else if (secondValue == 1 && lastSix.equals("000000")) {
            statement = units.get(firstValue) + " Hundred And " + teens.get(Integer.parseInt(secondTwo)) + " Million.";
        }

        // Else If The Last 6 Numbers Of The Parameter == "000000" and The Second Number == 0, Change Value Of Statement To The Appropriate Response
        else if (lastSix.equals("000000") && secondValue == 0) {
            statement = units.get(firstValue) + " Hundred And " + units.get(thirdValue) + " Million.";
        }

        // Else If The Last Six Numbers Of The Parameter != 0 And The Second Number == 0,
        // Change Value Of Statement To The Appropriate Response With Recursive Call
        else if (!lastSix.equals("000000") && secondValue == 0) {
            statement = units.get(firstValue) + " Hundred And " + units.get(thirdValue) + " Million, " + sayNumber(lastSix);
        }

        // Else If The Last Six Numbers Of The Parameter == "000000", Change Value Of Statement To The Appropriate Response
        // Else, Change Value Of Statement To The Appropriate Response With Recursive Call.
        else if (lastSix.equals("000000")) {
            statement = units.get(firstValue) + " Hundred And " + tens.get(secondValue) + " " + units.get(thirdValue) + " Million.";
        } else {
            statement = units.get(firstValue) + " Hundred And " + tens.get(secondValue) + " " + units.get(thirdValue) + " Million, " + sayNumber(lastSix);
        }

        // Return Statement
        return statement;
    }

    // Define Function That Takes In A 10-Digit Number As A Parameter And Returns The Number In Word Form
    private static String getDecuple(String number) {

        // Define Variables
        int firstValue = Integer.parseInt(String.valueOf(number.charAt(0)));
        String lastEight = String.valueOf(number.charAt(2)) + number.charAt(3) + number.charAt(4);
        lastEight += number.charAt(5) + String.valueOf(number.charAt(6)) + number.charAt(7) + number.charAt(8);
        lastEight += String.valueOf(number.charAt(9));
        String lastNine = number.charAt(1) + lastEight;
        String statement = null;

        // if The Last Nine Numbers Of The Parameter  == "000000000", Change Value Of Statement To The Appropriate Response
        // else, Change Value Of Statement To The Appropriate Response With Recursive Call.
        if (lastNine.equals("000000000")) {
            statement = units.get(firstValue) + " Billion.";
        } else {
            statement = units.get(firstValue) + " Billion, " + sayNumber(lastNine);
        }

        // Return Statement
        return statement;
    }

    // Define Function That Takes In A 11-Digit Number As A Parameter And Returns The Number In Word Form
    private static String getHendecuple(String number) {

        // Declare Variables
        int firstNumber = Integer.parseInt(String.valueOf(number.charAt(0)));
        int secondNumber = Integer.parseInt(String.valueOf(number.charAt(1)));
        String firstTwo = number.charAt(0) + String.valueOf(number.charAt(1));
        String threeToTen = number.charAt(2) + String.valueOf(number.charAt(3)) + number.charAt(4);
        threeToTen += number.charAt(5) + String.valueOf(number.charAt(6)) + number.charAt(7) + number.charAt(8);
        String lastTwo = number.charAt(9) + String.valueOf(number.charAt(10));
        String lastNine = String.valueOf(number.charAt(2)) + number.charAt(3);
        lastNine += number.charAt(4) + String.valueOf(number.charAt(5)) + number.charAt(6) + number.charAt(7);
        lastNine += number.charAt(8) + String.valueOf(number.charAt(9)) + number.charAt(10);
        String lastTen = number.charAt(1) + lastNine;
        String statement = null;

        // If The Last 10 Numbers Of The Parameter == "0000000000", Change Value Of Statement To The Appropriate Response
        if (lastTen.equals("0000000000")) {
            statement = tens.get(firstNumber) + " Billion.";
        }

        // Else If The Second Number == 0,
        else if (secondNumber == 0) {

            // If The Third Number of The Parameter To The Tenth Number Of The Parameter == "0000000",
            // Change Value Of Statement To The Appropriate Response With Recursive Call
            // Else, Change Value Of Statement To The Appropriate Response With Recursive Call
            if (threeToTen.equals("0000000")) {
                statement = tens.get(firstNumber) + " Billion And " + sayNumber(lastTwo);
            } else {
                statement = tens.get(firstNumber) + " Billion, " + sayNumber(lastNine);
            }
        }

        // Else If The First Number Of The Parameter == 1, Change Value Of Statement To The Appropriate Response With Recursive Call.
        // ELse, Change Value Of Statement To The Appropriate Response With Recursive Call.
        else if (firstNumber == 1) {
            statement = teens.get(Integer.parseInt(firstTwo)) + " Billion, " + sayNumber(lastNine);
        } else {
            statement = tens.get(firstNumber) + " " + sayNumber(lastTen);
        }

        // Return Statement
        return statement;
    }

    // Define Function That Takes In A 12-Digit Number As A Parameter And Returns The Number In Word Form
    private static String getDuoDecuple(String number) {

        // Declare Variables
        int firstValue = Integer.parseInt(String.valueOf(number.charAt(0)));
        int secondValue = Integer.parseInt(String.valueOf(number.charAt(1)));
        int thirdValue = Integer.parseInt(String.valueOf(number.charAt(2)));
        String secondTwo = number.charAt(1) + String.valueOf(number.charAt(2));
        String fourToTen = number.charAt(3) + String.valueOf(number.charAt(4)) + number.charAt(5);
        fourToTen += number.charAt(6) + String.valueOf(number.charAt(7)) + number.charAt(8) + number.charAt(9);
        String secondLastEight = fourToTen + number.charAt(10);
        String lastNine = secondLastEight + number.charAt(11);
        String statement = null;

        // If The Second Two Numbers of The Parameter == "00",
        if (secondTwo.equals("00")) {

            // if The Last Nine Numbers Of Parameter == '000000000", Change Value Of Statement To The Appropriate Response
            // Else If The Forth Number To The Tenth Number == "0000000"
            // Change Value Of Statement To The Appropriate Response With Recursive Call
            // Else, Change Value Of Statement To The Appropriate Response With Recursive Call
            if (lastNine.equals("000000000")) {
                statement = units.get(firstValue) + " Hundred Billion.";
            } else if (fourToTen.equals("0000000")) {
                statement = units.get(firstValue) + " Hundred Billion And " + sayNumber(lastNine);
            } else {
                statement = units.get(firstValue) + " Hundred Billion, " + sayNumber(lastNine);
            }
        }

        // Else If The Second Number Of The Parameter == 0,
        else if (secondValue == 0) {

            // if The Last Nine Numbers Of Parameter == '000000000", Change Value Of Statement To The Appropriate Response
            // Else,  Change Value Of Statement To The Appropriate Response With Recursive Call.
            if (lastNine.equals("000000000")) {
                statement = units.get(firstValue) + " Hundred And " + units.get(thirdValue) + " Billion.";
            } else {
                statement = units.get(firstValue) + " Hundred And " + units.get(thirdValue) + " Billion, " + sayNumber(lastNine);
            }
        }

        // Else If The Second Number Of The Parameter == 1,
        else if (secondValue == 1) {

            // if The Last Nine Numbers Of Parameter == '000000000", Change Value Of Statement To The Appropriate Response
            // Else,  Change Value Of Statement To The Appropriate Response With Recursive Call.
            if (lastNine.equals("000000000")) {
                statement = units.get(firstValue) + " Hundred And " + teens.get(Integer.parseInt(secondTwo)) + " Billion. ";
            } else {
                statement = units.get(firstValue) + " Hundred And " + teens.get(Integer.parseInt(secondTwo)) + " Billion, " + sayNumber(lastNine);
            }
        }

        // ELse If The Third Number Of The Parameter == 0,
        else if (thirdValue == 0) {

            // if The Last Nine Numbers Of Parameter == '000000000", Change Value Of Statement To The Appropriate Response
            // Else,  Change Value Of Statement To The Appropriate Response With Recursive Call.
            if (lastNine.equals("000000000")) {
                statement = units.get(firstValue) + " Hundred And " + tens.get(secondValue) + " Billion. ";
            } else {
                statement = units.get(firstValue) + " Hundred And " + tens.get(secondValue) + " Billion, " + sayNumber(lastNine);
            }

        }

        // Else,
        else {

            // if The Last Nine Numbers Of Parameter == '000000000", Change Value Of Statement To The Appropriate Response
            // Else,  Change Value Of Statement To The Appropriate Response With Recursive Call.
            if (lastNine.equals("000000000")) {
                statement = units.get(firstValue) + " Hundred And " + tens.get(secondValue) + " " + units.get(thirdValue) + " Billion.";
            } else {
                statement = units.get(firstValue) + " Hundred And " + tens.get(secondValue) + " " + units.get(thirdValue) + " Billion, " + sayNumber(lastNine);
            }
        }

        // Return statement
        return statement;
    }

    // Define Function That Takes In A 13-Digit Number As A Parameter And Returns The Number In Word Form
    private static String getTreDecuple(String number) {

        // Define Variables
        int firstValue = Integer.parseInt(String.valueOf(number.charAt(0)));
        String lastTwelve = number.charAt(1) + String.valueOf(number.charAt(2)) + number.charAt(3);
        lastTwelve += number.charAt(4) + String.valueOf(number.charAt(5)) + number.charAt(6);
        lastTwelve += number.charAt(7) + String.valueOf(number.charAt(8)) + number.charAt(9);
        lastTwelve += number.charAt(10) + String.valueOf(number.charAt(11)) + number.charAt(12);
        String statement = null;

        // If The Last Twelve Numbers Of The Parameter == "000000000000", Change Value Of Statement To The Appropriate Response
        // Else,  Change Value Of Statement To The Appropriate Response With Recursive Call
        if (lastTwelve.equals("000000000000")) {
            statement = units.get(firstValue) + " Trillion.";
        } else {
            statement = units.get(firstValue) + " Trillion, " + sayNumber(lastTwelve);
        }

        // Return Statement
        return statement;
    }

    // Define Function That Takes In A 14-Digit Number As A Parameter And Returns The Number In Word Form
    private static String getFourteenDigits(String number) {

        // Define Variables
        int firstValue = Integer.parseInt(String.valueOf(number.charAt(0)));
        int secondValue = Integer.parseInt(String.valueOf(number.charAt(1)));
        String firstTwo = number.charAt(0) + String.valueOf(number.charAt(1));
        String lastTwelve = String.valueOf(number.charAt(2)) + number.charAt(3) + number.charAt(4) + number.charAt(5) + number.charAt(6);
        lastTwelve += number.charAt(7) + String.valueOf(number.charAt(8)) + number.charAt(9);
        lastTwelve += number.charAt(10) + String.valueOf(number.charAt(11)) + number.charAt(12) + number.charAt(13);
        String statement = null;

        // If The Second Number Of The Parameter == 0,
        if (secondValue == 0) {

            // If The Last Twelve Numbers Of The Parameter == "000000000000", Change Value Of Statement To The Appropriate Response
            // Else, Change Value Of Statement To The Appropriate Response With Recursive Call
            if (lastTwelve.equals("000000000000")) {
                statement = tens.get(firstValue) + " Trillion.";
            } else {
                statement = tens.get(firstValue) + " Trillion, " + sayNumber(lastTwelve);
            }
        }

        // ELse if The First Number Of The Parameter == 1,
        else if (firstValue == 1) {

            // If The Last Twelve Numbers Of The Parameter == "000000000000", Change Value Of Statement To The Appropriate Response
            // Else, Change Value Of Statement To The Appropriate Response With Recursive Call
            if (lastTwelve.equals("000000000000")) {
                statement = teens.get(Integer.parseInt(firstTwo)) + " Trillion.";
            } else {
                statement = teens.get(Integer.parseInt(firstTwo)) + " Trillion, " + sayNumber(lastTwelve);
            }
        }

        // Else
        else {
            // If The Last Twelve Numbers Of The Parameter == "000000000000", Change Value Of Statement To The Appropriate Response
            // Else, Change Value Of Statement To The Appropriate Response With Recursive Call
            if (lastTwelve.equals("000000000000")) {
                statement = tens.get(firstValue) + " " + units.get(secondValue) + " Trillion.";
            } else {
                statement = tens.get(firstValue) + " " + units.get(secondValue) + " Trillion, " + sayNumber(lastTwelve);
            }
        }

        // Return Statement
        return statement;
    }

    // Define Function That Takes In A 15-Digit Number As A Parameter And Returns The Number In Word Form
    private static String getFifteenthDigit(String number) {

        // Declare Variables
        int firstValue = Integer.parseInt(String.valueOf(number.charAt(0)));
        int secondValue = Integer.parseInt(String.valueOf(number.charAt(1)));
        int thirdValue = Integer.parseInt(String.valueOf(number.charAt(2)));
        String secondTwo = number.charAt(1) + String.valueOf(number.charAt(2));
        String fourToThirteen = String.valueOf(number.charAt(3)) + number.charAt(4) + number.charAt(5);
        fourToThirteen += number.charAt(6) + String.valueOf(number.charAt(7)) + number.charAt(8) + number.charAt(9);
        fourToThirteen += number.charAt(10) + String.valueOf(number.charAt(11)) + number.charAt(12);
        String lastTwelve = fourToThirteen + number.charAt(13) + number.charAt(14);
        String statement = null;

        // If The Second Two Numbers From The parameter == "00",
        if (secondTwo.equals("00")) {

            // if The Last Twelve Numbers Of The Parameter == "000000000000", Change Value Of Statement To The Appropriate Response
            // Else If The Forth Number Of The Parameter TO The Thirteenth Number Of The Parameter == "0000000000",
            // Change Value Of Statement To The Appropriate Response With Recursive Call.
            // Else, Change Value Of Statement To The Appropriate Response With Recursive Call.
            if (lastTwelve.equals("000000000000")) {
                statement = units.get(firstValue) + " Hundred Trillion.";
            } else if (fourToThirteen.equals("0000000000")) {
                statement = units.get(firstValue) + " Hundred Trillion And " + sayNumber(lastTwelve);
            } else {
                statement = units.get(firstValue) + " Hundred Trillion, " + sayNumber(lastTwelve);
            }
        }

        // Else If The Second Value Of The Parameter == 0,
        else if (secondValue == 0) {

            // if The Last Twelve Numbers Of The Parameter == "000000000000", Change Value Of Statement To The Appropriate Response
            // Else, Change Value Of Statement To The Appropriate Response With Recursive Call.
            if (lastTwelve.equals("000000000000")) {
                statement = units.get(firstValue) + " Hundred And " + units.get(thirdValue) + " Trillion.";
            } else {
                statement = units.get(firstValue) + " Hundred And " + units.get(thirdValue) + " Trillion, " + sayNumber(lastTwelve);
            }
        }

        // Else If The Second Number Of The Parameter == 1,
        else if (secondValue == 1) {

            // if The Last Twelve Numbers Of The Parameter == "000000000000", Change Value Of Statement To The Appropriate Response
            // Else, Change Value Of Statement To The Appropriate Response With Recursive Call.
            if (lastTwelve.equals("000000000000")) {
                statement = units.get(firstValue) + " Hundred And " + teens.get(Integer.parseInt(secondTwo)) + " Trillion.";
            } else {
                statement = units.get(firstValue) + " Hundred And " + teens.get(Integer.parseInt(secondTwo)) + " Trillion, " + sayNumber(lastTwelve);
            }
        }

        // Else If The Third Number Of The Parameter == 0,
        else if (thirdValue == 0) {

            // if The Last Twelve Numbers Of The Parameter == "000000000000", Change Value Of Statement To The Appropriate Response
            // Else, Change Value Of Statement To The Appropriate Response With Recursive Call.
            if (lastTwelve.equals("000000000000")) {
                statement = units.get(firstValue) + " Hundred And " + tens.get(secondValue) + " Trillion.";
            } else {
                statement = units.get(firstValue) + " Hundred And " + tens.get(secondValue) + " Trillion, " + sayNumber(lastTwelve);
            }
        }

        // Else,
        else {

            // if The Last Twelve Numbers Of The Parameter == "000000000000", Change Value Of Statement To The Appropriate Response
            // Else, Change Value Of Statement To The Appropriate Response With Recursive Call.
            if (lastTwelve.equals("000000000000")) {
                statement = units.get(firstValue) + " Hundred And " + tens.get(secondValue) + " " + units.get(thirdValue) + " Trillion.";
            } else {
                statement = units.get(firstValue) + " Hundred And " + tens.get(secondValue) + " " + units.get(thirdValue) + " Trillion, " + sayNumber(lastTwelve);
            }
        }

        // Return Statement
        return statement;
    }
}