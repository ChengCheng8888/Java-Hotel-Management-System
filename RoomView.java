import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class Room {
    private DefaultTableModel model;

    public Room() {
        createGUI();
        updateRoomAvailability();
    }

    private void createGUI() {
        String[] columnNames = {"Floor Room ID", "Availability", "Date"};
        Object[][] rowData = {
                {"Floor 1_01", "Available",""},
                {"Floor 1_02", "Available",""},
                {"Floor 1_03", "Available",""},
                {"Floor 1_04", "Available",""},
                {"Floor 1_05", "Available"},
                {"Floor 1_06", "Available"},
                {"Floor 1_07", "Available",""},
                {"Floor 1_08", "Available"},
                {"Floor 1_09", "Available"},
                {"Floor 1_10", "Available"},
                {"", "",""},
                {"Floor 2_01", "Available"},
                {"Floor 2_02", "Available"},
                {"Floor 2_03", "Available"},
                {"Floor 2_04", "Available"},
                {"Floor 2_05", "Available"},
                {"Floor 2_06", "Available"},
                {"Floor 2_07", "Available"},
                {"Floor 2_08", "Available"},
                {"Floor 2_09", "Available"},
                {"Floor 2_10", "Available"}
        };

        model = new DefaultTableModel(rowData, columnNames) {
            @Override
            public Class<?> getColumnClass(int column) {
                return column == 1 ? String.class : super.getColumnClass(column);
            }
        };

        JTable table = new JTable(model);
        table.getColumnModel().getColumn(1).setCellRenderer(new CustomCellRenderer());
        table.getColumnModel().getColumn(2).setPreferredWidth(150);

        JScrollPane scrollPane = new JScrollPane(table);

        JPanel panel = new JPanel();
        panel.add(scrollPane);

        JFrame frame = new JFrame("Room Availability");
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }

    private void updateRoomAvailability() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("CustomerInformation.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 9) {
                    String floorRoomID = parts[6].trim();
                    String startDate = parts[7].trim();
                    String endDate = parts[8].trim();
                    for (int i = 0; i < model.getRowCount(); i++) {
                        String currentRoomID = ((String) model.getValueAt(i, 0)).trim();
                        if (currentRoomID.equals(floorRoomID)) {
                            model.setValueAt("Unavailable", i, 1);
                            model.setValueAt(startDate + " "+"--- " + endDate , i, 2 );
                            break;
                        }
                    }
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class CustomCellRenderer extends DefaultTableCellRenderer {
        @Override
        public java.awt.Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

            if (value instanceof String) {
                String availability = (String) value;
                if (availability.equals("Available")) {
                    setBackground(Color.CYAN);
                    setForeground(Color.BLACK);
                } else if (availability.equals("Unavailable")) {
                    setBackground(Color.RED);
                    setForeground(Color.WHITE);
                }
            }
            return this;
        }
    }
}

public class RoomView{
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Room();
            }
        });
    }
}