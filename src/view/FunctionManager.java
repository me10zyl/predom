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
import model.db.dao.FuntionsDAO;
import model.domain.FunctionsBean;
import util.BeanUtil;

public class FunctionManager extends JPanel
{
	private String[] columnNames =
	{ "编号", "名称", "说明" };
	private Class[] columnClasses =
	{ Integer.class, String.class, String.class };
	boolean[] canEdit = new boolean[3];
	private FuntionsDAO functionDAO = new FuntionsDAO();
	private TableModel funtionModel = null;
	// private FunctionDAO functionDAO = new FunctionDAO();
	private JButton jButton_add;
	private JButton jButton_delete;
	private JPanel jPanel_functionInfo;
	private JTable jTable_function;
	private JScrollPane jScrollPane_functionp;
	private JTextField jTextField_id;
	private JLabel jLabel_id;
	private JLabel jLabel_logo;
	private JButton jButton_modify;
	private JTextField jTextField_name;
	private JLabel jLabel_name;
	private JTextField jTextField_note;
	private JLabel jLabel_note;

	public FunctionManager()
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
		/*
		 * Vector records = CreatTableRecordUtil
		 * .createFunctionTableRecords
		 * (this.functionDAO.getAllFunction()); this.tableModel = new
		 * TableModel(this.columnNames, this.columnTypes, this.canEdit,
		 * records);
		 */
		this.jLabel_logo = new JLabel();
		this.jScrollPane_functionp = new JScrollPane();
		this.jTable_function = new JTable();
		this.jPanel_functionInfo = new JPanel();
		this.jLabel_name = new JLabel();
		this.jTextField_name = new JTextField();
		this.jLabel_id = new JLabel();
		this.jTextField_id = new JTextField();
		this.jButton_add = new JButton();
		this.jButton_delete = new JButton();
		this.jButton_modify = new JButton();
		this.jTextField_note = new JTextField();
		this.jLabel_note = new JLabel();
		setBorder(BorderFactory.createLineBorder(new Color(0, 51, 204)));
		setLayout(new GridBagLayout());
		this.jLabel_logo.setIcon(new ImageIcon(getClass().getResource("/images/functionManage.png")));
		GridBagConstraints gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.anchor = 11;
		add(this.jLabel_logo, gridBagConstraints);
		this.jScrollPane_functionp.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(new Color(0, 51, 255), new Color(102, 102, 102)), "功能列表", 2, 0, new Font("楷体_GB2312", 0, 18)));
		this.jScrollPane_functionp.setPreferredSize(new Dimension(600, 200));
		this.jTable_function.setBorder(BorderFactory.createEtchedBorder(new Color(51, 255, 255), Color.black));
		this.jTable_function.setFont(new Font("宋体", 0, 11));
		this.jTable_function.setName("viewFunction");
		Vector<Vector<String>> tableDataList = BeanUtil.convertFunctionsBeansToVector(functionDAO.getAll());
		funtionModel = new TableModel(columnNames, columnClasses, canEdit, tableDataList);
		jTable_function.setModel(funtionModel);
		/*
		 * TableRowSorter sorter = new TableRowSorter(this.tableModel);
		 * sorter.setComparator(0, new IntegerComparator());
		 * this.functionTable.setRowSorter(sorter);
		 */
