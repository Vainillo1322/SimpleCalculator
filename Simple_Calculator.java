import java.util.Scanner;
import java.io.IOException;
import java.util.InputMismatchException;
//this program is created by Biel Notario, on the 29th of september of 2026, last published edit: 02/10/2026
public class Simple_Calculator {
    //from line 9 to 13 they are diferent variables used in math operations, except "answerDiv", that variable is only used in division
    //that's because the result of the division can be decimal
    static char operacions;
    static int numero_1;
    static int numero_2;
    static int answer;
    static double answerDiv;
    //from line 15 to 17 they are the variables used to change the "settings" of this APP
    static String colorActual = "\u001B[37m";
    static String textStyle = "\u001B[37m";
    static String textDecoration = "\u001B[37m";
    //the rest of the variables are the ones that the APP needs to be able to use from one function to another (keeping the value)
    static int seleccioMenuVisual_3_1;
    static int seleccioMenuVisualEstilText;
    static int seleccioMenuVisualDecoracionText;
    public static void main(String[] args) {
        //The main is mostly empty because every function calls another function to be able to run the APP
        //Scanner is a line of code because it game me error if I put it in the parameters of main
        //the only thing that main does is call the first "visual" function
        
        Scanner sc = new Scanner(System.in);

        menuVisualPrincipal(sc);
        
    }

    public static void canviarColor(Scanner sc) {
        //this is the function used for changing the color of the characters
        //change colorActual to the corresponding value
        //if the answer in "if" is not the expected option, goes to errorGeneral_1();
        //if the answer in "if" is the expected option it will do:
        //change colorActuall to the corresponding value and go to menuVisualSuccessChange();

        if (seleccioMenuVisual_3_1 == 1) {
            colorActual="\u001B[37m";
            menuVisualSuccessChange();
        }
        else if (seleccioMenuVisual_3_1 == 2) {
            colorActual="\u001B[33m";
            menuVisualSuccessChange();
        }
        else if (seleccioMenuVisual_3_1 == 3) {
            colorActual="\u001B[32m";
            menuVisualSuccessChange();
        }
        else if (seleccioMenuVisual_3_1 == 4) {
            colorActual="\u001B[31m";
            menuVisualSuccessChange();
        }
        else
            errorGeneral_1();


    }

    public static void canviarEstilText(Scanner sc) {
        //this is the function used for changing the text style of the characters
        //if the answer in "if" is not the expected option, goes to errorGeneral_1();
        //if the answer in "if" is the expected option it will do:
        //change textStyle to the corresponding value and go to menuVisualSuccessChange();
       

        if (seleccioMenuVisualEstilText == 1){
            textStyle="\u001B[0m";
            menuVisualSuccessChange();
        }
        else if (seleccioMenuVisualEstilText == 2){
            textStyle="\u001B[1m";
            menuVisualSuccessChange();
        }
        else if (seleccioMenuVisualEstilText == 3) {
            textStyle="\u001B[2m";
            menuVisualSuccessChange();
        }
        else if (seleccioMenuVisualEstilText == 4) {
            textStyle="\u001B[3m";
            menuVisualSuccessChange();
        }
        else if (seleccioMenuVisualEstilText == 5)
            menuVisual_3(sc);
        else 
            errorCaracter_1();

    }

    public static void canviarDecoracionText(Scanner sc) {
        //This is the function "used" for changing the text decoration of the characters
        //if the answer in "if" is not the expected option, goes to errorGeneral_1();
        //if the answer in "if" is the expected option it will do:
        //change textDecoration to the corresponding value and go to menuVisualSuccessChange();
        if (seleccioMenuVisualDecoracionText == 1){
            textDecoration="\u001B[37m";
            menuVisualSuccessChange();
        }
        else if (seleccioMenuVisualDecoracionText == 2){
            errorGeneral_1();
        }
        else if (seleccioMenuVisualDecoracionText == 3){
            textDecoration="\u001B[9m";
            menuVisualSuccessChange();
        }
        else if (seleccioMenuVisualDecoracionText == 4)
            menuVisual_3(sc);
        else
            errorCaracter_1();
    }

