package ftnt.qa.autotest.ui.framework.excel;

import com.github.crab2died.converter.WriteConvertible;

public class BooleanWriteConvert implements WriteConvertible{

	@Override
	public Object execWrite(Object object) {
		boolean b = (Boolean)object;
		return b==true?"成功":"失败";
		//如果setXX为true，保存的结果为成功，如果为false，excel实际写入的数据是失败。
	}

}
