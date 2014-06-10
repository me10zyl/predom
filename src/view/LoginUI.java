/*
 * LoginUI.java
 *
 * Created on __DATE__, __TIME__
 */
package view;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import verifier.EmailVerifier;
import model.Login;
import exception.NoInputException;
import exception.UserNotExistException;
import exception.WrongPasswordException;

/**
 * 
 * @author __USER__
 */
public class LoginUI extends javax.swing.JFrame
{
	/** Creates new form LoginUI */
	public LoginUI()
	{
		initComponents();
	}
	/**
	 * This method is called from within the constructor to initialize the
	 * form. WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
	// GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents()
	{
		java.awt.GridBagConstraints gridBagConstraints;
		jPanel_login = new javax.swing.JPanel();
		jLabel_logo = new javax.swing.JLabel();
		jLabel_loginName = new javax.swing.JLabel();
		jLabel_password = new javax.swing.JLabel();
		jTextField_loginName = new javax.swing.JTextField();
		jPasswordField_password = new javax.swing.JPasswordField();
		jButton_login = new javax.swing.JButton();
		jLabel_result = new javax.swing.JLabel();
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		jPanel_login.setLayout(new java.awt.GridBagLayout());
		jLabel_logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/toplanf.png"))); // NOI18N
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridwidth = 2;
		gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
		gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
		jPanel_login.add(jLabel_logo, gridBagConstraints);
		jLabel_loginName.setText("\u767b\u9646\u540d\uff1a");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
		jPanel_login.add(jLabel_loginName, gridBagConstraints);
		jLabel_password.setText("\u5bc6  \u7801\uff1a");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
		jPanel_login.add(jLabel_password, gridBagConstraints);
		jTextField_loginName.setColumns(20);
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
		jPanel_login.add(jTextField_loginName, gridBagConstraints);
		jPasswordField_password.setColumns(20);
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
		jTextField_loginName.setInputVerifier(new EmailVerifier(jLabel_result));
		jPanel_login.add(jPasswordField_password, gridBagConstraints);
		jButton_login.setText("\u767b\u9646");
		jButton_login.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(java.awt.event.ActionEvent evt)
			{
				jButton_loginActionPerformed(evt);
			}
		});
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 3;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
		gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
		jPanel_login.add(jButton_login, gridBagConstraints);
		jLabel_result.setForeground(new java.awt.Color(255, 0, 0));
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 3;
		jPanel_login.add(jLabel_result, gridBagConstraints);
		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jPanel_login, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jPanel_login, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE));
		this.setLocationRelativeTo(getOwner());
		jTextField_loginName.setText("zyl@qq.com");
		jPasswordField_password.setText("123123");
		pack();
	}// </editor-fold>
		// GEN-END:initComponents
	private void jButton_loginActionPerformed(java.awt.event.ActionEvent e)
	{
		// TODO Auto-generated method stub
		if (e.getSource() == jButton_login)
		{
			try
			{
				String resultStr = new Login(jTextField_loginName.getText(), new String(jPasswordField_password.getPassword())).login();
				System.out.println(resultStr);
				this.dispose();
				new Permission().setVisible(true);
			} catch (NoInputException e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
				jLabel_result.setText(e1.getMessage());
			} catch (WrongPasswordException e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
				jLabel_result.setText(e1.getMessage());
			} catch (UserNotExistException e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
				jLabel_result.setText(e1.getMessage());
			} catch (SQLException e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null, e1.getMessage());
			} catch (ClassNotFoundException e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null, e1.getMessage());
			}
		}
	}
	/**
	 * @param args
	 *                the command line arguments
	 */
	public static void main(String args[])
	{
		java.awt.EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				new LoginUI().setVisible(true);
			}
		});
	}

	// GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JButton jButton_login;
	private javax.swing.JLabel jLabel_loginName;
	private javax.swing.JLabel jLabel_logo;
	private javax.swing.JLabel jLabel_password;
	private javax.swing.JLabel jLabel_result;
	private javax.swing.JPanel jPanel_login;
	private javax.swing.JPasswordField jPasswordField_password;
	private javax.swing.JTextField jTextField_loginName;
	// End of variables declaration//GEN-END:variables
}