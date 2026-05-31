class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);

        long currentMass = mass;

        for (int asteroid : asteroids) {
            if (currentMass < asteroid) {
                return false;
            }

            currentMass += asteroid;
        }

        return true;
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        // Example 1
        int mass1 = 10;
        int[] asteroids1 = {3,9,19,5,21};
        boolean output1 = sol.asteroidsDestroyed(mass1, asteroids1);
        System.out.println("Example 1: mass=10, asteroids=[3,9,19,5,21]");
        System.out.println("Output: " + output1);
        System.out.println("Expected: true");
        System.out.println();
        
        // Example 2
        int mass2 = 5;
        int[] asteroids2 = {4,9,23,4};
        boolean output2 = sol.asteroidsDestroyed(mass2, asteroids2);
        System.out.println("Example 2: mass=5, asteroids=[4,9,23,4]");
        System.out.println("Output: " + output2);
        System.out.println("Expected: false");
    }
}