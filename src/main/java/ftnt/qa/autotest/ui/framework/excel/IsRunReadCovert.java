package ftnt.qa.autotest.ui.framework.excel;

import com.github.crab2died.converter.ReadConvertible;

public class IsRunReadCovert implements ReadConvertible{
	@Override
	public Object execRead(String object) {
		return "是".equals(object);
		//如果getXX获取Excel的数据是是，java代码中的字段为true。
	}
}
