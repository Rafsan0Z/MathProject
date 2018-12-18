import java.util.ArrayList;
public class Power implements Groups{
  private int r;
  private int s,g,n;

  public Power(int start, int group, int size, int power) {
    r = power;
    s = start;
    g = group;
    n = size;
  }

  public int Num(int base) {
      int result = 1;
      for(int i = 1; i <= r; i++) {
        result = result * base;
      }
      return result;
  }

  public int count(int start, int end) {
    int[] result = database(start, end);
    return result.size();
  }

  public boolean Element(int num, int start, int end){
    if(num > start && num <= end) {return true;}
    else {return false;}
  }

  public int[] database(int start, int end) {
    double data = Math.sqrt(start);
  	int base = (int)data;
  	int[] result = new int[end-start+1];
  	int bindex = 0;
  	for(int i = start; i <= end  ; i++) {
  		if (Num(base,r) <= end && Num(base,r) >= start) {
  		result[bindex] = Num(base, r);
  		bindex++;
  		}
  		if (Num(base,r) > end) {
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

  public double DistribStat() {
    int num = 0;
    for(int i = 1; i <= g; i++) {
      int first = s + (i-1)*n + 1;
      int end = s + i*n;
      if(count(first,end) > 0) {num++;}
    }
    return ((double)num / (double)g)*100;
  }

  public String IntervalHops(int r1, int rn){
    String result = "";
    double data = Math.sqrt(s);
    int base = (int)data;
    int gapCounter = 0;
    for(int i = base; i >= rn*rn; i = i + n) {
      result += "This is the gap for perfect square " + r1*r1 + "and " + rn*rn + "is: " + gapCounter "." + "\n"; 
      gapCounter = 0;
    }
    return result;
  }
}
