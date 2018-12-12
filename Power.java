import java.util.ArrayList;
public class Power implements Groups{
  private int r;
  private int s,g,n;

  public Power(int start, int group, int size, int power) {
    r = power;
    s = start;
    g = group;
    n = size;
 //   DistribStat(s,g,n);
  }

  public int Num(int base) {
      int result = 1;
      for(int i = 1; i <= r; i++) {
        result = result * base;
      }
      return result;
  }

  public int count(int start, int end) {
    ArrayList<Integer> result = database(start, end);
    return result.size();
  }

  public boolean Element(int num, int start, int end){
    if(num > start && num <= end) {return true;}
    else {return false;}
  }

  public ArrayList<Integer> database(int start, int end) {
    double data = Math.sqrt(start);
    int base = (int) data;
    ArrayList<Integer> result = new ArrayList<Integer>();
    for(int i = start; i <= end; i++) {
      int Test = Num(base);
      if(Element(Test,start,end)) {
        result.add(Test);
      }
      base++;
    }
    return result;
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
}
