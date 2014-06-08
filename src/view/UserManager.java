package view;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import model.TableModel;
import model.db.dao.UserDAO;
import model.db.dao.UserGroupDAO;
import model.domain.Bean;
import model.domain.UserBean;
import model.domain.UserGroupBean;
import util.BeanUtil;

public class UserManager extends JPanel
{
	private String[] columnNames;
	private Class[] columnClasses;
	boolean[] canEdit;
	private TableModel userTableModel;
	private UserDAO userDAO;
	private JPasswordField jPasswordField_password;
	private JButton jButton_add;
	private JTextField jTextField_address;
	private JLabel jLabel_address;
	private JButton JButton_delete;
	private JTextField jTextField_eMail;
	private JLabel jLabel_eMail;
	private JTextField jTextField_id;
	private JLabel jLabel_id;
	private JComboBox jComboBox_userGroup;
	private JLabel jLabel_logo;
	private JButton jButton_modify;
	private JTextField jTextField_name;
	private JLabel jLabel_name;
	private JLabel jLabel_password;
	private JTextField jTextField_phone;
	private JLabel jLabel_phone;
	private JTextField jTextField_postCode;
	private JLabel jLabel_postCode;
	private JLabel jLabel_userGroup;
	private JPanel jPanel_userInfo;
	private JTable jTable_user;
	private JScrollPane jScrollPane_users;

	public UserManager()
	{
		this.columnNames = new String[]
		{ "编号", "用户组","姓名", "地址", "邮编", "电话", "eMail","密码" };
		this.canEdit = new boolean[8];
		this.userTableModel = null;
		this.userDAO = new UserDAO();
		this.columnClasses = new Class[]
		{ Integer.class, Integer.class, String.class, String.class, String.class, String.class, String.class, String.class };
		try
		{
			initComponents();
		} catch (SQLException e)
		{
			e.printStackTrace();
		} catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
	}
	private void initComponents() throws SQLException, ClassNotFoundException
	{
		/*
		 * Vector records = CreatTableRecordUtil
		 * .createUserTableRecords(this.usersDAO.getAllUsers());
		 * this.userTableModel = new TableModel(this.columnNames, null,
		 * this.canEdit, records);
		 */
		this.jLabel_logo = new JLabel();
		this.jScrollPane_users = new JScrollPane();
		this.jTable_user = new JTable();
		this.jPanel_userInfo = new JPanel();
		this.jLabel_name = new JLabel();
		this.jTextField_name = new JTextField();
		this.jTextField_eMail = new JTextField();
		this.jLabel_eMail = new JLabel();
		this.jLabel_id = new JLabel();
		this.jTextField_id = new JTextField();
		this.jLabel_password = new JLabel();
		this.jPasswordField_password = new JPasswordField();
		this.jLabel_userGroup = new JLabel();
		this.jButton_add = new JButton();
		this.JButton_delete = new JButton();
		this.jButton_modify = new JButton();
		this.jLabel_address = new JLabel();
		this.jTextField_address = new JTextField();
		this.jLabel_postCode = new JLabel();
		this.jTextField_postCode = new JTextField();
		this.jLabel_phone = new JLabel();
		this.jTextField_phone = new JTextField();
		setBorder(BorderFactory.createLineBorder(new Color(0, 51, 204)));
		setLayout(new GridBagLayout());
		this.jLabel_logo.setIcon(new ImageIcon(getClass().getResource("/images/toplanf.gif")));
		GridBagConstraints gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.anchor = 11;
		add(this.jLabel_logo, gridBagConstraints);
		this.jScrollPane_users.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(new Color(0, 51, 255), new Color(102, 102, 102)), "用户列表", 2, 0, new Font("楷体_GB2312", 0, 18)));
		this.jScrollPane_users.setPreferredSize(new Dimension(600, 200));
		// TODO jTabel
		this.jTable_user.setBorder(BorderFactory.createEtchedBorder(new Color(51, 255, 255), Color.black));
		this.jTable_user.setFont(new Font("宋体", 0, 11));
		Vector<Bean> beans = userDAO.getAll();
		userTableModel = new TableModel(columnNames, columnClasses, canEdit, BeanUtil.convertUserBeansToVector(beans));
		this.jTable_user.setModel(this.userTableModel);
//		TableRowSorter rowSorter = new TableRowSorter(this.userTableModel);
		/*
		 * rowSorter.setComparator(0, new IntegerComparator());
		 * rowSorter.setComparator(this.columnNames.length - 1, new
		 * IntegerComparator());
		 */
