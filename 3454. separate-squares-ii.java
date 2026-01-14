import java.util.*;

class Solution {
    public double separateSquares(int[][] squares) {
        List<Event> events = new ArrayList<>();
        
        for (int[] square : squares) {
            int x = square[0];
            int y = square[1];
            int l = square[2];
            events.add(new Event(y, 1, x, x + l));
            events.add(new Event(y + l, -1, x, x + l));
        }
        
        Collections.sort(events, (a, b) -> Integer.compare(a.y, b.y));
        
        List<Interval> xs = new ArrayList<>();
        int prev_y = events.get(0).y;
        int total = 0;
        List<Area> areas = new ArrayList<>();
        
        for (Event event : events) {
            int y = event.y;
            int typ = event.typ;
            int x1 = event.x1;
            int x2 = event.x2;
            
            if (y > prev_y && !xs.isEmpty()) {
                int h = y - prev_y;
                int w = unionLen(xs);
                areas.add(new Area(prev_y, h, w));
                total += h * w;
            }
            
            if (typ == 1) {
                xs.add(new Interval(x1, x2));
            } else {
                xs.remove(new Interval(x1, x2));
            }
            prev_y = y;
        }
        
        double half = total / 2.0;
        double acc = 0;
        
        for (Area area : areas) {
            if (acc + area.h * area.w >= half) {
                return area.y + (half - acc) / area.w;
            }
            acc += area.h * area.w;
        }
        
        return 0.0;
    }
    
    private int unionLen(List<Interval> intervals) {
        List<Interval> sorted = new ArrayList<>(intervals);
        Collections.sort(sorted, (a, b) -> Integer.compare(a.a, b.a));
        
        int res = 0;
        int end = Integer.MIN_VALUE;
        
        for (Interval interval : sorted) {
            int a = interval.a;
            int b = interval.b;
            
            if (a > end) {
                res += b - a;
                end = b;
            } else if (b > end) {
                res += b - end;
                end = b;
            }
        }
        
        return res;
    }
    
    static class Event {
        int y, typ, x1, x2;
        
        Event(int y, int typ, int x1, int x2) {
            this.y = y;
            this.typ = typ;
            this.x1 = x1;
            this.x2 = x2;
        }
    }
    
    static class Interval {
        int a, b;
        
        Interval(int a, int b) {
            this.a = a;
            this.b = b;
        }
        
        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (!(obj instanceof Interval)) return false;
            Interval other = (Interval) obj;
            return this.a == other.a && this.b == other.b;
        }
        
        @Override
        public int hashCode() {
            return Objects.hash(a, b);
        }
    }
    
    static class Area {
        int y, h, w;
        
        Area(int y, int h, int w) {
            this.y = y;
            this.h = h;
            this.w = w;
        }
    }

    // Test cases
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test case 1
        int[][] squares1 = {{0,0,1},{2,2,1}};
        double output1 = solution.separateSquares(squares1);
        System.out.println("Test 1: squares = [[0,0,1],[2,2,1]]");
        System.out.printf("Output: %.5f, Expected: 1.00000%n", output1);
        
        // Test case 2
        int[][] squares2 = {{0,0,2},{1,1,1}};
        double output2 = solution.separateSquares(squares2);
        System.out.println("Test 2: squares = [[0,0,2],[1,1,1]]");
        System.out.printf("Output: %.5f, Expected: 1.00000%n", output2);
        
        System.out.println("\nTest cases executed!");
    }
}
