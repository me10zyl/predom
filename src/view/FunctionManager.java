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

public class FunctionManager extends JPanel {
	private String[] columnNames = { "编号", "名称", "说明" };

	private Class[] columnTypes = { Integer.class, String.class, String.class };

	boolean[] canEdit = new boolean[3];

	private TableModel tableModel = null;

	//private FunctionDAO functionDAO = new FunctionDAO();
	private JButton addButton;
	private JButton deleteButton;
	private JPanel functionInfoPanel;
	private JTable functionTable;
	private JScrollPane functionpScrollpanel;
	private JTextField idField;
	private JLabel idLabel;
	private JLabel logoLabel;
	private JButton modifyButton;
	private JTextField nameField;
	private JLabel nameLabel;
	private JTextField noteField;
	private JLabel noteLabel;

	public FunctionManager() {
		try {
			initComponents();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private void initComponents() throws SQLException, ClassNotFoundException {
		/*Vector records = CreatTableRecordUtil
				.createFunctionTableRecords(this.functionDAO.getAllFunction());
		this.tableModel = new TableModel(this.columnNames, this.columnTypes,
				this.canEdit, records);*/

		this.logoLabel = new JLabel();
		this.functionpScrollpanel = new JScrollPane();
		this.functionTable = new JTable();
		this.functionInfoPanel = new JPanel();
		this.nameLabel = new JLabel();
		this.nameField = new JTextField();
		this.idLabel = new JLabel();
		this.idField = new JTextField();
		this.addButton = new JButton();
		this.deleteButton = new JButton();
		this.modifyButton = new JButton();
		this.noteField = new JTextField();
		this.noteLabel = new JLabel();

		setBorder(BorderFactory.createLineBorder(new Color(0, 51, 204)));
		setLayout(new GridBagLayout());

		this.logoLabel.setIcon(new ImageIcon(getClass().getResource(
				"/images/functionManage.png")));
		GridBagConstraints gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.anchor = 11;
		add(this.logoLabel, gridBagConstraints);

		this.functionpScrollpanel.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createEtchedBorder(new Color(0, 51, 255),
						new Color(102, 102, 102)), "功能列表", 2, 0, new Font(
						"楷体_GB2312", 0, 18)));
		this.functionpScrollpanel.setPreferredSize(new Dimension(600, 200));

		this.functionTable.setBorder(BorderFactory.createEtchedBorder(
				new Color(51, 255, 255), Color.black));
		this.functionTable.setFont(new Font("宋体", 0, 11));
		this.functionTable.setName("viewFunction");
		//this.functionTable.setModel(this.tableModel);
		/*TableRowSorter sorter = new TableRowSorter(this.tableModel);
		sorter.setComparator(0, new IntegerComparator());
		this.functionTable.setRowSorter(sorter);*/
		this.functionTable.setPreferredSize(new Dimension(600, 200));
		this.functionTable.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				/*try {
					PredomManager.canUse(evt);
					FunctionManager.this.functionTableMouseClicked(evt);
				} catch (SQLException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (CanNotUseException e) {
					e.printStackTrace();
				}*/
			}
		});
		this.functionpScrollpanel.setViewportView(this.functionTable);

		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.anchor = 11;
		add(this.functionpScrollpanel, gridBagConstraints);

		this.functionInfoPanel.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createEtchedBorder(new Color(0, 51, 255),
						new Color(102, 102, 102)), "功能信息", 1, 0, new Font(
						"楷体_GB2312", 0, 18)));
		this.functionInfoPanel.setPreferredSize(new Dimension(600, 150));
		this.functionInfoPanel.setLayout(new GridBagLayout());

		this.nameLabel.setFont(new Font("宋体", 0, 11));
		this.nameLabel.setText("*名称：");
		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.insets = new Insets(5, 5, 5, 5);
		this.functionInfoPanel.add(this.nameLabel, gridBagConstraints);

		this.nameField.setPreferredSize(new Dimension(180, 20));
		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 2;
		gridBagConstraints.gridy = 1;
		this.functionInfoPanel.add(this.nameField, gridBagConstraints);

		this.idLabel.setFont(new Font("宋体", 0, 11));
		this.idLabel.setText("*编号：");
		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.insets = new Insets(3, 5, 5, 5);
		this.functionInfoPanel.add(this.idLabel, gridBagConstraints);

		this.idField.setEditable(false);
		this.idField.setPreferredSize(new Dimension(180, 20));
		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 2;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.insets = new Insets(2, 5, 3, 5);
		this.functionInfoPanel.add(this.idField, gridBagConstraints);

		this.addButton.setFont(new Font("宋体", 0, 11));
		this.addButton.setText("添加");
		this.addButton.setName("addFunction");
		this.addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				/*try {
					PredomManager.canUse(evt);
					FunctionManager.this.addButtonActionPerformed(evt);
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
		gridBagConstraints.gridy = 3;
		gridBagConstraints.fill = 1;
		gridBagConstraints.insets = new Insets(5, 5, 5, 5);
		this.functionInfoPanel.add(this.addButton, gridBagConstraints);

		this.deleteButton.setFont(new Font("宋体", 0, 11));
		this.deleteButton.setText("删除");
		this.deleteButton.setName("deleteFunction");
		this.deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				/*try {
					PredomManager.canUse(evt);
					FunctionManager.this.deleteButtonActionPerformed(evt);
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
		gridBagConstraints.gridy = 3;
		gridBagConstraints.insets = new Insets(5, 5, 5, 5);
		this.functionInfoPanel.add(this.deleteButton, gridBagConstraints);

		this.modifyButton.setFont(new Font("宋体", 0, 11));
		this.modifyButton.setText("修改");
		this.modifyButton.setName("modifyFunction");
		this.modifyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				/*try {
					PredomManager.canUse(evt);
					FunctionManager.this.modifyButtonActionPerformed(evt);
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
		gridBagConstraints.gridy = 3;
		gridBagConstraints.insets = new Insets(5, 5, 5, 5);
		this.functionInfoPanel.add(this.modifyButton, gridBagConstraints);

		this.noteField.setPreferredSize(new Dimension(180, 20));
		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 2;
		gridBagConstraints.gridy = 2;
		this.functionInfoPanel.add(this.noteField, gridBagConstraints);

		this.noteLabel.setFont(new Font("宋体", 0, 11));
		this.noteLabel.setText("*说明：");
		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.insets = new Insets(5, 5, 5, 5);
		this.functionInfoPanel.add(this.noteLabel, gridBagConstraints);

		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.anchor = 11;
		add(this.functionInfoPanel, gridBagConstraints);
	}

	private void functionTableMouseClicked(MouseEvent evt) {
		int selectedRow = this.functionTable.getSelectedRow();
		Vector record = this.tableModel.getRow(this.functionTable
				.convertRowIndexToModel(selectedRow));
		this.idField.setText((String) record.elementAt(0));
		this.nameField.setText((String) record.elementAt(1));
		this.noteField.setText((String) record.elementAt(2));
	}

	private void addButtonActionPerformed(ActionEvent evt) throws SQLException,
			ClassNotFoundException {
		/*Function f = new Function();
		f.setFunction_name(this.nameField.getText());
		f.setFunction_note(this.noteField.getText());

		this.functionDAO.insertFunction(f);*/

		showTableDatas();
	}

	private void deleteButtonActionPerformed(ActionEvent evt)
			throws SQLException, ClassNotFoundException {
		int[] selectedRows = this.functionTable.getSelectedRows();
		int[] ids = new int[selectedRows.length];
		for (int i = 0; i < selectedRows.length; i++) {
			Vector record = this.tableModel.getRow(this.functionTable
					.convertRowIndexToModel(selectedRows[i]));
			ids[i] = Integer.parseInt((String) record.elementAt(0));
		}

		//this.functionDAO.deleteFunctions(ids);

		showTableDatas();
	}

	private void modifyButtonActionPerformed(ActionEvent evt)
			throws SQLException, ClassNotFoundException {
		//Function f = new Function();
		/*f.setFunction_ID(Integer.parseInt(this.idField.getText()));
		f.setFunction_name(this.nameField.getText());
		f.setFunction_note(this.noteField.getText());

		this.functionDAO.updateFunction(f);*/

		showTableDatas();
	}

	private void showTableDatas() throws SQLException, ClassNotFoundException {
		/*Vector records = CreatTableRecordUtil
				.createFunctionTableRecords(this.functionDAO.getAllFunction());
		this.tableModel.showNewRows(records);*/
	}
}