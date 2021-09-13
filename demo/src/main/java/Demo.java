import java.beans.PropertyEditor;
import java.beans.PropertyEditorSupport;

/**
 * @author virtiL
 * @see
 * @since
 */
public class Demo extends PropertyEditorSupport implements PropertyEditor {

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		this.setValue(new Demo());
	}
}