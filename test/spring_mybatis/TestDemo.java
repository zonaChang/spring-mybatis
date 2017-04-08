package spring_mybatis;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * @desc: 
 * @auth: zona
 * 2017年1月15日 下午2:49:55
 */
public class TestDemo {

	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>();
		for (Entry<String, String> item : map.entrySet()) {
			
		}
		Set<Entry<String, String>> set = map.entrySet();
		Iterator<Entry<String, String>> it = set.iterator();
		for (int i = 0; i < map.size(); i++) {
			Entry<String, String> item = it.next();
			item.getKey();
			item.getValue();
		}
	}
}
