import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.time.LocalTime;
import java.util.Scanner;

public class Driver{

  public static void main(String[] args) throws IOException {

    Scanner input = new Scanner(System.in);
    System.out.println("Input test type below. Not case sensitive");
    String type = input.nextLine();
    System.out.println("Input the name of the file to store test results");
    String TestFile = input.nextLine();
    System.out.println("--------------------");

    String bridge = "C:/Users/mzama/.ssh/MathProject/Tests/";
    String path = bridge + TestFile;
    File file = new File(path);

    try{
      file.createNewFile();
      System.out.println("File Created!");
      System.out.println("--------------------");
    } catch(IOException e) {
      System.out.println("File already exists");
      System.out.println("No Test! Chose different file Name and retest");
      System.out.println("----------END----------");
      System.exit(1);
    }

      if(type.equals("power")) {
      System.out.println("Input start value");
      int start = Integer.parseInt(input.nextLine());
      System.out.println("Input group size");
      int size = Integer.parseInt(input.nextLine());
      System.out.println("Input number of groups");
      int num = Integer.parseInt(input.nextLine());
      System.out.println("Input degree");
      int pow = Integer.parseInt(input.nextLine());
      System.out.println("--------------------");
      System.out.println("What style of test do you want: Press '1' for regular test or Press '2' for limit test!")
      int style = Integer.parseInt(input.nextLine());
      Power test = new Power(0,10,10,2);
      System.out.println("Tests Successful! Visit Tests Directory for results!")
      input.close();
    }
    else if(type.equals("prime")) {

    }
    else {
      System.out.println("Test not found!");
      System.out.println("----------END----------");
      System.exit(1);
    }

    String time = java.time.LocalTime.now().toString();
    String data = "New Test Done. Time: " + time + ".";
    try{
      BufferedWriter out = new BufferedWriter(new FileWriter("TestRecords.txt",true));
      BufferedReader read = new BufferedReader(new FileReader("TestRecords.txt"));
      long count = read.lines().count();
      read.close();
      out.write(data + "Test #: " + count + "." + "File: " + TestFile + "\n");
      out.close();
    } catch(IOException e) {
      System.out.println("Something is Wrong! Check the Directory");
    }

  }



}


/* References (Mostly Online Sources) :

  1. AVAJAVA Web Tutorials, How do I read a String from a File line-by-Line
  2. Tech Tutorials, How to Read File From The Line in java
  3. Java Date Time - LocalTime to toString()
  4. JavaTPoint, Get Current Date and time.
  5. GeeksforGeeks Java: Appending String to a File
  6. JournelDev Java create new file
  7. Javarevisited, How to Create File and Directory in Java Example



*/
