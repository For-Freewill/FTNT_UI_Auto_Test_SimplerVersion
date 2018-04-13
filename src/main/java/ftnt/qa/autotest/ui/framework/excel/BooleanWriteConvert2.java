package ftnt.qa.autotest.ui.framework.excel;

import com.github.crab2died.converter.WriteConvertible;

public class BooleanWriteConvert2 implements WriteConvertible{

	@Override
	public Object execWrite(Object object) {
		boolean b = (Boolean)object;
		return b==true?"是":"否";
	}

}
