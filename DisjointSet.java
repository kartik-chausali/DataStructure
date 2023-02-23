import java.util.*;
public class DisjointSet {

   static class Disjoint{
        List<Integer> rank = new ArrayList<>();
        List<Integer> parent = new ArrayList<>();
        List<Integer> size = new ArrayList<>();

        Disjoint(int n){
            for(int i =0; i<=n; i++){
                rank.add(0);
                parent.add(i);
                size.add(1); //initially all single nodes size will be 1
            }
        }

        public int find_Parent(int node){
            if( node == parent.get(node))return node;

           int ultimate_parent = find_Parent(parent.get(node)); //finding ultimate parent by recursion
           parent.set(node, ultimate_parent);  //doing path compression
           return parent.get(node);

        }

        public void UnionByRank(int u, int v){
            int ulp_u = find_Parent(u);
            int ulp_v = find_Parent(v);

            if(ulp_u == ulp_v)return; //i.e they belong to same component i.e cannot join them 

            if(rank.get(ulp_u) > rank.get(ulp_v)){  //smaller one getting attached to larger one
                parent.set(ulp_v, ulp_u);  //hence changing parent of smaller one to larger one
            }else if(rank.get(ulp_v) > rank.get(ulp_u)){
                parent.set(ulp_u, ulp_v);
            }else {
                parent.set(ulp_u, ulp_v);  //can join either of them with each other
                int rankV = rank.get(ulp_v);  //here we actually increases the rank 
                rank.set(ulp_v, rankV+1);
            }
        }

        public void UnionBySize(int u, int v){
            int ulp_u = find_Parent(u);
            int ulp_v = find_Parent(v);

            if(ulp_u == ulp_v)return;

            if(size.get(ulp_u) > size.get(ulp_v)){
                parent.set(ulp_v, ulp_u);
                size.set(ulp_u, size.get(ulp_u)+size.get(ulp_v));  //increase the size
            }else{  //in by rank we needed else if and then else bcoz there we are only increasing rank when both rank are equal but here we increase the size everytime so no need of an else if
                parent.set(ulp_u, ulp_v); 
                size.set(ulp_v, size.get(ulp_v)+size.get(ulp_u));  //increase the size
            }
        }
    }

  public static void main(String[] args) {
    
     Disjoint ds = new Disjoint(7);

     ds.UnionBySize(1, 2);
     ds.UnionBySize(2, 3);
     ds.UnionBySize(4, 5);
     ds.UnionBySize(6, 7);
     ds.UnionBySize(5, 6);
    
     if(ds.find_Parent(3) == ds.find_Parent(7))System.out.println("Same");
     else System.out.println("Not same");
     ds.UnionByRank(3, 7);
     if(ds.find_Parent(3) == ds.find_Parent(7))System.out.println("Same");
     else System.out.println("Not same");
     

  }
    
}
