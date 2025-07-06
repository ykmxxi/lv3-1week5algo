//  Meats On The Grill

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int TC = sc.nextInt();
        while (TC-- > 0) {
            int H, W;
            H = sc.nextInt();
            W = sc.nextInt();
            sc.nextLine(); // 버퍼 비우기

            Map<Piece, Character> memory = new HashMap<>();
            for (int r = 0; r < H; ++r) {
                String str = sc.nextLine();
                for (int c = 0; c < W; ++c) {
                    if (str.charAt(c) == '.') continue;
                    memory.put(new Piece(H - 1 - r, c), str.charAt(c));
                }
            }


            for (int r = 0; r < H; ++r) {
                for (int c = 0; c < W; ++c) {
                    if (!memory.containsKey(new Piece(r, c))) {
                        System.out.print(".");
                        continue;
                    }

                    System.out.print(memory.get(new Piece(r, c)));
                }
                System.out.println();
            }
        }
    }
}

class Piece {
    private final int row;
    private final int column;

    public Piece(int row, int column) {
        this.row = row;
        this.column = column;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Piece piece = (Piece) o;
        return row == piece.row && column == piece.column;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, column);
    }
}
