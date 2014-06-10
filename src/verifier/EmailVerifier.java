package verifier;
import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class EmailVerifier extends InputVerifier
{
	JLabel jLabel_result = null;

	public EmailVerifier()
	{
		// TODO Auto-generated constructor stub
	}
	public EmailVerifier(JLabel jLabel_result)
	{
		this.jLabel_result = jLabel_result;
	}
	@Override
	public boolean verify(JComponent input)
	{
		boolean match = true;
		// TODO Auto-generated method stub
		if (!((JTextField) input).getText().matches("\\w+@\\w+(\\.\\w+)+"))
		{
			match = false;
			if (jLabel_result != null)
				jLabel_result.setText("登录名为Email");
			else
				JOptionPane.showMessageDialog(null, "Email格式错误");
		}
		return match;
	}
	@Override
	public boolean shouldYieldFocus(JComponent input)
	{
		// TODO Auto-generated method stub
		return verify(input);
	}
}
