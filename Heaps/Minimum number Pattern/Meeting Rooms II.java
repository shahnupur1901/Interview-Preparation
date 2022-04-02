/**
 * Definition of Interval:
 * public classs Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Node{
    int time;
    //start or end?
    char when;
    Node(int t, char w){
        time = t;
        when = w;
    }
}
public class Solution {
    /**
     *
     //Going in increasing order of time progression
    
    public int minMeetingRooms(List<Interval> intervals) {
        // Write your code here
        PriorityQueue<Node> minHeap = new PriorityQueue(new Comparator<Node>(){
            @Override
            public int compare(Node x, Node y){
                //if start/end at same time, give greater priority to end Node
                if(x.time == y.time) return x.when == 'e' ? -1 : 1;
                //MinHeap based on time
                return x.time < y.time ? -1 : 1;
            }
        });
        for (Interval i : intervals){
            //add in priorityQueue
            minHeap.add(new Node(i.start, 's'));
            minHeap.add(new Node(i.end, 'e'));
        }
        int count = 0;
        int maxCount = 0;
        while(!minHeap.isEmpty()){
            Node x = minHeap.poll();
            //if a new conference is starting : increase room necessity by 1
            if(x.when == 's') count++;
            else
            //conference ending? decrement by 1
                count--;
            //System.out.println(count);
            maxCount = Integer.max(count, maxCount);
        }
        return maxCount;
    }
    */
    public int minMeetingRooms(List<Interval> intervals) {
        int start[] = new int[intervals.size()];
        int end[] = new int[intervals.size()];
        for(int x=0;x<intervals.size();x++){
            start[x] = intervals.get(x).start;
            end[x] = intervals.get(x).end;
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int count = 0, maxCount = 0;
        //pointers in arrays
        int sidx = 0, eidx =  0;
        while(sidx < intervals.size()){
            //get the earlier time
            if(start[sidx] < end[eidx]){
                count ++;
                sidx ++;
            }
            //else, ending time is early, of if start == end, give more priority to end
            else{
                count --;
                eidx ++;
            }
            maxCount = Integer.max(count,maxCount);
        }
        return maxCount;
    }
}
