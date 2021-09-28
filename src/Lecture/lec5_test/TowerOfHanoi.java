package Lecture.lec5_test;

public class TowerOfHanoi {
    int[][] rods;
    int height;

    public TowerOfHanoi(int n) {
        height = n;
        rods = new int[3][];

        for (int i = 0; i < 3; i++) {
            rods[i] = new int[n];
        }
        for (int i = 0; i < n; i++) {
            rods[0][i] = n - i;
        }

    }

    public void draw() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < 3; j++) {
                drawBlank(height - rods[j][height - i - 1]);
                drawBox(rods[j][height - i - 1]);
                System.out.print("\u2610");
                drawBox(rods[j][height - i - 1]);
                drawBlank(height - rods[j][height - i - 1]);
                drawBlank(5);
            }
            System.out.println();
        }
        drawBox(2*height+1);
        drawBlank(5);
        drawBox(2*height+1);
        drawBlank(5);
        drawBox(2*height+1);
        drawBlank(5);
    }

    public void drawBox(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print("\u2610");
        }
    }

    public void drawBlank(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(" ");
        }
    }

    public static void main(String[] args) {
        TowerOfHanoi towerOfHanoi = new TowerOfHanoi(5);
        towerOfHanoi.draw();
    }
}
