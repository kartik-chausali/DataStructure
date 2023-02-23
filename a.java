import java.util.*;

import javax.print.attribute.standard.Media;
class a{
   static class MedianFinder {
        ArrayList<Integer> al = new ArrayList<>();
        //  public MedianFinder() {
        //      MedianFinder obj = new MedianFinder();
             
        //  }
         
         public void addNum(int num) {
             al.add(num);
         }
         
         public double findMedian() {
             int median = 0;
             int n = al.size();
             if(al.size()>1){
                 if(al.size()%2==0){
                    median = (al.get(n/2) +( al.get((n/2)+1)))/2;
                 }else median = (al.get(n/2));
             }
             return median;
         }
     }
    public static void main(String[] args) {
            MedianFinder obj = new MedianFinder(); 
            obj.addNum(1);
            obj.addNum(2);
            System.out.println(obj.findMedian());
            obj.addNum(3);
            System.out.println(obj.findMedian());
    }
   
}