import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

import javax.swing.*;
import java.awt.*;
import java.io.FileOutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MedicineBillApp {
    public static void launch() {
        SwingUtilities.invokeLater(MedicineBillApp::createUI);
    }

    public static void createUI() {
        JFrame frame = new JFrame("Medicine Bill");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JTextField nameField = new JTextField();
        panel.add(new JLabel("Customer Name:"));
        panel.add(nameField);

        JTextField numField = new JTextField();
        panel.add(new JLabel("Number of Medicines:"));
        panel.add(numField);

        JButton generateButton = new JButton("Generate Bill");
        panel.add(generateButton);

        generateButton.addActionListener(e -> {
            String custName = nameField.getText();
            int numMeds;

            try {
                numMeds = Integer.parseInt(numField.getText());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(panel, "Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String[][] medData = new String[numMeds][4]; // medId, name, qty, price

            for (int i = 0; i < numMeds; i++) {
                medData[i][0] = JOptionPane.showInputDialog("Enter Med ID for item " + (i + 1));
                medData[i][1] = JOptionPane.showInputDialog("Enter Name for item " + (i + 1));
                medData[i][2] = JOptionPane.showInputDialog("Enter Quantity for item " + (i + 1));
                medData[i][3] = JOptionPane.showInputDialog("Enter Price per unit for item " + (i + 1));
            }

            generatePDF(custName, medData);
        });
    }

    private static void generatePDF(String custName, String[][] medData) {
        try {
            String dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
            String fileName = "Bill_" + dateTime + ".pdf";

            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(fileName));
            document.open();

            document.add(new Paragraph("Medicine Bill"));
            document.add(new Paragraph("Customer Name: " + custName));
            document.add(new Paragraph(" "));

            PdfPTable table = new PdfPTable(5);
            table.addCell("Med ID");
            table.addCell("Name");
            table.addCell("Qty");
            table.addCell("Price/Unit");
            table.addCell("Total");

            double grandTotal = 0;

            for (String[] row : medData) {
                int qty = Integer.parseInt(row[2]);
                double price = Double.parseDouble(row[3]);
                double total = qty * price;
                grandTotal += total;

                table.addCell(row[0]);
                table.addCell(row[1]);
                table.addCell(String.valueOf(qty));
                table.addCell(String.valueOf(price));
                table.addCell(String.valueOf(total));
            }

            document.add(table);
            document.add(new Paragraph(" "));
            document.add(new Paragraph("Grand Total: ₹" + grandTotal));
            document.add(new Paragraph("Thank you for your purchase!"));

            document.close();

            JOptionPane.showMessageDialog(null, "PDF created: " + fileName);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error generating PDF: " + e.getMessage());
        }
    }
}
