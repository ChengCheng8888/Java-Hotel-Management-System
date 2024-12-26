import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Iterator;


public class FunctionViewModifyDetails extends JFrame implements ActionListener {

    JFrame frame = new JFrame();
    JLabel label = new JLabel();
    JButton exitButton = new JButton("Exit");
    JTable table = new JTable();
    JScrollPane scrollPane = new JScrollPane();
    DefaultTableModel model = new DefaultTableModel();

    // Search Function
    JLabel searchNameLabel = new JLabel("Enter the ID_NUMBER: ");
    JTextField nameField = new JTextField();
    JButton searchButton = new JButton("Search");
    JButton clearButton = new JButton("Clear");
    JButton deleteButton = new JButton("Delete");
    JButton addButton = new JButton("Add");

    //
    JLabel ID = new JLabel("ID: ");
    JTextField IDField = new JTextField();

    JLabel name = new JLabel("Name: ");
    JTextField nameShow = new JTextField();

    JLabel gender = new JLabel("Gender: ");
    JTextField genderField = new JTextField();

    JLabel IC= new JLabel("IC/Passport: ");
    JTextField ICField= new JTextField();

    JLabel email = new JLabel("Gmail: ");
    JTextField emailField= new JTextField();

    JLabel room = new JLabel("Room_ID: ");
    JTextField roomField = new JTextField();

    JLabel inDay = new JLabel("Day In: ");
    JTextField inDayField= new JTextField();

    JLabel endDay = new JLabel("Day Out:");
    JTextField endDayField= new JTextField();

    JLabel contact = new JLabel("Contact:");
    JTextField contactField= new JTextField();

    JLabel savedData = new JLabel("Saved Booking Row --");
    JLabel newData = new JLabel("Modify Booking Row --");



    FunctionViewModifyDetails() {

        savedData.setBounds(5, -13, 300, 400);
        savedData.setFont(new Font(null, Font.PLAIN, 12));
        savedData.setBackground(Color.GREEN);
        frame.add(savedData);

        newData.setBounds(5, 4, 300, 400);
        newData.setFont(new Font(null, Font.PLAIN, 12));
        newData.setBackground(Color.red);
        frame.add(newData);

        // Name:
        name.setBounds(65, 82, 300, 400);
        name.setFont(new Font(null, Font.PLAIN, 15));
        //Customer Name fill
        nameShow.setBounds(120, 275, 150, 20);
        nameShow.setBackground(Color.WHITE);
        frame.add(name);
        frame.add(nameShow);


        //ID:

        ID.setBounds(90, 52, 300, 400);
        ID.setFont(new Font(null, Font.PLAIN, 15));
        IDField.setBounds(120, 245, 150, 20);
        IDField.setBackground(Color.WHITE);
        frame.add(ID);
        frame.add(IDField);


        //Gender:

        gender.setBounds(52, 112, 300, 400);
        gender.setFont(new Font(null, Font.PLAIN, 15));
        genderField.setBounds(120, 305, 150, 20);
        genderField.setBackground(Color.WHITE);
        frame.add(gender);
        frame.add(genderField);

        //IC/Passport:

        IC.setBounds(20, 142, 300, 400);
        IC.setFont(new Font(null, Font.PLAIN, 15));
        ICField.setBounds(120, 335, 150, 20);
        ICField.setBackground(Color.WHITE);
        frame.add(IC);
        frame.add(ICField);

        //contact

        contact.setBounds(50, 172, 300, 400);
        contact.setFont(new Font(null, Font.PLAIN, 15));
        contactField.setBounds(120, 365, 150, 20);
        contactField.setBackground(Color.WHITE);
        frame.add(contact);
        frame.add(contactField);

        //Gmail:
        email.setBounds(62, 202, 300, 400);
        email.setFont(new Font(null, Font.PLAIN, 15));
        emailField.setBounds(120, 395, 150, 20);
        emailField.setBackground(Color.WHITE);
        frame.add(email);
        frame.add(emailField);

        //RoomID:
        room.setBounds(34, 232, 300, 400);
        room.setFont(new Font(null, Font.PLAIN, 15));
        roomField.setBounds(120, 425, 150, 20);
        roomField.setBackground(Color.WHITE);
        frame.add(room);
        frame.add(roomField);

        //CHECK IN
        inDay.setBounds(60, 262, 300, 400);
        inDay.setFont(new Font(null, Font.PLAIN, 15));
        inDayField.setBounds(120, 455, 150, 20);
        inDayField.setBackground(Color.WHITE);
        frame.add(inDay);
        frame.add(inDayField);

        //CHECK OUT
        endDay.setBounds(50, 292, 300, 400);
        endDay.setFont(new Font(null, Font.PLAIN, 15));
        endDayField.setBounds(120, 485, 150, 20);
        endDayField.setBackground(Color.WHITE);
        frame.add(endDay);
        frame.add(endDayField);

        // Edit Page Location
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int centerX = (screenSize.width - frame.getWidth()) / 7;
        int centerY = (screenSize.height - frame.getHeight()) / 8;
        frame.setLocation(centerX, centerY);

        label.setBounds(0, 0, 100, 50);
        label.setFont(new Font(null, Font.PLAIN, 25));

        //Exit Button

        exitButton.setBounds(10, 10, 80, 30);
        exitButton.setFont(new Font(null, Font.PLAIN, 10));
        exitButton.setFocusable(false);
        exitButton.addActionListener(this);

        //Delete Button

        deleteButton.setBounds(350, 400, 80, 30);
        deleteButton.setFont(new Font(null, Font.PLAIN, 10));
        deleteButton.setFocusable(false);
        deleteButton.addActionListener(this);

        //Modify Button

        addButton.setBounds(350, 300, 80, 30);
        addButton.setFont(new Font(null, Font.PLAIN, 10));
        addButton.setFocusable(false);
        addButton.addActionListener(this);

        //Frame Add (Body)

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1300, 600);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setTitle("View & Modify Booking Page");
        frame.add(label);
        frame.add(exitButton);
        frame.setResizable(false);
        frame.add(searchNameLabel);
        frame.add(nameField);
        frame.add(searchButton);
        frame.add(clearButton);
        frame.add(deleteButton);
        frame.add(addButton);

