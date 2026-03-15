class Fancy {

    static final long MOD = 1000000007;
    List<Long> arr;
    long mul, add;

    public Fancy() {
        arr = new ArrayList<>();
        mul = 1;
        add = 0;
    }

    long modPow(long a, long b) {
        long res = 1;
        a %= MOD;

        while (b > 0) {
            if ((b & 1) == 1)
                res = (res * a) % MOD;

            a = (a * a) % MOD;
            b >>= 1;
        }

        return res;
    }

    long modInverse(long x) {
        return modPow(x, MOD - 2);
    }

    public void append(int val) {
        long stored = ((val - add + MOD) % MOD * modInverse(mul)) % MOD;
        arr.add(stored);
    }

    public void addAll(int inc) {
        add = (add + inc) % MOD;
    }

    public void multAll(int m) {
        mul = (mul * m) % MOD;
        add = (add * m) % MOD;
    }

    public int getIndex(int idx) {
        if (idx >= arr.size()) return -1;
        return (int)((arr.get(idx) * mul + add) % MOD);
    }
    
    public static void main(String[] args) {
        // Test case
        String[] operations = {"Fancy", "append", "addAll", "append", "multAll", "getIndex", "addAll", "append", "multAll", "getIndex", "getIndex", "getIndex"};
        int[][] values = {{}, {2}, {3}, {7}, {2}, {0}, {3}, {10}, {2}, {0}, {1}, {2}};
        int[] expected = {-1, -1, -1, -1, -1, 10, -1, -1, -1, 26, 34, 20};
        
        System.out.println("Test case for Fancy Sequence:");
        System.out.println("Operations: [Fancy, append, addAll, append, multAll, getIndex, addAll, append, multAll, getIndex, getIndex, getIndex]");
        System.out.println("Values: [[], [2], [3], [7], [2], [0], [3], [10], [2], [0], [1], [2]]");
        System.out.println("Expected: [null, null, null, null, null, 10, null, null, null, 26, 34, 20]");
        System.out.println();
        
        Fancy fancy = new Fancy();
        
        for (int i = 1; i < operations.length; i++) {
            String op = operations[i];
            int val = values[i].length > 0 ? values[i][0] : 0;
            
            if (op.equals("append")) {
                fancy.append(val);
                System.out.println(op + "(" + val + ") -> null");
            } else if (op.equals("addAll")) {
                fancy.addAll(val);
                System.out.println(op + "(" + val + ") -> null");
            } else if (op.equals("multAll")) {
                fancy.multAll(val);
                System.out.println(op + "(" + val + ") -> null");
            } else if (op.equals("getIndex")) {
                int result = fancy.getIndex(val);
                System.out.println(op + "(" + val + ") -> " + result + " (Expected: " + expected[i] + ")");
            }
        }
    }
}