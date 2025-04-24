package Builder;

import org.jetbrains.annotations.NotNull;

public class ChessBoard {

    private final int moveRook;
    private final int moveQueen;
    private final int moveBishop;

    private ChessBoard(@NotNull Builder builder) {
        this.moveRook = builder.moveRook;
        this.moveQueen = builder.moveQueen;
        this.moveBishop = builder.moveBishop;
    }

    public int getMoveRook(){
        return moveRook;
    }

    public int getMoveQueen(){
        return moveQueen;
    }

    public int getMoveBishop(){
        return moveBishop;
    }


    public static class Builder{
        private int moveRook;
        private int moveQueen;
        private int moveBishop;


        public Builder setMoveRook(int moveRook){
            this.moveRook = moveRook;
            return this;
        }

        public Builder setMoveQueen(int moveQueen) {
            this.moveQueen = moveQueen;
            return this;
        }

        public Builder setMoveBishop(int moveBishop){
            this.moveBishop = moveBishop;
            return this;
        }

        public ChessBoard build(){
            return new ChessBoard(this);
        }

    }
}
