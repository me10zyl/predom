package view;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import exception.CannotUseException;
import util.PredomManager;

public class Permission extends JFrame implements ActionListener
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	GridBagConstraints constraints = new GridBagConstraints();
	private JMenuItem jMenuItem_exitMenuItem;
	private JMenuItem jMenuItem_functionManageItem;
	private JMenuItem jMenuItem_helpMenuItem;
	private JMenuItem jMenuItem_predomItem;
	private JMenuItem jMenuItem_useManageItem;
	private JMenuItem jMenuItem_userGroupManageItem;
	private JMenuBar jMenuBar1;
	private JMenu jMenu_functionMenu;
	private JMenu jMenu_predomMenu;
	private JMenu jMenu_systemNenu;
	private JMenu jMenu_userGroupMenu;
	private JMenu jMenu_userManageMenu;
	private JLabel jLabel_welcome;

	public Permission()
	{
		this.constraints.gridx = 0;
		this.constraints.gridy = 0;
		this.constraints.anchor = 18;
		initComponents();
	}
	private void initComponents()
	{
		this.jMenuBar1 = new JMenuBar();
		this.jMenu_systemNenu = new JMenu();
		this.jMenuItem_helpMenuItem = new JMenuItem();
		this.jMenuItem_exitMenuItem = new JMenuItem();
		this.jMenu_userManageMenu = new JMenu();
		this.jMenuItem_useManageItem = new JMenuItem();
		this.jMenu_userGroupMenu = new JMenu();
		this.jMenuItem_userGroupManageItem = new JMenuItem();
		this.jMenu_functionMenu = new JMenu();
		this.jMenuItem_functionManageItem = new JMenuItem();
		this.jMenu_predomMenu = new JMenu();
		this.jMenuItem_predomItem = new JMenuItem();
		setDefaultCloseOperation(3);
		this.jMenu_systemNenu.setText("系统");
		this.jMenu_systemNenu.setFont(new Font("宋体", 0, 11));
		this.jMenuItem_helpMenuItem.setFont(new Font("宋体", 0, 11));
		this.jMenuItem_helpMenuItem.setText("帮助");
		this.jMenuItem_helpMenuItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent evt)
			{
				Permission.this.helpMenuItemActionPerformed(evt);
			}
		});
		this.jMenu_systemNenu.add(this.jMenuItem_helpMenuItem);
		this.jMenuItem_exitMenuItem.setFont(new Font("宋体", 0, 11));
		this.jMenuItem_exitMenuItem.setText("退出");
		this.jMenuItem_exitMenuItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent evt)
			{
				Permission.this.exitMenuItemActionPerformed(evt);
			}
		});
		this.jMenu_systemNenu.add(this.jMenuItem_exitMenuItem);
		this.jMenuBar1.add(this.jMenu_systemNenu);
		this.jMenu_userManageMenu.setText("用户管理");
		this.jMenu_userManageMenu.setFont(new Font("宋体", 0, 11));
		this.jMenu_userManageMenu.addActionListener(this);
		this.jMenuItem_useManageItem.setFont(new Font("宋体", 0, 11));
		this.jMenuItem_useManageItem.setText("用户管理");
		this.jMenuItem_useManageItem.setName("userManage");
		this.jMenu_userManageMenu.add(this.jMenuItem_useManageItem);
		this.jMenuItem_useManageItem.addActionListener(this);
		this.jMenuBar1.add(this.jMenu_userManageMenu);
		this.jMenu_userGroupMenu.setText("用户组管理");
		this.jMenu_userGroupMenu.setFont(new Font("宋体", 0, 11));
		this.jMenuItem_userGroupManageItem.setFont(new Font("宋体", 0, 11));
		this.jMenuItem_userGroupManageItem.setText("用户组管理");
		this.jMenuItem_userGroupManageItem.setName("userGroupManage");
		this.jMenu_userGroupMenu.add(this.jMenuItem_userGroupManageItem);
		this.jMenuItem_userGroupManageItem.addActionListener(this);
		this.jMenuBar1.add(this.jMenu_userGroupMenu);
		this.jMenu_functionMenu.setText("功能管理");
		this.jMenu_functionMenu.setFont(new Font("宋体", 0, 11));
		this.jMenuItem_functionManageItem.setFont(new Font("宋体", 0, 11));
		this.jMenuItem_functionManageItem.setText("功能管理");
		this.jMenuItem_functionManageItem.setName("functionManage");
		this.jMenu_functionMenu.add(this.jMenuItem_functionManageItem);
		this.jMenuItem_functionManageItem.addActionListener(this);
		this.jMenuBar1.add(this.jMenu_functionMenu);
		this.jMenu_predomMenu.setText("权限配置");
		this.jMenu_predomMenu.setFont(new Font("宋体", 0, 11));
		this.jMenuItem_predomItem.setFont(new Font("宋体", 0, 11));
		this.jMenuItem_predomItem.setText("权限配置");
		this.jMenuItem_predomItem.setName("predomManage");
		this.jMenu_predomMenu.add(this.jMenuItem_predomItem);
		this.jMenuItem_predomItem.addActionListener(this);
		this.jMenuBar1.add(this.jMenu_predomMenu);
		this.jLabel_welcome = new JLabel("欢迎你,"+PredomManager.getUser().getUserName());
		setJMenuBar(this.jMenuBar1);
		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		JPanel jPanel = new JPanel();
		jPanel.add(jLabel_welcome);
		getContentPane().add(jPanel,this.constraints);
