import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

// Login Frame
public class LoginPage extends JFrame implements ActionListener {

    //Call Function Frame
    JFrame frame = new JFrame();
    JLabel label = new JLabel();

    JButton loginButton = new JButton("Login"); // Button for Login
    JButton resetButton = new JButton("Clear"); // 按钮for Reset

    JTextField userIDField = new JTextField(); // Field for UserID
    JPasswordField userPasswordField = new JPasswordField(); // 填格for UserPassword

    JLabel userIDLabel = new JLabel("Admin_ID: "); // Display “userID:”
    JLabel userPasswordLabel = new JLabel("Password: ");// Display “Password:”
    JLabel messageLabel = new JLabel(); //显示 登记成功或失败

    ImageIcon imageIcon = new ImageIcon("JavaLogo.png");


    HashMap<String, String> logininfo;
    LoginPage(HashMap<String, String> loginInfoOriginal) {

        logininfo = loginInfoOriginal;

        //Set page location
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int centerX = (screenSize.width - frame.getWidth()) / 3; // left,right
        int centerY = (screenSize.height - frame.getHeight()) / 5; // up, down
        frame.setLocation(centerX, centerY);

        // （x = 左右 ， y = 上下），（width = 宽度，height = 高度 ）
        //userID 和 Password
        userIDLabel.setBounds(60, 100, 300, 400);
        userIDLabel.setFont(new Font(null, Font.PLAIN, 18));

        userPasswordLabel.setBounds(60, 150, 300, 400);
        userPasswordLabel.setFont(new Font(null, Font.PLAIN, 18));

        //Message的显示和字体
        messageLabel.setBounds(110, 250, 300, 35);
        messageLabel.setFont(new Font(null, Font.ITALIC, 18));

        //userID的填表格 和 Password填表格
        userIDField.setBounds(150, 285, 180, 30);
        userPasswordField.setBounds(150, 336, 180, 30);

        // Login按钮
        loginButton.setBounds(125, 400, 100, 25);
        loginButton.setFocusable(false);
        loginButton.addActionListener(this);

        // reset按钮
        resetButton.setBounds(225, 400, 100, 25);
        resetButton.setFocusable(false);
        resetButton.addActionListener(this);

        // Logo(Java 124)显示
        label.setText("Welcome Back, Java 124 Hotel Admin ");
        label.setBounds(120, 0, 200, 300);
        label.setFont(new Font(null, Font.PLAIN, 10));
        label.setIcon(imageIcon);
        label.setHorizontalAlignment(JLabel.CENTER);

        //呼应区域
        frame.add(userIDLabel);       //窗口呼应上面的设计 userIDLabel
        frame.add(userPasswordLabel); //窗口呼应上面的设计 userPasswordLabel
        frame.add(messageLabel);      //窗口呼应上面的设计 messageLabel
        frame.add(userIDField);       //窗口呼应上面的设计 userIDField
        frame.add(userPasswordField); //窗口呼应上面的设计 userPasswordField
        frame.add(loginButton);       //窗口呼应上面的设计 loginButton
        frame.add(resetButton);       //窗口呼应上面的设计 resetButton
        frame.add(label);

        //以下的是窗口配置 (frame.set......)
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450, 500); // Frame Size 窗口大小
        frame.setLayout(null);
        frame.setVisible(true); //窗口可见 = true ， 窗口不可见= false
        frame.setTitle("Java 124 Hotel (Hotel Room Booking System)");
        frame.getContentPane().setBackground(Color.GRAY);
        frame.setResizable(false); //固定窗口大小

        // 窗口图标的设置(Java 124 Hotel)
        ImageIcon image = new ImageIcon("JavaLogo.png");
        frame.setIconImage(image.getImage());
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == resetButton) {
            userIDField.setText("");
            userPasswordField.setText("");
        }
        if (e.getSource() == loginButton) {
            String userID = userIDField.getText();
            String password = String.valueOf(userPasswordField.getPassword());

            if (userID.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Please fill all information");
            } else

            if (logininfo.containsKey(userID)) {
                if (logininfo.get(userID).equals(password)) {
                    JOptionPane.showMessageDialog(frame, "Login Successful","Java Hotel 124",JOptionPane.INFORMATION_MESSAGE);
                    WelcomePage welcomePage = new WelcomePage();
                    frame.dispose();
                } else {
                    JOptionPane.showMessageDialog(frame, "Wrong Password", "Login Failed", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(frame, "Wrong Username", "Login Failed", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
