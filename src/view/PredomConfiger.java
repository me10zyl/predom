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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableRowSorter;

public class PredomConfiger extends JPanel
{
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private String[] userGroupColumnNames = { "编号", "名称" };
  private String[] functionColumnNames = { "编号", "名称", "说明" };

  private Class[] userGroupColumnTypes = { 
    Integer.class, String.class };

  private Class[] functionColumnTypes = { 
    Integer.class, String.class, String.class };

  boolean[] userGroupCanEdit = new boolean[2];
  boolean[] functionCanEdit = new boolean[3];

  private TableModel userGroupTableModel = null;
  private TableModel canUseTableModel = null;
  private TableModel canNotUseTableModel = null;

  //private UserGroupDAO userGroupDAO = new UserGroupDAO();
 // private PredomDAO predomDAO = new PredomDAO();
  private JScrollPane canNotUseScrollpanel;
  private JTable canNotUseTable;
  private JScrollPane canUseScrollpanel;
  private JTable canUseTable;
  private JButton configPredom;
  private JLabel logoLabel;
  private JTable userGroupTable;
  private JScrollPane usersGroupScrollpanel;

  public PredomConfiger()
  {
    try
    {
      initComponents();
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
    catch (ClassNotFoundException e)
    {
      e.printStackTrace();
    }
  }

  private void initComponents()
    throws SQLException, ClassNotFoundException
  {
    //Vector records = createUserGroupTableRecords(this.userGroupDAO.getAllUserGroup());
    //this.userGroupTableModel = new TableModel(this.userGroupColumnNames, this.userGroupColumnTypes, this.userGroupCanEdit, records);

    this.canUseTableModel = new TableModel(this.functionColumnNames, this.functionColumnTypes, this.functionCanEdit, new Vector());
    this.canNotUseTableModel = new TableModel(this.functionColumnNames, this.functionColumnTypes, this.functionCanEdit, new Vector());

    this.logoLabel = new JLabel();
    this.usersGroupScrollpanel = new JScrollPane();
    this.userGroupTable = new JTable();
    this.canNotUseScrollpanel = new JScrollPane();
    this.canNotUseTable = new JTable();
    this.canUseScrollpanel = new JScrollPane();
    this.canUseTable = new JTable();
    this.configPredom = new JButton();

    setBorder(
      BorderFactory.createLineBorder(new Color(0, 51, 204)));
    setMinimumSize(new Dimension(602, 350));
    setPreferredSize(new Dimension(602, 530));
    setLayout(new GridBagLayout());

    this.logoLabel.setIcon(
      new ImageIcon(getClass()
      .getResource("/images/predomConfiger.png")));
    GridBagConstraints gridBagConstraints = new GridBagConstraints();
    gridBagConstraints.anchor = 11;
    add(this.logoLabel, gridBagConstraints);

    this.usersGroupScrollpanel.setBorder(
      BorderFactory.createTitledBorder(
      BorderFactory.createEtchedBorder(new Color(0, 51, 255), 
      new Color(102, 102, 102)), 
      "用户组列表", 
      2, 
      0, 
      new Font("楷体_GB2312", 0, 18)));
    this.usersGroupScrollpanel
      .setPreferredSize(new Dimension(600, 150));

    this.userGroupTable.setBorder(BorderFactory.createEtchedBorder(
      new Color(51, 255, 255), Color.black));
    this.userGroupTable.setFont(new Font("宋体", 0, 11));
    this.userGroupTable.setName("viewPredom");
    //this.userGroupTable.setModel(this.userGroupTableModel);

   // TableRowSorter userGroupTableSorter = new TableRowSorter(this.userGroupTableModel);
    //userGroupTableSorter.setComparator(0, new IntegerComparator());
    //this.userGroupTable.setRowSorter(userGroupTableSorter);

    this.userGroupTable.setPreferredSize(new Dimension(600, 200));
   
    this.usersGroupScrollpanel.setViewportView(this.userGroupTable);

    gridBagConstraints = new GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 1;
    gridBagConstraints.anchor = 11;
    add(this.usersGroupScrollpanel, gridBagConstraints);

    this.canNotUseScrollpanel.setBorder(
      BorderFactory.createTitledBorder(
      BorderFactory.createEtchedBorder(new Color(0, 51, 255), 
      new Color(102, 102, 102)), 
      "不能使用的功能", 
      1, 
      0, 
      new Font("楷体_GB2312", 0, 18)));
    this.canNotUseScrollpanel.setPreferredSize(new Dimension(600, 150));

    this.canNotUseTable.setBorder(BorderFactory.createEtchedBorder(
      new Color(51, 255, 255), Color.black));
    this.canNotUseTable.setFont(new Font("宋体", 0, 11));
    this.canNotUseTable.setModel(this.canNotUseTableModel);

    TableRowSorter canNotUseTablesorter = new TableRowSorter(this.canNotUseTableModel);
   // canNotUseTablesorter.setComparator(0, new IntegerComparator());
    this.canNotUseTable.setRowSorter(canNotUseTablesorter);

    this.canNotUseTable.setPreferredSize(new Dimension(600, 300));
    this.canNotUseScrollpanel.setViewportView(this.canNotUseTable);

    gridBagConstraints = new GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 3;
    gridBagConstraints.anchor = 11;
    add(this.canNotUseScrollpanel, gridBagConstraints);

    this.canUseScrollpanel.setBorder(
      BorderFactory.createTitledBorder(
      BorderFactory.createEtchedBorder(new Color(0, 51, 255), 
      new Color(102, 102, 102)), 
      "能使用的功能", 
      1, 
      0, 
      new Font("楷体_GB2312", 0, 18)));
    this.canUseScrollpanel.setPreferredSize(new Dimension(600, 150));

    this.canUseTable.setBorder(BorderFactory.createEtchedBorder(
      new Color(51, 255, 255), Color.black));
    this.canUseTable.setFont(new Font("宋体", 0, 11));
    this.canUseTable.setModel(this.canUseTableModel);
    TableRowSorter canUseTableSorter = new TableRowSorter(this.canUseTableModel);
    //canUseTableSorter.setComparator(0, new IntegerComparator());
    this.canUseTable.setRowSorter(canUseTableSorter);

    this.canUseTable.setPreferredSize(new Dimension(600, 300));
    this.canUseScrollpanel.setViewportView(this.canUseTable);

    gridBagConstraints = new GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 2;
    gridBagConstraints.anchor = 11;
    add(this.canUseScrollpanel, gridBagConstraints);

    this.configPredom.setFont(new Font("宋体", 0, 11));
    this.configPredom.setText("配置权限");
    this.configPredom.setName("configPredom");
   
    gridBagConstraints = new GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 4;
    add(this.configPredom, gridBagConstraints);
  }

  private void configPredomActionPerformed(ActionEvent evt)
    throws NumberFormatException, SQLException, ClassNotFoundException
  {
    int selectdIdOfUserGroupTable = this.userGroupTable.getSelectedRow();
    String userGroup_idStr = (String)this.userGroupTableModel.getRow(this.userGroupTable.convertRowIndexToModel(selectdIdOfUserGroupTable)).elementAt(0);

    int[] selectdIdsOfCanUseTable = this.canUseTable.getSelectedRows();

    int[] deleteIds = new int[selectdIdsOfCanUseTable.length];
    for (int i = 0; i < selectdIdsOfCanUseTable.length; i++)
    {
      String deleteIdStr = (String)this.canUseTableModel.getRow(this.canUseTable.convertRowIndexToModel(selectdIdsOfCanUseTable[i])).elementAt(0);
      deleteIds[i] = Integer.parseInt(deleteIdStr);
    }

    int[] selectdIdsOfCanNotUseTable = this.canNotUseTable.getSelectedRows();
    int[] insertIds = new int[selectdIdsOfCanNotUseTable.length];
    for (int i = 0; i < selectdIdsOfCanNotUseTable.length; i++)
    {
      String insertIdStr = (String)this.canNotUseTableModel.getRow(this.canNotUseTable.convertRowIndexToModel(selectdIdsOfCanNotUseTable[i])).elementAt(0);
      insertIds[i] = Integer.parseInt(insertIdStr);
    }

   // this.predomDAO.configPredom(Integer.parseInt(userGroup_idStr), deleteIds, insertIds);
    userGroupTableMouseClicked(null);
  }

  private void userGroupTableMouseClicked(MouseEvent evt) throws NumberFormatException, SQLException, ClassNotFoundException {
    int selectedRow = this.userGroupTable.getSelectedRow();
    String userGroup_idStr = (String)this.userGroupTableModel.getRow(this.userGroupTable.convertRowIndexToModel(selectedRow)).elementAt(0);
    //Vector canUsedFunctions = this.predomDAO.getCanUsedFunctions(Integer.parseInt(userGroup_idStr));
    //Vector canUsedFunctionRecords = CreatTableRecordUtil.createFunctionTableRecords(canUsedFunctions);
    //this.canUseTableModel.showNewRows(canUsedFunctionRecords);

    //Vector canNotUsedFunctions = this.predomDAO.getCanNotUsedFunctions(Integer.parseInt(userGroup_idStr));
    //Vector canNotUsedFunctionRecords = CreatTableRecordUtil.createFunctionTableRecords(canNotUsedFunctions);
    //this.canNotUseTableModel.showNewRows(canNotUsedFunctionRecords);
  }

  /*private Vector<Vector<String>> createUserGroupTableRecords(Vector<UserGroup> userGroups)
  {
    Vector records = new Vector();
    for (int i = 0; i < userGroups.size(); i++)
    {
      UserGroup userGroup = (UserGroup)userGroups.get(i);
      records.add(createUserGroupTableRecord(userGroup));
    }
    return records;
  }*/

  /*private Vector<String> createUserGroupTableRecord(UserGroup userGroups)
  {
    Vector record = new Vector();
    record.add(userGroups.getUserGroup_id());
    record.add(userGroups.getUserGroup_name());
    return record;
  }*/
}