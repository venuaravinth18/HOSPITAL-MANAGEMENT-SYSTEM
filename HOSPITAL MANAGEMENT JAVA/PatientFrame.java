import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class PatientFrame extends JFrame {
    private JTextField nameField, ageField, phoneField, addressField, bloodGroupField;
    private JComboBox<String> genderComboBox;
    private JButton addButton, updateButton, deleteButton, clearButton;

    public PatientFrame() {
        setTitle("Patient Management");
        setSize(600, 400);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(7, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        panel.add(new JLabel("Name:"));
        nameField = new JTextField();
        panel.add(nameField);

        panel.add(new JLabel("Age:"));
        ageField = new JTextField();
        panel.add(ageField);

        panel.add(new JLabel("Gender:"));
        genderComboBox = new JComboBox<>(new String[]{"Male", "Female", "Other"});
        panel.add(genderComboBox);

        panel.add(new JLabel("Phone:"));
        phoneField = new JTextField();
        panel.add(phoneField);

        panel.add(new JLabel("Address:"));
        addressField = new JTextField();
        panel.add(addressField);

        panel.add(new JLabel("Blood Group:"));
        bloodGroupField = new JTextField();
        panel.add(bloodGroupField);

        addButton = new JButton("Add");
        addButton.addActionListener(e -> addPatient());
        panel.add(addButton);

        updateButton = new JButton("Update");
        updateButton.addActionListener(e -> updatePatient());
        panel.add(updateButton);

        deleteButton = new JButton("Delete");
        deleteButton.addActionListener(e -> deletePatient());
        panel.add(deleteButton);

        clearButton = new JButton("Clear");
        clearButton.addActionListener(e -> clearFields());
        panel.add(clearButton);

        add(panel);
    }

    private void addPatient() {
        String name = nameField.getText();
        int age = Integer.parseInt(ageField.getText());
        String gender = (String) genderComboBox.getSelectedItem();
        String phone = phoneField.getText();
        String address = addressField.getText();
        String bloodGroup = bloodGroupField.getText();

        try (Connection conn = DBConnection.getConnection()) {
            String query = "INSERT INTO patients (name, age, gender, phone, address, blood_group) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, name);
            stmt.setInt(2, age);
            stmt.setString(3, gender);
            stmt.setString(4, phone);
            stmt.setString(5, address);
            stmt.setString(6, bloodGroup);
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(this, "Patient added successfully!");
        } catch (SQLException | NumberFormatException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    private void updatePatient() {
        // Implement update logic
    }

    private void deletePatient() {
        // Implement delete logic
    }

    private void clearFields() {
        nameField.setText("");
        ageField.setText("");
        genderComboBox.setSelectedIndex(0);
        phoneField.setText("");
        addressField.setText("");
        bloodGroupField.setText("");
    }
}