//		this.jTable_function.setPreferredSize(new Dimension(600, 400));
		this.jTable_function.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent evt)
			{
//				try {
//					PredomManager.canUse(evt);
//					FunctionManager.this.functionTableMouseClicked(evt);
//				} catch (SQLException e) {
//					e.printStackTrace();
//				} catch (ClassNotFoundException e) {
//					e.printStackTrace();
//				} catch (CanNotUseException e) {
//					e.printStackTrace();
//				}
				FunctionManager.this.functionTableMouseClicked(evt);
			}
		});
		this.jScrollPane_functionp.setViewportView(this.jTable_function);
		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.anchor = 11;
		add(this.jScrollPane_functionp, gridBagConstraints);
		this.jPanel_functionInfo.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(new Color(0, 51, 255), new Color(102, 102, 102)), "功能信息", 1, 0, new Font("楷体_GB2312", 0, 18)));
		this.jPanel_functionInfo.setPreferredSize(new Dimension(600, 150));
		this.jPanel_functionInfo.setLayout(new GridBagLayout());
		this.jLabel_name.setFont(new Font("宋体", 0, 11));
		this.jLabel_name.setText("*名称：");
		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.insets = new Insets(5, 5, 5, 5);
		this.jPanel_functionInfo.add(this.jLabel_name, gridBagConstraints);
		this.jTextField_name.setPreferredSize(new Dimension(180, 20));
		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 2;
		gridBagConstraints.gridy = 1;
		this.jPanel_functionInfo.add(this.jTextField_name, gridBagConstraints);
		this.jLabel_id.setFont(new Font("宋体", 0, 11));
		this.jLabel_id.setText("*编号：");
		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.insets = new Insets(3, 5, 5, 5);
		this.jPanel_functionInfo.add(this.jLabel_id, gridBagConstraints);
		this.jTextField_id.setEditable(false);
		this.jTextField_id.setPreferredSize(new Dimension(180, 20));
		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 2;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.insets = new Insets(2, 5, 3, 5);
		this.jPanel_functionInfo.add(this.jTextField_id, gridBagConstraints);
		this.jButton_add.setFont(new Font("宋体", 0, 11));
		this.jButton_add.setText("添加");
		this.jButton_add.setName("addFunction");
		this.jButton_add.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent evt)
			{
				/*
				 * try { PredomManager.canUse(evt);
				 * FunctionManager
				 * .this.addButtonActionPerformed(evt); } catch
				 * (SQLException e) { e.printStackTrace(); }
				 * catch (ClassNotFoundException e) {
				 * e.printStackTrace(); } catch
				 * (CanNotUseException e) { e.printStackTrace();
				 * }
				 */
				try
				{
					FunctionManager.this.addButtonActionPerformed(evt);
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
						functionDAO.release();
					} catch (SQLException e)
					{
						// TODO Auto-generated catch
						// block
						e.printStackTrace();
						JOptionPane.showMessageDialog(null, e.getMessage());
					}
				}
			}
		});
		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 3;
		gridBagConstraints.fill = 1;
		gridBagConstraints.insets = new Insets(5, 5, 5, 5);
		this.jPanel_functionInfo.add(this.jButton_add, gridBagConstraints);
		this.jButton_delete.setFont(new Font("宋体", 0, 11));
		this.jButton_delete.setText("删除");
		this.jButton_delete.setName("deleteFunction");
		this.jButton_delete.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent evt)
			{
				/*
				 * try { PredomManager.canUse(evt);
				 * FunctionManager
				 * .this.deleteButtonActionPerformed(evt); }
				 * catch (SQLException e) { e.printStackTrace();
				 * } catch (ClassNotFoundException e) {
				 * e.printStackTrace(); } catch
				 * (CanNotUseException e) { e.printStackTrace();
				 * }
				 */
				try
				{
					FunctionManager.this.deleteButtonActionPerformed(evt);
				} catch (SQLException e)
				{
					JOptionPane.showMessageDialog(null, e.getMessage());
					e.printStackTrace();
				} catch (ClassNotFoundException e)
				{
					JOptionPane.showMessageDialog(null, e.getMessage());
					e.printStackTrace();
				} finally
				{
					try
					{
						functionDAO.release();
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
		gridBagConstraints.gridy = 3;
		gridBagConstraints.insets = new Insets(5, 5, 5, 5);
		this.jPanel_functionInfo.add(this.jButton_delete, gridBagConstraints);
		this.jButton_modify.setFont(new Font("宋体", 0, 11));
		this.jButton_modify.setText("修改");
		this.jButton_modify.setName("modifyFunction");
		this.jButton_modify.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent evt)
			{
				/*
				 * try { PredomManager.canUse(evt);
				 * FunctionManager
				 * .this.modifyButtonActionPerformed(evt); }
				 * catch (SQLException e) { e.printStackTrace();
				 * } catch (ClassNotFoundException e) {
				 * e.printStackTrace(); } catch
				 * (CanNotUseException e) { e.printStackTrace();
				 * }
				 */
				try
				{
					FunctionManager.this.modifyButtonActionPerformed(evt);
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
						functionDAO.release();
					} catch (SQLException e)
					{
						// TODO Auto-generated catch
						// block
						e.printStackTrace();
						JOptionPane.showMessageDialog(null, e.getMessage());
					}
				}
			}
		});
		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 2;
		gridBagConstraints.gridy = 3;
		gridBagConstraints.insets = new Insets(5, 5, 5, 5);
		this.jPanel_functionInfo.add(this.jButton_modify, gridBagConstraints);
		this.jTextField_note.setPreferredSize(new Dimension(180, 20));
		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 2;
		gridBagConstraints.gridy = 2;
		this.jPanel_functionInfo.add(this.jTextField_note, gridBagConstraints);
		this.jLabel_note.setFont(new Font("宋体", 0, 11));
		this.jLabel_note.setText("*说明：");
		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.insets = new Insets(5, 5, 5, 5);
		this.jPanel_functionInfo.add(this.jLabel_note, gridBagConstraints);
		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.anchor = 11;
		add(this.jPanel_functionInfo, gridBagConstraints);
	}
	private void functionTableMouseClicked(MouseEvent evt)
	{
		int selectedRow = this.jTable_function.getSelectedRow();
		Vector record = this.funtionModel.getRow(this.jTable_function.convertRowIndexToModel(selectedRow));
		this.jTextField_id.setText((String) record.elementAt(0));
		this.jTextField_name.setText((String) record.elementAt(1));
		this.jTextField_note.setText((String) record.elementAt(2));
	}
	private void addButtonActionPerformed(ActionEvent evt) throws SQLException, ClassNotFoundException
	{
		FunctionsBean functionsBean = new FunctionsBean();
		functionsBean.setFunction_name(jTextField_name.getText());
		functionsBean.setFunction_note(jTextField_note.getText());
		functionDAO.add(functionsBean);
		showTableDatas();
	}
	private void deleteButtonActionPerformed(ActionEvent evt) throws SQLException, ClassNotFoundException
	{
		int[] selectedRows = this.jTable_function.getSelectedRows();
		int[] ids = new int[selectedRows.length];
		for (int i = 0; i < selectedRows.length; i++)
		{
			Vector record = this.funtionModel.getRow(this.jTable_function.convertRowIndexToModel(selectedRows[i]));
			ids[i] = Integer.parseInt((String) record.elementAt(0));
		}
		for (int id : ids)
		{
			this.functionDAO.deleteById(id);
		}
		showTableDatas();
	}
	private void modifyButtonActionPerformed(ActionEvent evt) throws SQLException, ClassNotFoundException
	{
		// Function f = new Function();
		/*
		 * f.setFunction_ID(Integer.parseInt(this.idField.getText()));
		 * f.setFunction_name(this.nameField.getText());
		 * f.setFunction_note(this.noteField.getText());
		 * 
		 * this.functionDAO.updateFunction(f);
		 */
		FunctionsBean functionsBean = new FunctionsBean();
		functionsBean.setFunction_name(jTextField_name.getText());
		functionsBean.setFunction_note(jTextField_note.getText());
		functionDAO.modifyById(Integer.parseInt(this.jTextField_id.getText()), functionsBean);
		showTableDatas();
	}
	private void showTableDatas() throws SQLException, ClassNotFoundException
	{
		Vector records = BeanUtil.convertFunctionsBeansToVector(functionDAO.getAll());
		this.funtionModel.showNewRows(records);
	}
}