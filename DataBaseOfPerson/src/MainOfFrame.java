import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import java.awt.Font;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainOfFrame {
	private static JTextField fieldName;
	private static JTextField fieldFamily;
	private static JTextField fieldAge;
	public static JLabel labelFoundName;
	public static JLabel labelFoundFamily;
	public static JLabel labelFoundAge;
	
	private static void addComponentsToPane(Container pane) {
//		pane.setLayout(new FlowLayout());
		addATabbedPane(pane);
	}
	private static void addComponentsToPanel1(Container panel) {
//		panel.setLayout(new BorderLayout());
		JButton buttonOFCreate = addAButton("Создать", panel);
		JButton buttonOFClear = addAButton("Очистить", panel);
		addALabel ("Создать", panel);
		addALabel ("*******************", panel);
		addALabel ("Имя", panel);
		fieldName = addATextField(panel);
		addALabel ("Фамилия", panel);
		fieldFamily = addATextField(panel);
		addALabel ("Возраст", panel);
		fieldAge = addATextField(panel);
		
		MyListener.addAnActionListenerClear(buttonOFClear, fieldName);
		MyListener.addAnActionListenerClear(buttonOFClear, fieldFamily);
		MyListener.addAnActionListenerClear(buttonOFClear, fieldAge);
		MyListener.addAnActionListenerCreateFile(buttonOFCreate, fieldName, fieldFamily, fieldAge);
		MyListener.addAnFocusListener_txt(fieldName);
		MyListener.addAnFocusListener_txt(fieldFamily);
		MyListener.addAnFocusListener_digit(fieldAge);
		
	}
	private static void addComponentsToPanel2(Container panel) {
		addALabel ("Найти", panel);
		JTextField fieldSearch = addATextField(panel);
		addALabel ("Введите id и нажмите enter", panel);
		JButton buttonOFClear = addAButton("Очистить", panel);
		JPanel panelIn = new JPanel();
		panelIn.setLayout(new BoxLayout(panelIn, BoxLayout.PAGE_AXIS));
		labelFoundName = addALabelFound ("Имя: ", panelIn);
		labelFoundFamily = addALabelFound ("Фамилия: ", panelIn);
		labelFoundAge = addALabelFound ("Возраст: ", panelIn);
		panel.add(panelIn);
		
		MyListener.addAnActionListenerClear(buttonOFClear, fieldSearch);
		MyListener.addAnKeyListener_enter(fieldSearch);
		MyListener.addAnFocusListener_digit(fieldSearch);
	}
	
    private static JLabel addALabel (String text, Container cont) {
		JLabel label = new JLabel(text);
//		label.setBounds(20,20,100,20);
		label.setAlignmentX(Component.CENTER_ALIGNMENT);
		cont.add(label);
		return label;
	}
    private static JLabel addALabelFound (String text, Container cont) {
		JLabel label = new JLabel(text);
//		label.setBounds(20,20,100,20);
		label.setAlignmentX(Component.LEFT_ALIGNMENT);
		Font bigFontTR = new Font("TimesRoman", Font.BOLD, 20);
		label.setFont(bigFontTR);
		cont.add(label);
		return label;
	}
     
	private static JTextField addATextField(Container cont) {
		JTextField tField = new JTextField(35);
		tField.setAlignmentX(Component.CENTER_ALIGNMENT);
		cont.add(tField);
		return tField;
	}
	
	
	private static JButton addAButton(String text, Container cont) {
		JButton button = new JButton();
		button.setText(text);
		cont.add(button);
		return button;		
	}
	
	private static void addATabbedPane(Container cont) {
		JTabbedPane tabPane = new JTabbedPane(JTabbedPane.BOTTOM, JTabbedPane.SCROLL_TAB_LAYOUT);
		JPanel panel1 = new JPanel();
		addComponentsToPanel1(panel1);
		tabPane.addTab("Создание", panel1);
		JPanel panel2 = new JPanel();
		addComponentsToPanel2(panel2);
		tabPane.addTab("Поиск", panel2);
		tabPane.setMnemonicAt(1, String.valueOf("String").charAt(0));
		cont.add(tabPane);
	}

	
	public static void createAndShowGUI() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		JFrame frame = new JFrame("DATABASE");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(350, 500));
		frame.setMinimumSize(new Dimension (350,500));
		frame.setMaximumSize(new Dimension (500, 500));
		addComponentsToPane(frame.getContentPane());
		frame.pack();
		frame.setVisible(true);
	}
}
