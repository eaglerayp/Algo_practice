import java.util.*;

/**
 * Created by eagle on 2015/3/20.
 */
public class LRUCache {
    // doubly linklist method
    public class node{
        public int key;
        public int value;
        public node next_node;
        public node prev_node;
        public node(int k,int v,node prev,node next){
            key=k;
            value=v;
            next_node=next;
            prev_node=prev;
        }
    }

    HashMap<Integer,node> Cache=new HashMap<Integer, node>();
    int maxsize;
    node head;
    node end;
    public LRUCache(int capacity) {
        maxsize=capacity;
    }

    public int get(int key) {
        if(Cache.containsKey(key)){
            node nownode=Cache.get(key);
            int value=nownode.value;
            shift_to_head(nownode);
            return value;
        }else{
            return -1;
        }
    }

    public void set(int key, int value) {
        if(Cache.size()==0){
            head=new node(key,value,null,null);
            end =head;
            Cache.put(key,head);
        }else{
            if(Cache.containsKey(key)){//替換
                node nownode=Cache.get(key);
                nownode.value=value;
                shift_to_head(nownode);
            }else if(Cache.size()==maxsize){//remove end  insert to head
                Cache.remove(end.key);
                if(end!=head) {
                    end = end.prev_node;
                }
                end.next_node=null;

                node newhead=new node(key,value,null,head);
                head.prev_node=newhead;
                head=newhead;
                Cache.put(key,head);
            }else{//insert to head
                node newhead=new node(key,value,null,head);
                head.prev_node=newhead;
                head=newhead;
                Cache.put(key,head);
            }
        }
    }

    public void shift_to_head(node nownode){
        if(nownode!=head){
            nownode.prev_node.next_node=nownode.next_node;
            if(nownode!=end){
                nownode.next_node.prev_node=nownode.prev_node;
            }else{
                end=nownode.prev_node;
            }
            nownode.next_node=head;
            head.prev_node=nownode;
            head=nownode;
        }
    }
    // linked hashmap method
    /*static LinkedHashMap<Integer,Integer> Cache=new LinkedHashMap<Integer, Integer>();
    static int maxsize;
    public LRUCache(int capacity) {
        maxsize=capacity;
    }

    public int get(int key) {
        if(Cache.containsKey(key)){
            int value=Cache.get(key);
            Cache.remove(key);
            Cache.put(key,value);
            return value;
        }else{
            return -1;
        }
    }

    public void set(int key, int value) {
        if(Cache.size()==maxsize&&!Cache.containsKey(key)){
            Cache.remove(Cache.keySet().iterator().next());
        }
        else if(Cache.containsKey(key)){
            Cache.remove(key);
        }
        Cache.put(key,value);
    }*/
}