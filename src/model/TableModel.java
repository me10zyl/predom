/**
 * 
 */
package model;
import java.util.Vector;
import javax.swing.table.AbstractTableModel;

/**
 * @author 张小华
 * 
 */
public class TableModel extends AbstractTableModel
{
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unchecked")
	private Vector<Vector<String>> tableDataList = new Vector<Vector<String>>();
	private String[] columnNames = null;
	@SuppressWarnings("unchecked")
	public Class[] columnClasses = null;
	boolean[] canEdit = null;

	public TableModel(String[] columnNames, Class[] columnClasses, boolean[] canEdit, Vector<Vector<String>> tableDataList)
	{
		this.columnNames = columnNames;
		this.columnClasses = columnClasses;
		this.canEdit = canEdit;
		this.tableDataList = tableDataList;
	}
	/**
	 * 获得表格的总列数
	 */
	public int getColumnCount()
	{
		return columnNames.length;
	}
	/**
	 * 获得表格的总行数
	 */
	public int getRowCount()
	{
		return tableDataList.size();
	}
	/**
	 * 获得表格指定单元格的值
	 * 
	 * @param row
	 *                行
	 * @param column
	 *                列
	 */
	public Object getValueAt(int row, int column)
	{
		Object value = null;
		// 如果指定单元格非空
		if (!tableDataList.isEmpty())
		{
			value = tableDataList.elementAt(row).elementAt(column);
		}
		return value;
	}
	/**
	 * 获得指定列的列名
	 * 
	 * @param column
	 *                指定的列
	 */
	public String getColumnName(int column)
	{
		return columnNames[column];
	}
	/**
	 * 获得指定的列对象
	 * 
	 * @param column
	 *                指定的列
	 */
	@SuppressWarnings("unchecked")
	public Class getColumnClass(int column)
	{
		return columnClasses[column];
	}
	/**
	 * 获得可编辑的单元格
	 * 
	 * @param row
	 *                行
	 * @param column
	 *                列
	 */
	public boolean isCellEditable(int row, int column)
	{
		return canEdit[column];
	}
	/**
	 * 设置表格指定单元格的值
	 * 
	 * @param 值
	 * @param row
	 *                行
	 * @param column
	 *                列
	 */
	@SuppressWarnings("unchecked")
	public void setValueAt(Object value, int row, int column)
	{
		tableDataList.elementAt(row).setElementAt((String) value, column);
		fireTableDataChanged();
	}
	/**
	 * 显示最新的所有行数据
	 * 
	 * @return
	 * @throws URISyntaxException
	 * @throws IOException
	 */
	public void showNewRows(Vector<Vector<String>> newRecords)
	{
		tableDataList = newRecords;
		fireTableDataChanged();
	}
	/**
	 * 获得指定行数据
	 * 
	 * @param row
	 * @return
	 */
	public Vector<String> getRow(int row)
	{
		if (!tableDataList.isEmpty())
		{
			return tableDataList.elementAt(row);
		}
		return null;
	}
	/**
	 * 在表格末尾插入新行
	 * 
	 * @param rowCouont
	 *                将要插入的新行总数
	 * @throws URISyntaxException
	 * @throws IOException
	 */
	public void insertRow(Vector<String> record, int newRowCount)
	{
		tableDataList.add(record);
		int rowCount = getRowCount();
		fireTableRowsInserted(rowCount - newRowCount, rowCount - 1);
	}
}
