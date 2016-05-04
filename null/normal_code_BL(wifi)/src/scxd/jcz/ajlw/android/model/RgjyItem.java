package scxd.jcz.ajlw.android.model;

import java.util.List;
/**
 * 工具Class
 * @author CXY
 *
 */
public class RgjyItem {
	public String msg;
	public String pid;
	public List<Item> items;
	
	public class Item{
		/**
		 * 分类ID
		 */
		public String pid;
		/**
		 * ID值
		 */
		public String id;
		/**
		 * 项目名
		 */
		public String name;
		/**
		 * 项目对应的序号
		 */
		public String code;
		/**
		 * 是否为否决项
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
