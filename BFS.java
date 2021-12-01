package pack;

import java.util.LinkedList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Queue;
public class BFS {
    int size;
    boolean visit[];
    LinkedList<Integer>[] list; //각 노드의 간선이 적혀있는 배열이라고 생각함
    Queue<Integer> node_queue;
    BFS(int size){
        this.size = size;
        node_queue = new LinkedList<Integer>();
        list = new LinkedList[size+1];

        for(int i=0 ; i<size+1 ; i++){
            list[i] = new LinkedList<Integer>();
        }
        visit = new boolean[this.size+1];
        Arrays.fill(visit,false);
    }

    int[] depthList; //해당 노드의 depth
    public void BFSUtil(int v){
        if(visit[v] == false)
            visit[v] = true;

        Iterator<Integer> i = list[v].listIterator();

        while(i.hasNext()){
            int next = i.next();
            if(!visit[next]){
                node_queue.add(next);
                if(depthList[next] == 0)
                    depthList[next] = depthList[v]+1;
                
            }
        }
    }


    public void BFSExecute(int v){
        depthList = new int[this.size+1];
        node_queue.add(v);
        while(!node_queue.isEmpty()){
            if(!visit[node_queue.peek()])//방문하지 않은 노드만 체크
                BFSUtil(node_queue.poll());
            else
                node_queue.poll();
        }
    }

    public void add_edge(int start, int end){
        list[start].add(end);
        list[end].add(start); //단방향이라면 제거하도록함
    }
    public int[] getDepthList(){
        return depthList;
    }

}
