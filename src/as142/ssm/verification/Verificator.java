package as111.ssm.verification;

import javax.swing.JComponent;

public abstract class Verificator {
	protected final JComponent component;
	private final String fieldName;
	
	public Verificator(JComponent component, String fieldName) {
		this.component = component;
		this.fieldName = fieldName;
	}
	
	public String getFieldName() {
		return fieldName;
	}
	
	public abstract boolean isOk();
}
