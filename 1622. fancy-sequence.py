class Fancy:

    MOD = 10**9 + 7

    def __init__(self):
        self.arr = []
        self.mul = 1
        self.add = 0

    def mod_pow(self, a, b):
        res = 1
        a %= self.MOD
        while b > 0:
            if b & 1:
                res = (res * a) % self.MOD
            a = (a * a) % self.MOD
            b >>= 1
        return res

    def mod_inverse(self, x):
        return self.mod_pow(x, self.MOD - 2)

    def append(self, val: int) -> None:
        stored = ((val - self.add) % self.MOD * self.mod_inverse(self.mul)) % self.MOD
        self.arr.append(stored)

    def addAll(self, inc: int) -> None:
        self.add = (self.add + inc) % self.MOD

    def multAll(self, m: int) -> None:
        self.mul = (self.mul * m) % self.MOD
        self.add = (self.add * m) % self.MOD

    def getIndex(self, idx: int) -> int:
        if idx >= len(self.arr):
            return -1
        return (self.arr[idx] * self.mul + self.add) % self.MOD

if __name__ == "__main__":
    # Test case
    fancy = Fancy()
    operations = ["Fancy", "append", "addAll", "append", "multAll", "getIndex", "addAll", "append", "multAll", "getIndex", "getIndex", "getIndex"]
    values = [[], [2], [3], [7], [2], [0], [3], [10], [2], [0], [1], [2]]
    expected = [None, None, None, None, None, 10, None, None, None, 26, 34, 20]
    
    print("Test case for Fancy Sequence:")
    print("Operations:", operations)
    print("Values:", values)
    print("Expected:", expected)
    print()
    
    results = []
    fancy = Fancy()
    
    for i in range(1, len(operations)):
        op = operations[i]
        val = values[i]
        
        if op == "append":
            fancy.append(val[0])
            result = None
        elif op == "addAll":
            fancy.addAll(val[0])
            result = None
        elif op == "multAll":
            fancy.multAll(val[0])
            result = None
        elif op == "getIndex":
            result = fancy.getIndex(val[0])
        
        results.append(result)
        print(f"{op}{val} -> {result} (Expected: {expected[i]})")