//		this.jTable_user.setRowSorter(rowSorter);
		this.jTable_user.setName("viewUser");
		this.jTable_user.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent evt)
			{
				/*
				 * try { PredomManager.canUse(evt);
				 * UserManager.this.userTableMouseClicked(evt);
				 * } catch (SQLException e) {
				 * e.printStackTrace(); } catch
				 * (ClassNotFoundException e) {
				 * e.printStackTrace(); } catch
				 * (CanNotUseException e) { e.printStackTrace();
				 * }
				 */
				// TODO
				UserManager.this.userTableMouseClicked(evt);
			}
		});
		this.jScrollPane_users.setViewportView(this.jTable_user);
		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.anchor = 11;
		add(this.jScrollPane_users, gridBagConstraints);
		this.jPanel_userInfo.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(new Color(0, 51, 255), new Color(102, 102, 102)), "用户信息", 1, 0, new Font("楷体_GB2312", 0, 18)));
		this.jPanel_userInfo.setPreferredSize(new Dimension(600, 300));
		this.jPanel_userInfo.setLayout(new GridBagLayout());
		this.jLabel_name.setFont(new Font("宋体", 0, 11));
		this.jLabel_name.setText("*姓名：");
		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.insets = new Insets(5, 5, 5, 5);
		this.jPanel_userInfo.add(this.jLabel_name, gridBagConstraints);
		this.jTextField_name.setPreferredSize(new Dimension(180, 20));
		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 2;
		gridBagConstraints.gridy = 1;
		this.jPanel_userInfo.add(this.jTextField_name, gridBagConstraints);
		this.jTextField_eMail.setPreferredSize(new Dimension(180, 20));
		// this.eMailField.setInputVerifier(new
		// IsNotChinese("eMail中不能有中文！"));
		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 2;
		gridBagConstraints.gridy = 4;
		gridBagConstraints.insets = new Insets(5, 5, 5, 5);
		this.jPanel_userInfo.add(this.jTextField_eMail, gridBagConstraints);
		this.jLabel_eMail.setFont(new Font("宋体", 0, 11));
		this.jLabel_eMail.setText("*EMail：");
		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 4;
		gridBagConstraints.insets = new Insets(5, 5, 5, 5);
		this.jPanel_userInfo.add(this.jLabel_eMail, gridBagConstraints);
		this.jLabel_id.setFont(new Font("宋体", 0, 11));
		this.jLabel_id.setText("*编号：");
		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.insets = new Insets(3, 5, 5, 5);
		this.jPanel_userInfo.add(this.jLabel_id, gridBagConstraints);
		this.jTextField_id.setEditable(false);
		this.jTextField_id.setPreferredSize(new Dimension(180, 20));
		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 2;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.insets = new Insets(2, 5, 3, 5);
		this.jPanel_userInfo.add(this.jTextField_id, gridBagConstraints);
		this.jLabel_password.setFont(new Font("宋体", 0, 11));
		this.jLabel_password.setText("*密码：");
		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 5;
		gridBagConstraints.insets = new Insets(5, 5, 5, 5);
		this.jPanel_userInfo.add(this.jLabel_password, gridBagConstraints);
		this.jPasswordField_password.setPreferredSize(new Dimension(180, 20));
		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 2;
		gridBagConstraints.gridy = 5;
		gridBagConstraints.insets = new Insets(5, 5, 5, 5);
		this.jPanel_userInfo.add(this.jPasswordField_password, gridBagConstraints);
		this.jLabel_userGroup.setFont(new Font("宋体", 0, 11));
		this.jLabel_userGroup.setText("用户组：");
		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 7;
		gridBagConstraints.insets = new Insets(5, 5, 5, 5);
		this.jPanel_userInfo.add(this.jLabel_userGroup, gridBagConstraints);
		this.jButton_add.setFont(new Font("宋体", 0, 11));
		this.jButton_add.setText("添加");
		this.jButton_add.setName("addUser");
		this.jButton_add.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent evt)
			{
				/*
				 * try { PredomManager.canUse(evt);
				 * UserManager.this
				 * .addButtonActionPerformed(evt); } catch
				 * (SQLException e) { e.printStackTrace(); }
				 * catch (ClassNotFoundException e) {
				 * e.printStackTrace(); } catch
				 * (CanNotUseException e) { e.printStackTrace();
				 * }
				 */
				try
				{
					UserManager.this.addButtonActionPerformed(evt);
					JOptionPane.showMessageDialog(null, "添加成功");
				} catch (SQLException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, e.getMessage());
				} catch (ClassNotFoundException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, e.getMessage());
				} finally
				{
					try
					{
						userDAO.release();
					} catch (SQLException e)
					{
						// TODO Auto-generated catch
						// block
						e.printStackTrace();
					}
				}
			}
		});
		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 8;
		gridBagConstraints.fill = 1;
		gridBagConstraints.insets = new Insets(5, 5, 5, 5);
		this.jPanel_userInfo.add(this.jButton_add, gridBagConstraints);
		this.JButton_delete.setFont(new Font("宋体", 0, 11));
		this.JButton_delete.setText("删除");
		this.JButton_delete.setName("deleteUser");
		this.JButton_delete.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent evt)
			{
				/*
				 * try { PredomManager.canUse(evt);
				 * UserManager.this
				 * .deleteButtonActionPerformed(evt); } catch
				 * (NumberFormatException e) {
				 * e.printStackTrace(); } catch (SQLException e)
				 * { e.printStackTrace(); } catch
				 * (ClassNotFoundException e) {
				 * e.printStackTrace(); } catch
				 * (CanNotUseException e) { e.printStackTrace();
				 * }
				 */
				try
				{
					UserManager.this .deleteButtonActionPerformed(evt);
				} catch (NumberFormatException e)
				{
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e.getMessage());
					e.printStackTrace();
				} catch (SQLException e)
				{
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e.getMessage());
					e.printStackTrace();
				} catch (ClassNotFoundException e)
				{
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e.getMessage());
					e.printStackTrace();
				}finally{
					try
					{
						userDAO.release();
					} catch (SQLException e)
					{
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, e.getMessage());
						e.printStackTrace();
					}
				}
			}
		});
		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 3;
		gridBagConstraints.gridy = 8;
		gridBagConstraints.insets = new Insets(5, 5, 5, 5);
		this.jPanel_userInfo.add(this.JButton_delete, gridBagConstraints);
		this.jButton_modify.setFont(new Font("宋体", 0, 11));
		this.jButton_modify.setText("修改");
		this.jButton_modify.setName("modifyUser");
		this.jButton_modify.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent evt)
			{
//			*try {
//					PredomManager.canUse(evt);
//					UserManager.this.modifyButtonActionPerformed(evt);
//				} catch (SQLException e) {
//					e.printStackTrace();
//				} catch (ClassNotFoundException e) {
//					e.printStackTrace();
//				} catch (CanNotUseException e) {
//					e.printStackTrace();
//				}
				try
				{
					UserManager.this.modifyButtonActionPerformed(evt);
					JOptionPane.showMessageDialog(null, "修改成功");
				} catch (SQLException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, e.getMessage());
				} catch (ClassNotFoundException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, e.getMessage());
				} finally
				{
					try
					{
						userDAO.release();
					} catch (SQLException e)
					{
						// TODO Auto-generated catch
						// block
						e.printStackTrace();
					}
				}
			}
		});
		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 2;
		gridBagConstraints.gridy = 8;
		this.jPanel_userInfo.add(this.jButton_modify, gridBagConstraints);
		this.jLabel_address.setFont(new Font("宋体", 0, 11));
		this.jLabel_address.setText("*地址：");
		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.insets = new Insets(5, 5, 5, 5);
		this.jPanel_userInfo.add(this.jLabel_address, gridBagConstraints);
		this.jTextField_address.setPreferredSize(new Dimension(180, 20));
		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 2;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.insets = new Insets(5, 5, 5, 5);
		this.jPanel_userInfo.add(this.jTextField_address, gridBagConstraints);
		this.jLabel_postCode.setFont(new Font("宋体", 0, 11));
		this.jLabel_postCode.setText("*邮编：");
		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 3;
		gridBagConstraints.insets = new Insets(5, 5, 5, 5);
		this.jPanel_userInfo.add(this.jLabel_postCode, gridBagConstraints);
		this.jTextField_postCode.setPreferredSize(new Dimension(180, 20));
		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 2;
		gridBagConstraints.gridy = 3;
		gridBagConstraints.insets = new Insets(5, 5, 5, 5);
		this.jPanel_userInfo.add(this.jTextField_postCode, gridBagConstraints);
		this.jLabel_phone.setFont(new Font("宋体", 0, 11));
		this.jLabel_phone.setText("*电话：");
		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 6;
		gridBagConstraints.insets = new Insets(5, 5, 5, 5);
		this.jPanel_userInfo.add(this.jLabel_phone, gridBagConstraints);
		this.jTextField_phone.setPreferredSize(new Dimension(180, 20));
		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 2;
		gridBagConstraints.gridy = 6;
		gridBagConstraints.insets = new Insets(5, 5, 5, 5);
		this.jPanel_userInfo.add(this.jTextField_phone, gridBagConstraints);
		UserGroupDAO userGroupDAO = new UserGroupDAO();
		Vector<Bean> userGroups = userGroupDAO.getAll();
		Vector<Integer> userGroupIds = new Vector<Integer>();
		for (Bean bean : userGroups)
		{
			UserGroupBean userGroupBean = (UserGroupBean) bean;
			userGroupIds.add(userGroupBean.getUserGroupId());
		}
		this.jComboBox_userGroup = new JComboBox(userGroupIds);
		this.jComboBox_userGroup.setFont(new Font("宋体", 0, 9));
		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 2;
		gridBagConstraints.gridy = 7;
		gridBagConstraints.anchor = 17;
		gridBagConstraints.insets = new Insets(5, 5, 5, 5);
		this.jPanel_userInfo.add(this.jComboBox_userGroup, gridBagConstraints);
		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.anchor = 11;
		add(this.jPanel_userInfo, gridBagConstraints);
	}
	private void userTableMouseClicked(MouseEvent evt)
	{
		int rowIndex = this.jTable_user.convertRowIndexToModel(this.jTable_user.getSelectedRow());
		Vector record = this.userTableModel.getRow(rowIndex);
		this.jTextField_id.setText((String) record.elementAt(0));
		this.jTextField_name.setText((String) record.elementAt(2));
		this.jTextField_address.setText((String) record.elementAt(3));
		this.jTextField_postCode.setText((String) record.elementAt(4));
		this.jTextField_phone.setText((String) record.elementAt(5));
		this.jTextField_eMail.setText((String) record.elementAt(6));
		this.jPasswordField_password.setText((String) record.elementAt(7));
		String userGroup_idStr = (String) record.elementAt(1);
		this.jComboBox_userGroup.setSelectedItem(Integer.parseInt(userGroup_idStr));
		 
	}
	private void modifyButtonActionPerformed(ActionEvent evt) throws SQLException, ClassNotFoundException
	{
		UserBean user = new UserBean();
		user.setUserName(this.jTextField_name.getText());
		user.setUserAddress(this.jTextField_address.getText());
		user.setUserCode(this.jTextField_postCode.getText());
		user.setUserEmail(this.jTextField_eMail.getText());
		user.setUserPassword(new String(this.jPasswordField_password.getPassword()));
		user.setUserPhone(this.jTextField_phone.getText());
		user.setUserGroupId(((Integer) (this.jComboBox_userGroup.getSelectedItem())).intValue());
		userDAO.modifyById(Integer.parseInt(jTextField_id.getText()), user);
		showTableDatas();
	}
	private void deleteButtonActionPerformed(ActionEvent evt) throws NumberFormatException, SQLException, ClassNotFoundException
	{
		int[] selectedRows = this.jTable_user.getSelectedRows();
		int[] ids = new int[selectedRows.length];
		for (int i = 0; i < selectedRows.length; i++)
		{
			Vector record = this.userTableModel.getRow(this.jTable_user.convertRowIndexToModel(selectedRows[i]));
			ids[i] = Integer.parseInt((String) record.elementAt(0));
		}
		for(int id : ids)
		{
			userDAO.deleteById(id);
		}
		showTableDatas();
	}
	private void addButtonActionPerformed(ActionEvent evt) throws SQLException, ClassNotFoundException
	{
		// TODO addButton
		UserBean user = new UserBean();
		user.setUserName(this.jTextField_name.getText());
		user.setUserAddress(this.jTextField_address.getText());
		user.setUserCode(this.jTextField_postCode.getText());
		user.setUserEmail(this.jTextField_eMail.getText());
		user.setUserPassword(new String(this.jPasswordField_password.getPassword()));
		user.setUserPhone(this.jTextField_phone.getText());
		user.setUserGroupId(((Integer) (this.jComboBox_userGroup.getSelectedItem())).intValue());
		userDAO.add(user);
		showTableDatas();
//		/*UserGroup userGroup = (UserGroup) this.userGroupComBox
//				.getSelectedItem();
//		user.setUserGroup_id(userGroup.getUserGroup_id());
//
//		this.usersDAO.insertUsers(user);*/
//
	}
	private void showTableDatas() throws SQLException, ClassNotFoundException
	{
		Vector records = BeanUtil.convertUserBeansToVector(userDAO.getAll());
		this.userTableModel.showNewRows(records);
	}
}
