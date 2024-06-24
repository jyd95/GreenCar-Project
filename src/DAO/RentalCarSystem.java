package DAO;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class RentalCarSystem extends JFrame {

    private Connection conn;
    private JPanel mainPanel;
    private JTabbedPane tabbedPane;
    private JTextArea reservationTextArea;
    private JComboBox<String> carIdComboBox; // ComboBox to display car IDs

    public RentalCarSystem() {
        initializeDB();
        createMainFrame();
        createLoginGUI();
    }

    private void initializeDB() {
        try {
            conn = DBCarConnectionManager.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void createMainFrame() {
        setTitle("렌터카 시스템");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

        tabbedPane = new JTabbedPane();
        mainPanel.add(tabbedPane, BorderLayout.CENTER);

        add(mainPanel);
        setVisible(true);
    }

    private void createLoginGUI() {
        JFrame frame = new JFrame("로그인");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);
        frame.setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        JLabel usernameLabel = new JLabel("사용자 이름:");
        JTextField usernameField = new JTextField();
        JLabel passwordLabel = new JLabel("비밀번호:");
        JPasswordField passwordField = new JPasswordField();
        JButton loginButton = new JButton("로그인");
        JButton signupButton = new JButton("회원 가입");

        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(loginButton);
        panel.add(signupButton);

        frame.add(panel, BorderLayout.CENTER);
        frame.setVisible(true);

        loginButton.addActionListener(e -> {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());
            if (checkLogin(username, password)) {
                frame.dispose();
                createMainTabs(username);
            } else {
                JOptionPane.showMessageDialog(null, "로그인 실패. 사용자 이름 또는 비밀번호를 확인하세요.");
            }
        });

        signupButton.addActionListener(e -> {
            frame.dispose();
            showSignupForm();
        });
    }

    private boolean checkLogin(String username, String password) {
        String query = "SELECT * FROM users WHERE username = ? AND password = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private void createMainTabs(String username) {
        JPanel reservationPanel = createReservationPanel(username);
        JPanel cancellationPanel = createCancellationPanel();
        JPanel bookingPanel = createBookingPanel(username);

        tabbedPane.addTab("예약하기", bookingPanel);
        tabbedPane.addTab("예약 조회", reservationPanel);
        tabbedPane.addTab("예약 취소", cancellationPanel);

        tabbedPane.setSelectedComponent(reservationPanel);
    }

    private JPanel createReservationPanel(String username) {
        JPanel panel = new JPanel(new BorderLayout());

        JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel usernameLabel = new JLabel("사용자 이름:");
        JTextField usernameField = new JTextField(10);
        JButton searchButton = new JButton("조회");

        searchPanel.add(usernameLabel);
        searchPanel.add(usernameField);
        searchPanel.add(searchButton);

        reservationTextArea = new JTextArea(15, 50);
        reservationTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(reservationTextArea);

        panel.add(searchPanel, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);

        searchButton.addActionListener(e -> {
            String searchUsername = usernameField.getText().trim();
            if (!searchUsername.isEmpty()) {
                showReservationsByUsername(searchUsername);
            } else {
                JOptionPane.showMessageDialog(null, "사용자 이름을 입력하세요.");
            }
        });

        return panel;
    }

    private void showReservationsByUsername(String username) {
        String query = "SELECT * FROM reservation WHERE username = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();
            StringBuilder sb = new StringBuilder();
            while (rs.next()) {
                int reservationId = rs.getInt("reservation_id");
                String carid = rs.getString("carid");
                Date startDate = rs.getDate("start_date");
                Date endDate = rs.getDate("end_date");

                sb.append("예약 ID: ").append(reservationId).append("\n")
                  .append("차량 ID: ").append(carid).append("\n")
                  .append("대여 시작일: ").append(formatDate(startDate)).append("\n")
                  .append("반납 예정일: ").append(formatDate(endDate)).append("\n\n");
            }
            if (sb.length() > 0) {
                reservationTextArea.setText(sb.toString());
            } else {
                reservationTextArea.setText("해당 사용자의 예약 정보가 없습니다.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private String formatDate(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(date);
    }

    private JPanel createCancellationPanel() {
        JPanel panel = new JPanel(new BorderLayout());

        JLabel cancelLabel = new JLabel("예약을 취소하려면 아래에 예약 ID를 입력하세요:");
        panel.add(cancelLabel, BorderLayout.NORTH);

        JPanel inputPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JTextField cancelIdField = new JTextField(10);
        JButton cancelButton = new JButton("취소");

        inputPanel.add(cancelIdField);
        inputPanel.add(cancelButton);

        panel.add(inputPanel, BorderLayout.CENTER);

        cancelButton.addActionListener(e -> {
            String cancelIdText = cancelIdField.getText().trim();
            if (!cancelIdText.isEmpty()) {
                try {
                    int cancelId = Integer.parseInt(cancelIdText);
                    if (cancelReservation(cancelId)) {
                        JOptionPane.showMessageDialog(null, "예약이 취소되었습니다.");
                        cancelIdField.setText("");
                    } else {
                        JOptionPane.showMessageDialog(null, "예약 취소 실패. 다시 시도하세요.");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "올바른 예약 ID를 입력하세요.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "예약 ID를 입력하세요.");
            }
        });

        return panel;
    }

    private boolean cancelReservation(int reservationId) {
        String query = "DELETE FROM reservation WHERE reservation_id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, reservationId);
            int rowsDeleted = pstmt.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private JPanel createBookingPanel(String username) {
        JPanel panel = new JPanel(new BorderLayout());

        JLabel welcomeLabel = new JLabel("환영합니다, " + username + "님! 예약을 진행해주세요.");
        panel.add(welcomeLabel, BorderLayout.NORTH);

        JPanel formPanel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(5, 5, 5, 5);
        constraints.anchor = GridBagConstraints.WEST;

        JLabel carIdLabel = new JLabel("차량 ID:");
        carIdComboBox = new JComboBox<>();
        populateCarIds();

        JLabel carNameLabel = new JLabel("차량 이름:");
        JLabel carTypeLabel = new JLabel("차량 종류:");
        JLabel brandLabel = new JLabel("브랜드:");
        JLabel priceLabel = new JLabel("일일 대여료:");
        JLabel fuelLabel = new JLabel("연료:");
        JLabel licenseLabel = new JLabel("면허 필요 여부:");

        JPanel carInfoPanel = new JPanel(new GridLayout(6, 2));
        carInfoPanel.add(carNameLabel);
        carInfoPanel.add(new JLabel());
        carInfoPanel.add(carTypeLabel);
        carInfoPanel.add(new JLabel());
        carInfoPanel.add(brandLabel);
        carInfoPanel.add(new JLabel());
        carInfoPanel.add(priceLabel);
        carInfoPanel.add(new JLabel());
        carInfoPanel.add(fuelLabel);
        carInfoPanel.add(new JLabel());
        carInfoPanel.add(licenseLabel);
        carInfoPanel.add(new JLabel());

        carIdComboBox.addActionListener(e -> {
            String selectedCarId = (String) carIdComboBox.getSelectedItem();
            if (selectedCarId != null) {
                showCarDetails(selectedCarId, carInfoPanel);
            }
        });

        JLabel startDateLabel = new JLabel("대여 시작일 (yyyy-MM-dd):");
        JTextField startDateField = new JTextField(10);

        JLabel endDateLabel = new JLabel("반납 예정일 (yyyy-MM-dd):");
        JTextField endDateField = new JTextField(10);

        JButton reserveButton = new JButton("예약하기");

        constraints.gridx = 0;
        constraints.gridy = 0;
        formPanel.add(carIdLabel, constraints);

        constraints.gridx = 1;
        formPanel.add(carIdComboBox, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        formPanel.add(startDateLabel, constraints);

        constraints.gridx = 1;
        formPanel.add(startDateField, constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        formPanel.add(endDateLabel, constraints);

        constraints.gridx = 1;
        formPanel.add(endDateField, constraints);

        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        formPanel.add(reserveButton, constraints);

        panel.add(formPanel, BorderLayout.CENTER);
        panel.add(carInfoPanel, BorderLayout.SOUTH);

        reserveButton.addActionListener(e -> {
            String carId = (String) carIdComboBox.getSelectedItem();
            String startDateText = startDateField.getText().trim();
            String endDateText = endDateField.getText().trim();

            if (carId.isEmpty() || startDateText.isEmpty() || endDateText.isEmpty()) {
                JOptionPane.showMessageDialog(null, "모든 필드를 입력하세요.");
            } else {
                try {
                    // Parse dates from text fields
                    Date startDate = new SimpleDateFormat("yyyy-MM-dd").parse(startDateText);
                    Date endDate = new SimpleDateFormat("yyyy-MM-dd").parse(endDateText);

                    // Check if start date is before or equal to end date
                    if (startDate.after(endDate)) {
                        JOptionPane.showMessageDialog(null, "반납 예정일은 시작일 이후여야 합니다.");
                    } else {
                        // Check if the date range is available
                        if (isDateRangeAvailable(carId, startDate, endDate)) {
                            // Make reservation
                            if (makeReservation(username, carId, startDate, endDate)) {
                            	JOptionPane.showMessageDialog(null, "예약이 완료 되었습니다");
                                StringBuilder sb = new StringBuilder();
                                sb.append("예약이 완료되었습니다.\n\n")
                                  .append("차량 번호: ").append(carId).append("\n")
                                  .append("대여 시작일: ").append(formatDate(startDate)).append("\n")
                                  .append("반납 예정일: ").append(formatDate(endDate)).append("\n");

                                reservationTextArea.setText(sb.toString());
                                startDateField.setText("");
                                endDateField.setText("");
                                populateCarIds(); // Refresh car IDs in case of new reservations
                                carInfoPanel.removeAll(); // Clear existing car info
                            } else {
                                JOptionPane.showMessageDialog(null, "예약 실패. 다시 시도하세요.");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "선택한 날짜 범위에 이미 예약이 있습니다.");
                        }
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "올바른 날짜 형식으로 입력하세요 (yyyy-MM-dd).");
                }
            }
        });

        return panel;
    }

    private void showCarDetails(String carId, JPanel carInfoPanel) {
        String query = "SELECT * FROM carmanagement as cm\r\n"
        		+ "join carinfo as ci\r\n"
        		+ "on cm.carname = ci.carname\r\n"
        		+ "WHERE carid = ? ";
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, carId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                String carName = rs.getString("carname");
                String carType = rs.getString("cartype");
                String brand = rs.getString("brand");
                double pricePerDay = rs.getDouble("priceperday");
                String puel = rs.getString("puel");
                String needLicense = rs.getString("needlicence");

                ((JLabel) carInfoPanel.getComponent(1)).setText(carName);
                ((JLabel) carInfoPanel.getComponent(3)).setText(carType);
                ((JLabel) carInfoPanel.getComponent(5)).setText(brand);
                ((JLabel) carInfoPanel.getComponent(7)).setText(String.valueOf(pricePerDay));
                ((JLabel) carInfoPanel.getComponent(9)).setText(puel);
                ((JLabel) carInfoPanel.getComponent(11)).setText(needLicense);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void populateCarIds() {
        String query = "SELECT carid FROM carmanagement";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            List<String> carIds = new ArrayList<>();
            while (rs.next()) {
                carIds.add(rs.getString("carid"));
            }
            carIdComboBox.setModel(new DefaultComboBoxModel<>(carIds.toArray(new String[0])));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private boolean isDateRangeAvailable(String carId, Date startDate, Date endDate) {
        String query = "SELECT * FROM reservation WHERE carid = ? AND ((start_date <= ? AND end_date >= ?) OR (start_date <= ? AND end_date >= ?) OR (start_date >= ? AND end_date <= ?))";
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, carId);
            pstmt.setDate(2, new java.sql.Date(startDate.getTime()));
            pstmt.setDate(3, new java.sql.Date(startDate.getTime()));
            pstmt.setDate(4, new java.sql.Date(endDate.getTime()));
            pstmt.setDate(5, new java.sql.Date(endDate.getTime()));
            pstmt.setDate(6, new java.sql.Date(startDate.getTime()));
            pstmt.setDate(7, new java.sql.Date(endDate.getTime()));

            ResultSet rs = pstmt.executeQuery();
            return !rs.next(); // Return true if no overlapping reservation found
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private boolean makeReservation(String username, String carId, Date startDate, Date endDate) {
        String query = "INSERT INTO reservation (username, carid, start_date, end_date) VALUES (?, ?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, username);
            pstmt.setString(2, carId);
            pstmt.setDate(3, new java.sql.Date(startDate.getTime()));
            pstmt.setDate(4, new java.sql.Date(endDate.getTime()));

            int rowsInserted = pstmt.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private void showSignupForm() {
        JFrame frame = new JFrame("회원 가입");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(300, 250); // Increased size to accommodate additional fields
        frame.setLayout(new BorderLayout());

        JPanel panel = new JPanel(new GridLayout(6, 2)); // Adjusted grid layout for new fields

        JLabel usernameLabel = new JLabel("사용자 이름:");
        JTextField usernameField = new JTextField();
        JLabel passwordLabel = new JLabel("비밀번호:");
        JPasswordField passwordField = new JPasswordField();
        JLabel phonumLabel = new JLabel("전화번호:");
        JTextField phonumField = new JTextField();
        JLabel addressLabel = new JLabel("주소:");
        JTextField addressField = new JTextField();
        JLabel emailLabel = new JLabel("이메일:");
        JTextField emailField = new JTextField();
        JButton signupButton = new JButton("가입");

        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(phonumLabel);
        panel.add(phonumField);
        panel.add(addressLabel);
        panel.add(addressField);
        panel.add(emailLabel);
        panel.add(emailField);
        panel.add(new JLabel()); // Empty label for spacing
        panel.add(signupButton);

        frame.add(panel, BorderLayout.CENTER);
        frame.setVisible(true);

        signupButton.addActionListener(e -> {
            String username = usernameField.getText().trim();
            String password = new String(passwordField.getPassword());
            String phonum = phonumField.getText().trim();
            String address = addressField.getText().trim();
            String email = emailField.getText().trim();

            if (username.isEmpty() || password.isEmpty() || phonum.isEmpty() || address.isEmpty() || email.isEmpty()) {
                JOptionPane.showMessageDialog(null, "모든 필드를 입력하세요.");
            } else {
                if (signupUser(username, password, phonum, address, email)) {
                    JOptionPane.showMessageDialog(null, "회원 가입이 완료되었습니다.");
                    frame.dispose();
                    createLoginGUI();
                } else {
                    JOptionPane.showMessageDialog(null, "회원 가입 실패. 다시 시도하세요.");
                }
            }
        });
    }


    private boolean signupUser(String username, String password, String phonum, String address, String email) {
        String query = "INSERT INTO users (username, password, phonum, address, email) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            pstmt.setString(3, phonum);
            pstmt.setString(4, address);
            pstmt.setString(5, email);

            int rowsInserted = pstmt.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new RentalCarSystem());
    }
}