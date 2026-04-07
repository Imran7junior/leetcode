class Robot {

    int w, h;
    int x, y;
    int dir; // 0=East, 1=North, 2=West, 3=South
    int per;

    public Robot(int width, int height) {
        this.w = width;
        this.h = height;
        this.x = 0;
        this.y = 0;
        this.dir = 0; // initially East
        this.per = 2 * (w + h) - 4;
    }
    
    public void step(int num) {
        if (per == 0) return;

        num %= per;

        // special case: full cycle
        if (num == 0) {
            if (x == 0 && y == 0) {
                dir = 3; // South
            }
            return;
        }

        while (num > 0) {
            if (dir == 0) { // East
                int move = Math.min(num, w - 1 - x);
                x += move;
                num -= move;
                if (num > 0) dir = 1;
            } 
            else if (dir == 1) { // North
                int move = Math.min(num, h - 1 - y);
                y += move;
                num -= move;
                if (num > 0) dir = 2;
            } 
            else if (dir == 2) { // West
                int move = Math.min(num, x);
                x -= move;
                num -= move;
                if (num > 0) dir = 3;
            } 
            else { // South
                int move = Math.min(num, y);
                y -= move;
                num -= move;
                if (num > 0) dir = 0;
            }
        }
    }
    
    public int[] getPos() {
        return new int[]{x, y};
    }
    
    public String getDir() {
        if (dir == 0) return "East";
        if (dir == 1) return "North";
        if (dir == 2) return "West";
        return "South";
    }
    
    public static void main(String[] args) {
        // Example 1
        Robot robot = new Robot(6, 3);
        System.out.println("Example 1: Robot(6, 3)");
        robot.step(2);
        robot.step(2);
        System.out.println("After step(2), step(2): getPos=" + java.util.Arrays.toString(robot.getPos()) + ", getDir='" + robot.getDir() + "'");
        System.out.println("Expected: getPos=[4, 0], getDir='East'");
        System.out.println();
        
        robot.step(2);
        robot.step(1);
        robot.step(4);
        System.out.println("After step(2), step(1), step(4): getPos=" + java.util.Arrays.toString(robot.getPos()) + ", getDir='" + robot.getDir() + "'");
        System.out.println("Expected: getPos=[1, 2], getDir='West'");
    }
}

/**
 * Your Robot object will be instantiated and called as such:
 * Robot obj = new Robot(width, height);
 * obj.step(num);
 * int[] param_2 = obj.getPos();
 * String param_3 = obj.getDir();
 */