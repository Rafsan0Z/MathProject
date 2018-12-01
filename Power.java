import java.util.ArrayList;
public class Power{
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
    for(int i = start; i <= end && end > Num(base,power); i++) {
      int Test = Num(base,power);
      if(Element(Test,start,end)) {
        result.add(Test);
      }
      base++;
    }
    return result;
  }
}
