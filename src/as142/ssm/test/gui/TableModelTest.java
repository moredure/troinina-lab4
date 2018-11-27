package as111.ssm.test.gui;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

import as111.ssm.Directory;
import as111.ssm.User;
import as111.ssm.gui.AppTableModel;

public class TableModelTest {
	private AppTableModel model;
	private User user1 = new User("10", "Jason", "Petrovich", "Statham", "777", "jasonstatham@gmail.com");
	
	@Before
	public void init() {
		Directory directory = new Directory();
		directory.addUser(user1);
		directory.addUser(new User("20", "Peter", "Petrovich", "Griffin", "444", "petergriffin@mail.ru"));
		model = new AppTableModel(directory);
	}
	
	@Test
	public void testGetUser() {
		assertNull(model.getUser(-1));
		assertNotNull(model.getUser(0));
		assertNotNull(model.getUser(1));
		assertNull(model.getUser(2));
	}
	
	@Test
	public void testGetRowCount() {
		assertEquals(2, model.getRowCount());
	}
	
	@Test
	public void testGetColumnCount() {
		assertEquals(6, model.getColumnCount());
	}
	
	@Test
	public void testGetColumnName() {
		assertEquals("ContractID", model.getColumnName(0));
		assertEquals("Name", model.getColumnName(1));
		assertEquals("Surname", model.getColumnName(2));
		assertEquals("Phone", model.getColumnName(3));
		assertEquals("E-mail", model.getColumnName(4));
		assertEquals("MiddleName", model.getColumnName(5));
	}
	
	@Test
	public void testGetValueAt() {
		assertEquals(null, model.getValueAt(-1, 0));
		assertEquals(user1.getContractId(), model.getValueAt(0, 0));
		assertEquals(user1.getName(), model.getValueAt(0, 1));
		assertEquals(user1.getSurname(), model.getValueAt(0, 2));
		assertEquals(user1.getPhone(), model.getValueAt(0, 3));
		assertEquals(user1.getMail(), model.getValueAt(0, 4));
		assertEquals(user1.getMiddleName(), model.getValueAt(0, 5));
	}
}
