import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.*;

// User class representing a person in the system
class User {
    protected String name;
    protected String email;
    protected String password;

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public String getName() {
        return name;
    }
}

// Patient class extending User
class Patient extends User {
    private String medicalHistory;

    public Patient(String name, String email, String password, String medicalHistory) {
        super(name, email, password);
        this.medicalHistory = medicalHistory;
    }

    public String getMedicalHistory() {
        return medicalHistory;
    }
}

// Doctor class extending User
class Doctor extends User {
    private String specialization;

    public Doctor(String name, String email, String password, String specialization) {
        super(name, email, password);
        this.specialization = specialization;
    }

    public String getSpecialization() {
        return specialization;
    }
}

// Appointment class representing appointments
class Appointment {
    private String patientName;
    private String doctorName;
    private String date;
    private String time;

    public Appointment(String patientName, String doctorName, String date, String time) {
        this.patientName = patientName;
        this.doctorName = doctorName;
        this.date = date;
        this.time = time;
    }

    public String getDetails() {
        return "Patient: " + patientName + ", Doctor: " + doctorName + ", Date: " + date + ", Time: " + time;
    }

    public String toCSV() {
        return patientName + "," + doctorName + "," + date + "," + time;
    }
}

// Main system class with GUI
public class HealthcareManagementSystemGUI {
    private ArrayList<Patient> patients;
    private ArrayList<Doctor> doctors;
    private ArrayList<Appointment> appointments;

    public HealthcareManagementSystemGUI() {
        patients = new ArrayList<>();
        doctors = new ArrayList<>();
        appointments = new ArrayList<>();
        createMainGUI();
    }

    private void createMainGUI() {
        JFrame frame = new JFrame("Healthcare Management System");
        frame.setSize(400, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(173, 216, 230)); // Light blue background
        panel.setLayout(new GridLayout(6, 1, 10, 10));

        JButton addPatientButton = new JButton("Add Patient");
        JButton addDoctorButton = new JButton("Add Doctor");
        JButton bookAppointmentButton = new JButton("Book Appointment");
        JButton viewAppointmentsButton = new JButton("View Appointments");
        JButton exportToCSVButton = new JButton("Export to CSV");
        JButton exitButton = new JButton("Exit");

        // Set button colors
        addPatientButton.setBackground(new Color(144, 238, 144)); // Light green
        addDoctorButton.setBackground(new Color(240, 128, 128)); // Light coral
        bookAppointmentButton.setBackground(new Color(255, 215, 0)); // Gold
        viewAppointmentsButton.setBackground(new Color(135, 206, 235)); // Sky blue
        exportToCSVButton.setBackground(new Color(221, 160, 221)); // Plum
        exitButton.setBackground(new Color(255, 160, 122)); // Light salmon

        addPatientButton.addActionListener(e -> openAddPatientGUI());
        addDoctorButton.addActionListener(e -> openAddDoctorGUI());
        bookAppointmentButton.addActionListener(e -> openBookAppointmentGUI());
        viewAppointmentsButton.addActionListener(e -> openViewAppointmentsGUI());
        exportToCSVButton.addActionListener(e -> exportDataToCSV());
        exitButton.addActionListener(e -> System.exit(0));

        panel.add(addPatientButton);
        panel.add(addDoctorButton);
        panel.add(bookAppointmentButton);
        panel.add(viewAppointmentsButton);
        panel.add(exportToCSVButton);
        panel.add(exitButton);

        frame.add(panel);
        frame.setVisible(true);
    }

    private void openAddPatientGUI() {
        JFrame frame = new JFrame("Add Patient");
        frame.setSize(300, 300);

        JPanel panel = new JPanel(new GridLayout(5, 2, 10, 10));
        panel.setBackground(new Color(255, 250, 205)); // Light goldenrod yellow background
        JTextField nameField = new JTextField();
        JTextField emailField = new JTextField();
        JTextField passwordField = new JTextField();
        JTextField medicalHistoryField = new JTextField();

        JButton addButton = new JButton("Add Patient");
        addButton.setBackground(new Color(144, 238, 144)); // Light green
        addButton.addActionListener(e -> {
            String name = nameField.getText();
            String email = emailField.getText();
            String password = passwordField.getText();
            String history = medicalHistoryField.getText();

            patients.add(new Patient(name, email, password, history));
            JOptionPane.showMessageDialog(frame, "Patient added successfully!");
            frame.dispose();
        });

        panel.add(new JLabel("Name:"));
        panel.add(nameField);
        panel.add(new JLabel("Email:"));
        panel.add(emailField);
        panel.add(new JLabel("Password:"));
        panel.add(passwordField);
        panel.add(new JLabel("Medical History:"));
        panel.add(medicalHistoryField);
        panel.add(new JLabel());
        panel.add(addButton);

        frame.add(panel);
        frame.setVisible(true);
    }