    public static void imprimirLN(String text){
        //This is the funcion that this APP uses to print everything with println
        //that's because I don't know if there is a better way to implement changes in the text (like change the color)
        //with this function I replaced the System.out.println(); with imprimirLN();

        System.out.println(textDecoration + textStyle + colorActual + text);
        
    }

    public static void imprimirONLY(String text){
        //This is the function that this APP uses to print everything with print
        //that's because I don't know if there is a better way to implement changes in the text (like change the color)
        //with this function I replaced the System.out.print(); with imprimirONLY();
        
        System.out.print(textDecoration + textStyle + colorActual + text);

    }

    public static void clearTerminal(Scanner sc) {
        //this is the function that this app uses to clear the terminal before printing another "visual" menu
        //it detects in what OS you are because in windows you have to do "cls" and in linux/macOS "clear"
        //after that it's just an "if" that detects what's inside os, and if it contains the word Windows it will do cls, or else clear
        //it's very simple function, but very used in this APP

        String os = System.getProperty("os.name");

        if (os.contains("Windows")) {   
            try {
            new ProcessBuilder("cls").inheritIO().start();

            } catch (IOException e) {
                // nothing for the moment
            }
        }
        else {
             try {
            new ProcessBuilder("clear").inheritIO().start();

            } catch (IOException e) {
                // nothing for the moment
            }
        }
    }

    public static void menuVisualPrincipal(Scanner sc) {
        //this is the "principal" "visual" menu of the APP
        //basically what it does (like every other "visual" menu) is clear the terminal and wait 0.5 seconds before printing the "interface"
        //it has to wait 0.5 seconds because I had problems that only half of the interface showed (or no interface was showing up in the terminal)
        //after that it starts the opcionsMenuPrincipal 
        //every "interface" is like this: clear, wait 0.5 sec, printing and calling opcions"name of the function();

        clearTerminal(sc);
        
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            //nothing for the moment
        }

        imprimirLN("╔═══════════════════════════════════════╗");
        imprimirLN("║           SIMPLE CALCULATOR           ║");
        imprimirLN("╠═══════════════════════════════════════╣");
        imprimirLN("║                                       ║");
        imprimirLN("║   [1] New Calculation                 ║");
        imprimirLN("║                                       ║");
        imprimirLN("║   [2] Calculation History             ║");
        imprimirLN("║                                       ║");
        imprimirLN("║   [3] Settings                        ║");
        imprimirLN("║                                       ║");
        imprimirLN("║   [4] Exit                            ║");
        imprimirLN("║                                       ║");
        imprimirLN("╚═══════════════════════════════════════╝");

