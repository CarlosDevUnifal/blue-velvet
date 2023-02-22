package model;

import entitys.product.Product;

import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ProductTableModel extends AbstractTableModel {
    private static final String[] COLUMN_NAMES = { "ID", "Nome", "Artista", "Preço", "Lista de músicas", "Foto" };
    private static final Class[] COLUMN_CLASSES = { Integer.class, String.class, String.class, Double.class, String.class, String.class };
    private List<Product> products;

    public ProductTableModel(List<Product> products) {
        this.products = products;
    }

    @Override
    public int getRowCount() {
        return products.size();
    }

    @Override
    public int getColumnCount() {
        return COLUMN_NAMES.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Product product = products.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return product.getId();
            case 1:
                return product.getName();
            case 2:
                return product.getArtistName();
            case 3:
                return product.getPrice();
            case 4:
                return product.getMusicList();
            case 5:
                return product.getPhoto();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return COLUMN_NAMES[column];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return COLUMN_CLASSES[columnIndex];
    }
}
