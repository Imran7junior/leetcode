class Solution {
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> result = new ArrayList<>();
        
        for (int hour = 0; hour < 12; hour++) {
            
            for (int minute = 0; minute < 60; minute++) {
                
                int totalBits = Integer.bitCount(hour) + Integer.bitCount(minute);
                
                if (totalBits == turnedOn) {
                    
                    String time = hour + ":" + 
                                  (minute < 10 ? "0" + minute : minute);
                    
                    result.add(time);
                }
            }
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        // Example 1:
        int turnedOn1 = 1;
        List<String> output1 = sol.readBinaryWatch(turnedOn1);
        System.out.println("Example 1: Input: turnedOn = " + turnedOn1);
        System.out.println("Output: " + output1);
        System.out.println("Expected: [0:01, 0:02, 0:04, 0:08, 0:16, 0:32, 1:00, 2:00, 4:00, 8:00]");
        System.out.println();
        
        // Example 2:
        int turnedOn2 = 9;
        List<String> output2 = sol.readBinaryWatch(turnedOn2);
        System.out.println("Example 2: Input: turnedOn = " + turnedOn2);
        System.out.println("Output: " + output2);
        System.out.println("Expected: []");
    }
}