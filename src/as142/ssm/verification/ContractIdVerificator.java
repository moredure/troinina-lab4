package as111.ssm.verification;

import javax.swing.JComponent;
import javax.swing.JTextField;

public class ContractIdVerificator extends Verificator {

	public ContractIdVerificator(JComponent component, String fieldName) {
		super(component, fieldName);
	}
	
	@Override
	public boolean isOk() {
		if(component instanceof JTextField) {
			JTextField field = (JTextField) component;
			return field.getText().matches("\\d+");
		}
		return false;
	}
}
