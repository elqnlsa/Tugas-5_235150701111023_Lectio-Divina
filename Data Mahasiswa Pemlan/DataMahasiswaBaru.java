import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DataMahasiswaBaru extends JFrame {

    private JTextField nameField, dobField, registrationField, phoneField, addressField, emailField;
    private JButton submitButton;

    public DataMahasiswaBaru() {
        setTitle("Form Pendaftaran Mahasiswa Baru");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 20, 5, 20);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        Dimension textFieldSize = new Dimension(300, 30);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;
        add(new JLabel("Nama Lengkap:"), gbc);
        nameField = new JTextField();
        nameField.setPreferredSize(textFieldSize);
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        add(nameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.EAST;
        add(new JLabel("Tanggal Lahir:"), gbc);
        dobField = new JTextField();
        dobField.setPreferredSize(textFieldSize);
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        add(dobField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.EAST;
        add(new JLabel("Nomor Pendaftaran:"), gbc);
        registrationField = new JTextField();
        registrationField.setPreferredSize(textFieldSize);
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        add(registrationField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.EAST;
        add(new JLabel("No. Telp:"), gbc);
        phoneField = new JTextField();
        phoneField.setPreferredSize(textFieldSize);
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        add(phoneField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.EAST;
        add(new JLabel("Alamat:"), gbc);
        addressField = new JTextField();
        addressField.setPreferredSize(textFieldSize);
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        add(addressField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.EAST;
        add(new JLabel("E-mail:"), gbc);
        emailField = new JTextField();
        emailField.setPreferredSize(textFieldSize);
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        add(emailField, gbc);

        submitButton = new JButton("Submit");
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        add(submitButton, gbc);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (areFieldsEmpty()) {
                    JOptionPane.showMessageDialog(null, "Semua kolom harus diisi", "Warning", JOptionPane.WARNING_MESSAGE);
                } else {
                    int confirm = JOptionPane.showConfirmDialog(null, "Apakah anda yakin data yang anda isi sudah benar?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
                    if (confirm == JOptionPane.YES_OPTION) {
                        displayData();
                    }
                }
            }
        });
    }

    private boolean areFieldsEmpty() {
        return nameField.getText().trim().isEmpty() || dobField.getText().trim().isEmpty() ||
               registrationField.getText().trim().isEmpty() || phoneField.getText().trim().isEmpty() ||
               addressField.getText().trim().isEmpty() || emailField.getText().trim().isEmpty();
    }

    private void displayData() {
        JFrame dataFrame = new JFrame("Data Mahasiswa");
        dataFrame.setSize(300, 200);
        dataFrame.setLocationRelativeTo(null);

        JTextArea dataArea = new JTextArea();
        dataArea.setEditable(false);
        dataArea.setText("Nama\t: " + nameField.getText() + "\n" +
                         "Tanggal Lahir\t: " + dobField.getText() + "\n" +
                         "No. Pendaftaran: " + registrationField.getText() + "\n" +
                         "No. Telp\t: " + phoneField.getText() + "\n" +
                         "Alamat\t: " + addressField.getText() + "\n" +
                         "E-mail\t: " + emailField.getText());

        dataFrame.add(new JScrollPane(dataArea));
        dataFrame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new DataMahasiswaBaru().setVisible(true);
            }
        });
    }
}
