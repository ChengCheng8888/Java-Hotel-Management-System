import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;

public class FunctionViewMakeReceipt extends JFrame implements ActionListener {

    JFrame frame = new JFrame();
    JLabel label = new JLabel();
    JButton exitButton = new JButton("Exit");
    JButton makeReceiptButton = new JButton("Print");

    JTextArea showScreen = new JTextArea();
    JButton printButton = new JButton("View Receipt");
    JLabel dayStart = new JLabel("Check In: ");
    JLabel dayEnd = new JLabel("Check Out: ");

    JComboBox Floor = new JComboBox();
    JComboBox roomNumber = new JComboBox();

    JComboBox StartOFDay = new JComboBox();
    JComboBox StartOFMonth = new JComboBox();
    JComboBox StartOFYear = new JComboBox();

    JComboBox EndOFDay = new JComboBox();
    JComboBox EndOFMonth = new JComboBox();
    JComboBox EndOFYear = new JComboBox();


    JLabel Title = new JLabel("Java124 Hotel Fee Receipt System");

    JLabel customerName = new JLabel("Enter Customer Name: ");
    JTextField customerNameField = new JTextField();

    JLabel personID = new JLabel("IC/Passport: ");
    JTextField personIDField = new JTextField();

    JLabel emailID = new JLabel("Customer Email: ");
    JTextField emailIDField = new JTextField();

    JLabel RoomID = new JLabel("Room ID:");
    JTextField amountField = new JTextField();

