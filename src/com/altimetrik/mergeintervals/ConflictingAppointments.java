package com.altimetrik.mergeintervals;

import java.util.Arrays;

public class ConflictingAppointments {

    public static boolean canAttendAllAppointments(Interval[] intervals) {
        // TODO: Write your code here
        //List<Interval> list = Arrays.asList(intervals);
        Arrays.sort(intervals,(a, b)->Integer.compare(a.start,b.start));
        Interval firstInterval = intervals[0];
        int firstStrt = firstInterval.start;
        int firstEnd = firstInterval.end;
        for(int i=1;i<intervals.length;i++){
            Interval secondInterval = intervals[i];
            int secondStrt = secondInterval.start;
            int secondEnd = secondInterval.end;

            if(firstStrt <= secondEnd && firstEnd >= secondStrt){
                return false;
            }
            firstStrt = secondStrt;
            firstEnd = secondEnd;
        }
        return true;
    }

    public static void main(String[] args) {
        Interval[] intervals = { new Interval(1, 4), new Interval(2, 5), new Interval(7, 9) };
        boolean result = ConflictingAppointments.canAttendAllAppointments(intervals);
        System.out.println("Can attend all appointments: " + result);

        Interval[] intervals1 = { new Interval(6, 7), new Interval(2, 4), new Interval(8, 12) };
        result = ConflictingAppointments.canAttendAllAppointments(intervals1);
        System.out.println("Can attend all appointments: " + result);

        Interval[] intervals2 = { new Interval(4, 5), new Interval(2, 3), new Interval(3, 6) };
        result = ConflictingAppointments.canAttendAllAppointments(intervals2);
        System.out.println("Can attend all appointments: " + result);
    }
}
