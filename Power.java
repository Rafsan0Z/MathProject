import java.util.ArrayList;
public class Power implements Groups{
  private int power;
  private int start,group,size;

  public Power(int s, int g, int n, int r) {
    power = r;
    start = s;
    group = g;
    size = n;
 //   DistribStat(s,g,n);
  }

  public int Num(int base, int r) {
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
      int Test = Num(base,power);
      if(Element(Test,start,end)) {
        result.add(Test);
      }
      base++;
    }
    return result;
  }

  public double DistribStat(int start, int group, int size) {
    int num = 0;
    for(int i = 1; i <= group; i++) {
      int first = start + (i-1)*size + 1;
      int end = start + i*size;
      if(count(first,end) > 0) {num++;}
    }
    return ((double)num / (double)group)*100;
  }
}
