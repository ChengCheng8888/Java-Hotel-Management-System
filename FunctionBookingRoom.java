import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;
import java.util.List;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class FunctionBookingRoom extends JFrame implements ActionListener {

    List<List> bookings = new ArrayList<>();

    JFrame frame = new JFrame();
    JLabel label = new JLabel();
    JButton exitButton = new JButton("Exit");
    JButton submitButton = new JButton("Submit Booking");
    JTable table = new JTable();
    JScrollPane scrollPane = new JScrollPane();
    DefaultTableModel model = new DefaultTableModel();
    JButton deleteButton = new JButton("Delete");
    JButton clearButton = new JButton("Clear");
    JButton viewRoom = new JButton("View Room");

    JCheckBox terms = new JCheckBox();
    JComboBox StartOFDay = new JComboBox();
    JComboBox StartOFMonth = new JComboBox();
    JComboBox StartOFYear = new JComboBox();

    JComboBox EndOFDay = new JComboBox();
    JComboBox EndOFMonth = new JComboBox();
    JComboBox EndOFYear = new JComboBox();


    JComboBox Floor = new JComboBox();
    JComboBox roomNumber = new JComboBox();


    // Booking Details （name,ic,phone,email,room id,day of stay）
    JLabel customerName = new JLabel("Customer Name : ");
    JLabel personID = new JLabel("IC / Passport : ");
    JLabel Contact = new JLabel("Contact Number : ");
    JLabel Gmail = new JLabel("Email : ");
    JLabel roomID = new JLabel("Room ID : ");
    JLabel dayStart = new JLabel("Day of Start : ");
    JLabel dayEnd = new JLabel("Day of End : ");
    JLabel gender = new JLabel("Gender : ");
    JLabel ID = new JLabel("ID : ");

    JTextField customerNameField = new JTextField();
    JTextField personIDField = new JTextField();
    JTextField contactField = new JTextField();
    JTextField gmailField = new JTextField();
    JTextField roomIDField = new JTextField();
    JTextField dayRoomField = new JTextField();
    JTextField IDField = new JTextField();

    JButton addButton = new JButton("Add");

    JRadioButton male = new JRadioButton();
    JRadioButton female = new JRadioButton();

    FunctionBookingRoom() {

        //Set the page location
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int centerX = (screenSize.width - frame.getWidth()) / 85; // left,right
        int centerY = (screenSize.height - frame.getHeight()) / 8; // up,down
        frame.setLocation(centerX, centerY);

        // 窗口图标的设置(Java 124 Hotel)
        ImageIcon image = new ImageIcon("JavaLogo.png");
        frame.setIconImage(image.getImage());


        //label设置，上面的“HelloWorld”
        label.setBounds(0, 0, 500, 50);
        label.setFont(new Font(null, Font.PLAIN, 25)); // setFont 是字体

        //Exit Button

        exitButton.setBounds(10, 10, 80, 30);
        exitButton.setFont(new Font(null, Font.PLAIN, 10));
        exitButton.setFocusable(false); //这个是格子不要有虚线 就是美化
        exitButton.addActionListener(this);

        //View Room
        viewRoom.setBounds(450, 10, 120, 30);
        viewRoom.setFont(new Font(null, Font.PLAIN, 10));
        viewRoom.setFocusable(false);
        viewRoom.addActionListener(this);
        frame.add(viewRoom);

        //Clear Button

        clearButton.setBounds(300, 325, 80, 30);
        clearButton.setFont(new Font(null, Font.PLAIN, 10));
        clearButton.setFocusable(false);
        clearButton.addActionListener(this);
        frame.add(clearButton);


        //窗口

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1500, 600);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setTitle("Booking Room Page");
        frame.add(exitButton);
        frame.add(label);
        frame.setResizable(false);

        //Booking的add (标签)
        frame.add(customerName);
        frame.add(personID);
        frame.add(Contact);
        frame.add(Gmail);
        frame.add(roomID);
        frame.add(dayStart);
        frame.add(dayEnd);

        //Booking的textField
        frame.add(customerNameField);
        frame.add(personIDField);
        frame.add(contactField);
        frame.add(gmailField);
        frame.add(roomIDField);
        frame.add(dayRoomField);

        //Gender :
        frame.add(gender);

        // Save
        frame.add(submitButton);

        // （x = 左右 ， y = 上下），（width = 宽度，height = 高度 ）
        //Customer Name:

        customerName.setBounds(60, -120, 300, 400);//置组件的位置和大小 //SetBounds是设计坐标
        customerName.setFont(new Font(null, Font.PLAIN, 15));
        //Customer Name fill
        customerNameField.setBounds(200, 75, 150, 20);
        customerNameField.setBackground(Color.WHITE);

        //ID

        ID.setBounds(155, -150, 300, 400);
        ID.setFont(new Font(null, Font.PLAIN, 15));
        //Customer Name fill
        IDField.setBounds(200, 45, 150, 20);
        IDField.setBackground(Color.WHITE);
        frame.add(ID);
        frame.add(IDField);

        //IC/Passport :

        personID.setBounds(80, -60, 300, 400);
        personID.setFont(new Font(null, Font.PLAIN, 15));
        //IC/Passport fill
        personIDField.setBounds(200, 130, 150, 20);
        personIDField.setBackground(Color.WHITE);

        //Contact :

        Contact.setBounds(60, -33, 300, 400);
        Contact.setFont(new Font(null, Font.PLAIN, 15));
        contactField.setBounds(200, 160, 150, 20);
        contactField.setBackground(Color.WHITE);

        //Gmail :

        Gmail.setBounds(130, -3, 300, 400);
        Gmail.setFont(new Font(null, Font.PLAIN, 15));
        gmailField.setBounds(200, 190, 150, 20);
        gmailField.setBackground(Color.WHITE);

        //roomID :


        roomID.setBounds(105, 30, 300, 400);
        roomID.setFont(new Font(null, Font.PLAIN, 15));

        String Floors[] = {"Floor 1", "Floor 2"};
        String roomNumbers[] = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10"};

        Floor = new JComboBox(Floors);
        roomNumber = new JComboBox(roomNumbers);

        Floor.setBounds(200, 222, 50, 20);
        roomNumber.setBounds(260, 222, 70, 20);

        frame.add(Floor);
        frame.add(roomNumber);


        //Day of Start :

        dayStart.setBounds(86, 65, 300, 400);
        dayStart.setFont(new Font(null, Font.PLAIN, 15));

        String days[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19",
                "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};

        String months[] = {"January", "February", "March", "April", "May", "June", "July",
                "August", "September", "October", "November", "December"};

        String years[] = {"2023"};

        StartOFDay = new JComboBox(days);
        StartOFMonth = new JComboBox(months);
        StartOFYear = new JComboBox(years);

        StartOFDay.setBounds(180, 257, 50, 20);
        StartOFMonth.setBounds(240, 257, 70, 20);
        StartOFYear.setBounds(320, 257, 60, 20);

        frame.add(StartOFDay);
        frame.add(StartOFMonth);
        frame.add(StartOFYear);

        //Day of End:

        dayEnd.setBounds(88, 100, 300, 400);
        dayEnd.setFont(new Font(null, Font.PLAIN, 15));

        String Endday[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19",
                "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};

        String Endmonths[] = {"January", "February", "March", "April", "May", "June", "July",
                "August", "September", "October", "November", "December"};

        String Endyears[] = {"2023"};

        EndOFDay = new JComboBox(Endday);
        EndOFMonth = new JComboBox(Endmonths);
        EndOFYear = new JComboBox(Endyears);

        EndOFDay.setBounds(180, 290, 50, 20);
        EndOFMonth.setBounds(240, 290, 70, 20);
        EndOFYear.setBounds(320, 290, 60, 20);

        frame.add(EndOFDay);
        frame.add(EndOFMonth);
        frame.add(EndOFYear);


        //Gender :

        gender.setBounds(119, 100, 100, 20);
        gender.setFont(new Font(null, Font.PLAIN, 15));

        male = new JRadioButton("Male");
        female = new JRadioButton("Female");

        male.setBounds(200, 100, 60, 20);
        female.setBounds(270, 100, 80, 20);
        male.setSelected(true);

        male.setFont(new Font(null, Font.PLAIN, 15));
        female.setFont(new Font(null, Font.PLAIN, 15));

        frame.add(male);
        frame.add(female);
        male.setFocusable(false);
        female.setFocusable(false);

        ButtonGroup gen = new ButtonGroup();
        gen.add(male);
        gen.add(female);

        // Show information Table

        scrollPane = new JScrollPane();
        scrollPane.setBounds(450, 60, 1000, 340);
        scrollPane.setFont(new Font(null, Font.PLAIN, 15));
        frame.add(scrollPane);

        table = new JTable();
        table.setBackground(Color.WHITE);
        model = new DefaultTableModel();
        Object[] column = {"ID", "NAME", "GENDER", "IC/PASSPORT", "CONTACT", "EMAIL", "ROOM_ID", "DAY IN", "DAY OUT"};
        Object[] row = new Object[0];
        model.setColumnIdentifiers(column);
        table.setModel(model);
        scrollPane.setViewportView(table);

        // Confirm the Booking

        terms = new JCheckBox("Confirm Booking?");
        terms.setBounds(150, 400, 350, 30);
        terms.setFont(new Font(null, Font.PLAIN, 18));
        terms.setFocusable(false);
        frame.add(terms);

        //Submit Button

        submitButton.setBounds(150, 450, 180, 30);
        submitButton.setFont(new Font(null, Font.PLAIN, 18));
        submitButton.setFocusable(false);//这个是格子不要有虚线 就是美化
        submitButton.addActionListener(this); // 关键: 放了这个就可以run Action了

        // Add

        addButton.setBounds(100, 325, 80, 30);
        addButton.setFont(new Font(null, Font.PLAIN, 10));
        addButton.setFocusable(false);
        addButton.addActionListener(this);
        frame.add(addButton);

        // Delete

        deleteButton.setBounds(200, 325, 80, 30);
        deleteButton.setFont(new Font(null, Font.PLAIN, 10));
        deleteButton.setFocusable(false);
        deleteButton.addActionListener(this);
        frame.add(deleteButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == clearButton) {
            customerNameField.setText("");
            personIDField.setText("");
            IDField.setText("");
            contactField.setText("");
            gmailField.setText("");

        } else if (e.getSource() == viewRoom) {
            new Room();

        } else if (e.getSource() == exitButton) {
            WelcomePage welcomePage = new WelcomePage();
            frame.dispose();
        } else if (e.getSource() == deleteButton) {
            int i = table.getSelectedRow();
            if (i == -1) {
                JOptionPane.showMessageDialog(null, "Please select a row");
            } else {
                model.removeRow(i);
                JOptionPane.showMessageDialog(null, "Deleted Successfully");
            }
        } else if (e.getSource() == addButton) {
            if (IDField.getText().equals("") || customerNameField.getText().equals("") || gender.getText().equals("")
                    || contactField.getText().equals("") || gmailField.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Please fill information");
            } else {
                String id = IDField.getText();
                String name = customerNameField.getText();
                String gender = "";
                if (male.isSelected()) {
                    gender = "Male";
                } else if (female.isSelected()) {
                    gender = "Female";
                }
                String personal = personIDField.getText();
                String contact = contactField.getText();
                String email = gmailField.getText();
                String roomID = Floor.getSelectedItem() + "_" + roomNumber.getSelectedItem().toString();

                String dayOfStay = StartOFDay.getSelectedItem().toString() + " "
                        + StartOFMonth.getSelectedItem().toString() + " " + StartOFYear.getSelectedItem().toString();

                String dayOfEnd = EndOFDay.getSelectedItem().toString() + " "
                        + EndOFMonth.getSelectedItem().toString() + " " + EndOFYear.getSelectedItem().toString();

                Object[] rowData = {id, name, gender, personal, contact, email, roomID, dayOfStay, dayOfEnd};
                model.addRow(rowData);
                contactField.setText("");
                JOptionPane.showMessageDialog(null, "Saved Successfully");

                List<String> tempoList = new ArrayList<>();
                Collections.addAll(tempoList, id, name, gender, personal, contact, email, roomID, dayOfStay, dayOfEnd);
                bookings.add(tempoList);
            }

            // Submit button action
        } else if (e.getSource() == submitButton) {
            if (!terms.isSelected()) {
                JOptionPane.showMessageDialog(null, "Please * Click * confirm booking.");
            } else {
                // Perform the submit action
                StringBuilder sb = new StringBuilder();
                for (List booking : bookings) {
                    sb.append("ID_" + booking.get(0) + "," + booking.get(1) + "," + booking.get(2) + ","
                            + booking.get(3) + "," + booking.get(4) +
                            "," + booking.get(5) + "," + booking.get(6) + "," + booking.get(7) + "," + booking.get(8) + "\n");
                }
                // Save Data to Txt.File
                try (Writer writer = new FileWriter("CustomerInformation.txt", true);
                     BufferedWriter bufferedWriter = new BufferedWriter(writer)) {
                    System.out.println("Start");
                    bufferedWriter.write(sb.toString());
                    System.out.println("Complete");
                    JOptionPane.showMessageDialog(null, "The Data Saved");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}
