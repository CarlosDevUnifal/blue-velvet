package View.product_list_screen;

import controllers.product.ProductController;
import entitys.product.Product;
import model.ProductTableModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ProductListScreen extends JFrame {

    private ProductController productController = new ProductController();
    private JTable productTable;
    private JScrollPane scrollPane;
    private JButton addProductButton;
    private JButton removeProductButton;

    public ProductListScreen() {
        setTitle("Lista de Produtos");
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        productTable = new JTable();
        scrollPane = new JScrollPane(productTable);
        add(scrollPane, BorderLayout.CENTER);

        addProductButton = new JButton("Adicionar Produto");
        addProductButton.addActionListener((ActionListener) new AddProductButtonListener());
        removeProductButton = new JButton("Remover Produto");
        removeProductButton.addActionListener(new RemoveProductButtonListener());

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addProductButton);
        buttonPanel.add(removeProductButton);
        add(buttonPanel, BorderLayout.SOUTH);

        loadProducts();
    }

    private void loadProducts() {
        List<Product> products = productController.getAllProducts();
        ProductTableModel model = new ProductTableModel(products);
        productTable.setModel(model);
    }

    private class AddProductButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JFrame addProductFrame = new JFrame("Adicionar Produto");
            addProductFrame.setSize(500, 400);
            addProductFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            addProductFrame.setLocationRelativeTo(null);
            addProductFrame.setResizable(false);

            Container content = addProductFrame.getContentPane();
            content.setLayout(new BorderLayout());

            JPanel formPanel = new JPanel();
            formPanel.setLayout(new GridBagLayout());
            GridBagConstraints c = new GridBagConstraints();
            c.insets = new Insets(10, 10, 10, 10);
            c.fill = GridBagConstraints.HORIZONTAL;

            JLabel nameLabel = new JLabel("Nome:");
            c.gridx = 0;
            c.gridy = 0;
            c.weightx = 0.2;
            formPanel.add(nameLabel, c);

            JTextField nameTextField = new JTextField();
            c.gridx = 1;
            c.gridy = 0;
            c.weightx = 0.8;
            formPanel.add(nameTextField, c);

            JLabel artistLabel = new JLabel("Artista:");
            c.gridx = 0;
            c.gridy = 1;
            formPanel.add(artistLabel, c);

            JTextField artistTextField = new JTextField();
            c.gridx = 1;
            c.gridy = 1;
            formPanel.add(artistTextField, c);

            JLabel priceLabel = new JLabel("Preço:");
            c.gridx = 0;
            c.gridy = 2;
            formPanel.add(priceLabel, c);

            JTextField priceTextField = new JTextField();
            c.gridx = 1;
            c.gridy = 2;
            formPanel.add(priceTextField, c);

            JLabel musicListLabel = new JLabel("Lista de músicas:");
            c.gridx = 0;
            c.gridy = 3;
            formPanel.add(musicListLabel, c);

            JTextField musicListTextField = new JTextField();
            c.gridx = 1;
            c.gridy = 3;
            formPanel.add(musicListTextField, c);

            JLabel photoLabel = new JLabel("Foto:");
            c.gridx = 0;
            c.gridy = 4;
            formPanel.add(photoLabel, c);

            JTextField photoTextField = new JTextField();
            c.gridx = 1;
            c.gridy = 4;
            formPanel.add(photoTextField, c);

            JPanel buttonPanel = new JPanel();
            buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

            JButton saveButton = new JButton("Salvar");
            buttonPanel.add(saveButton);

            content.add(buttonPanel, BorderLayout.SOUTH);

            JButton cancelButton = new JButton("Cancelar");
            c.gridx = 1;
            c.gridy = 5;
            c.insets = new Insets(20, 10, 10, 10);
            cancelButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    addProductFrame.dispose();
                }
            });
            buttonPanel.add(cancelButton, c);

            saveButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String name = nameTextField.getText();
                    String artist = artistTextField.getText();
                    double price = Double.parseDouble(priceTextField.getText());
                    String musicList = musicListTextField.getText();
                    String photo = photoTextField.getText();

                    Product product = new Product(name, artist, price, musicList, photo);
                    productController.addProduct(product);
                    loadProducts();

                    addProductFrame.dispose();
                }
            });
            formPanel.add(new JLabel());

            content.add(formPanel, BorderLayout.CENTER);

            addProductFrame.setVisible(true);
        }
    }

    private class RemoveProductButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int selectedRow = productTable.getSelectedRow();
            if (selectedRow != -1) {
                int selectedId = (int) productTable.getValueAt(selectedRow, 0);
                Product product = productController.getProductAt(selectedId);
                System.out.println(product);
                productController.removeProduct(product);
                loadProducts();
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ProductListScreen().setVisible(true));
    }
}
