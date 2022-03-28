

import java.util.*;

public class friendCost {
    
	private final int V;

	private final LinkedList<Integer> graph[];

	Graph(int v)
	{
		V = v;
		graph = new LinkedList[v];
		for (int i = 0; i < v; ++i)
			graph[i] = new LinkedList();
	}

        
	void addEdge(int v, int w)
	{
		graph[v].add(w);
                                     graph[w].add(v); 
	}

	
                 int co=1;
                
	int DFSV(int v, boolean visited[])
	{
	                 
		visited[v] = true;
		
                
		Iterator<Integer> i = graph[v].listIterator();
		while (i.hasNext())
		{
                                                    
			int n = i.next();
                                                       
			if (!visited[n]){
			DFSV(n, visited);
                                                       co++;
                                                             }
		}
                
                return co;
                
	}
        
        
	void DFS(int v)
	{
		boolean visited[] = new boolean[V];
                                   
                                    int total=0;
                                   
                                     for(int i=0;i<V;i++){
                                         
                                                 if(!visited[i]){
                                                            
                                                             DFSV(i, visited);
                                                             total+=(co*(co-1));
                                                             co=1;
                                                    }
                                     }
                                     
                                   System.out.println("total : "+total);
                                     
	}


	public static void main(String args[])
	{
	
            
                             
                            Scanner s=new Scanner(System.in);
                            System.out.print("Enter number of groups : ");
                            int gp=s.nextInt();
                            
                            for(int  i=0; i<gp;i++){
                        
                                int total=0;
                                System.out.print("Enter number of group "+(i+1)+" : ");
                                 int v=s.nextInt(); 
                                System.out.print("Enter number of friendship group "+(i+1)+" : ");  
                                int e=s.nextInt();
                                
                         Graph g = new Graph(v);
  
                                 for(int j=0; j<e; j++){
                                     System.out.print("Enter friendship "+(j+1) +" of group "+(i+1)+" : ");
                                     int x=s.nextInt();   int y=s.nextInt();
                                    g.addEdge(x-1, y-1);
                                 }
                                 
                               g.DFS(0);
                              
                            }
        }
}

