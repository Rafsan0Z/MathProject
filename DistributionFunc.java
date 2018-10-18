
public class DistributionFunc {

public static void printArray(int[] ary) {
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
	int base = 1;
	int first = start;
	int[] result = new int[end-start+1];
	for(int i = 0; first <= end  ; i++) {
		if (rthPowerNum(base,power) <= end && rthPowerNum(base,power) >= start) {
		result[i] = rthPowerNum(base, power);
		}
		if (rthPowerNum(base,power) > end) {
		i = end + 1;
		}
		base += 1;
		first += 1;
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

//public static String  NormalDistribution(int a, int K, int N, int r) {
	//int range = K*N - a;
	//int[] database = rthPowerDatabase(r,range);
	//int result = database.length * 100;
	//return "" + (result / (K*N - a)) + "%" ;
//}

public static int[][] DistribFunc(int start, int group, int size, int power) {
	int end = start + group*size;
	int[][] result = new int[group][];
	for (int i= 1; i <= group; i++) {
		int first = (i-1)*size + 1;
		int last = i*size;
		result[i-1] = rthPowerDatabase(power,first,last);
	} 
	return result;
}

public static int DistribStat(int start, int group, int size, int power) {
//	int[][] database = DistribFunc(start,group,size,power);
	int num = 0;
//	for (int i =1 ; i <= group; i++) {
//		if (i == 1 && database[0].length > 0) {
//			num += 1;
//		}
//		else if ((database[i-1].length - database[i-2].length) > 0){
//			num += 1;
//		}
//	}
//	return num;
	for(int i = 1; i <= group ; i++) {
		int first = start + (i-1)*size;
		int end  = i*size;
		if (rthPowerCount(power,first,end) > 0) {
			num++;
		}
	}
	return num;	
}

public static boolean isPrime(int num) {
int score = 0;
for(int i = 2; i < num; i++) {
	if (num % i != 0) {
		score++;
	}
}
if (score == num - 2) {
	return true;
}
else {
	return false;
}
}

public static int[] PrimeList(int start, int end) {
int count = 0;
for(int i = start; i <= end; i++) {
	if (isPrime(i)) {
		count++;
	}
}
int[] result = new int[count];
int index = 0;
for(int i = start; i <= end; i++) {
	if(isPrime(i)) {
		result[index] = i;
		index++;
	}
}
return result;
}

public static int PrimePosition(int start,int end,int prime) {
int[] database = PrimeList(start,end);
int pos = 0;
for(int i =0; i<database.length ; i++) {
	if(database[i] == prime) {
		pos = i;
		i = database.length;
	}
}
return pos;
}

public static void main(String[] args){

//System.out.println(NormalDistribution(0,10,5,2));
System.out.println(rthPowerNum(3,2));
System.out.println(rthPowerCount(2,1,100));
System.out.println(DistribStat(1,4,25,2));
System.out.println("The Number 97 is Prime? " + isPrime(97));
printArray(rthPowerDatabase(2,4532,78376));
printArray(PrimeList(20,140));
System.out.println("The Position of Prime 97 between 20 and 140 is: " + PrimePosition(20,140,97));
//System.out.println(SubdivDistribution(0,100,10,10,3));
//printArray(RangedRthPowerDatabase(2,11,50));
//PrintArray(DistribFunc(1,100,5,2));
//System.out.println(DistribStat(1,100,10,2));
}

}