//		layout.setHorizontalGroup(layout.createParallelGroup(1).add(0, 623, 32767));
//		layout.setVerticalGroup(layout.createParallelGroup(1).add(0, 457, 32767));
		// setResizable(false);
		this.setSize(new Dimension(800, 600));
//		this.setMinimumSize(new Dimension(200, 200));
		this.setLocationRelativeTo(getOwner());
		this.setResizable(false);
//		pack();
	}
	private void exitMenuItemActionPerformed(ActionEvent evt)
	{
		new LoginUI().setVisible(true);
		dispose();
	}
	private void helpMenuItemActionPerformed(ActionEvent evt)
	{
		JOptionPane.showMessageDialog(null, "此功能尚未开放");
	}
	private void setAllComponentsDisvisible()
	{
		Component[] components = getContentPane().getComponents();
		for (int i = 0; i < components.length; i++)
		{
			components[i].setVisible(false);
		}
	}
	@Override
	public void actionPerformed(ActionEvent e)
	{
		// TODO Auto-generated method stub
		if (e.getSource() == jMenuItem_useManageItem)
		{
			try
			{
				PredomManager.canUse(e);
				setAllComponentsDisvisible();
				getContentPane().setLayout(new GridBagLayout());
				getContentPane().add(new UserManager(), this.constraints);
				pack();
			} catch (ClassNotFoundException e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (CannotUseException e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} else if (e.getSource() == jMenuItem_userGroupManageItem)
		{
			try
			{
				PredomManager.canUse(e);
				setAllComponentsDisvisible();
				getContentPane().setLayout(new GridBagLayout());
				getContentPane().add(new UserGroupManager(), this.constraints);
				pack();
			} catch (ClassNotFoundException e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (CannotUseException e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} else if (e.getSource() == jMenuItem_functionManageItem)
		{
			try
			{
				PredomManager.canUse(e);
				setAllComponentsDisvisible();
				getContentPane().setLayout(new GridBagLayout());
				getContentPane().add(new FunctionManager(), this.constraints);
				pack();
			} catch (ClassNotFoundException e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (CannotUseException e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		} else if (e.getSource() == jMenuItem_predomItem)
		{
			try
			{
				PredomManager.canUse(e);
				setAllComponentsDisvisible();
				getContentPane().setLayout(new GridBagLayout());
				getContentPane().add(new PredomConfiger(), this.constraints);
				pack();
			} catch (ClassNotFoundException e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (CannotUseException e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
	}
}
