package DAO;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import DAO.CarInfoDAO;

public class InputForm extends JFrame {

    private CarInfoDAO dao = new CarInfoDAO();
    private DefaultTableModel dtm;
    private JTable table;

    public InputForm() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        createTabbedPane();
        setTitle("TestCar");
        setSize(800, 500);
        setLocationRelativeTo(null); // 화면 중앙에 배치
        setVisible(true);
    }

    private void createTabbedPane() {
        try {
            dao.loadData();
        } catch (Exception e) {
            e.printStackTrace();
        }
        JTabbedPane tPane = new JTabbedPane();

        // 모델 초기화
        dtm = new DefaultTableModel(dao.getObj(), dao.getCName());
        table = new JTable(dtm);
        JScrollPane scrollPane = new JScrollPane(table);

        // 탭 추가
        tPane.addTab("차량 확인", createViewCarPanel(scrollPane));
        tPane.addTab("차량 추가", createAddCarPanel());
        tPane.addTab("차량 삭제", createDeleteCarPanel());
        tPane.addTab("차량 가격 수정", createModifyPricePanel());
        tPane.addTab("차량 검색", createSearchCarPanel());

        // 프레임에 탭 패널 추가
        add(tPane);
    }
    
    private JPanel createSearchCarPanel() {
        JPanel searchCarPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;

        JComboBox<String> searchCriteriaBox = new JComboBox<>(new String[]{ "carid", "cartype", "brand", "puel"});
        JTextField keywordField = new JTextField(10);
        JButton searchButton = new JButton("검색");

        addComponent(searchCarPanel, gbc, new JLabel("검색 기준:"), 0, 0);
        addComponent(searchCarPanel, gbc, searchCriteriaBox, 1, 0);
        addComponent(searchCarPanel, gbc, new JLabel("검색어:"), 0, 1);
        addComponent(searchCarPanel, gbc, keywordField, 1, 1);
        addComponent(searchCarPanel, gbc, searchButton, 1, 2);

        searchButton.addActionListener(e -> performSearch((String) searchCriteriaBox.getSelectedItem(), keywordField.getText()));

        return searchCarPanel;
    }
    
    private void performSearch(String criteria, String keyword) {
        try {
            dao.searchCar(criteria.toLowerCase(), keyword);
            showSearchResultsDialog();
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "검색 중 오류가 발생했습니다.");
        }
    }

    private void showSearchResultsDialog() {
        JDialog dialog = new JDialog(this, "검색 결과", true); // 다이얼로그?
        dialog.setLayout(new BorderLayout());

        DefaultTableModel searchResultModel = new DefaultTableModel(dao.getObj(), dao.getCName());
        JTable searchResultTable = new JTable(searchResultModel);
        JScrollPane scrollPane = new JScrollPane(searchResultTable);

        dialog.add(scrollPane, BorderLayout.CENTER);

        JButton closeButton = new JButton("닫기");
        closeButton.addActionListener(e -> dialog.dispose());
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(closeButton);
        dialog.add(buttonPanel, BorderLayout.SOUTH);

        dialog.setSize(600, 400);
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
    }

    private JPanel createViewCarPanel(JScrollPane scrollPane) {
        JPanel viewCarPanel = new JPanel();
        viewCarPanel.setLayout(new BoxLayout(viewCarPanel, BoxLayout.Y_AXIS));
        viewCarPanel.add(scrollPane);

        JButton refreshButton = new JButton("새로고침");
        refreshButton.addActionListener(e -> refreshTableData());
        viewCarPanel.add(refreshButton);

        return viewCarPanel;
    }

    private JPanel createAddCarPanel() {
        JPanel addCarPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;

        JTextField carNameField = new JTextField(10);
        JTextField carIdField = new JTextField(10);

        JComboBox<String> carTypeBox = new JComboBox<>(new String[]{"중형", "준중형", "대형", "소형"});
        JComboBox<String> brandBox = new JComboBox<>(new String[]{"기아", "현대", "쉐보레", "제네시스", "벤츠", "테슬라", "BMW"});
        JComboBox<String> puelBox = new JComboBox<>(new String[]{"가스", "가솔린", "디젤", "전기", "수소"});
        JComboBox<String> needLicenceBox = new JComboBox<>(new String[]{"2종", "1종"});

        JTextField pricePerDayField = new JTextField(10);
        JButton addButton = new JButton("차량 추가");

        addComponent(addCarPanel, gbc, new JLabel("차량 이름:"), 0, 0);
        addComponent(addCarPanel, gbc, carNameField, 1, 0);
        addComponent(addCarPanel, gbc, new JLabel("차량 번호:"), 0, 1);
        addComponent(addCarPanel, gbc, carIdField, 1, 1);
        addComponent(addCarPanel, gbc, new JLabel("차량 종류:"), 0, 2);
        addComponent(addCarPanel, gbc, carTypeBox, 1, 2);
        addComponent(addCarPanel, gbc, new JLabel("브랜드:"), 0, 3);
        addComponent(addCarPanel, gbc, brandBox, 1, 3);
        addComponent(addCarPanel, gbc, new JLabel("유종:"), 0, 4);
        addComponent(addCarPanel, gbc, puelBox, 1, 4);
        addComponent(addCarPanel, gbc, new JLabel("면허 필요 여부:"), 0, 5);
        addComponent(addCarPanel, gbc, needLicenceBox, 1, 5);
        addComponent(addCarPanel, gbc, new JLabel("일일 가격:"), 0, 6);
        addComponent(addCarPanel, gbc, pricePerDayField, 1, 6);
        addComponent(addCarPanel, gbc, addButton, 1, 7);

        addButton.addActionListener(e -> addCar(carNameField, carIdField, carTypeBox, brandBox, puelBox, needLicenceBox, pricePerDayField));

        return addCarPanel;
    }

    private JPanel createDeleteCarPanel() {
        JPanel deleteCarPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;

        JTextField carIdField = new JTextField(10);
        carIdField.setPreferredSize(new Dimension(280, 30));
        JButton deleteButton = new JButton("차량 삭제");

        addComponent(deleteCarPanel, gbc, new JLabel("삭제할 차량 번호:"), 0, 0);
        addComponent(deleteCarPanel, gbc, carIdField, 1, 0);
        addComponent(deleteCarPanel, gbc, deleteButton, 1, 1);

        deleteButton.addActionListener(e -> deleteCar(carIdField));

        return deleteCarPanel;
    }

    private JPanel createModifyPricePanel() {
        JPanel modifyPricePanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;

        JTextField carIdField = new JTextField(10);
        JTextField newPriceField = new JTextField(10);
        JButton modifyButton = new JButton("차량 가격 수정");

        addComponent(modifyPricePanel, gbc, new JLabel("수정할 차량 번호:"), 0, 0);
        addComponent(modifyPricePanel, gbc, carIdField, 1, 0);
        addComponent(modifyPricePanel, gbc, new JLabel("새로운 일일 가격:"), 0, 1);
        addComponent(modifyPricePanel, gbc, newPriceField, 1, 1);
        addComponent(modifyPricePanel, gbc, modifyButton, 1, 2);

        modifyButton.addActionListener(e -> modifyCarPrice(carIdField, newPriceField));

        return modifyPricePanel;
    }

    private void addComponent(JPanel panel, GridBagConstraints gbc, java.awt.Component component, int x, int y) {
        gbc.gridx = x;
        gbc.gridy = y;
        panel.add(component, gbc);
    }

    private void refreshTableData() {
        try {
            dao.loadData();
            dtm.setDataVector(dao.getObj(), dao.getCName());
            JOptionPane.showMessageDialog(null, "데이터가 새로고침되었습니다.");
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "데이터 새로고침 중 오류가 발생했습니다.");
        }
    }

    private void addCar(JTextField carNameField, JTextField carIdField, JComboBox<String> carTypeBox, JComboBox<String> brandBox,
                        JComboBox<String> puelBox, JComboBox<String> needLicenceBox, JTextField pricePerDayField) {
        String carName = carNameField.getText();
        String carId = carIdField.getText();
        String carType = (String) carTypeBox.getSelectedItem();
        String brand = (String) brandBox.getSelectedItem();
        String puel = (String) puelBox.getSelectedItem();
        String needLicence = (String) needLicenceBox.getSelectedItem();
        int price = Integer.parseInt(pricePerDayField.getText());

        try {
            dao.addCar(carName, carId, carType, brand, puel, needLicence, price);
            JOptionPane.showMessageDialog(null, "차량이 추가되었습니다.");
            refreshTableData();
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "차량 추가 중 오류가 발생했습니다.");
        }
    }

    private void deleteCar(JTextField carIdField) {
        String carId = carIdField.getText();
        try {
            boolean success = dao.deleteCar(carId);
            if (success) {
                JOptionPane.showMessageDialog(null, "차량이 삭제되었습니다.");
            } else {
                JOptionPane.showMessageDialog(null, "삭제할 차량이 없습니다.");
            }
            refreshTableData();
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "차량 삭제 중 오류가 발생했습니다.");
        }
    }

    private void modifyCarPrice(JTextField carIdField, JTextField newPriceField) {
        String carId = carIdField.getText();
        try {
            int newPrice = Integer.parseInt(newPriceField.getText());
            boolean success = dao.updateCarPrice(carId, newPrice);
            if (success) {
                JOptionPane.showMessageDialog(null, "차량 가격이 수정되었습니다.");
            } else {
                JOptionPane.showMessageDialog(null, "수정할 차량이 없습니다.");
            }
            refreshTableData();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "올바른 숫자 형식이 아닙니다.");
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "차량 가격 수정 중 오류가 발생했습니다.");
        }
    }

    public static void main(String[] args) {
        new InputForm();
    }
}
