import javafx.application.Application;
public class DistributionFunc {

public static void printArray(double[] ary) {
 String result = "[";
 for (int i = 0; i < ary.length ; i++) {
  result += " " + ary[i];
  if (i != ary.length - 1) {
    result += ",";
  }
}
 System.out.println(result + "]");
}

public static void PrintArray(int[][] ary) {
  String result = "[";
  for (int i = 0; i < ary.length ; i++) {
    for(int j = 0; j < ary[i].length ; j++) {
      if ( j == 0 ) {
        result += "{";
      }
      if ( j == ary[i].length - 1) {
        result += ary[i][j];
        result += "}, \n";
      }
      else{
        result += ary[i][j] + ",";
      }
    }
  }
  System.out.println(result + "]");
}

public static int rthPowerNum(int base, int r){
	int result = 1;
	for(int i = 1; i <= r; i++) {
		result = result * base;
	}
	return result;
}

public static int[] rthPowerDatabase(int power, int start, int end) {
	double data = Math.sqrt(start);
	int base = (int)data;
	int[] result = new int[end-start+1];
	int bindex = 0;
	for(int i = start; i <= end  ; i++) {
		if (rthPowerNum(base,power) <= end && rthPowerNum(base,power) >= start) {
		result[bindex] = rthPowerNum(base, power);
		bindex++;
		}
		if (rthPowerNum(base,power) > end) {
		i = end + 1;
		}
		base += 1;
	}
	int FnLength = 0;
	for(int i = 0; i < result.length ; i++) {
		if (result[i] != 0) {
			FnLength++;
		}
	}
	int[] answer =  new int[FnLength];
	int index = 0;
	for(int i = 0; i < result.length ; i++) {
		if (result[i] != 0) {
			answer[index] = result[i];
			index++;
		}
	}

	return answer;
}

public static int rthPowerCount(int power, int start, int end) {

	int[] result = rthPowerDatabase(power,start,end);
	return result.length;
}

//public static int[][] DistribFunc(int start, int group, int size, int power) {
//	int end = start + group*size;
//	int[][] result = new int[group][];
//	for (int i= 1; i <= group; i++) {
//		int first = (i-1)*size + 1;
//		int last = i*size;
//		result[i-1] = rthPowerDatabase(power,first,last);
//	}
//	return result;
//}

public static double DistribStat(int start, int group, int size, int power) {
	int num = 0;
	int total = start + group*size - 1;
	for(int i = 1; i <= group ; i++) {
		int first = start + (i-1)*size + 1;
		int end  = start + i*size;
		if (rthPowerCount(power,first,end) > 0) {
			num++;
		}
	}
	return ((double)num / (double)group)*100;
}

//public static int MaxNum(int n, int size, int start, int first) {

//}



//public static boolean isPrime(int num) {
//int score = 0;
//for(int i = 2; i < num; i++) {
//	if (num % i != 0) {
//		score++;
//	}
//}
//if (score == num - 2) {
//	return true;
//}
//else {
//	return false;
//}
//}

//public static int[] PrimeList(int start, int end) {
//int count = 0;
//for(int i = start; i <= end; i++) {
//	if (isPrime(i)) {
//		count++;
//	}
//}
//int[] result = new int[count];
//int index = 0;
//for(int i = start; i <= end; i++) {
//	if(isPrime(i)) {
//		result[index] = i;
//		index++;
//	}
//}
//return result;
//}

//public static double PrimeChance(int start, int group, int size) {
//int end = start + group*size - 1;
//int num = 0;
//int total = group*size;
//for(int i = 1; i <= group; i++) {
//	int first = (i-1)*size + start;
//	int last = i*size;
//	int[] database = PrimeList(first,last);
//	if(database.length > 0) {
//		num++;
//	}
//}
//	return ((double)num / (double)group)*100;
//}

//public static int PrimePosition(int start,int end,int prime) {
//int[] database = PrimeList(start,end);
//int pos = 0;
//for(int i =0; i<database.length ; i++) {
//	if(database[i] == prime) {
//		pos = i;
//		i = database.length;
//	}
//}
//return pos;
//}

public static void main(String[] args){



int start = 0;
int group = 0;
int size = 0;
//String variable = args[5];
//int factor = Integer.parseInt(args[4]);
//System.out.println(rthPowerNum(3,2));
//System.out.println(rthPowerCount(2,141,150));
//System.out.println(DistribStat(start,group,size,2));
for(int i = 1; i <= 100; i++) {
  start = start + i*3;
  size = size + i*3;
  group = group + i*3;
	System.out.println(DistribStat(start,group,size,3));
}
//PrintArray(DistribFunc(1,1500,10,2));
//System.out.println("The Number 9 is Prime? " + isPrime(9));
//printArray(rthPowerDatabase(2,141,150));
//System.out.println(PrimeChance(1,50,2));
//System.out.println("The Position of Prime 97 between 20 and 140 is: " + PrimePosition(20,140,97));
}

}
