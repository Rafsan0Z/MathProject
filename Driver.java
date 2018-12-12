import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.time.LocalTime;
import java.util.Scanner;
import java.util.ArrayList;

public class Driver{

  public static void standardLimitTest(int start, int group, int size, int pow, int iterations, File XP) {
    try{
    BufferedWriter draw = new BufferedWriter(new FileWriter(XP));
    for(int i = 0; i < iterations; i++) {
      Power limittest = new Power(start,group,size,pow);
      double result = limittest.DistribStat();
      draw.write("We will write something here" + result + "\n");
      size++;
      start++;
      group++;
    }
    draw.close();
  } catch(IOException e) {}
  }

  public static void customLimitTest(int start,int group, int size, int pow, int iterations, int[] increments, File XP) {
    try{
      BufferedWriter draw = new BufferedWriter(new FileWriter(XP));
      Power cusLimittest = new Power(start,size,group,pow);
      for(int i=0; i < iterations; i++) {
//        cusLimittest.DistribStat();
        start += increments[0];
        size += increments[1];
        group += increments[2];
        draw.write("Write custom things here" + "\n");
      }
      draw.close();
    } catch(IOException e) {}
    }

  public static void main(String[] args) throws IOException {

    System.out.println("--------------------------------------------!Welcome!---------------------------------------------");
    System.out.println("----------------------------------!Granular Distribution Tester!---------------------------------------------");
    System.out.println("This version of the program is limited to the terminal. For this reason, it is highly recommended that you read the user manuel before you begin testing! Write 'go to manuel' below to do so. Write 'continue' otherwise! ");
    Scanner input = new Scanner(System.in);
    String refer = input.nextLine();
    if(refer.equals("go to manuel")) {
      ProcessBuilder pb = new ProcessBuilder("Notepad.exe" , "Manuel");
      pb.start();
      System.exit(1);
    }
    System.out.println("Input test type below. Not case sensitive");
    String type = input.nextLine();
    System.out.println("Input the name of the file to store test results");
    String TestFile = input.nextLine();
    System.out.println("--------------------");

    String bridge = "C:/Users/mzama/.ssh/MathProject/Tests/";
    String path = bridge + TestFile;
    File file = new File(path);

    if(file.exists()) {
      System.out.println("File already exists");
      System.out.println("Do you want to add results to an existing file? If So then Write 'Yes'");
      String answer = input.nextLine();
      if(answer.equals("Yes")) {
        System.out.println("The result has been added!");
        System.exit(1);
      }
      System.out.println("No Test! Chose different file Name and retest");
      System.out.println("----------END----------");
      System.exit(1);
    }
    else {
      file.createNewFile();
      System.out.println("File Created!");
      System.out.println("--------------------");
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
      System.out.println("What style of test do you want: Press '1' for regular test or Press '2' for limit test!");
      String style = input.nextLine();
      if(style.equals("2")) {
        System.out.println("What type of limit test do you want? Press '1' for standard limit test or Press '2' for custom limit test!");
        String styletype = input.nextLine();
        if(styletype.equals("2")) {
          System.out.println("Input the increment for size");
          int sizeIncr = Integer.parseInt(input.nextLine());
          System.out.println("Input the increment for start");
          int startIncr = Integer.parseInt(input.nextLine());
          System.out.println("Input the increment for group");
          int groupIncr = Integer.parseInt(input.nextLine());
          System.out.println("Input the number of iterations");
          int iter = Integer.parseInt(input.nextLine());
          int[] values = {startIncr,sizeIncr,groupIncr};
          customLimitTest(start,size,num,pow,iter,values,file);
        }
        else {
          System.out.println("Input the number of iterations");
          int iter = Integer.parseInt(input.nextLine());
          standardLimitTest(start,num,size,pow,iter,file);
        }
      }
      else{
//        regularTest(start,size,num,pow);
      }
      System.out.println("Tests Successful! Visit Tests Directory for results!");
      input.close();
    }
    else if(type.equals("prime")) {
      System.out.println("Test is not yet available");
      System.out.println("----------END----------");
      file.delete();
      System.exit(1);
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
