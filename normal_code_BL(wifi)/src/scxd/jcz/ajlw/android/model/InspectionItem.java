package scxd.jcz.ajlw.android.model;

import java.util.List;

public class InspectionItem {
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
		 * 判定结果
		 * 0为不检测，1为检测合格，2为不合格
		 */
		public String pdjg;
	}
}
