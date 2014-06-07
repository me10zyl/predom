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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableRowSorter;

public class UserGroupManager extends JPanel {
	private String[] userColumnNames;
	private String[] userGroupColumnNames;
	private Class[] userColumnTypes;
	private Class[] userGroupColumnTypes;
	boolean[] userCanEdit;
	boolean[] userGroupCanEdit;
	private TableModel userGroupTableModel;
	private TableModel userTableModel;
	//private UsersDAO usersDAO;
	//private UserGroupDAO userGroupDAO;
	private JButton addButton;
	private JButton deleteButton;
	private JTextField idField;
	private JLabel idLabel;
	private JLabel logoLabel;
	private JButton modifyButton;
	private JTextField nameField;
	private JLabel nameLabel;
	private JPanel userGroupInfoPanel;
	private JTable userGroupTable;
	private JTable userTable;
	private JScrollPane usersGroupScrollpanel;
	private JScrollPane usersScrollpanel;

	public UserGroupManager() {
		this.userColumnNames = new String[] { "编号", "姓名", "地址", "邮编", "eMail",
				"密码", "电话", "用户组" };
		this.userGroupColumnNames = new String[] { "编号", "名称" };
		this.userColumnTypes = new Class[] { Integer.class, String.class,
				String.class, String.class, String.class, String.class,
				String.class, Integer.class };
		this.userGroupColumnTypes = new Class[] { Integer.class, String.class };
		this.userCanEdit = new boolean[8];
		this.userGroupCanEdit = new boolean[2];
		this.userGroupTableModel = null;
		this.userTableModel = null;
		/*this.usersDAO = new UsersDAO();
		this.userGroupDAO = new UserGroupDAO();
		try {
			initComponents();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}*/
	}

