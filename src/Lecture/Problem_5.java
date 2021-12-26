package Lecture;

public class Problem_5 {
    boolean[] s = new boolean[12];
    int[][] distance = new int[12][12];

    public Problem_5() {
        for (int i = 0; i < 12; i++) {
            s[i] = false;
            for (int j = 0; j < 12; j++) {
                distance[i][j] = 0;
            }
        }
    }

    public void addEdge(int a, int b, int dis) {
        distance[a-1][b-1] = dis;
        distance[b-1][a-1] = dis;
    }

    public void connect(){
        int minpath_start = 0, minpath_end = 0;
        int minpath_distance = 100;
        for (int i = 0; i < 12; i++) {
            if(s[i]) { // node i is in s
                // find unconnected node
                for (int j = 1; j < 12; j++) {
                    if(!s[j] && !(distance[i][j] == 0) && distance[i][j] < minpath_distance){ // unconnected
                        minpath_start = i;
                        minpath_end = j;
                        minpath_distance = distance[i][j];
                    }
                }
            }
        }
        s[minpath_end] = true;
        System.out.println("Connect " + (minpath_start+1) + " to " + (minpath_end+1));
    }

    public boolean connected() {
        for (int i = 0; i < 12; i++) if (!s[i]) return false;
        return true;
    }

    public void printSituation(){
        for (int i = 0; i < 12; i++)  System.out.print(s[i] + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        Problem_5 test = new Problem_5();
        test.addEdge(1,5,5);
        test.addEdge(1,2,5);
        test.addEdge(2,3,2);
        test.addEdge(2,5,4);
        test.addEdge(2,7,7);
        test.addEdge(3,4,4);
        test.addEdge(3,7,1);
        test.addEdge(4,7,3);
        test.addEdge(4,8,6);
        test.addEdge(5,6,3);
        test.addEdge(5,9,1);
        test.addEdge(6,7,2);
        test.addEdge(6,10,1);
        test.addEdge(7,8,8);
        test.addEdge(7,10,9);
        test.addEdge(7,11,1);
        test.addEdge(8,11,1);
        test.addEdge(8,12,4);
        test.addEdge(9,10,5);
        test.addEdge(10,11,2);
        test.addEdge(11,12,8);

        while (!test.connected()) test.connect();
    }
}
