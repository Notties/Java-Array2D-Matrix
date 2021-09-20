import javax.swing.*;

public class Ass5Matries {

    public static Ass5Matries a = new Ass5Matries();
    int arrd[][];
    int arrt[][];

    public static void main(String[] args) throws Exception {
        a.menu();
    }

    public void menu() {
        int ch;

        do {
            try{
                ch = Integer.parseInt(JOptionPane
                        .showInputDialog("##############" + "\n Sparse Matrices" + "\n ##############" + "\n 1. Diagonal"
                                + "\n 2. Lower triangular" + "\n 3. print" + "\n 0. exit" + "\n ##############"));

                switch (ch) {
                    case 1:
                        a.diagonal();
                        break;
                    case 2:
                        a.triangular();
                        break;
                    case 3:
                        a.submenu();
                        break;
                    case 0:
                        JOptionPane.showMessageDialog(null, "Program Exit");
                        System.exit(0);
                }
            }catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Please Input Number");
            }
        } while (ch != 0);
    }

    public void submenu() {
        int ch;

        do {
            ch = Integer.parseInt(JOptionPane.showInputDialog(
                    "##############" + "\n Sub Menu Print" + "\n ##############" + "\n 1. Row-Major Mapping"
                            + "\n 2. Column-Major Mapping" + "\n 0. return to Main menu" + "\n ##############"));

            switch (ch) {
                case 1:
                    a.printRowMajor();
                    break;
                case 2:
                    a.printcolMajor();
                    break;
                case 0:
                    a.menu();
                    break;
            }
        } while (ch != 0);
    }

    public void diagonal() {

        int col = 0;
        int row = 0;
        int matrix = 0;
        int number = 0;
        boolean check = false;
        String out = "";

        do {
            check = false;
            try {
                matrix = Integer.parseInt(JOptionPane.showInputDialog("Enter row & column for the array (max 10)"));
                col = matrix;
                row = matrix;
                if ((row > 0 && row <= 10) && (col > 0 && col <= 10)) {
                    check = true;
                    arrd = new int[col][row];
                } else {
                    JOptionPane.showMessageDialog(null, "Please Input Number 1 - 10");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Please Input Number 1 - 10");
            }
        } while (!check);

        out += (row * col) + " Array Elements\n";

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                check = false;
                if (i != j) {
                    arrd[i][j] = 0;
                    out += arrd[i][j] + "   ";
                    check = true;
                } else {
                    do {

                        try {
                            number = Integer.parseInt(JOptionPane.showInputDialog(out));
                            check = true;
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "Please Input Number");
                        }
                    } while (!check);
                    if (i == j) {
                        arrd[i][j] = number;
                    }
                    out += arrd[i][j] + "   ";
                }
            }
            out += "\n";
        }

        JOptionPane.showMessageDialog(null, out);

    }

    public void triangular() {

        int col = 0;
        int row = 0;
        int number = 0;
        boolean check = false;
        String out = "";

        do {
            check = false;
            try {
                int matrix = Integer.parseInt(JOptionPane.showInputDialog("Enter row & column for the array (max 10)"));
                col = matrix;
                row = matrix;
                if ((row > 0 && row <= 10) && (col > 0 && col <= 10)) {
                    check = true;
                    arrt = new int[col][row];
                } else {
                    JOptionPane.showMessageDialog(null, "Please Input Number 1 - 10");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Please Input Number 1 - 10");
            }
        } while (!check);

        out += (row * col) + " Array Elements\n";

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                check = false;
                if (i < j) {
                    arrt[i][j] = 0;
                    out += arrt[i][j] + "   ";
                    check = true;
                } else {
                    do {

                        try {
                            number = Integer.parseInt(JOptionPane.showInputDialog(out));
                            check = true;
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "Please Input Number");
                        }
                    } while (!check);
                    if (i >= j) {
                        arrt[i][j] = number;
                    }
                    out += arrt[i][j] + "   ";
                }
            }
            out += "\n";
        }

        JOptionPane.showMessageDialog(null, out);

    }

    public void printRowMajor() {
        String out = "Print Diagonal Matrix\n";

        for (int i = 0; i < arrd.length; i++) {
            for (int j = 0; j < arrd[i].length; j++) {
                out += arrd[i][j] + "   ";
            }
            out += "\n";
        }

        out += "\nRow-Major Mapping\n";

        for (int i = 0; i < arrd.length; i++) {
            for (int j = 0; j < arrd[i].length; j++) {
                if (arrd[i][j] != 0) {
                    out += arrd[i][j] + "   ";
                }
            }
        }
        out += "\n";
        out += "\nPrint Lower triangular matrix\n";

        for (int i = 0; i < arrt.length; i++) {
            for (int j = 0; j < arrt[i].length; j++) {
                out += arrt[i][j] + "   ";
            }
            out += "\n";
        }

        out += "\nRow-Major Mapping\n";

        for (int i = 0; i < arrt.length; i++) {
            for (int j = 0; j < arrt[i].length; j++) {
                if (arrt[i][j] != 0) {
                    out += arrt[i][j] + "   ";
                }
            }
        }
        JOptionPane.showMessageDialog(null, out);

    }

    public void printcolMajor() {
        String out = "Print Diagonal Matrix\n";

        for (int i = 0; i < arrd.length; i++) {
            for (int j = 0; j < arrd[i].length; j++) {
                out += arrd[i][j] + "   ";
            }
            out += "\n";
        }

        out += "\nColumn-Major Mapping\n";

        for (int i = 0; i < arrd.length; i++) {
            for (int j = 0; j < arrd[i].length; j++) {
                if (arrd[j][i] != 0) {
                    out += arrd[i][j] + "   ";
                }
            }
        }
        out += "\n";
        out += "\nPrint Lower triangular matrix\n";

        for (int i = 0; i < arrt.length; i++) {
            for (int j = 0; j < arrt[i].length; j++) {
                out += arrt[i][j] + "   ";
            }
            out += "\n";
        }
        out += "\nColumn-Major Mapping\n";

        for (int i = 0; i < arrt.length; i++) {
            for (int j = 0; j < arrt[i].length; j++) {
                if (arrt[j][i] != 0) {
                    out += arrt[j][i] + "   ";
                }
            }
        }
        JOptionPane.showMessageDialog(null, out);

    }
}
