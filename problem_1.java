// Time Complexity : O(n log n), n -> no. of intervals
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Approach:
// 1. Sort the intervals based on start time
// 2. Use Min Heap to store the end time
// 3. If the curr start time is later than or equal to the min end time in min heap,
// there is no overlap, we can use the same room, remove the min from heap, insert the cur end time
//    Else add the cur end time without removing min from heap
// 4. Return the size of heap as minimun meeting rooms

import java.util.Arrays;
import java.util.PriorityQueue;

public class problem_1 {
    public int minMeetingRooms(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        PriorityQueue<Integer> endTimes = new PriorityQueue<>();

        for(int[] interval : intervals) {

            if(endTimes.isEmpty()) {
                endTimes.add(interval[1]);
            }
            else {
                int endtime = endTimes.peek();

                if(endtime <= interval[0]) {
                    endTimes.poll();
                }
                endTimes.add(interval[1]);
            }
        }
        return endTimes.size();
    }
}
