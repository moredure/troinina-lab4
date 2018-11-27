package as111.ssm.gui;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import as111.ssm.User;
import as111.ssm.verification.ContractIdVerificator;
import as111.ssm.verification.Verificator;

public class UserWindow extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	private final User user;
	
	private List<Verificator> verificators = new ArrayList<Verificator>();
	
	private JTextField fName = new JTextField(15);
	private JTextField fSurname = new JTextField(15);
	private JTextField fMiddleName = new JTextField(15);
	private JTextField fPhone = new JTextField(15);
	private JTextField fContractId = new JTextField(15);
	private JTextField fMail = new JTextField(15);

	public UserWindow(User editingUser) {
		super("Change the user");
		user = editingUser;
		
		JPanel panel = new JPanel();
		
		panel.setLayout(new GridLayout(0, 2, 5, 5));
		panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		addElements(panel);
		
		JButton okButton = new JButton("Ok");
		okButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				onOk();
			}
		});
		panel.add(okButton);
		
		add(panel);
		
		setMinimumSize(new Dimension(300, 300));
		pack();
		setLocationRelativeTo(null);
		
		setVisible(true);
	}
	
	private void addElements(JPanel panel) {
		addTextField(panel, "Contract ID: ", fContractId, user.getContractId(),
				new ContractIdVerificator(fContractId, "Contract ID"));
		
		addTextField(panel, "Name: ", fName, user.getName(), null);
		
		addTextField(panel, "Surname: ", fSurname, user.getSurname(), null);

		addTextField(panel, "Middle Name: ", fMiddleName, user.getMiddleName(), null);
		
		addTextField(panel, "Phone: ", fPhone, user.getPhone(), null);
		
		addTextField(panel, "E-mail: ", fMail, user.getMail(), null);
	}
	
	public void onOk() {
		for(Verificator verificator : verificators) {
			if(!verificator.isOk()) {
				String fieldName = verificator.getFieldName();
				JOptionPane.showMessageDialog(null, 
						"Field \"" + fieldName + "\" contains invalid value");
				return;
			}
		}
		
		user.setName(fName.getText());
		user.setSurname(fSurname.getText());
		user.setMiddleName(fMiddleName.getText());
		user.setPhone(fPhone.getText());
		user.setContractId(fContractId.getText());
		user.setMail(fMail.getText());
		
		dispose();
	}

	private void addTextField (JPanel panel, String label, JTextField component, 
			String initialValue, Verificator verificator) {
		
		panel.add(new JLabel(label));
		panel.add(component);
		component.setText(initialValue);
		if(verificator != null) {
			verificators.add(verificator);
		}
	}
}