        ImageIcon image = new ImageIcon("JavaLogo.png");
        frame.setIconImage(image.getImage());
        //Field ID
        searchNameLabel.setBounds(125, -118, 300, 400);
        searchNameLabel.setFont(new Font(null, Font.PLAIN, 18));

        nameField.setBounds(320, 70, 180, 30);
        nameField.setFont(new Font(null, Font.PLAIN, 20));
        nameField.setBackground(Color.WHITE);

        searchButton.setBounds(320, 120, 80, 30);
        searchButton.setFont(new Font(null, Font.PLAIN, 10));
        searchButton.setFocusable(false);
        searchButton.addActionListener(this);

        // Clear Button
        clearButton.setBounds(420, 120, 80, 30);
        clearButton.setFont(new Font(null, Font.PLAIN, 10));
        clearButton.setFocusable(false);
        clearButton.addActionListener(this);

        //Show Information
        scrollPane.setBounds(120, 160, 1150, 60);
        scrollPane.setFont(new Font(null, Font.PLAIN, 20));
        frame.add(scrollPane);

        table.setBackground(Color.WHITE);
        model = new DefaultTableModel();
        Object[] column = {"ID", "NAME", "GENDER", "IC/PASSPORT", "CONTACT", "EMAIL", "ROOM_ID", "DAY IN", "DAY OUT"};
        model.setColumnIdentifiers(column);
        table.setModel(model);
        scrollPane.setViewportView(table);
        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent event) {
                if (!event.getValueIsAdjusting()) {
                    int selectedRow = table.getSelectedRow();
                    if (selectedRow != -1) {
                        populateFieldsFromSelectedRow(selectedRow);
                    }
                }
            }
        });
    }
    public void populateFieldsFromSelectedRow(int selectedRow) {
        // Get the values from the selected row in the table
        String id = (String) table.getValueAt(selectedRow, 0);
        String name = (String) table.getValueAt(selectedRow, 1);
        String gender = (String) table.getValueAt(selectedRow, 2);
        String ic = (String) table.getValueAt(selectedRow, 3);
        String contact = (String) table.getValueAt(selectedRow, 4);
        String email = (String) table.getValueAt(selectedRow, 5);
        String roomID = (String) table.getValueAt(selectedRow, 6);
        String dayIn = (String) table.getValueAt(selectedRow, 7);
        String dayOut = (String) table.getValueAt(selectedRow, 8);

        // Set the values to the corresponding fields
        IDField.setText(id);
        nameShow.setText(name);
        genderField.setText(gender);
        ICField.setText(ic);
        contactField.setText(contact);
        emailField.setText(email);
        roomField.setText(roomID);
        inDayField.setText(dayIn);
        endDayField.setText(dayOut);

    }

    private List<String> readFileData(String filePath) throws IOException {
        List<String> data = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;

        while ((line = reader.readLine()) != null) {
            data.add(line);
        }
        reader.close();
        return data;
    }

    private void deleteRowFromFile(String searchTerm) {
        File file = new File("CustomerInformation.txt");
        List<String> fileData;
        try {
            fileData = readFileData(file.getAbsolutePath());

            // Find and remove the line containing the searchTerm
            for (Iterator<String> iterator = fileData.iterator(); iterator.hasNext(); ) {
                String line = iterator.next();
                if (line.contains(searchTerm)) {
                    iterator.remove();
                    break;
                }
            }

            // Write the updated list back to the file
            BufferedWriter writer = new BufferedWriter(new FileWriter(file.getAbsolutePath()));
            for (String line : fileData) {
                writer.write(line);
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    List<List<String>> bookings = new ArrayList<>();
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == exitButton) {
            WelcomePage welcomePage = new WelcomePage();
            frame.dispose();

        } else if (e.getSource() == clearButton) {
            nameField.setText("");

        } else if (e.getSource() == searchButton) {
            String searchTerm = nameField.getText();

            if (searchTerm.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Please fill the ID Number.", "Error", JOptionPane.ERROR_MESSAGE);
                return; // Exit the method if the text field is empty
            }
            File file = new File("CustomerInformation.txt");

            try {
                List<String> fileData = readFileData(file.getAbsolutePath());
                DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
                tableModel.setRowCount(0);

                boolean foundData = false;

                for (String line : fileData) {
                    if (line.contains(searchTerm)) {
                        String[] rowData = line.split(",");
                        tableModel.addRow(rowData);
                        foundData = true;

                    }
                }
                if (!foundData) {
                    JOptionPane.showMessageDialog(frame, "No available data.", "Message", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        else if (e.getSource() == deleteButton) {
            int selectedRow = table.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(frame, "Please select a row to delete.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            String searchTerm = table.getValueAt(selectedRow, 0).toString(); // Assuming ID is in the first column

            deleteRowFromFile(searchTerm);

            // Remove the selected row from the table model
            DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
            tableModel.removeRow(selectedRow);
        }

        else if (e.getSource() == addButton){
            if (IDField.getText().equals("") || nameShow.getText().equals("") || genderField.getText().equals("") ||
                    ICField.getText().equals("") || contactField.getText().equals("") || emailField.getText().equals("") || roomField.getText().equals("")
                    || inDayField.getText().equals("") || endDayField.getText().equals("") );
            else {
                String id = IDField.getText();
                String name = nameShow.getText();
                String gender = genderField.getText();
                String personal = ICField.getText();
                String contact = contactField.getText();
                String email = emailField.getText();
                String room = roomField.getText();
                String inDay = inDayField.getText();
                String endDay = endDayField.getText();

                Object[] rowData = {id, name, gender, personal, contact, email, room, inDay, endDay};
                model.addRow(rowData);
                contactField.setText("");
                JOptionPane.showMessageDialog(null, "Saved Successful");

                List<String> tempoList = new ArrayList<>();
                Collections.addAll(tempoList, id, name, gender, personal, contact, email, room, inDay, endDay);
                bookings.add(tempoList);
                try (BufferedWriter writer = new BufferedWriter(new FileWriter("CustomerInformation.txt", true))) {
                    writer.write(String.join(",", tempoList));
                    writer.newLine();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new FunctionViewModifyDetails();
            }
        });
    }
}