class CustomStack(object):

    def __init__(self, maxSize):
        """
        :type maxSize: int
        """
        self.s=[None]*maxSize
        self.top=-1
        self.size=maxSize

    def push(self, x):
        """
        :type x: int
        :rtype: None
        """
        if self.top+1==self.size:
            return
        if self.top==-1:
            self.top=0
            self.s[self.top]=x
        else:
            self.top+=1
            self.s[self.top]=x

    def pop(self):
        """
        :rtype: int
        """
        if self.top==-1:
            return -1
        val=self.s[self.top]
        self.top-=1
        return val

    def increment(self, k, val):
        """
        :type k: int
        :type val: int
        :rtype: None
        """
        if self.top==-1:
            return
        t=self.top
        for i in range(k):
            self.s[i]=self.s[i]+val
            t-=1
            if t==-1:
                break


# Your CustomStack object will be instantiated and called as such:
# obj = CustomStack(maxSize)
# obj.push(x)
# param_2 = obj.pop()
# obj.increment(k,val)