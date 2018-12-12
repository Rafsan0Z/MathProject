public class Prime implements Groups{
  private int start,group,size;

  public Prime(int s, int g, int n) {
    group = g;
    size = n;
    start = s;
    DistribStat(s,g,n);
  }

  public boolean Element(int num) {

  }

  public boolean isPrime(int num) {
    int score = 0;
    for(int i = 2; i < num; i++) {
      if(num % i != 0) {
        score++;
      }
    }
    if(score == num - 2) {return true;}
    else{return false;}
  }

  public ArrayList<Integer> database(start,end) {

  }

}
