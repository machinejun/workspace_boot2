package ch08;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginPanel extends JPanel{
	JLabel idLabel;
	JLabel psLabel;
	JTextField idFeild;
	JPasswordField passwordField;
	
	JButton loginBt;
	JButton quitBt;
	
	public LoginPanel() {
		setVisible(true);	
	}
	
	public static void main(String[] args) {
		new LoginPanel();
	}
}
