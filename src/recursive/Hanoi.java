package recursive;

/**
 * 汉诺伊塔
 */
public class Hanoi {

    public void move(int[] data) {
        if (data == null || data.length == 0) {
            return;
        }
        moveInner(data, data.length, 1, 3);
    }

    private void moveInner(int[] data, int count, int origin, int target) {
        if (count <= 1) {
            doMove((char) data[count - 1], origin, target);
            return;
        }
        int tmp = getTarget(origin, target);
        moveInner(data, count - 1, origin, tmp);
        doMove((char) data[count - 1], origin, target);
        moveInner(data, count - 1, tmp, target);
    }

    private void doMove(char data, int origin, int target) {
        System.out.println("将《" + data + "》from " + origin + " to " + target);
    }

    private int getTarget(int one, int two) {
        if (one == 1 && two == 2 || one == 2 && two == 1) {
            return 3;
        } else if (one == 1 && two == 3 || one == 3 && two == 1) {
            return 2;
        } else if (one == 2 && two == 3 || one == 3 && two == 2) {
            return 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        Hanoi test = new Hanoi();
        test.move(new int[]{'A','B','C'});
    }
}
