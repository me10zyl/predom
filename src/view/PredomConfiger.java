package view;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
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
import javax.swing.table.TableRowSorter;
import util.BeanUtil;
import model.TableModel;
import model.db.dao.PredomDAO;
import model.db.dao.UserGroupDAO;
import model.domain.Bean;
import model.domain.PredomBean;

public class PredomConfiger extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String[] userGroupColumnNames =
	{ "编号", "名称" };
	private String[] functionColumnNames =
	{ "编号", "名称", "说明" };
	private Class[] userGroupColumnTypes =
	{ Integer.class, String.class };
	private Class[] functionColumnTypes =
	{ Integer.class, String.class, String.class };
	boolean[] userGroupCanEdit = new boolean[2];
	boolean[] functionCanEdit = new boolean[3];
	private TableModel userGroupTableModel = null;
	private TableModel canUseTableModel = null;
	private TableModel canNotUseTableModel = null;
	private UserGroupDAO userGroupDAO = new UserGroupDAO();
	private PredomDAO predomDAO = new PredomDAO();
	private JScrollPane jScrollPane_canNotUse;
	private JTable jTable_canNotUse;
	private JScrollPane jScrollPane_canUse;
	private JTable jTable_canUse;
	private JButton jButton_configPredom;
	private JLabel jLabel_logo;
	private JTable jTable_userGroup;
	private JScrollPane jScrollPane_usersGroup;

	public PredomConfiger()
	{
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
		Vector<Vector<String>> records = BeanUtil.convertUserGroupBeanToVector(userGroupDAO.getAll());
		this.userGroupTableModel = new TableModel(this.userGroupColumnNames, this.userGroupColumnTypes, this.userGroupCanEdit, records);
		this.canUseTableModel = new TableModel(this.functionColumnNames, this.functionColumnTypes, this.functionCanEdit, new Vector());
		this.canNotUseTableModel = new TableModel(this.functionColumnNames, this.functionColumnTypes, this.functionCanEdit, new Vector());
		this.jLabel_logo = new JLabel();
		this.jScrollPane_usersGroup = new JScrollPane();
		this.jTable_userGroup = new JTable();
		this.jScrollPane_canNotUse = new JScrollPane();
		this.jTable_canNotUse = new JTable();
		this.jScrollPane_canUse = new JScrollPane();
		this.jTable_canUse = new JTable();
		this.jButton_configPredom = new JButton();
		setBorder(BorderFactory.createLineBorder(new Color(0, 51, 204)));
		setMinimumSize(new Dimension(602, 350));
		setPreferredSize(new Dimension(602, 530));
		setLayout(new GridBagLayout());
		this.jLabel_logo.setIcon(new ImageIcon(getClass().getResource("/images/predomConfiger.png")));
		GridBagConstraints gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.anchor = 11;
		add(this.jLabel_logo, gridBagConstraints);
		this.jScrollPane_usersGroup.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(new Color(0, 51, 255), new Color(102, 102, 102)), "用户组列表", 2, 0, new Font("楷体_GB2312", 0, 18)));
		this.jScrollPane_usersGroup.setPreferredSize(new Dimension(600, 150));
		this.jTable_userGroup.setBorder(BorderFactory.createEtchedBorder(new Color(51, 255, 255), Color.black));
		this.jTable_userGroup.setFont(new Font("宋体", 0, 11));
		this.jTable_userGroup.setName("viewPredom");
		this.jTable_userGroup.setModel(this.userGroupTableModel);
		this.jTable_userGroup.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				try
				{
					PredomConfiger.this.userGroupTableMouseClicked(e);
				} catch (NumberFormatException e1)
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, e1.getMessage());
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
		});
		// TableRowSorter userGroupTableSorter = new
		// TableRowSorter(this.userGroupTableModel);
		// userGroupTableSorter.setComparator(0, new
		// IntegerComparator());
		// this.userGroupTable.setRowSorter(userGroupTableSorter);
		this.jScrollPane_usersGroup.setViewportView(this.jTable_userGroup);
		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.anchor = 11;
		add(this.jScrollPane_usersGroup, gridBagConstraints);
		this.jScrollPane_canNotUse.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(new Color(0, 51, 255), new Color(102, 102, 102)), "不能使用的功能", 1, 0, new Font("楷体_GB2312", 0, 18)));
		this.jScrollPane_canNotUse.setPreferredSize(new Dimension(600, 150));
		this.jTable_canNotUse.setBorder(BorderFactory.createEtchedBorder(new Color(51, 255, 255), Color.black));
		this.jTable_canNotUse.setFont(new Font("宋体", 0, 11));
		this.jTable_canNotUse.setModel(this.canNotUseTableModel);
		TableRowSorter canNotUseTablesorter = new TableRowSorter(this.canNotUseTableModel);
		// canNotUseTablesorter.setComparator(0, new
		// IntegerComparator());
		this.jTable_canNotUse.setRowSorter(canNotUseTablesorter);
		this.jScrollPane_canNotUse.setViewportView(this.jTable_canNotUse);
		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 3;
		gridBagConstraints.anchor = 11;
		add(this.jScrollPane_canNotUse, gridBagConstraints);
		this.jScrollPane_canUse.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(new Color(0, 51, 255), new Color(102, 102, 102)), "能使用的功能", 1, 0, new Font("楷体_GB2312", 0, 18)));
		this.jScrollPane_canUse.setPreferredSize(new Dimension(600, 150));
		this.jTable_canUse.setBorder(BorderFactory.createEtchedBorder(new Color(51, 255, 255), Color.black));
		this.jTable_canUse.setFont(new Font("宋体", 0, 11));
		this.jTable_canUse.setModel(this.canUseTableModel);
		TableRowSorter canUseTableSorter = new TableRowSorter(this.canUseTableModel);
		// canUseTableSorter.setComparator(0, new IntegerComparator());
		this.jTable_canUse.setRowSorter(canUseTableSorter);
		this.jScrollPane_canUse.setViewportView(this.jTable_canUse);
		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.anchor = 11;
		add(this.jScrollPane_canUse, gridBagConstraints);
		this.jButton_configPredom.setFont(new Font("宋体", 0, 11));
		this.jButton_configPredom.setText("配置权限");
		this.jButton_configPredom.setName("configPredom");
		this.jButton_configPredom.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					PredomConfiger.this.configPredomActionPerformed(e);
				} catch (NumberFormatException e1)
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, e1.getMessage());
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
		});
		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 4;
		add(this.jButton_configPredom, gridBagConstraints);
	}
	private void configPredomActionPerformed(ActionEvent evt) throws NumberFormatException, SQLException, ClassNotFoundException
	{
		int selectdIdOfUserGroupTable = this.jTable_userGroup.getSelectedRow();
		String userGroup_idStr = (String) this.userGroupTableModel.getRow(this.jTable_userGroup.convertRowIndexToModel(selectdIdOfUserGroupTable)).elementAt(0);
		int[] selectRows_CanUseTable = this.jTable_canUse.getSelectedRows();
		int[] deleteIds = new int[selectRows_CanUseTable.length];// 要删除的function_id
		// 获得可用表中选中的行的function_id;
		for (int i = 0; i < selectRows_CanUseTable.length; i++)
		{
			String deleteIdStr = (String) this.canUseTableModel.getRow(this.jTable_canUse.convertRowIndexToModel(selectRows_CanUseTable[i])).elementAt(0);
			deleteIds[i] = Integer.parseInt(deleteIdStr);
		}
		int[] selectRows_CanNotUseTable = this.jTable_canNotUse.getSelectedRows();
		int[] insertIds = new int[selectRows_CanNotUseTable.length];// 要插入的function_id
		// 获得不可用表中选中的行的function_id;
		for (int i = 0; i < selectRows_CanNotUseTable.length; i++)
		{
			String insertIdStr = (String) this.canNotUseTableModel.getRow(this.jTable_canNotUse.convertRowIndexToModel(selectRows_CanNotUseTable[i])).elementAt(0);
			insertIds[i] = Integer.parseInt(insertIdStr);
		}
		for (int id : deleteIds)
		{
			this.predomDAO.deleteByUserGroupIdAndFunctionId(Integer.parseInt(userGroup_idStr), id);
		}
		for (int id : insertIds)
		{
			PredomBean predomBean = new PredomBean();
			predomBean.setUserGroupId(Integer.parseInt(userGroup_idStr));
			predomBean.setFunctionId(id);
			this.predomDAO.add(predomBean);
		}
		// this.predomDAO.configPredom(Integer.parseInt(userGroup_idStr),
		// deleteIds, insertIds);
		userGroupTableMouseClicked(null);
	}
	private void userGroupTableMouseClicked(MouseEvent evt) throws NumberFormatException, SQLException, ClassNotFoundException
	{
		int selectedRow = this.jTable_userGroup.getSelectedRow();
		String userGroupId = (String) this.userGroupTableModel.getRow(this.jTable_userGroup.convertRowIndexToModel(selectedRow)).elementAt(0);
		Vector<Bean> functionsBeans = this.predomDAO.getFunctionsBeansByUserGroupId(Integer.parseInt(userGroupId));
		canUseTableModel.showNewRows(BeanUtil.convertFunctionsBeansToVector(functionsBeans));
		Vector<Bean> otherFunctionsBeans = this.predomDAO.getOtherFunctionsBeansByUserGroupId(Integer.parseInt(userGroupId));
		canNotUseTableModel.showNewRows(BeanUtil.convertFunctionsBeansToVector(otherFunctionsBeans));
		// Vector canUsedFunctions =
		// this.predomDAO.getCanUsedFunctions(Integer.parseInt(userGroup_idStr));
		// Vector canUsedFunctionRecords =
		// CreatTableRecordUtil.createFunctionTableRecords(canUsedFunctions);
		// this.canUseTableModel.showNewRows(canUsedFunctionRecords);
		// Vector canNotUsedFunctions =
		// this.predomDAO.getCanNotUsedFunctions(Integer.parseInt(userGroup_idStr));
		// Vector canNotUsedFunctionRecords =
		// CreatTableRecordUtil.createFunctionTableRecords(canNotUsedFunctions);
		// this.canNotUseTableModel.showNewRows(canNotUsedFunctionRecords);
	}
	/*
	 * private Vector<Vector<String>>
	 * createUserGroupTableRecords(Vector<UserGroup> userGroups) { Vector
	 * records = new Vector(); for (int i = 0; i < userGroups.size(); i++) {
	 * UserGroup userGroup = (UserGroup)userGroups.get(i);
	 * records.add(createUserGroupTableRecord(userGroup)); } return records;
	 * }
	 */
	/*
	 * private Vector<String> createUserGroupTableRecord(UserGroup
	 * userGroups) { Vector record = new Vector();
	 * record.add(userGroups.getUserGroup_id());
	 * record.add(userGroups.getUserGroup_name()); return record; }
	 */
}