import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/**
 * Created by Zmiecer on 18.11.2015.
 */

public class Frame extends JFrame
{
    public Frame (String s)
    {
        super(s);
        JPanel panel = new JPanel();
        setBounds(100, 100, 600, 400);
        setContentPane(panel);
        panel.setLayout(new BorderLayout());

        JPanel panel1 = new JPanel();
        panel1.setBounds(0, 0, 100, 50);
        panel.add(panel1, BorderLayout.SOUTH);


        JPanel panel2 = new JPanel(new GridLayout(0, 1));
        panel2.setBounds(0, 0, 100, 50);
        panel.add(panel2, BorderLayout.WEST);

        JLabel label1 = new JLabel("�������� ����������:      ");

        JRadioButton linButton = new JRadioButton("��������������");
        linButton.setSelected(true);

        JRadioButton expButton = new JRadioButton("��������������");

        ButtonGroup group = new ButtonGroup();
        group.add(linButton);
        group.add(expButton);

        panel2.add(label1);
        panel2.add(linButton);
        panel2.add(expButton);

        JTextField editFile = new JTextField();
        editFile.setBounds(100, 100, 100, 100);


        JLabel label2 = new JLabel("������� ��� ����� ��� ���������� ����� ����������: ");

        JPanel panel3 = new JPanel(new GridLayout(0, 1));
        panel3.add(label2);
        panel3.add(editFile);
        panel.add(panel3, BorderLayout.NORTH);

        JPanel panel4 = new JPanel(new GridLayout(0, 1));
        JLabel labelElem = new JLabel("  ������� ��������� ����������:      ");
        JLabel labelDelta = new JLabel("  ������� ����������� ����������: ");
        JLabel labelLength = new JLabel("  ������� ����� ����������: ");
        JTextField editElem = new JTextField();
        JTextField editDelta = new JTextField();
        JTextField editLength = new JTextField();
        panel4.add(labelElem);
        panel4.add(editElem);
        panel4.add(labelDelta);
        panel4.add(editDelta);
        panel4.add(labelLength);
        panel4.add(editLength);
        panel.add(panel4, BorderLayout.CENTER);


        JButton buttonOk = new JButton("OK");
        JButton buttonClear = new JButton("Clear");
        JButton buttonSave = new JButton("Save");
        JPanel panel5 = new JPanel();
        panel5.setBounds(0, 0, 100, 0);
        panel5.setLayout(new GridLayout(0, 1));
        panel1.add(buttonOk);
        panel1.add(buttonClear);
        panel1.add(buttonSave);


        JLabel labelOut = new JLabel("���������: ");
        panel4.add(labelOut);
        panel.add(panel5, BorderLayout.EAST);


        buttonOk.addActionListener(e -> {
            try {
                if (editElem.getText().length() < 1) {
                    throw new IllegalArgumentException("������� ���������!");
                }
                if (editDelta.getText().length() < 1) {
                    throw new IllegalArgumentException("������� �����������!");
                }
                if (editLength.getText().length() < 1) {
                    throw new IllegalArgumentException("������� �����!");
                }
                double el = new Double(editElem.getText());
                double del = new Double(editDelta.getText());
                int len = new Integer(editLength.getText());
                if (linButton.isSelected()) {
                    Linear line = new Linear(el, del, len);
                    labelOut.setText("<html>" + "���������:   " + line.toString() + "  " + "</html>");
                } else if (expButton.isSelected()) {
                    Exponential exp = new Exponential(el, del, len);
                    labelOut.setText("<html>" + "���������:   " + exp.toString() + "  " + "</html>");
                }


            } catch (IllegalArgumentException ee) {
                labelOut.setText("  " + ee.getMessage() + "  ");
            }
        });

        buttonClear.addActionListener(e ->
        {
            labelOut.setText("���������: ");
        });

        buttonSave.addActionListener(e ->
        {
            try {
                if (editFile.getText().length() < 1) {
                    throw new IllegalArgumentException("������� ��� �����!");
                }
                double el = new Double(editElem.getText());
                double del = new Double(editDelta.getText());
                if (linButton.isSelected())
                {
                    Linear line = new Linear(el, del, 10);
                    line.write(editFile.getText() + ".txt");
                }
                else if (expButton.isSelected())
                {
                    Exponential exp = new Exponential(el, del, 10);
                    exp.write(editFile.getText() + ".txt");
                }
            }
            catch (IllegalArgumentException ee) {
                labelOut.setText("  " + ee.getMessage() + "  ");
            }
            catch (IOException ee)
            {
                labelOut.setText("  " + "Invalid file name!" + "  ");
            }
        });


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);


    }
    public static void main(String[] args) {
        Frame frame = new Frame("����������");
    }
}
