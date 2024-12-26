import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;

interface Function {
    void performAction();
}
class BookingRoom implements Function {
    @Override
    public void performAction() {
        System.out.println("page 1 in successful");
        FunctionBookingRoom bookingRoom = new FunctionBookingRoom();
    }
}
class ViewModifyDetails implements Function {
    @Override
    public void performAction() {
        System.out.println("page 2 in successful");
        FunctionViewModifyDetails viewModifyDetails = new FunctionViewModifyDetails();
    }
}
class ViewMakeReceipt implements Function {
    @Override
    public void performAction() {
        System.out.println("page 3 in successful");
        FunctionViewMakeReceipt viewMakeReceipt = new FunctionViewMakeReceipt();
    }
}

public class WelcomePage extends JFrame implements ActionListener {

    JFrame frame = new JFrame();
    JLabel welcomeLabel = new JLabel("Hello!");
    // 4 Button Function Setting
    JButton bookingButton = new JButton("Booking Room");
    JButton detailsButton = new JButton("View & Modify Booking");
    JButton receiptButton = new JButton("View & Make Receipt");
    JButton exitButton = new JButton("Exit to login");

    Function bookingFunction = new BookingRoom();
    Function detailsFunction = new ViewModifyDetails();
    Function receiptFunction = new ViewMakeReceipt();

    WelcomePage() {
        // Set the page location
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int centerX = (screenSize.width - frame.getWidth()) / 4; // left,right
        int centerY = (screenSize.height - frame.getHeight()) / 5; // up,down
        frame.setLocation(centerX, centerY);

        bookingButton.setBounds(200, 150, 280, 30);
        bookingButton.setFont(new Font(null, Font.PLAIN, 18));
        bookingButton.setFocusable(false);
        bookingButton.addActionListener(this);

        detailsButton.setBounds(200, 200, 280, 30);
        detailsButton.setFont(new Font(null, Font.PLAIN, 18));
        detailsButton.setFocusable(false);
        detailsButton.addActionListener(this);

        receiptButton.setBounds(200, 250, 280, 30);
        receiptButton.setFont(new Font(null, Font.PLAIN, 18));
        receiptButton.setFocusable(false);
        receiptButton.addActionListener(this);

        exitButton.setBounds(10, 10, 90, 30);
        exitButton.setFont(new Font(null, Font.PLAIN, 10));
        exitButton.setFocusable(false);
        exitButton.addActionListener(this);

        welcomeLabel.setBounds(200, 50, 600, 55);
        welcomeLabel.setFont(new Font(null, Font.PLAIN, 25));
        welcomeLabel.setText("Please Select Your Option");

        frame.add(welcomeLabel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 480);
        frame.setTitle("Java 124 Hotel (Hotel Room Booking System)");
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setResizable(false);

        ImageIcon image = new ImageIcon("JavaLogo.png");
        frame.setIconImage(image.getImage());

        frame.add(bookingButton);
        frame.add(receiptButton);
        frame.add(detailsButton);
        frame.add(exitButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bookingButton) {
            frame.dispose();
            bookingFunction.performAction();
        } else if (e.getSource() == detailsButton) {
            frame.dispose();
            detailsFunction.performAction();
        } else if (e.getSource() == receiptButton) {
            frame.dispose();
            receiptFunction.performAction();
        } else if (e.getSource() == exitButton) {
            frame.dispose();
            IdPassword idPassword = new IdPassword();
            LoginPage loginPage = new LoginPage(idPassword.getLoginInfo());
        }
    }

    public static void main(String[] args) {
        WelcomePage welcomePage = new WelcomePage();
    }
}