        opcionsMenuPrincipal(sc);

        }

    public static void menuVisual_2(Scanner sc) {
        //this is the interface you see when the input from opcionsMenuPrincipal is 2
        //again the same that the first "interface"
    
        clearTerminal(sc);

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            //nothing for the moment
        }

        imprimirLN("╔═══════════════════════════════════════╗");
        imprimirLN("║           SIMPLE CALCULATOR           ║");
        imprimirLN("╠═══════════════════════════════════════╣");
        imprimirLN("║                                       ║");
        imprimirLN("║            IN CONSTRUCTION            ║");
        imprimirLN("║                                       ║");
        imprimirLN("║   [1] Return to home page             ║");
        imprimirLN("║                                       ║");
        imprimirLN("╚═══════════════════════════════════════╝");

        opcionsMenuVisual_2(sc);
    }

    public static void menuVisual_3(Scanner sc) {
        //this is the interface you see when the input from opcionsMenuPrincipal is 3
        //again the same that the first "interface" 

        clearTerminal(sc);

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            //nothing for the moment
        }

        imprimirLN("╔═══════════════════════════════════════╗");
        imprimirLN("║           SIMPLE CALCULATOR           ║");
        imprimirLN("╠═══════════════════════════════════════╣");
        imprimirLN("║                                       ║");
        imprimirLN("║               Settings                ║");
        imprimirLN("║                                       ║");
        imprimirLN("║   [1] Change color (font)             ║");
        imprimirLN("║                                       ║");
        imprimirLN("║   [2] Font settings                   ║");
        imprimirLN("║                                       ║");
        imprimirLN("║   [3] Reset default settings          ║");
        imprimirLN("║                                       ║");
        imprimirLN("║   [4] Return to home page             ║");
        imprimirLN("║                                       ║");
        imprimirLN("╚═══════════════════════════════════════╝");

        opcionsMenuVisual_3(sc);
    }

    public static void menuVisual_3_1(Scanner sc) {
        //this is the interface you see when the input from opcionsMenuVisual_3 is 1
        //again the same that the first "interface

        clearTerminal(sc);

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            //nothing for the moment
        }

        imprimirLN("╔═══════════════════════════════════════╗");
        imprimirLN("║           SIMPLE CALCULATOR           ║");
        imprimirLN("╠═══════════════════════════════════════╣");
        imprimirLN("║                                       ║");
        imprimirLN("║          Change color (font)          ║");
        imprimirLN("║                                       ║");
        imprimirLN("║   [1] White                           ║");
        imprimirLN("║                                       ║");
        imprimirLN("║   [2] Yellow                          ║");
        imprimirLN("║                                       ║");
        imprimirLN("║   [3] Green                           ║");
        imprimirLN("║                                       ║");
        imprimirLN("║   [4] Red                             ║");
        imprimirLN("║                                       ║");
        imprimirLN("╚═══════════════════════════════════════╝");

        opcionsMenuVisual_3_1(sc);
    }

    public static void menuVisual_3_2(Scanner sc) {
        //this is the interface you see when the input from opcionsMenuVisual_3 is 2
        //again the same that the first "interface"
    
        clearTerminal(sc);

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            //nothing for the moment
        }

        imprimirLN("╔═══════════════════════════════════════╗");
        imprimirLN("║           SIMPLE CALCULATOR           ║");
        imprimirLN("╠═══════════════════════════════════════╣");
        imprimirLN("║                                       ║");
        imprimirLN("║             Font settings             ║");
        imprimirLN("║                                       ║");
        imprimirLN("║   [1] Text style                      ║");
        imprimirLN("║                                       ║");
        imprimirLN("║   [2] Text decoration                 ║");
        imprimirLN("║                                       ║");
        imprimirLN("║   [3] Return to Home Page             ║");
        imprimirLN("║                                       ║");
        imprimirLN("╚═══════════════════════════════════════╝");

        opcionsMenuVisual_3_2(sc);
    }

    public static void menuVisual_4 (Scanner sc) {
        //this is the interface you see when the input from opcionsMenuPrincipal is 4
        //again the same that the first "interface"

        clearTerminal(sc);        

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            //nothing for the moment
        }

        imprimirLN("╔═══════════════════════════════════════╗");
        imprimirLN("║           SIMPLE CALCULATOR           ║");
        imprimirLN("╠═══════════════════════════════════════╣");
        imprimirLN("║                                       ║");
        imprimirLN("║                Goodbye                ║");
        imprimirLN("║                                       ║");
        imprimirLN("╚═══════════════════════════════════════╝");

        try {
            Thread.sleep(1750);
        } catch (InterruptedException e) {
            //nothing for the moment
        }

        clearTerminal(sc);
        
        System.exit(0);

    }

    public static void menuVisualTypeFirst(Scanner sc) {
        //this is the interface you see when the input from opcionsMenuPrincipal is 1
        //again the same that the first "interface"

        clearTerminal(sc);

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            //nothing for the moment
        }

        imprimirLN("╔═══════════════════════════════════════╗");
        imprimirLN("║           SIMPLE CALCULATOR           ║");
        imprimirLN("╠═══════════════════════════════════════╣");
        imprimirLN("║                                       ║");
        imprimirLN("║         Type the first number         ║");
        imprimirLN("║                                       ║");
        imprimirLN("╚═══════════════════════════════════════╝");
        
        opcionsMenuVisualTypeFirst(sc);

    }

    public static void menuVisualOperationsDef(Scanner sc) {
        //This is the interface you see when you input a number in the opcionsMenuVisualTypeFirst
        //again the same that the first "interface"

        clearTerminal(sc);

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            //nothing for the moment
        }
        
        imprimirLN("╔═══════════════════════════════════════╗");
        imprimirLN("║           SIMPLE CALCULATOR           ║");
        imprimirLN("╠═══════════════════════════════════════╣");
        imprimirLN("║                                       ║");
        imprimirLN("║   [1] Addition                        ║");
        imprimirLN("║                                       ║");
        imprimirLN("║   [2] Subtraction                     ║");
        imprimirLN("║                                       ║");
        imprimirLN("║   [3] Multiplication                  ║");
        imprimirLN("║                                       ║");
        imprimirLN("║   [4] Division                        ║");
        imprimirLN("║                                       ║");
        imprimirLN("║   [5] Return to start                 ║");
        imprimirLN("║                                       ║");
        imprimirLN("╚═══════════════════════════════════════╝");

        opcionsMenuVisualOperationsDef(sc);
    }

    public static void menuVisualTypeSecond(Scanner sc) {
        //this is the interface you see when the input from opcionsMenuVisualOperatorsDef is between 1 to 4
        //again the same that the first "interface"


        clearTerminal(sc);

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            //nothing for the moment
        }

        imprimirLN("╔════════════════════════════════════════╗");
        imprimirLN("║           SIMPLE CALCULATOR            ║");
        imprimirLN("╠════════════════════════════════════════╣");
        imprimirLN("║                                        ║");
        imprimirLN("║         Type the second number         ║");
        imprimirLN("║                                        ║");
        imprimirLN("╚════════════════════════════════════════╝");
        
        opcionsMenuVisualTypeSecond(sc);

    
    }

    public static void menuVisualDivisError(Scanner sc) {
        //this is the interface you see if you input 4 in opcionsMenuVisualOperatorsDef and you had input 0 in opcionsMenuVisualTypeSecond
        //because this is an error message, before sending you to menuVisualTypeSecond again, it waits 1.5 sec to let the user read the error
        //it goes again to menuVisualTypeSecond to let the user input a diferent number

        //I have to find a way to calculate the times the user input to be able, when the user input 0 like 2-3 times say errorGeneral_1

        clearTerminal(sc);

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            //nothing for the moment
        }

        imprimirLN("╔════════════════════════════════════════╗");
        imprimirLN("║           SIMPLE CALCULATOR            ║");
        imprimirLN("╠════════════════════════════════════════╣");
        imprimirLN("║                                        ║");
        imprimirLN("║        ERROR: Cannot divide by 0       ║");
        imprimirLN("║                                        ║");
        imprimirLN("╚════════════════════════════════════════╝");

        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            //nothing for the moment
        }

        menuVisualTypeSecond(sc);
   }

    public static void menuVisualResult(Scanner sc) {
        //this is the interface where you see the result to the math operation
        //I used System.out.print(answer); because if i used imprimirONLY(answer); it gave me error because it has special parameters
        //it has start over and go to home page option
        //the rest is again the same that the first "interface"

        clearTerminal(sc);

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            //nothing for the moment
        }

        imprimirLN("╔════════════════════════════════════════╗");
        imprimirLN("║           SIMPLE CALCULATOR            ║");
        imprimirLN("╠════════════════════════════════════════╣");
        imprimirLN("║                                        ║");
        imprimirLN("║    The result of your operation is:    ║");
        imprimirLN("║                                        ║");
        imprimirONLY("                   ║");
        System.out.print(answer);
        imprimirLN("║");
        imprimirLN("║                                        ║");
        imprimirLN("║    [1] Start over                      ║");
        imprimirLN("║                                        ║");
        imprimirLN("║    [2] Go to home page                 ║");
        imprimirLN("╚════════════════════════════════════════╝");

        opcionsMenuVisualResult(sc);
    }

    public static void menuVisualResultDiv (Scanner sc) {
        //this is the interface used to print the answer to a division
        //it's diferent from the others math operators because it uses a double variable (answerDiv) instead of an int (answer)
        //it uses System.out.print(answerDiv); for the same reason it's used in menuVisualResult
        //it has start over and go to home page option
        //it works like every other interface 

        clearTerminal(sc);

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            //nothing for the moment
        }

        imprimirLN("╔════════════════════════════════════════╗");
        imprimirLN("║           SIMPLE CALCULATOR            ║");
        imprimirLN("╠════════════════════════════════════════╣");
        imprimirLN("║                                        ║");
        imprimirLN("║    The result of your operation is:    ║");
        imprimirLN("║                                        ║");
        imprimirONLY("                   ║");
        System.out.print(answerDiv);
        imprimirLN("║");
        imprimirLN("║                                        ║");
        imprimirLN("║    [1] Start over                      ║");
        imprimirLN("║                                        ║");
        imprimirLN("║    [2] Go to home page                 ║");
        imprimirLN("╚════════════════════════════════════════╝");

        opcionsMenuVisualResult(sc);
    }
  
    public static void menuVisualErrorClose (Scanner sc) {
        //this is an unused interface
        //it was used in some errors when the input was invalid but I change it to errorGeneral_1, the only exception is menuVisualDivisError
        //it's a simple interface that does the same that every other one

        clearTerminal(sc);

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            //nothing for the moment
        }

        imprimirLN("╔════════════════════════════════════════╗");
        imprimirLN("║           SIMPLE CALCULATOR            ║");
        imprimirLN("╠════════════════════════════════════════╣");
        imprimirLN("║                                        ║");
        imprimirLN("║        ERROR: invalid character        ║");
        imprimirLN("║                                        ║");
        imprimirLN("║  The Simple calculator will close now  ║");
        imprimirLN("║                                        ║");
        imprimirLN("╚════════════════════════════════════════╝");

        opcionsMenuVisualErrorClose(sc);
    }

    public static void menuVisualEstilText() {
        //this is the interface used to show the user what options they have to change the text style
        //also, there is a return to settings option
        //the input is captured at the called function (at the end of this function)
        //the text style options are: Normal, Bold, Dim and Italic

        Scanner sc = new Scanner(System.in);
        
        clearTerminal(sc);

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            //nothing for the moment
        }

        imprimirLN("╔═══════════════════════════════════════╗");
        imprimirLN("║           SIMPLE CALCULATOR           ║");
        imprimirLN("╠═══════════════════════════════════════╣");
        imprimirLN("║                                       ║");
        imprimirLN("║              Text style               ║");
        imprimirLN("║                                       ║");
        imprimirLN("║       Choose one from this list       ║");
        imprimirLN("║                                       ║");
        imprimirLN("║   [1] Normal                          ║");
        imprimirLN("║                                       ║");
        imprimirLN("║   [2] Bold                            ║");
        imprimirLN("║                                       ║");
        imprimirLN("║   [3] Dim                             ║");
        imprimirLN("║                                       ║");
        imprimirLN("║   [4] Italic                          ║");
        imprimirLN("║                                       ║");
        imprimirLN("║   [5] Return to Settings              ║");
        imprimirLN("║                                       ║");
        imprimirLN("╚═══════════════════════════════════════╝");
        
        opcionsMenuVisualEstilText();
    }

    public static void menuVisualDecoracionText() {
        //this is the interface used to show the user what options they have to change the text decoration
        //also (like in menuVisualEstilText), there is a return to settings option
        //the input is captured at the called function (at the end of this function)
        // the options for text decoration are: Underline and Strikethorough

        Scanner sc = new Scanner(System.in);
        
        clearTerminal(sc);

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            //nothing for the moment
        }

        imprimirLN("╔═══════════════════════════════════════╗");
        imprimirLN("║           SIMPLE CALCULATOR           ║");
        imprimirLN("╠═══════════════════════════════════════╣");
        imprimirLN("║                                       ║");
        imprimirLN("║            Text decoration            ║");
        imprimirLN("║                                       ║");
        imprimirLN("║       Choose one from this list       ║");
        imprimirLN("║                                       ║");
        imprimirLN("║   [1] Normal                          ║");
        imprimirLN("║                                       ║");
        imprimirLN("║   [2] Underline (Doesn't work)        ║");
        imprimirLN("║                                       ║");
        imprimirLN("║   [3] Strikethrough                   ║");
        imprimirLN("║                                       ║");
        imprimirLN("║   [4] Return to Settings              ║");
        imprimirLN("║                                       ║");
        imprimirLN("╚═══════════════════════════════════════╝");
        
        opcionsMenuVisualDecoracionText();
    }

    public static void menuVisualResetText() { 
        //this is the interface used to show a message when you restore default settings in settings
        //also it redirects you to the home menu
        
        Scanner sc = new Scanner(System.in);
        
        clearTerminal(sc);
        
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            //nothing for the moment
        }

        imprimirLN("╔════════════════════════════════════════╗");
        imprimirLN("║           SIMPLE CALCULATOR            ║");
        imprimirLN("╠════════════════════════════════════════╣");
        imprimirLN("║                                        ║");
        imprimirLN("║       Default Settings restored!       ║");
        imprimirLN("║                                        ║");
        imprimirLN("║    You will return to home page now    ║");
        imprimirLN("║                                        ║");
        imprimirLN("╚════════════════════════════════════════╝");
         
        try {
            Thread.sleep(1250);
        } catch (InterruptedException e) {
            //nothing for the moment
        }

        menuVisualPrincipal(sc);
    }

    public static void menuVisualSuccessChange() {
        //this is the interface used when the user changes an option in settings (Color, Text Style or Text Decoration)
        //it starts a variable at the end

        Scanner sc = new Scanner(System.in);

        clearTerminal(sc);

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            //nothing for the moment
        }

        imprimirLN("╔════════════════════════════════════════╗");
        imprimirLN("║           SIMPLE CALCULATOR            ║");
        imprimirLN("╠════════════════════════════════════════╣");
        imprimirLN("║                                        ║");
        imprimirLN("║        Change made successfully        ║");
        imprimirLN("║                                        ║");
        imprimirLN("║      You will go to home menu now      ║");
        imprimirLN("║                                        ║");
        imprimirLN("╚════════════════════════════════════════╝");

        opcionsmenuVisualSuccessChange();

    }

    public static void errorCaracter_1 () {
        //this is the interface used to show an error because the input recieved is not a permited character
        //it's used in every function that recieves input

        Scanner sc = new Scanner(System.in);

        clearTerminal(sc);
        
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            //nothing for the moment
        }

        imprimirLN("╔════════════════════════════════════════╗");
        imprimirLN("║           SIMPLE CALCULATOR            ║");
        imprimirLN("╠════════════════════════════════════════╣");
        imprimirLN("║                                        ║");
        imprimirLN("║        ERROR: invalid character        ║");
        imprimirLN("║                                        ║");
        imprimirLN("║    You will return to home page now    ║");
        imprimirLN("║                                        ║");
        imprimirLN("╚════════════════════════════════════════╝");
         
        try {
            Thread.sleep(1250);
        } catch (InterruptedException e) {
            //nothing for the moment
        }
        menuVisualPrincipal(sc);
    }

    public static void errorGeneral_1 () {
        //"Visual" menu of a general error
        //I think it's only used in one function
        //when finalised, redirects to home menu
        
        Scanner sc = new Scanner(System.in);

        clearTerminal(sc);
        
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            //nothing for the moment
        }

        imprimirLN("╔════════════════════════════════════════╗");
        imprimirLN("║           SIMPLE CALCULATOR            ║");
        imprimirLN("╠════════════════════════════════════════╣");
        imprimirLN("║                                        ║");
        imprimirLN("║              UNKNOWN ERROR             ║");
        imprimirLN("║                                        ║");
        imprimirLN("║    You will return to home page now    ║");
        imprimirLN("║                                        ║");
        imprimirLN("╚════════════════════════════════════════╝");
         
        try {
            Thread.sleep(1250);
        } catch (InterruptedException e) {
            //nothing for the moment
        }

        menuVisualPrincipal(sc);

    }

    public static void opcionsMenuPrincipal(Scanner sc) {
        //with this function we create a variable INT and ask the user to input a number between 1 to 4 
        //if the user input is not between 1 to 4 it calls errorCaracter_1

        int seleccioMenuPrincipal;
        try {
        seleccioMenuPrincipal=sc.nextInt();
        } catch (InputMismatchException e) {
            seleccioMenuPrincipal=0;
            errorCaracter_1();
            
        }
        if (seleccioMenuPrincipal == 1) 
            menuVisualTypeFirst(sc);

        else if (seleccioMenuPrincipal == 2)
            menuVisual_2(sc);

        else if (seleccioMenuPrincipal == 3)
            menuVisual_3(sc);
        
        else if (seleccioMenuPrincipal == 4)
            menuVisual_4(sc);

        else
            errorCaracter_1();
        

    }

    public static void opcionsMenuVisualTypeFirst(Scanner sc) {
        //with this function we edit the variable numero_1 with the input recieved
        //if the character is not a number the variable's value becomes 0 and calls errorCaracter_1

        try {
        numero_1=sc.nextInt();
        } catch (InputMismatchException e) {
            numero_1=0;
            errorCaracter_1();
            
        }
        menuVisualOperationsDef(sc);


    }

    public static void opcionsMenuVisualOperationsDef(Scanner sc) {
    //with this function we create a variable INT and ask the user to input a number between 1 to 5
    //if the user input is not between 1 to 5 it calls errorCaracter_1
    //every input between 1 to 5 changes the value of the operacions variable
       
    int seleccioMenu_1;
    try {
        seleccioMenu_1=sc.nextInt();
    } catch (InputMismatchException e) {
            seleccioMenu_1=0;
            errorCaracter_1();
            
        }
    if (seleccioMenu_1 == 1) {
        operacions = '+';
        menuVisualTypeSecond(sc);

    }


    else if (seleccioMenu_1 == 2) {
        operacions = '-';
        menuVisualTypeSecond(sc);

    }

    else if (seleccioMenu_1 == 3){
        operacions = '*';
        menuVisualTypeSecond(sc);

    }

    else if (seleccioMenu_1 == 4){
        operacions = '/';
        menuVisualTypeSecond(sc);

    }
        

    else if (seleccioMenu_1 == 5)
        menuVisualPrincipal(sc);

    else
        errorCaracter_1();


    }

    public static void opcionsMenuVisualTypeSecond(Scanner sc) {
        //with this function we edit the variable numero_2 with the input recieved
        //if the character is not a number the variable's value becomes 0 and calls errorCaracter_1
        //if the input recieved is valid, it calls calculateResult
        
        try {
        numero_2=sc.nextInt();
        } catch (InputMismatchException e) {
            numero_2=0;
            errorCaracter_1();
            
        }
        calculateResult(sc);

    }

    public static void opcionsMenuVisualResult(Scanner sc) {
    //with this function we create a variable INT and ask the user to input a number, 1 or 2
    //if the user input is not 1 or 2 it calls errorCaracter_1
    //input = 1 goes to menuVisualTypeFirst (starts all over again the math operation)
    //input = 2 goes to menuVisualPrincipal (goes to home menu)

        int seleccioMenuResult;
        try {
            seleccioMenuResult=sc.nextInt();
        } catch (InputMismatchException e) {
            seleccioMenuResult=0;
            errorCaracter_1();
            
        }

        if (seleccioMenuResult == 1) {
            menuVisualTypeFirst(sc);
        }
        else if (seleccioMenuResult == 2) {
            menuVisualPrincipal(sc);
        }
        else {
            errorCaracter_1();
        }
    }
    
    public static void opcionsMenuVisualErrorClose(Scanner sc) {
        //this is the function used when we call menuVisualErrorClose to wait 2.75 seconds before clearing the terminal and closing the app

        try {
            Thread.sleep(2750);
        } catch (InterruptedException e) {
            //nothing for the moment
        }

        clearTerminal(sc);

        System.exit(0);

    }

    public static void calculateResult(Scanner sc) {
        //this function is used to calculate the result of the math operation
        //when operacions = / it looks up if numero_2 = 0, if that is true it calls menuVisualDivisError
        //if the value of operacions is not contemplated, it goes to menuVisualErrorClose

        if (operacions == '+' ) {
            answer = numero_1 + numero_2;
            menuVisualResult(sc);
        }

        else if (operacions == '-') {
            answer = numero_1 - numero_2;
            menuVisualResult(sc);
        }

        else if (operacions == '*') {
            answer = numero_1 * numero_2;
            menuVisualResult(sc);
        }
        
        else if (operacions == '/') {
            
            if (numero_2 == 0) {
                menuVisualDivisError(sc);

            }
            
            else {
                
                answerDiv = (double) numero_1 / (double) numero_2;
                menuVisualResultDiv(sc);
            }
        }
        else {
            menuVisualErrorClose(sc);    
        }

    }

    public static void opcionsMenuVisual_2(Scanner sc) {

        int seleccioMenuVisual_2;
        try {
            seleccioMenuVisual_2=sc.nextInt();
        } catch (InputMismatchException e) {
            seleccioMenuVisual_2=0;
            errorCaracter_1();
            
        }

        if (seleccioMenuVisual_2 == 1)
            menuVisualPrincipal(sc);
        else
            errorCaracter_1();
    }

    public static void opcionsMenuVisual_3(Scanner sc) {

        int seleccioMenuVisual_3;
        try {
            seleccioMenuVisual_3=sc.nextInt();
        } catch (InputMismatchException e) {
            seleccioMenuVisual_3=0;
            errorCaracter_1();
            
        }

        if (seleccioMenuVisual_3 == 1){
            menuVisual_3_1(sc);

        }
        else if (seleccioMenuVisual_3 == 2) 
            menuVisual_3_2(sc);
        else if (seleccioMenuVisual_3 == 3)
            opcionsMenuVisualResetText();
        else if (seleccioMenuVisual_3 == 4)
            menuVisualPrincipal(sc);
        else 
            errorCaracter_1();

            
        
            
    }

    public static void opcionsMenuVisual_3_1(Scanner sc){

       
        try {
            seleccioMenuVisual_3_1=sc.nextInt();
        } catch (InputMismatchException e) {
            seleccioMenuVisual_3_1=0;
            errorCaracter_1();
        }
        canviarColor(sc);
        
    }

    public static void opcionsMenuVisual_3_2(Scanner sc) {

        int seleccioMenuVisual_3_2;
        try {
            seleccioMenuVisual_3_2=sc.nextInt();
        } catch (InputMismatchException e) {
            seleccioMenuVisual_3_2=0;
            errorCaracter_1();
            
        }

        if (seleccioMenuVisual_3_2 == 1)
            menuVisualEstilText();
        else if (seleccioMenuVisual_3_2 == 2)
            menuVisualDecoracionText();
        else if (seleccioMenuVisual_3_2 == 3)
            menuVisualPrincipal(sc);
        else
            errorCaracter_1();
    }

    public static void opcionsMenuVisualColorCanviat() {

        Scanner sc = new Scanner(System.in);

        menuVisualPrincipal(sc);

    }

    public static void opcionsMenuVisualResetText() {
        // Reset the Characters and color
        //redirects to a message in a "Visual" menu

        colorActual = "\u001B[37m";
        textStyle = "\u001B[0m";
        textDecoration = "\u001B[0m";
        menuVisualResetText();
    }
    
    public static void opcionsMenuVisualEstilText() {
        //import Scanner to be able to receieve input
        //redirects to canviarEstilText(sc);
       
        Scanner sc = new Scanner(System.in);

        try {
            seleccioMenuVisualEstilText = sc.nextInt();
        } catch (InputMismatchException e) {
            errorCaracter_1();
        }
        
        canviarEstilText(sc);


    }

    public static void opcionsmenuVisualSuccessChange() {
        //redirects to home menu after a successfull change
        
        Scanner sc = new Scanner(System.in);

        try {
            Thread.sleep(1750);
        } catch (InterruptedException e) {

            //nothing for the moment
        }

        menuVisualPrincipal(sc);

    }

    public static void opcionsMenuVisualDecoracionText() {
        //import scanner to be able to recieve input
        //redirects to canviarDecoracionText(sc);

        Scanner sc = new Scanner(System.in);

        try {
            seleccioMenuVisualDecoracionText = sc.nextInt();
        } catch (InputMismatchException e) {
            errorCaracter_1();
        }

        canviarDecoracionText(sc);
    }

}
