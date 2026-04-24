import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class StockGUI extends JFrame {
    private StockManager manager;
    private DatabaseManager db;
    private JTable table;
    private DefaultTableModel tableModel;

    public StockGUI(StockManager manager, DatabaseManager db) {
        this.manager = manager;
        this.db = db;

        setTitle("Stock Management System - GUI");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        String[] columns = {"Name", "Qty", "Price", "Category"};
        tableModel = new DefaultTableModel(columns, 0);
        table = new JTable(tableModel);
        updateTable();

        JPanel btnPanel = new JPanel();
        JButton btnRefresh = new JButton("Refresh List");
        JButton btnAdd = new JButton("Add Item (Demo)");

        btnRefresh.addActionListener(e -> updateTable());
        btnAdd.addActionListener(e -> JOptionPane.showMessageDialog(this, "Use Console for secure adding!"));

        btnPanel.add(btnRefresh);
        btnPanel.add(btnAdd);

        add(new JScrollPane(table), BorderLayout.CENTER);
        add(btnPanel, BorderLayout.SOUTH);
    }

    public void updateTable() {
        tableModel.setRowCount(0);
        for (Product p : manager.items) {
            tableModel.addRow(new Object[]{p.getName(), p.getQuantity(), p.getPrice(), p.getCategory()});
        }
    }
}
