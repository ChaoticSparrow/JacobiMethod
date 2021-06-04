import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Stack;

public class Main {

    public static void main(String[] args){
        int size = 3;
        int iterations = 7;
        double[][] testMatrix = {
                new double[]{4d, -1d, -1d},
                new double[]{-2d, 6d, 1d},
                new double[]{-1d, 1d, 7d}
        };
        double[][] testB = {
                new double[]{3d},
                new double[]{9d},
                new double[]{-6d}
        };
        double[][] testx = {
                new double[]{0},
                new double[]{0},
                new double[]{0}
        };

        Stack<double[][]> result = JacobiMethod.solveFor(testMatrix,testB, testx, iterations);

        for(int z = 0; z < result.size(); z++){

            for(int i = 0; i < result.get(z).length; i++){

                System.out.print("\n");
                for(int j = 0; j < result.get(z)[i].length; j++){

                    System.out.print(result.get(z)[i][j] + " ");
                }
            }
            System.out.print("\niteration: " + z);
        }
    }
}

//import javax.swing.*;
//        import javax.swing.table.DefaultTableModel;
//        import java.awt.*;
//        import java.awt.event.ActionEvent;
//        import java.awt.event.ActionListener;
//        import java.util.Stack;
//
//public class ResultDialog extends JDialog {
//    private JPanel contentPane;
//    private JButton buttonOK;
//    private JTable tblResult;
//    private JLabel lblConclusion;
//
//    public ResultDialog(Stack<double[][]> result, int size) {
//        setTitle("Jacobi Method Result");
//        setSize(new Dimension(800, 400));
//        setContentPane(contentPane);
//        setLocationRelativeTo(null);
//        setModal(true);
//        getRootPane().setDefaultButton(buttonOK);
//
//        DefaultTableModel data = new DefaultTableModel();
//
//        data.addColumn("n");
//        for(int z = 0; z < size; z++){
//            data.addColumn("x" + z);
//        }
//
//        for (int i = 0; i < result.size(); i++) {
//            double[][] array = result.get(i);
//            String[] d = new String[array.length + 1];
//            d[0] = String.valueOf(i);
//
//            for(int j = 0; j < array.length; j++){
//                for(int k = 0; k < array[j].length; k++){
//                    d[i+1] = String.valueOf(array[j][k]);
//                }
//            }
//        }
//
//        tblResult.setModel(data);
//        tblResult.setDragEnabled(false);
//        tblResult.setRowHeight(30);
//        tblResult.setFont(new Font("Times New Roman", Font.PLAIN, 14));
//
//        buttonOK.addActionListener(e -> onOK());
//    }
//
//    private void onOK() {
//        dispose();
//    }
//}
