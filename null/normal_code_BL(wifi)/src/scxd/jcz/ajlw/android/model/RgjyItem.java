package scxd.jcz.ajlw.android.model;

import java.util.List;
/**
 * ����Class
 * @author CXY
 *
 */
public class RgjyItem {
	public String msg;
	public String pid;
	public List<Item> items;
	
	public class Item{
		/**
		 * ����ID
		 */
		public String pid;
		/**
		 * IDֵ
		 */
		public String id;
		/**
		 * ��Ŀ��
		 */
		public String name;
		/**
		 * ��Ŀ��Ӧ�����
		 */
		public String code;
		/**
		 * �Ƿ�Ϊ�����
		 */
		public String property;
		
		@Override
		public String toString() {
			return pid+"|"+id+"|"+name+"|"+code+"|"+property+"|";
		}
	}

	@Override
	public String toString() {
		return msg+","+pid+","+items.toString();
	}
	
}
