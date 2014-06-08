package util;
import java.util.Vector;
import view.FunctionManager;
import model.domain.Bean;
import model.domain.FunctionsBean;
import model.domain.PredomBean;
import model.domain.UserBean;
import model.domain.UserGroupBean;

public class BeanUtil
{
	public static Vector<Vector<String>> convertUserBeansToVector(Vector<Bean> beans)
	{
		Vector<Vector<String>> tableDataList = new Vector<Vector<String>>();
		for (Bean bean : beans)
		{
			Vector<String> vec = new Vector<String>();
			UserBean userBean = (UserBean) bean;
			vec.add(userBean.getUserId() + "");
			vec.add(userBean.getUserGroupId() + "");
			vec.add(userBean.getUserName());
			vec.add(userBean.getUserAddress());
			vec.add(userBean.getUserCode());
			vec.add(userBean.getUserPhone());
			vec.add(userBean.getUserEmail());
			vec.add(userBean.getUserPassword());
			tableDataList.add(vec);
		}
		return tableDataList;
	}
	public static Vector<Vector<String>> convertUserGroupBeanToVector(Vector<Bean> beans)
	{
		Vector<Vector<String>> tableDataList = new Vector<Vector<String>>();
		for (Bean bean : beans)
		{
			Vector<String> vec = new Vector<String>();
			UserGroupBean userGroupBean = (UserGroupBean) bean;
			vec.add(userGroupBean.getUserGroupId() + "");
			vec.add(userGroupBean.getUserGroupName());
			tableDataList.add(vec);
		}
		return tableDataList;
	}
	public static Vector<Vector<String>> convertFunctionsBeansToVector(Vector<Bean> beans)
	{
		Vector<Vector<String>> tableDataList = new Vector<Vector<String>>();
		for (Bean bean : beans)
		{
			Vector<String> vec = new Vector<String>();
			FunctionsBean functionsBean = (FunctionsBean) bean;
			vec.add(functionsBean.getFunction_id() + "");
			vec.add(functionsBean.getFunction_name());
			vec.add(functionsBean.getFunction_note());
			tableDataList.add(vec);
		}
		return tableDataList;
	}
	public static Vector<Vector<String>> convertPredomBeanToVector(Vector<Bean> beans)
	{
		Vector<Vector<String>> tableDataList = new Vector<Vector<String>>();
		for (Bean bean : beans)
		{
			Vector<String> vec = new Vector<String>();
			PredomBean predomBean = (PredomBean) bean;
			vec.add(predomBean.getPredomId() + "");
			vec.add(predomBean.getUserGroupId()+"");
			vec.add(predomBean.getFunctionId()+"");
			tableDataList.add(vec);
		}
		return tableDataList;
	}
}
