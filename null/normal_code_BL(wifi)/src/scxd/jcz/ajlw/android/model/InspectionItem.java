package scxd.jcz.ajlw.android.model;

import java.util.List;

public class InspectionItem {
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
		 * �ж����
		 * 0Ϊ����⣬1Ϊ���ϸ�2Ϊ���ϸ�
		 */
		public String pdjg;
	}
}
