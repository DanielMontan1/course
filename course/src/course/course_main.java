package course;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;


public class course_main extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField nameField;
    private JComboBox<String> directionBox;
    private JComboBox<String> durationBox;
    private JTextArea resultArea;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
            	course_main frame = new course_main();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * Create the frame.
     */
    public course_main() {
        setTitle("Курсы обучения");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 600, 400);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel nameLabel = new JLabel("Введите имя:");
        nameLabel.setBounds(20, 20, 120, 25);
        contentPane.add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(150, 20, 200, 25);
        contentPane.add(nameField);
        nameField.setColumns(10);

        JLabel directionLabel = new JLabel("Выберите направление:");
        directionLabel.setBounds(20, 60, 160, 25);
        contentPane.add(directionLabel);

        String[] directions = {"Программирование", "Здоровье и питание", "Вышивание"};
        directionBox = new JComboBox<>(directions);
        directionBox.setBounds(200, 60, 200, 25);
        contentPane.add(directionBox);

        JLabel durationLabel = new JLabel("Выберите срок обучения:");
        durationLabel.setBounds(20, 100, 160, 25);
        contentPane.add(durationLabel);

        String[] durations = {"1 месяц", "3 месяца", "6 месяцев"};
        durationBox = new JComboBox<>(durations);
        durationBox.setBounds(200, 100, 200, 25);
        contentPane.add(durationBox);

        JButton resultButton = new JButton("Показать курс");
        resultButton.setBounds(150, 150, 150, 30);
        contentPane.add(resultButton);

        resultArea = new JTextArea();
        resultArea.setEditable(false);
        resultArea.setBounds(20, 200, 540, 120);
        contentPane.add(resultArea);

        resultButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                displayCourse();
            }
        });
    }

    public void displayCourse() {
        String name = nameField.getText().trim();
        String direction = (String) directionBox.getSelectedItem();
        String duration = (String) durationBox.getSelectedItem();

        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Пожалуйста, введите имя!", "Ошибка", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String course = findCourse(direction, duration);
        String message = String.format(
            "%s,\nВам подходит следующий курс: %s\nНаправление: %s\nСрок: %s",
            name, course, direction, duration
        );

        
        JOptionPane.showMessageDialog(this, message, "Курс", JOptionPane.INFORMATION_MESSAGE);
    }


    protected String findCourse(String direction, String duration) {
        String[][] courses = {
            {"Основы программирования", "Веб-разработка", "Мобильная разработка"},
            {"Диетология", "Фитнес для начинающих", "Здоровый образ жизни"},
            {"Базовое вышивание", "Креативное рукоделие", "Вышивка крестиком"}
        };

        int index = -1;
        switch (direction) {
            case "Программирование":
                index = 0;
                break;
            case "Здоровье и питание":
                index = 1;
                break;
            case "Вышивание":
                index = 2;
                break;
            default:
                return "Курс не найден"; // Если направление не совпадает
        }

        String[] selectedCourses = courses[index];
        switch (duration) {
            case "1 месяц":
                return selectedCourses[0];
            case "3 месяца":
                return selectedCourses[1];
            case "6 месяцев":
                return selectedCourses[2];
            default:
                return "Курс не найден"; // Если срок обучения не совпадает
        }
    }

}