    private void openAddDoctorGUI() {
        JFrame frame = new JFrame("Add Doctor");
        frame.setSize(300, 300);

        JPanel panel = new JPanel(new GridLayout(5, 2, 10, 10));
        panel.setBackground(new Color(255, 228, 225)); // Misty rose background
        JTextField nameField = new JTextField();
        JTextField emailField = new JTextField();
        JTextField passwordField = new JTextField();
        JTextField specializationField = new JTextField();

        JButton addButton = new JButton("Add Doctor");
        addButton.setBackground(new Color(240, 128, 128)); // Light coral
        addButton.addActionListener(e -> {
            String name = nameField.getText();
            String email = emailField.getText();
            String password = passwordField.getText();
            String specialization = specializationField.getText();

            doctors.add(new Doctor(name, email, password, specialization));
            JOptionPane.showMessageDialog(frame, "Doctor added successfully!");
            frame.dispose();
        });

        panel.add(new JLabel("Name:"));
        panel.add(nameField);
        panel.add(new JLabel("Email:"));
        panel.add(emailField);
        panel.add(new JLabel("Password:"));
        panel.add(passwordField);
        panel.add(new JLabel("Specialization:"));
        panel.add(specializationField);
        panel.add(new JLabel());
        panel.add(addButton);

        frame.add(panel);
        frame.setVisible(true);
    }

    private void openBookAppointmentGUI() {
        JFrame frame = new JFrame("Book Appointment");
        frame.setSize(300, 300);

        JPanel panel = new JPanel(new GridLayout(5, 2, 10, 10));
        panel.setBackground(new Color(240, 255, 255)); // Azure background
        JTextField patientNameField = new JTextField();
        JTextField doctorNameField = new JTextField();
        JTextField dateField = new JTextField();
        JTextField timeField = new JTextField();

        JButton bookButton = new JButton("Book Appointment");
        bookButton.setBackground(new Color(135, 206, 235)); // Sky blue
        bookButton.addActionListener(e -> {
            String patientName = patientNameField.getText();
            String doctorName = doctorNameField.getText();
            String date = dateField.getText();
            String time = timeField.getText();

            appointments.add(new Appointment(patientName, doctorName, date, time));
            JOptionPane.showMessageDialog(frame, "Appointment booked successfully!");
            frame.dispose();
        });

        panel.add(new JLabel("Patient Name:"));
        panel.add(patientNameField);
        panel.add(new JLabel("Doctor Name:"));
        panel.add(doctorNameField);
        panel.add(new JLabel("Date (YYYY-MM-DD):"));
        panel.add(dateField);
        panel.add(new JLabel("Time (HH:MM):"));
        panel.add(timeField);
        panel.add(new JLabel());
        panel.add(bookButton);

        frame.add(panel);
        frame.setVisible(true);
    }

    private void openViewAppointmentsGUI() {
        JFrame frame = new JFrame("View Appointments");
        frame.setSize(400, 300);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(new Color(245, 245, 220)); // Beige background

        for (Appointment appointment : appointments) {
            JLabel label = new JLabel(appointment.getDetails());
            label.setForeground(Color.DARK_GRAY);
            panel.add(label);
        }

        JScrollPane scrollPane = new JScrollPane(panel);
        frame.add(scrollPane);
        frame.setVisible(true);
    }

    private void exportDataToCSV() {
        try {
            FileWriter patientWriter = new FileWriter("patients.csv");
            patientWriter.write("Name,Email,MedicalHistory\n");
            for (Patient patient : patients) {
                patientWriter.write(patient.getName() + "," + patient.email + "," + patient.getMedicalHistory() + "\n");
            }
            patientWriter.close();

            FileWriter doctorWriter = new FileWriter("doctors.csv");
            doctorWriter.write("Name,Email,Specialization\n");
            for (Doctor doctor : doctors) {
                doctorWriter.write(doctor.getName() + "," + doctor.email + "," + doctor.getSpecialization() + "\n");
            }
            doctorWriter.close();

            FileWriter appointmentWriter = new FileWriter("appointments.csv");
            appointmentWriter.write("PatientName,DoctorName,Date,Time\n");
            for (Appointment appointment : appointments) {
                appointmentWriter.write(appointment.toCSV() + "\n");
            }
            appointmentWriter.close();

            JOptionPane.showMessageDialog(null, "Data exported to CSV files successfully!");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error exporting data to CSV: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        new HealthcareManagementSystemGUI();
    }
}