    JLabel totalDay = new JLabel("Total Day: ");
    JTextField totalDayField = new JTextField();

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    FunctionViewMakeReceipt() {

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int centerX = (screenSize.width - frame.getWidth()) / 5; // left,right
        int centerY = (screenSize.height - frame.getHeight()) / 8; // up,down
        frame.setLocation(centerX, centerY);

        //label setting

        label.setBounds(0, 0, 100, 50);
        label.setFont(new Font(null, Font.PLAIN, 25)); // setFont 是字体

        //Exit Button

        exitButton.setBounds(10, 10, 80, 30);
        exitButton.setFont(new Font(null, Font.PLAIN, 10));
        exitButton.setFocusable(false);
        exitButton.addActionListener(this);

        //窗口 The frame setting

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setTitle("View & Make Receipt Page");
        frame.add(exitButton);
        frame.add(label);
        frame.setResizable(false);

        // 窗口图标的设置(Java 124 Hotel) The Logo Setting

        ImageIcon image = new ImageIcon("JavaLogo.png");
        frame.setIconImage(image.getImage());

        //Title Java124 Hotel Fee Receipt System

        Title.setBounds(225, -175, 400, 400);
        Title.setFont(new Font(null, Font.PLAIN, 20));
        frame.add(Title);

        //Enter Customer Name:

        customerName.setBounds(30, 30, 200, 100);
        customerName.setFont(new Font(null, Font.PLAIN, 16));
        frame.add(customerName);

        customerNameField.setBounds(200, 72, 150, 20);
        customerNameField.setBackground(Color.white);
        frame.add(customerNameField);

        //RoodID

        RoomID.setBounds(118, 80, 200, 200);
        RoomID.setFont(new Font(null, Font.PLAIN, 16));
        frame.add(RoomID);

        String Floors[] = {"Floor 1.txt", "Floor 2"};
        String roomNumbers[] = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10"};

        Floor = new JComboBox(Floors);
        roomNumber = new JComboBox(roomNumbers);

        Floor.setBounds(200, 170, 50, 20);
        roomNumber.setBounds(260, 170, 70, 20);

        frame.add(Floor);
        frame.add(roomNumber);

        //IC/Passport:

        personID.setBounds(105, -92, 300, 400);
        personID.setFont(new Font(null, Font.PLAIN, 15));
        frame.add(personID);
        //IC/Passport fill
        personIDField.setBounds(200, 100, 150, 20);
        personIDField.setBackground(Color.WHITE);
        frame.add(personIDField);

        //Email

        emailID.setBounds(77, -64, 300, 400);
        emailID.setFont(new Font(null, Font.PLAIN, 15));
        frame.add(emailID);

        //IC/Passport fill
        emailIDField.setBounds(200, 128, 150, 20);
        emailIDField.setBackground(Color.WHITE);
        frame.add(emailIDField);


        // Receipt ShowScreen Setting

        showScreen.setBounds(430, 70, 300, 420);
        showScreen.setFont(new Font(null, Font.PLAIN, 15));
        frame.add(showScreen);

        // View Receipt Button

        printButton.setBounds(250, 350, 120, 30);
        printButton.setFont(new Font(null, Font.PLAIN, 14));
        printButton.setFocusable(false);
        printButton.addActionListener(this);
        frame.add(printButton);

        //  Print Receipt Button

        makeReceiptButton.setBounds(250, 400, 120, 30);
        makeReceiptButton.setFont(new Font(null, Font.PLAIN, 14));
        makeReceiptButton.setFocusable(false);
        makeReceiptButton.addActionListener(this);
        frame.add(makeReceiptButton);

        //Total Day:

        totalDay.setBounds(110, 170, 200, 200);
        totalDay.setFont(new Font(null, Font.PLAIN, 16));
        frame.add(totalDay);

        totalDayField.setBounds(200, 265, 50, 20);
        totalDayField.setBackground(Color.WHITE);
        frame.add(totalDayField);

        //Check In

        dayStart.setBounds(118, 10, 300, 400);
        dayStart.setFont(new Font(null, Font.PLAIN, 16));

        String days[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19",
                "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};

        String months[] = {"January", "February", "March", "April", "May", "June", "July",
                "August", "September", "October", "November", "December"};

        String years[] = {"2023"};

        StartOFDay = new JComboBox(days);
        StartOFMonth = new JComboBox(months);
        StartOFYear = new JComboBox(years);

        StartOFDay.setBounds(200, 200, 50, 20);
        StartOFMonth.setBounds(260, 200, 70, 20);
        StartOFYear.setBounds(340, 200, 60, 20);

        frame.add(StartOFDay);
        frame.add(StartOFMonth);
        frame.add(StartOFYear);
        frame.add(dayStart);

        //Check Out

        dayEnd.setBounds(105, 40, 300, 400);
        dayEnd.setFont(new Font(null, Font.PLAIN, 16));

        String Endday[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19",
                "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};

        String Endmonths[] = {"January", "February", "March", "April", "May", "June", "July",
                "August", "September", "October", "November", "December"};

        String Endyears[] = {"2023"};

        EndOFDay = new JComboBox(Endday);
        EndOFMonth = new JComboBox(Endmonths);
        EndOFYear = new JComboBox(Endyears);

        EndOFDay.setBounds(200, 230, 50, 20);
        EndOFMonth.setBounds(260, 230, 70, 20);
        EndOFYear.setBounds(340, 230, 60, 20);

        frame.add(EndOFDay);
        frame.add(EndOFMonth);
        frame.add(EndOFYear);
        frame.add(dayEnd);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == exitButton) {
            WelcomePage welcomePage = new WelcomePage();
            frame.dispose();
        }

        // Make Receipt
        if (e.getSource() == makeReceiptButton) {
            try {
                showScreen.print();
            } catch (PrinterException ex) {
                ex.printStackTrace();
            }
        }
        // Action of information getText
        if (e.getSource() == printButton) {

            String name = customerNameField.getText();
            String roomFee = amountField.getText();
            String ID = personIDField.getText();
            String gmail = emailIDField.getText();

            String roomID = Floor.getSelectedItem() +
                    "_" + roomNumber.getSelectedItem();

            String dateStart = StartOFDay.getSelectedItem() +
                    " " + StartOFMonth.getSelectedItem() +
                    " " + StartOFYear.getSelectedItem();

            String dateEnd = EndOFDay.getSelectedItem() +
                    " " + EndOFMonth.getSelectedItem() +
                    " " + EndOFYear.getSelectedItem();

            String totalDayFieldText = totalDayField.getText();

            boolean fieldEmpty = false;
            if (name.isEmpty() || roomFee.isEmpty() || ID.isEmpty() || gmail.isEmpty() || roomID.isEmpty() || dateStart.isEmpty() || dateEnd.isEmpty() || totalDayFieldText.isEmpty()) {

                // The calculation of Total Amount
                double roomFeePerDay = 350.00; // Room Fee per day: RM350
                double serviceTaxRate = 0.10; // 10% service tax rate
                double tourismTaxPerNight = 10.0; // Tourism tax per night: RM10

                int totalDay = Integer.parseInt(totalDayField.getText()); // Get the total number of days

                double totalRoomCharges = roomFeePerDay * totalDay; // Calculate total room charges
                double serviceTax = totalRoomCharges * serviceTaxRate; // Calculate service tax amount
                double tourismTax = tourismTaxPerNight * totalDay; // Calculate tourism tax amount

                double totalAmount = totalRoomCharges + serviceTax + tourismTax; // Calculate the total amount

                showScreen.setText(
                        "*********************************************************\n" +
                                " ###           Java124 Hotel Receipt          ###\n" +
                                "*********************************************************" + "\n" +
                                " Name: " + name + "\n" +
                                " IC / Passport: " + ID + "\n" +
                                " Email: " + gmail + "\n" +
                                " Room_ID: " + roomID + "\n" +
                                " Check in:  " + dateStart + "\n" +
                                " Check Out: " + dateEnd + "\n" +
                                " Total_Day: " + totalDay + "\n" +

                                "______________________________________" + "\n" +
                                " Room Fee (per day): MYR350" + roomFee +
                                "\n" +
                                " Service Tax: 10% " + "\n" +
                                " Tourism Tax: MYR10 (per night) " + "\n" +
                                "----------------------------------------------------------------" + "\n" +
                                "Total Amount: MYR" + totalAmount + "\n" +
                                "----------------------------------------------------------------" + "\n" + "\n" +
                                "      Thank you for visiting Java124 Hotel         "
                );
            }
        }
    }
}