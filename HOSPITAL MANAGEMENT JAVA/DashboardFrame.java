import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DashboardFrame extends JFrame {
    public DashboardFrame(String role) {
        setTitle("Hospital Management System - Dashboard");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new BorderLayout());
        JPanel buttonPanel = new JPanel(new GridLayout(5, 1, 10, 10));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JButton patientButton = new JButton("Manage Patients");
        patientButton.addActionListener(e -> new PatientFrame().setVisible(true));

        JButton doctorButton = new JButton("Manage Doctors");
        doctorButton.addActionListener(e -> new DoctorFrame().setVisible(true));

        JButton appointmentButton = new JButton("Manage Appointments");
        appointmentButton.addActionListener(e -> new AppointmentFrame().setVisible(true));

        JButton billingButton = new JButton("Manage Billing");
        billingButton.addActionListener(e -> new BillingFrame().setVisible(true));

        JButton logoutButton = new JButton("Logout");
        logoutButton.addActionListener(e -> {
            new LoginFrame().setVisible(true);
            dispose();
        });

        buttonPanel.add(patientButton);
        buttonPanel.add(doctorButton);
        buttonPanel.add(appointmentButton);
        buttonPanel.add(billingButton);
        buttonPanel.add(logoutButton);

        panel.add(new JLabel("Welcome to Hospital Management System", JLabel.CENTER), BorderLayout.NORTH);
        panel.add(buttonPanel, BorderLayout.CENTER);

        add(panel);
    }
}