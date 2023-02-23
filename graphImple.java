import java.util.*;
public class graphImple {
    
    static class graph{

      //  HashMap<T , List<T>> map = new HashMap<>();

      

        void addEdge(int u , int v, boolean direction, ArrayList<ArrayList<Integer>> al){

            //boolean direction = 0 -> undirected graph
            // direction = 1 -> directed graph

            // map.put(u, new ArrayList<T>());
            // map.get(u).add(v);
            // if(direction == false){
            //     map.put(v, new ArrayList<>());
            //     map.get(v).add(u);
            // }

            al.get(u).add(v);
            if(!direction)al.get(v).add(u);
            
        }


        void printList(ArrayList<ArrayList<Integer>> al){
        //    for(T key: map.keySet()){
        //     System.out.println(key + "-> " + map.get(key));
           
        // }
        for(int i = 0; i<al.size(); i++){
            System.out.print(i + "-> ");
            for(int j = 0; j<al.get(i).size(); j++){
                System.out.print(al.get(i).get(j) + ",");
            }
            System.out.println();
        }

    }

    ArrayList<Integer> bfsTraversal(int n, ArrayList<ArrayList<Integer>> adj){

        ArrayList<Integer> bfs = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();

        int visited[] = new int[n];  //we are considering graphs 0based i.e starting node may be 0 if graph would be 1based then we 
                                     // may create visited array of n+
        q.add(0);
        visited[0] = 1;

        while(!q.isEmpty()){

            int node = q.remove();
            bfs.add(node);

            for(int it: adj.get(node)){
                if(visited[it]==0){
                    visited[it]=1;
                        q.add(it);
                }
            }
        }
        return bfs;
    }

    public void dfsTraversal(int node, int visited[], ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> dfs){
       
        visited[node] = 1;
        dfs.add(node);
        for(int i : adj.get(node)){
            if(visited[i]==0){
                dfsTraversal(i, visited, adj, dfs);
            }
        }
    }
    ArrayList<Integer> dfsOfGraph(int n , ArrayList<ArrayList<Integer>> adj ){
        int visited[] = new int[n];
        ArrayList<Integer> dfs = new ArrayList<>();
        dfsTraversal(0,visited, adj, dfs );
        return dfs;
    }
}

     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of nodes");
        int n = sc.nextInt();
        System.out.println("Eneter number of edges");
        int m = sc.nextInt();

        graph g = new graph();
        ArrayList<ArrayList<Integer>> adj =new ArrayList<>(n);
        for(int i = 0; i<n ; i++){
            adj.add(new ArrayList<Integer>());
        }

        for(int i =0; i<m ; i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            g.addEdge(u, v, false, adj);
        }

       // g.printList(al);

       System.out.println(g.bfsTraversal(n, adj));
        System.out.println(g.dfsOfGraph(n, adj));

    }
}
