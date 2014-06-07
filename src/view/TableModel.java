package view;

import java.io.BufferedWriter;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

public class TableModel extends AbstractTableModel
{
  private static final long serialVersionUID = 1L;
  private Vector<Vector<String>> tableDataList = new Vector<Vector<String>>();

  private String[] columnNames = null;

  public Class[] columnClasses = null;

  boolean[] canEdit = null;
  BufferedWriter bw = null;

  public TableModel(String[] columnNames, Class[] columnClasses, boolean[] canEdit, Vector<Vector<String>> tableDataList)
  {
    this.columnNames = columnNames;
    this.columnClasses = columnClasses;
    this.canEdit = canEdit;
    this.tableDataList = tableDataList;
  }

  public int getColumnCount()
  {
    return this.columnNames.length;
  }

  public int getRowCount()
  {
    return this.tableDataList.size();
  }

  public Object getValueAt(int row, int column)
  {
    Object value = null;

    if (!this.tableDataList.isEmpty())
    {
      value = this.tableDataList.elementAt(row).elementAt(column);
    }

    return value;
  }

  public String getColumnName(int column)
  {
    return this.columnNames[column];
  }

  public boolean isCellEditable(int row, int column)
  {
    return this.canEdit[column];
  }

  public void setValueAt(Object value, int row, int column)
  {
    this.tableDataList.elementAt(row).setElementAt((String)value, column);
    fireTableDataChanged();
  }

  public void showNewRows(Vector<Vector<String>> newRecords)
  {
    this.tableDataList = newRecords;

    fireTableDataChanged();
  }

  public Vector<String> getRow(int row)
  {
    if (!this.tableDataList.isEmpty())
    {
      return this.tableDataList.elementAt(row);
    }
    return null;
  }

  public void insertRow(Vector<String> record, int newRowCount)
  {
    this.tableDataList.add(record);
    int rowCount = getRowCount();
    fireTableRowsInserted(rowCount - newRowCount, rowCount - 1);
  }
}
