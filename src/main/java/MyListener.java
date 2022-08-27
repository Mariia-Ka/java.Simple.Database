import java.awt.event.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.*;


// все слушатели 

public class MyListener {
	
	public static void addAnActionListenerClear(JButton button) {
		ActionListener actList = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					MainOfFrame.fieldName.setText("");
					MainOfFrame.fieldFamily.setText("");
					MainOfFrame.fieldAge.setText("");
				}
		};
		button.addActionListener(actList);
	}
//	public static void addAnActionListenerClear(JButton button, JTextField tField, JLabel label) {
//		ActionListener actList = new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//					tField.setText("");
//					label.setText("");
//				}
//		};
//		button.addActionListener(actList);
//	}
	public static void addAnActionListenerCreateFile(JButton button) {
		ActionListener actList = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					String name = MainOfFrame.fieldName.getText();
					String family = MainOfFrame.fieldFamily.getText();
					int age = Integer.parseInt(MainOfFrame.fieldAge.getText().trim());
					InfoPerson person = new InfoPerson(name, family, age);
					CreateFile.create(person);
					person.showInfo();
				}
		};
		button.addActionListener(actList);
	}
	
//	public static void addAnFocusListener_txt(JTextField tField) {
//		FocusListener focList = new FocusListener() {
//			public void focusGained(FocusEvent e) {
//
//			}
//			public void focusLost(FocusEvent e) {
//				if (tField.getText().equals("")) {
////					JOptionPane.showMessageDialog(null, "* Введите от 3 до 30 символов! *"); // !!!!!!
//				} else {
//					String txt = tField.getText();
//					Pattern pt6=Pattern.compile("[a-zA-Z]{3,30}"); // it says, it should be 3-30 non Digits
//					Matcher mh1 = pt6.matcher(txt);
//					boolean matchFound1 = mh1.matches();
//					if (!(matchFound1)) {
//					JOptionPane.showMessageDialog(null,
//					"* Допустимы только буквы! *");
//					tField.setText("");
//					tField.requestFocus();
//				    } else {
////				    	JOptionPane.showMessageDialog(null, "Хорошо"); // !!!!!!!
//				    	}
//				}
//			}
//		};
//		tField.addFocusListener(focList);
//	}
	
//	public static void addAnFocusListener_digit(JTextField tField) {
//		FocusListener focList = new FocusListener() {
//			public void focusGained(FocusEvent e) {
//
//			}
//			public void focusLost(FocusEvent e) {
//				if (tField.getText().equals("")) {
////					JOptionPane.showMessageDialog(null, "* Введите от 3 до 30 символов! *"); // !!!!!!
//				} else {
//					String digits = tField.getText();
//					Pattern pt6=Pattern.compile("\\d{3,13}"); // it says, it should be 3-13 Digits
//					Matcher mh1 = pt6.matcher(digits);
//					boolean matchFound1 = mh1.matches();
//					if (!(matchFound1)) {
//					JOptionPane.showMessageDialog(null,
//					"* Допустимы только цифры! *");
//					tField.setText("");
//					tField.requestFocus();
//				    } else {
////				    	JOptionPane.showMessageDialog(null, "Хорошо"); // !!!!!!!
//				    	}
//				}
//			}
//		};
//		tField.addFocusListener(focList);
//	}
	
	public static void addAnKeyListener_enter(JTextField tField) {
		KeyListener keyList = new KeyListener() {
			public void keyTyped(KeyEvent e) {	
			}
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					int id = Integer.parseInt(MainOfFrame.fieldSearch.getText());
//					SearchFile.search(id);
					ConnectToBase.search(id);
				}
			}
			public void keyReleased(KeyEvent e) {	
			}
			
		};
		tField.addKeyListener(keyList);
	}
}
