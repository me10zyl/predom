package model.db.dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import model.domain.Bean;
import model.domain.FunctionsBean;
import model.domain.UserBean;

/**
 * �û�DataAcessObject
 * 
 * @author ZyL
 * 
 */
public class FuntionsDAO extends DAO
{
	/**
	 * @param record
	 *                һ����¼ ���һ����¼
	 */
	@Override
	public void add(Bean record) throws SQLException, ClassNotFoundException
	{
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		sql = "insert into functions(function_name,function_note) values(?,?)";
		ps = getPrepareStatement(sql);
		// ������
		FunctionsBean functionsBean = (FunctionsBean) record;
		ps.setString(1, functionsBean.getFunction_name());
		ps.setString(2, functionsBean.getFunction_note());
		// ִ��SQL���
		int res = ps.executeUpdate();
		if (res == 1)
		{
			System.out.println("��ӳɹ�Ŷ");
		}
		release();
	}
	/**
	 * �����ݿ�ĵ�����¼(assemble���)
	 * 
	 * @param rs
	 *                �����
	 * @param record
	 * @return Vector<String>
	 * @throws SQLException
	 */
	public Bean assemble(ResultSet rs) throws SQLException
	{
		Vector<String> record = new Vector<String>();
		record.add(rs.getInt("function_id") + "");
		record.add(rs.getString("function_name"));
		record.add(rs.getString("function_note"));
		FunctionsBean functionsBean = new FunctionsBean(Integer.parseInt(record.get(0)),record.get(1),record.get(2));
		return functionsBean;
	}
	@Override
	public void deleteById(int id) throws ClassNotFoundException, SQLException
	{
		sql = "delete  from functions where function_id=?";
		ps  = getPrepareStatement(sql);
		ps.setInt(1, id);
		int res =  ps.executeUpdate();
		if(res == 1)
		{
			System.out.println("ɾ���ɹ�");
		}
	}
	@Override
	public Vector<Bean> getAll() throws ClassNotFoundException, SQLException
	{
		// TODO Auto-generated method stub
		sql = "select * from functions";
		ps = getPrepareStatement(sql);
		// ִ��SQL���
		rs = ps.executeQuery();
		// �����ѯ���
		Bean bean = null;
		Vector<Bean> records = new Vector<Bean>();
		while (rs.next())
		{
			bean = assemble(rs);
			records.add(bean);
		}
		release();
		return records;
	}
	@Override
	public Bean getById(int id) throws ClassNotFoundException, SQLException
	{
		// TODO Auto-generated method stub
		sql = "select * from functions where function_id=?";
		ps = getPrepareStatement(sql);
		// ������
		ps.setInt(1, id);
		// ִ��SQL���
		rs = ps.executeQuery();
		// �����ѯ���
		Bean bean = null;
		// һ��Vector����һ����¼
		if (rs.next())
		{
			bean = assemble(rs);
		}
		release();
		return bean;
	}
	@Override
	public void modifyById(int id, Bean record) throws ClassNotFoundException, SQLException
	{
		// TODO Auto-generated method stub
		sql = "update functions set function_name=?,function_note=? where function_id=?";
		ps = getPrepareStatement(sql);
		FunctionsBean functionsBean = (FunctionsBean) record;
		ps.setString(1, functionsBean.getFunction_name());
		ps.setString(2, functionsBean.getFunction_note());
		ps.setInt(3, id);
		int res = ps.executeUpdate();
		if (res == 1)
		{
			System.out.println("�޸ĳɹ�");
		}
	}
}
