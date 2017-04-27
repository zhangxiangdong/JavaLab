package me.zhang.array.game;

/**
 * Created by zhangxiangdong on 2017/4/27.
 */
public class Scoreboard {

    private int numEntries = 0; // 已有GameEntry个数
    private GameEntry[] board; // 记录保存的GameEntry

    public Scoreboard(int capacity) {
        board = new GameEntry[capacity];
    }

    public void add(GameEntry entry) {
        int newScore = entry.getScore();

        // 满足：数组未满；新增GameEntry大于最小的记录
        if (numEntries < board.length || newScore > board[numEntries - 1].getScore()) {
            if (numEntries < board.length) { // GameEntry未存满
                numEntries++; // 总记录数+1
            }

            int i = numEntries - 1;
            // 向后移动小于待插入项，找到待插入位置
            while (i > 0 && board[i - 1].getScore() < newScore) {
                board[i] = board[i - 1];
                i--;
            }
            board[i] = entry; // 插入新的GameEntry
        }
    }

    public GameEntry remove(int i) throws IndexOutOfBoundsException {
        if (i < 0 || i >= numEntries) {
            throw new IndexOutOfBoundsException("Invalid Index: " + i);
        }

        GameEntry removed = board[i];
        for (int j = i; j < numEntries - 1; j++) {
            board[j] = board[j + 1];
        }

        board[numEntries - 1] = null;
        numEntries--;
        return removed;
    }

}
