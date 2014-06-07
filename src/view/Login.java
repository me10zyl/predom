package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton jButton1;
	private JLabel jLabel3;
	private JLabel jLabel4;
	private JTextField JTextField_eMailField;
	private JLabel JLabel_logoLabel;
	private JPasswordField jPasswordField_passwordField;
	private JLabel JLabel_tipLabel;

	public Login() {
		initComponents();
	}

	private void initComponents() {
		this.JLabel_logoLabel = new JLabel();
		this.JLabel_tipLabel = new JLabel();
		this.jLabel3 = new JLabel();
		this.JTextField_eMailField = new JTextField();
		this.jLabel4 = new JLabel();
		this.jPasswordField_passwordField = new JPasswordField();
		this.jButton1 = new JButton();

		setDefaultCloseOperation(3);
		setMinimumSize(new Dimension(300, 150));
		getContentPane().setLayout(new GridBagLayout());

		this.JLabel_logoLabel.setBackground(new Color(51, 51, 255));
		this.JLabel_logoLabel.setIcon(new ImageIcon(getClass().getResource(
				"/images/toplanf.png")));
		this.JLabel_logoLabel.setMaximumSize(new Dimension(300, 50));
		this.JLabel_logoLabel.setMinimumSize(new Dimension(300, 50));
		this.JLabel_logoLabel.setPreferredSize(new Dimension(300, 30));
		GridBagConstraints gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.gridwidth = 2;
		gridBagConstraints.fill = 1;
		gridBagConstraints.insets = new Insets(5, 5, 5, 5);
		getContentPane().add(this.JLabel_logoLabel, gridBagConstraints);

		this.JLabel_tipLabel.setForeground(new Color(255, 0, 0));
		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.gridwidth = 2;
		gridBagConstraints.fill = 2;
		gridBagConstraints.anchor = 17;
		gridBagConstraints.insets = new Insets(5, 5, 5, 5);
		getContentPane().add(this.JLabel_tipLabel, gridBagConstraints);

		this.jLabel3.setFont(new Font("ËÎÌå", 0, 11));
		this.jLabel3.setText("eMail:");
		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.anchor = 13;
		gridBagConstraints.insets = new Insets(5, 5, 5, 5);
		getContentPane().add(this.jLabel3, gridBagConstraints);

		this.JTextField_eMailField.setMinimumSize(new Dimension(100, 20));
		this.JTextField_eMailField.setPreferredSize(new Dimension(150, 20));
		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.anchor = 13;
		gridBagConstraints.insets = new Insets(5, 5, 5, 5);
		getContentPane().add(this.JTextField_eMailField, gridBagConstraints);

		this.jLabel4.setFont(new Font("ËÎÌå", 0, 11));
		this.jLabel4.setText("ÃÜÂë:");
		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 3;
		gridBagConstraints.anchor = 13;
		gridBagConstraints.insets = new Insets(5, 5, 5, 5);
		getContentPane().add(this.jLabel4, gridBagConstraints);

		this.jPasswordField_passwordField.setPreferredSize(new Dimension(150,
				20));
		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 3;
		gridBagConstraints.anchor = 13;
		gridBagConstraints.insets = new Insets(5, 5, 5, 5);
		getContentPane().add(this.jPasswordField_passwordField,
				gridBagConstraints);

		this.jButton1.setFont(new Font("ËÎÌå", 0, 11));
		this.jButton1.setText("µÇÂ¼");
		this.jButton1.addActionListener(this);
		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 4;
		gridBagConstraints.gridwidth = 2;
		gridBagConstraints.anchor = 13;
		gridBagConstraints.insets = new Insets(5, 5, 5, 5);
		getContentPane().add(this.jButton1, gridBagConstraints);

		this.setTitle("userManager¡ª¡ªLogin");
		this.setLocationRelativeTo(getOwner());
		pack();
		this.setVisible(true);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Login();
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == jButton1) {
			this.dispose();
			new Permission().setVisible(true);
		}
	}
}