	private void initComponents() throws SQLException, ClassNotFoundException {
		/*Vector records = CreatTableRecordUtil
				.createUserGroupTableRecords(this.userGroupDAO
						.getAllUserGroup());
		this.userGroupTableModel = new TableModel(this.userGroupColumnNames,
				this.userGroupColumnTypes, this.userGroupCanEdit, records);

		this.userTableModel = new TableModel(this.userColumnNames,
				this.userColumnTypes, this.userCanEdit, new Vector());*/

		this.logoLabel = new JLabel();
		this.usersGroupScrollpanel = new JScrollPane();
		this.userGroupTable = new JTable();
		this.userGroupInfoPanel = new JPanel();
		this.nameLabel = new JLabel();
		this.nameField = new JTextField();
		this.idLabel = new JLabel();
		this.idField = new JTextField();
		this.addButton = new JButton();
		this.deleteButton = new JButton();
		this.modifyButton = new JButton();
		this.usersScrollpanel = new JScrollPane();
		this.userTable = new JTable();

		setBorder(BorderFactory.createLineBorder(new Color(0, 51, 204)));
		setMinimumSize(new Dimension(602, 200));
		setPreferredSize(new Dimension(602, 492));
		setLayout(new GridBagLayout());

		this.logoLabel.setIcon(new ImageIcon(getClass().getResource(
				"/images/userGroupManage.png")));
		GridBagConstraints gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.anchor = 11;
		add(this.logoLabel, gridBagConstraints);

		this.usersGroupScrollpanel.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createEtchedBorder(new Color(0, 51, 255),
						new Color(102, 102, 102)), "用户组列表", 2, 0, new Font(
						"楷体_GB2312", 0, 18)));
		this.usersGroupScrollpanel.setPreferredSize(new Dimension(600, 150));

		this.userGroupTable.setBorder(BorderFactory.createEtchedBorder(
				new Color(51, 255, 255), Color.black));
		this.userGroupTable.setFont(new Font("宋体", 0, 11));
		this.userGroupTable.setName("viewUserGroup");
		this.userGroupTable.setModel(this.userGroupTableModel);
		/*TableRowSorter userGroupTableSorter = new TableRowSorter(
				this.userGroupTableModel);
		userGroupTableSorter.setComparator(0, new IntegerComparator());
		this.userGroupTable.setRowSorter(userGroupTableSorter);*/
		this.userGroupTable.setPreferredSize(new Dimension(600, 200));
		this.userGroupTable.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				/*try {
					PredomManager.canUse(evt);
					UserGroupManager.this.userGroupTableMouseClicked(evt);
				} catch (SQLException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (CanNotUseException e) {
					e.printStackTrace();
				}*/
			}
		});
		this.usersGroupScrollpanel.setViewportView(this.userGroupTable);

		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.anchor = 11;
		add(this.usersGroupScrollpanel, gridBagConstraints);

		this.userGroupInfoPanel.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createEtchedBorder(new Color(0, 51, 255),
						new Color(102, 102, 102)), "用户组信息", 1, 0, new Font(
						"楷体_GB2312", 0, 18)));
		this.userGroupInfoPanel.setPreferredSize(new Dimension(600, 150));
		this.userGroupInfoPanel.setLayout(new GridBagLayout());

		this.nameLabel.setFont(new Font("宋体", 0, 11));
		this.nameLabel.setText("*名称：");
		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.insets = new Insets(5, 5, 5, 5);
		this.userGroupInfoPanel.add(this.nameLabel, gridBagConstraints);

		this.nameField.setPreferredSize(new Dimension(180, 20));
		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 2;
		gridBagConstraints.gridy = 1;
		this.userGroupInfoPanel.add(this.nameField, gridBagConstraints);

		this.idLabel.setFont(new Font("宋体", 0, 11));
		this.idLabel.setText("*编号：");
		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.insets = new Insets(3, 5, 5, 5);
		this.userGroupInfoPanel.add(this.idLabel, gridBagConstraints);

		this.idField.setEditable(false);
		this.idField.setPreferredSize(new Dimension(180, 20));
		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 2;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.insets = new Insets(2, 5, 3, 5);
		this.userGroupInfoPanel.add(this.idField, gridBagConstraints);

		this.addButton.setFont(new Font("宋体", 0, 11));
		this.addButton.setText("添加");
		this.addButton.setName("addUserGroup");
		this.addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				/*try {
					PredomManager.canUse(evt);
					UserGroupManager.this.addButtonActionPerformed(evt);
				} catch (SQLException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (CanNotUseException e) {
					e.printStackTrace();
				}*/
			}
		});
		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 8;
		gridBagConstraints.fill = 1;
		gridBagConstraints.insets = new Insets(5, 5, 5, 5);
		this.userGroupInfoPanel.add(this.addButton, gridBagConstraints);

		this.deleteButton.setFont(new Font("宋体", 0, 11));
		this.deleteButton.setText("删除");
		this.deleteButton.setName("deleteUserGroup");
		this.deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				/*try {
					PredomManager.canUse(evt);
					UserGroupManager.this.deleteButtonActionPerformed(evt);
				} catch (SQLException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (CanNotUseException e) {
					e.printStackTrace();
				}*/
			}
		});
		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 3;
		gridBagConstraints.gridy = 8;
		gridBagConstraints.insets = new Insets(5, 5, 5, 5);
		this.userGroupInfoPanel.add(this.deleteButton, gridBagConstraints);

		this.modifyButton.setFont(new Font("宋体", 0, 11));
		this.modifyButton.setText("修改");
		this.modifyButton.setName("modifyUserGroup");
		this.modifyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				/*try {
					PredomManager.canUse(evt);
					UserGroupManager.this.modifyButtonActionPerformed(evt);
				} catch (SQLException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (CanNotUseException e) {
					e.printStackTrace();
				}*/
			}
		});
		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 2;
		gridBagConstraints.gridy = 8;
		this.userGroupInfoPanel.add(this.modifyButton, gridBagConstraints);

		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 3;
		gridBagConstraints.anchor = 11;
		add(this.userGroupInfoPanel, gridBagConstraints);

		this.usersScrollpanel.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createEtchedBorder(new Color(0, 51, 255),
						new Color(102, 102, 102)), "用户组列表", 2, 0, new Font(
						"楷体_GB2312", 0, 18)));
		this.usersScrollpanel.setPreferredSize(new Dimension(600, 150));

		this.userTable.setBorder(BorderFactory.createEtchedBorder(new Color(51,
				255, 255), Color.black));
		this.userTable.setFont(new Font("宋体", 0, 11));
		this.userTable.setModel(this.userTableModel);
		/*TableRowSorter userTableSorter = new TableRowSorter(this.userTableModel);
		userTableSorter.setComparator(0, new IntegerComparator());
		userTableSorter.setComparator(this.userColumnNames.length - 1,
				new IntegerComparator());
		this.userTable.setRowSorter(userTableSorter);*/
		this.userTable.setPreferredSize(new Dimension(600, 300));

		this.usersScrollpanel.setViewportView(this.userTable);

		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.anchor = 11;
		add(this.usersScrollpanel, gridBagConstraints);
	}

	private void userGroupTableMouseClicked(MouseEvent evt)
			throws SQLException, ClassNotFoundException {
		int selectRow = this.userGroupTable.getSelectedRow();
	/*	Vector record = this.userGroupTableModel.getRow(this.userGroupTable
				.convertRowIndexToModel(selectRow));

		this.idField.setText((String) record.elementAt(0));
		this.nameField.setText((String) record.elementAt(1));

		Vector users = this.userGroupDAO.getUsersByUserGroupID(Integer
				.parseInt((String) record.elementAt(0)));
		Vector userRecords = CreatTableRecordUtil.createUserTableRecords(users);
		this.userTableModel.showNewRows(userRecords);*/
	}

	private void addButtonActionPerformed(ActionEvent evt) throws SQLException,
			ClassNotFoundException {
		/*UserGroup userGroup = new UserGroup();
		userGroup.setUserGroup_name(this.nameField.getText());

		this.userGroupDAO.insertUserGroup(userGroup);*/

		showTableDatas();
	}

	private void deleteButtonActionPerformed(ActionEvent evt)
			throws SQLException, ClassNotFoundException {
		int[] selectedRows = this.userGroupTable.getSelectedRows();
		int[] ids = new int[selectedRows.length];
		/*for (int i = 0; i < selectedRows.length; i++) {
			Vector record = this.userGroupTableModel.getRow(this.userGroupTable
					.convertRowIndexToModel(selectedRows[i]));
			ids[i] = Integer.parseInt((String) record.elementAt(0));
		}

		this.userGroupDAO.deleteUserGroups(ids);*/

		showTableDatas();
	}

	private void modifyButtonActionPerformed(ActionEvent evt)
			throws SQLException, ClassNotFoundException {
		/*UserGroup userGroup = new UserGroup();
		userGroup.setUserGroup_name(this.nameField.getText());
		userGroup.setUserGroup_id(Integer.parseInt(this.idField.getText()));

		this.userGroupDAO.updateUserGroup(userGroup);*/

		showTableDatas();
	}

	private void showTableDatas() throws SQLException, ClassNotFoundException {
		/*Vector records = CreatTableRecordUtil
				.createUserGroupTableRecords(this.userGroupDAO
						.getAllUserGroup());
		this.userGroupTableModel.showNewRows(records);*/
	}
}
