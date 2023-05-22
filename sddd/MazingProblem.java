package sddd;

import java.util.ArrayDeque;
import java.util.Deque;

enum Directions {
    N, NE, E, SE, S, SW, W, NW
}

class Offset {
    int a;
    int b;

    public Offset(int a, int b) {
        this.a = a;
        this.b = b;
    }
}

public class MazingProblem {
    private static final Offset[] MOVES = {
        new Offset(-1, 0),   // N
        new Offset(-1, 1),   // NE
        new Offset(0, 1),    // E
        new Offset(1, 1),    // SE
        new Offset(1, 0),    // S
        new Offset(1, -1),   // SW
        new Offset(0, -1),   // W
        new Offset(-1, -1)   // NW
    };

    public static void path(int[][] maze, int[][] mark, int ix, int iy) {
        mark[ix][iy] = 2;  // 출구

        Deque<Offset> stack = new ArrayDeque<>();
        stack.push(new Offset(ix, iy));

        while (!stack.isEmpty()) {
            Offset current = stack.pop();
            int i = current.a;
            int j = current.b;

            if (maze[i][j] == 0) {  // 갈 수 있는 경로인 경우
                mark[i][j] = 1;  // 경로로 표시

                if (i == 0 || i == maze.length - 1 || j == 0 || j == maze[0].length - 1) {
                    // 출구에 도달한 경우
                    System.out.println("There is an exit");  // 경로가 존재함을 출력
                    return;
                }

                for (Offset move : MOVES) {
                    int g = i + move.a;
                    int h = j + move.b;

                    if ((g >= 0 && g < maze.length) && (h >= 0 && h < maze[0].length) && (mark[g][h] == 0)) {
                        // 새로운 위치가 미로 내부이고, 방문하지 않은 곳인 경우
                        stack.push(new Offset(g, h));
                    }
                }
            }
        }

        System.out.println("No path in maze");
    }

    public static void main(String[] args) {
        int[][] maze = {
            { 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1 },
            { 1, 0, 0, 0, 1, 1, 0, 1, 1, 1, 0, 0, 1, 1, 1 },
            { 0, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 1, 1 },
            { 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 0, 0 },
            { 1, 1, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1 },
            { 0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 0, 0, 1, 0, 1 },
            { 0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 0, 0, 1, 0, 1 },
            { 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1 },
            { 0, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1 },
            { 1, 1, 0, 0, 0, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0 },
            { 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0 },
            { 0, 1, 0, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0 }
        };

        int[][] mark = new int[maze.length][maze[0].length];

        path(maze, mark, 11, 14);

        System.out.println("mark:");
        for (int[] row : mark) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}