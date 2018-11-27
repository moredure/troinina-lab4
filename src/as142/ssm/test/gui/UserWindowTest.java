package as111.ssm.test.gui;

import static org.junit.Assert.*;

import java.lang.reflect.Field;

import javax.swing.JTextField;

import org.junit.Test;

import as111.ssm.User;
import as111.ssm.gui.UserWindow;

public class UserWindowTest {
	private User user = new User("10", "Britney", "Petrovna", "Spears", "777-777", "mail@mail.com");
	private UserWindow window = new UserWindow(user);
	
	@Test
	public void testInitialValues() throws Exception {
		assertEquals(user.getContractId(), getTextFieldValue("fContractId"));
		assertEquals(user.getName(), getTextFieldValue("fName"));
		assertEquals(user.getSurname(), getTextFieldValue("fSurname"));
		assertEquals(user.getMiddleName(), getTextFieldValue("fMiddleName"));
		assertEquals(user.getPhone(), getTextFieldValue("fPhone"));
		assertEquals(user.getMail(), getTextFieldValue("fMail"));
	}
	
	@Test
	public void testSetBadValues() throws Exception {
		setTextFieldValue("fContractId", "asdas");
		window.onOk();
		assertEquals(user.getContractId(), "10");
	}
	
	@Test
	public void testSetValues() throws Exception {
		User user2 = new User("11", "Ricky", "Petrovich","Martin", "888-888", "ricky@me.com");
		setTextFieldValue("fContractId", user2.getContractId());
		setTextFieldValue("fName", user2.getName());
		setTextFieldValue("fSurname", user2.getSurname());
		setTextFieldValue("fMiddleName", user2.getMiddleName());
		setTextFieldValue("fPhone", user2.getPhone());
		setTextFieldValue("fMail", user2.getMail());
		
		window.onOk();
		
		assertEquals(user.getContractId(), user2.getContractId());
		assertEquals(user.getName(), user2.getName());
		assertEquals(user.getSurname(), user2.getSurname());
		assertEquals(user.getMiddleName(), user2.getMiddleName());
		assertEquals(user.getPhone(), user2.getPhone());
		assertEquals(user.getMail(), user2.getMail());
	}
	
	private String getTextFieldValue(String fieldName) throws Exception {
		Field f = UserWindow.class.getDeclaredField(fieldName);
		f.setAccessible(true);
		Object textField = f.get(window);
		if(textField instanceof JTextField) {
			return ((JTextField)textField).getText();
		}
		return null;
	}
	
	
	private void setTextFieldValue(String fieldName, String value) throws Exception {
		Field f = UserWindow.class.getDeclaredField(fieldName);
		f.setAccessible(true);
		Object textField = f.get(window);
		if(textField instanceof JTextField) {
			((JTextField)textField).setText(value);
		}
	}
}
