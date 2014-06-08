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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
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

public class UserGroupManager extends JPanel
{
	private String[] userColumnNames;
	private String[] userGroupColumnNames;
	private Class[] userColumnTypes;
	private Class[] userGroupColumnTypes;
	boolean[] userCanEdit;
	boolean[] userGroupCanEdit;
	private TableModel userGroupTableModel;
	private TableModel userTableModel;
	private UserDAO userDAO;
	private UserGroupDAO userGroupDAO;
	private JButton jButton_add;
	private JButton jButton_delete;
	private JTextField jTextField_id;
	private JLabel jLabel_id;
	private JLabel jLabel_logo;
	private JButton jButton_modify;
	private JTextField jTextField_name;
	private JLabel jLabel_name;
	private JPanel jPanel_serGroupInfo;
	private JTable jTable_userGroup;
	private JTable jTable_user;
	private JScrollPane jScrollPane_usersGroup;
	private JScrollPane jScrollPane_users;

	public UserGroupManager()
	{
		this.userColumnNames = new String[]
		{ "编号", "用户组", "姓名", "地址", "邮编", "eMail", "密码", "电话" };
		this.userGroupColumnNames = new String[]
		{ "编号", "名称" };
		this.userColumnTypes = new Class[]
		{ Integer.class, String.class, String.class, String.class, String.class, String.class, String.class, Integer.class };
		this.userGroupColumnTypes = new Class[]
		{ Integer.class, String.class };
		this.userCanEdit = new boolean[8];
		this.userGroupCanEdit = new boolean[2];
		this.userGroupTableModel = null;
		this.userTableModel = null;
		this.userDAO = new UserDAO();
		this.userGroupDAO = new UserGroupDAO();
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
		 * .createUserGroupTableRecords(this.userGroupDAO
		 * .getAllUserGroup()); this.userGroupTableModel = new
		 * TableModel(this.userGroupColumnNames,
		 * this.userGroupColumnTypes, this.userGroupCanEdit, records);
		 * 
		 * this.userTableModel = new TableModel(this.userColumnNames,
		 * this.userColumnTypes, this.userCanEdit, new Vector());
		 */
		this.jLabel_logo = new JLabel();
		this.jScrollPane_usersGroup = new JScrollPane();
		this.jTable_userGroup = new JTable();
		this.jPanel_serGroupInfo = new JPanel();
		this.jLabel_name = new JLabel();
		this.jTextField_name = new JTextField();
		this.jLabel_id = new JLabel();
		this.jTextField_id = new JTextField();
		this.jButton_add = new JButton();
		this.jButton_delete = new JButton();
		this.jButton_modify = new JButton();
		this.jScrollPane_users = new JScrollPane();
		this.jTable_user = new JTable();
		setBorder(BorderFactory.createLineBorder(new Color(0, 51, 204)));
		setMinimumSize(new Dimension(602, 200));
		setPreferredSize(new Dimension(602, 492));
		setLayout(new GridBagLayout());
		this.jLabel_logo.setIcon(new ImageIcon(getClass().getResource("/images/userGroupManage.png")));
		GridBagConstraints gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.anchor = 11;
		add(this.jLabel_logo, gridBagConstraints);
		this.jScrollPane_usersGroup.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(new Color(0, 51, 255), new Color(102, 102, 102)), "用户组列表", 2, 0, new Font("楷体_GB2312", 0, 18)));
		this.jScrollPane_usersGroup.setPreferredSize(new Dimension(600, 150));
		this.jTable_userGroup.setBorder(BorderFactory.createEtchedBorder(new Color(51, 255, 255), Color.black));
		this.jTable_userGroup.setFont(new Font("宋体", 0, 11));
		this.jTable_userGroup.setName("viewUserGroup");
		Vector<Vector<String>> tableDataList = BeanUtil.convertUserGroupBeanToVector(userGroupDAO.getAll());
		userGroupTableModel = new TableModel(userGroupColumnNames, userGroupColumnTypes, userGroupCanEdit, tableDataList);
		this.jTable_userGroup.setModel(this.userGroupTableModel);
		/*
		 * TableRowSorter userGroupTableSorter = new TableRowSorter(
		 * this.userGroupTableModel);
		 * userGroupTableSorter.setComparator(0, new
		 * IntegerComparator());
		 * this.userGroupTable.setRowSorter(userGroupTableSorter);
		 */
		// this.jTable_userGroup.setPreferredSize(new Dimension(600,
		// 200));
		this.jTable_userGroup.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent evt)
			{
				/*
				 * try { PredomManager.canUse(evt);
				 * UserGroupManager
				 * .this.userGroupTableMouseClicked(evt); }
				 * catch (SQLException e) { e.printStackTrace();
				 * } catch (ClassNotFoundException e) {
				 * e.printStackTrace(); } catch
				 * (CanNotUseException e) { e.printStackTrace();
				 * }
				 */
				try
				{
					UserGroupManager.this.userGroupTableMouseClicked(evt);
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
						userGroupDAO.release();
						userGroupDAO.release();
					} catch (SQLException e)
					{
						// TODO Auto-generated catch
						// block
						e.printStackTrace();
					}
				}
			}
		});
		this.jScrollPane_usersGroup.setViewportView(this.jTable_userGroup);
		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.anchor = 11;
		add(this.jScrollPane_usersGroup, gridBagConstraints);
		this.jPanel_serGroupInfo.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(new Color(0, 51, 255), new Color(102, 102, 102)), "用户组信息", 1, 0, new Font("楷体_GB2312", 0, 18)));
		this.jPanel_serGroupInfo.setPreferredSize(new Dimension(600, 150));
		this.jPanel_serGroupInfo.setLayout(new GridBagLayout());
		this.jLabel_name.setFont(new Font("宋体", 0, 11));
		this.jLabel_name.setText("*名称：");
		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.insets = new Insets(5, 5, 5, 5);
		this.jPanel_serGroupInfo.add(this.jLabel_name, gridBagConstraints);
		this.jTextField_name.setPreferredSize(new Dimension(180, 20));
		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 2;
		gridBagConstraints.gridy = 1;
		this.jPanel_serGroupInfo.add(this.jTextField_name, gridBagConstraints);
		this.jLabel_id.setFont(new Font("宋体", 0, 11));
		this.jLabel_id.setText("*编号：");
		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.insets = new Insets(3, 5, 5, 5);
		this.jPanel_serGroupInfo.add(this.jLabel_id, gridBagConstraints);
		this.jTextField_id.setEditable(false);
		this.jTextField_id.setPreferredSize(new Dimension(180, 20));
		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 2;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.insets = new Insets(2, 5, 3, 5);
		this.jPanel_serGroupInfo.add(this.jTextField_id, gridBagConstraints);
		this.jButton_add.setFont(new Font("宋体", 0, 11));
		this.jButton_add.setText("添加");
		this.jButton_add.setName("addUserGroup");
		this.jButton_add.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent evt)
			{
				/*
				 * try { PredomManager.canUse(evt);
				 * UserGroupManager
				 * .this.addButtonActionPerformed(evt); } catch
				 * (SQLException e) { e.printStackTrace(); }
				 * catch (ClassNotFoundException e) {
				 * e.printStackTrace(); } catch
				 * (CanNotUseException e) { e.printStackTrace();
				 * }
				 */
				try
				{
					UserGroupManager.this.addButtonActionPerformed(evt);
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
						userGroupDAO.release();
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
		this.jPanel_serGroupInfo.add(this.jButton_add, gridBagConstraints);
		this.jButton_delete.setFont(new Font("宋体", 0, 11));
		this.jButton_delete.setText("删除");
		this.jButton_delete.setName("deleteUserGroup");
		this.jButton_delete.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent evt)
			{
				/*
				 * try { PredomManager.canUse(evt);
				 * UserGroupManager
				 * .this.deleteButtonActionPerformed(evt); }
				 * catch (SQLException e) { e.printStackTrace();
				 * } catch (ClassNotFoundException e) {
				 * e.printStackTrace(); } catch
				 * (CanNotUseException e) { e.printStackTrace();
				 * }
				 */
				try
				{
					UserGroupManager.this.deleteButtonActionPerformed(evt);
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
						userGroupDAO.release();
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
		gridBagConstraints.gridx = 3;
		gridBagConstraints.gridy = 8;
		gridBagConstraints.insets = new Insets(5, 5, 5, 5);
		this.jPanel_serGroupInfo.add(this.jButton_delete, gridBagConstraints);
		this.jButton_modify.setFont(new Font("宋体", 0, 11));
		this.jButton_modify.setText("修改");
		this.jButton_modify.setName("modifyUserGroup");
		this.jButton_modify.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent evt)
			{
				/*
				 * try { PredomManager.canUse(evt);
				 * UserGroupManager
				 * .this.modifyButtonActionPerformed(evt); }
				 * catch (SQLException e) { e.printStackTrace();
				 * } catch (ClassNotFoundException e) {
				 * e.printStackTrace(); } catch
				 * (CanNotUseException e) { e.printStackTrace();
				 * }
				 */
				try
				{
					UserGroupManager.this.modifyButtonActionPerformed(evt);
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
						userGroupDAO.release();
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
		this.jPanel_serGroupInfo.add(this.jButton_modify, gridBagConstraints);
		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 3;
		gridBagConstraints.anchor = 11;
		add(this.jPanel_serGroupInfo, gridBagConstraints);
		this.jScrollPane_users.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(new Color(0, 51, 255), new Color(102, 102, 102)), "用户组列表", 2, 0, new Font("楷体_GB2312", 0, 18)));
		this.jScrollPane_users.setPreferredSize(new Dimension(600, 150));
		this.jTable_user.setBorder(BorderFactory.createEtchedBorder(new Color(51, 255, 255), Color.black));
		this.jTable_user.setFont(new Font("宋体", 0, 11));
		Vector<Vector<String>> userTableDataLis2t = new Vector<Vector<String>>();
		userTableModel = new TableModel(userColumnNames, userColumnTypes, userCanEdit, userTableDataLis2t);
		this.jTable_user.setModel(this.userTableModel);
		/*
		 * TableRowSorter userTableSorter = new
		 * TableRowSorter(this.userTableModel);
		 * userTableSorter.setComparator(0, new IntegerComparator());
		 * userTableSorter.setComparator(this.userColumnNames.length -
		 * 1, new IntegerComparator());
		 * this.userTable.setRowSorter(userTableSorter);
		 */
//		this.jTable_user.setPreferredSize(new Dimension(600, 300));
		this.jScrollPane_users.setViewportView(this.jTable_user);
		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.anchor = 11;
		add(this.jScrollPane_users, gridBagConstraints);
	}
	private void userGroupTableMouseClicked(MouseEvent evt) throws SQLException, ClassNotFoundException
	{
		int selectRow = this.jTable_userGroup.getSelectedRow();
		Vector record = this.userGroupTableModel.getRow(this.jTable_userGroup.convertRowIndexToModel(selectRow));
		this.jTextField_id.setText((String) record.elementAt(0));
		this.jTextField_name.setText((String) record.elementAt(1));
		Vector<Bean> beans = this.userGroupDAO.getUserBeansByUserGroupId(((Integer.parseInt((String) record.elementAt(0)))));
		Vector<Vector<String>> userRecords = BeanUtil.convertUserBeansToVector(beans);
		this.userTableModel.showNewRows(userRecords);
	}
	private void addButtonActionPerformed(ActionEvent evt) throws SQLException, ClassNotFoundException
	{
		
		 UserGroupBean userGroupBean = new UserGroupBean();
		 userGroupBean.setUserGroupName(this.jTextField_name.getText());
		 this.userGroupDAO.add(userGroupBean);
		showTableDatas();
	}
	private void deleteButtonActionPerformed(ActionEvent evt) throws SQLException, ClassNotFoundException
	{
		int[] selectedRows = this.jTable_userGroup.getSelectedRows();
		int[] ids = new int[selectedRows.length];
		for (int i = 0; i < selectedRows.length; i++)
		{
			Vector record = this.userGroupTableModel.getRow(this.jTable_userGroup.convertRowIndexToModel(selectedRows[i]));
			ids[i] = Integer.parseInt((String) record.elementAt(0));
		}
		for (int id : ids)
			this.userGroupDAO.deleteById(id);
		showTableDatas();
	}
	private void modifyButtonActionPerformed(ActionEvent evt) throws SQLException, ClassNotFoundException
	{
		UserGroupBean userGroupBean = new UserGroupBean();
		userGroupBean.setUserGroupName(this.jTextField_name.getText());
		this.userGroupDAO.modifyById(Integer.parseInt(this.jTextField_id.getText()), userGroupBean);
		showTableDatas();
	}
	private void showTableDatas() throws SQLException, ClassNotFoundException
	{
		Vector records = BeanUtil.convertUserGroupBeanToVector(userGroupDAO.getAll());
		this.userGroupTableModel.showNewRows(records);
	}
}
