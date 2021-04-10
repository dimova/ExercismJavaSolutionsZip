import java.util.ArrayList;
import java.util.List;

class MinesweeperBoard {
    private List<char[]> board = new ArrayList<>();

    MinesweeperBoard(List<String> inputBoard) {
        for (String s :
                inputBoard) {
            board.add(s.toCharArray());
        }

    }

    List<String> withNumbers() {
        List<String> output=new ArrayList<>();
        int numberOfLines = board.size();

        for (int i = 0; i < numberOfLines; i++) {
            int numberOfColumns = board.get(i).length;
            for (int j = 0; j < board.get(i).length; j++) {
                if (board.get(i)[j] == '*') {
                    if (j + 1 < numberOfColumns) {
                        if (board.get(i)[j + 1] != '*') {
                            if (board.get(i)[j + 1] == ' ') {
                                board.get(i)[j + 1] = '1';
                            } else {
                                board.get(i)[j + 1] = (char) (board.get(i)[j + 1] + 1);
                            }
                        }
                    }
                    if (j - 1 >= 0) {
                        if (board.get(i)[j - 1] != '*') {
                            if (board.get(i)[j - 1] == ' ') {
                                board.get(i)[j - 1] = '1';
                            } else {
                                board.get(i)[j - 1] = (char) (board.get(i)[j - 1] + 1);
                            }
                        }
                    }

                    if (i + 1 < numberOfLines) {
                        if (board.get(i + 1)[j] != '*') {
                            if (board.get(i + 1)[j] == ' ') {
                                board.get(i + 1)[j] = '1';
                            } else {
                                board.get(i + 1)[j] = (char) (board.get(i + 1)[j] + 1);
                            }
                        }

                        if (j + 1 < numberOfColumns) {
                            if (board.get(i + 1)[j + 1] != '*') {
                                if (board.get(i + 1)[j + 1] == ' ') {
                                    board.get(i + 1)[j + 1] = '1';
                                } else {
                                    System.out.println(board.get(i + 1)[j + 1]);
                                    board.get(i + 1)[j + 1] = (char) (board.get(i + 1)[j + 1] + 1);
                                }
                            }
                        }
                        if (j - 1 >= 0) {
                            if (board.get(i + 1)[j - 1] != '*') {
                                if (board.get(i + 1)[j - 1] == ' ') {
                                    board.get(i + 1)[j - 1] = '1';
                                } else {
                                    board.get(i + 1)[j - 1] = (char) (board.get(i + 1)[j - 1] + 1);
                                }
                            }
                        }
                    }

                    if (i - 1 >= 0) {
                        if (board.get(i - 1)[j] != '*') {
                            if (board.get(i - 1)[j] == ' ') {
                                board.get(i - 1)[j] = '1';
                            } else {

                                board.get(i - 1)[j] = (char) (board.get(i - 1)[j] + 1);
                            }
                        }


                        if (j + 1 < numberOfColumns) {
                            if (board.get(i - 1)[j + 1] != '*') {
                                if (board.get(i - 1)[j + 1] == ' ') {
                                    board.get(i - 1)[j + 1] = '1';
                                } else {
                                    board.get(i - 1)[j + 1] = (char)(board.get(i - 1)[j + 1] + 1);
                                }
                            }
                        }
                        if (j - 1 >= 0) {
                            if (board.get(i - 1)[j - 1] != '*') {
                                if (board.get(i - 1)[j - 1] == ' ') {
                                    board.get(i - 1)[j - 1] = '1';
                                } else {
                                    board.get(i - 1)[j - 1] = (char) (board.get(i - 1)[j - 1] + 1);
                                }
                            }
                        }
                    }
                }
            }
        }

        for (char[] cArray:
                this.board) {
            output.add(new String(cArray));
        }

        return output;

    }
}
