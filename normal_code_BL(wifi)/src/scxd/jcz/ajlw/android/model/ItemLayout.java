package scxd.jcz.ajlw.android.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import scxd.jcz.ajlw.android.common.Md_Car_Temp;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

/**
 * ��Ŀ����
 * 
 * @author wdn
 */
public class ItemLayout extends LinearLayout {

	private Context context;
	Map<String, Object> map = null;
	/**
	 * ��Ŀ����
	 */
	private List<InfoItemBar> itemBars;

	public List<InfoItemBar> getItemBars() {
		return itemBars;
	}

	public ItemLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
		this.setOrientation(VERTICAL);
		this.setPadding(10, 3, 10, 3);
		this.context = context;
		this.itemBars = new ArrayList<InfoItemBar>();
	}

	/**
	 * ���ƶ� ��Ŀ�����������Ŀ
	 * 
	 * @param itemBarIndex
	 * @param item
	 */
	public void addItem(int itemBarIndex, View item) {
		this.itemBars.get(itemBarIndex).addView(item);
	}

	/**
	 * ��� ÿһ����Ŀ �Ƿ����
	 * 
	 * @return
	 */
	public boolean isCompleted() {
		// for (InfoItemBar itemBar : itemBars) {
		// //������ ���ɼ�����Ŀ��
		// if(itemBar.getVisibility() != View.GONE){
		// for (InfoItem item : itemBar.getItems()) {
		// //���ж� �����õ���Ŀ
		// if(item.isEnabled() && !item.isPassed())
		// return false ;
		// }
		// }
		// }
		return true;
	}

	/**
	 * ��� ÿһ������ �Ϸ���
	 */
	public boolean isMatch() {
		for (InfoItemBar itemBar : itemBars) {
			// ������ ���ɼ�����Ŀ��
			if (itemBar.getVisibility() == View.VISIBLE) {
				for (InfoItem item : itemBar.getItems()) {
					// ���ж� �����õ���Ŀ
					if (item.isEnabled() && !item.isMatch())
						return false;
				}
			}
		}
		return true;
	}

	/**
	 * ��ȡ ������ ÿһ��Item �� Log
	 */
	public String Log() {
		String result = "";
		for (InfoItemBar itemBar : itemBars) {
			// ������ ���ɼ�����Ŀ��
			if (itemBar.getVisibility() == View.VISIBLE) {
				for (InfoItem item : itemBar.getItems()) {
					// ���ж� �����õ���Ŀ
					if (item.isEnabled() && item.Log() != null)
						result += item.Log() + "\n";
					/*
					 * item.setFocusable(true); item.requestFocus();
					 */
				}
			}
		}

		return result;
	}

	/**
	 * ��ȡ������¼Map���� jyxmû��ʹ��
	 * 
	 * @return
	 */
	public Map<String, Object> getDataNodeAndValue() {
		if (map != null) {
			map = null;
		}
		map = new HashMap<String, Object>();
		for (int i = 0; i < itemBars.size(); i++) {
			if (itemBars.get(i).getVisibility() == View.VISIBLE) {
				if (itemBars.get(i).titleName.equals("���������Ŀ")) {
					String jyxm = "";
					for (InfoItem item : itemBars.get(i).getItems()) {

						if (!item.getData().equals("")) {

							if (jyxm.equals("")) {
								jyxm = item.getData();
							} else {
								jyxm = jyxm + "," + item.getData();
							}
						}
					}
					map.put("jyxm", jyxm);
				}
				if (itemBars.get(i).titleName.equals("�ۼ������Ŀ")) {
					String zjjylb = "";
					String jylb = "";
					for (InfoItem item : itemBars.get(i).getItems()) {

						if (!item.getData().equals("")) {

							if (zjjylb.equals("")) {
								if ("grade".equals(item.getData())) {
									jylb = "1";
								} else if ("ejwh".equals(item.getData())) {
									jylb = "2";
								} else if ("repair".equals(item.getData())) {
									jylb = "3";
								} else {
									jylb = "";
								}
								zjjylb = jylb;
							} else {
								if ("grade".equals(item.getData())) {
									jylb = "1";
								} else if ("ejwh".equals(item.getData())) {
									jylb = "2";
								} else if ("repair".equals(item.getData())) {
									jylb = "3";
								} else {
									jylb = "";
								}
								zjjylb = zjjylb + "," + jylb;
							}
						}
					}
					map.put("zjjylb", zjjylb);
				} else {
					if (!itemBars.get(i).titleName.equals("����������Ϣ��")
							&& !itemBars.get(i).titleName.equals("���������Ϣ")) {
						for (InfoItem item : itemBars.get(i).getItems()) {
							if (item.isEnabled()) {
								if (item.xml.equals("yxqz")) {
									map.put("jyyxqz", item.getData());
								} else if (item.xml.equals("qzdz")) {
									if (item.getData().equals("00")) {
										map.put(item.xml, "");
									} else {
										map.put(item.xml, item.getData());
									}
								} else if (item.xml.equals("zczw")) {
									zczw(map, item.getData());
								} else if (item.xml.equals("ltgg")) {
									map.put(item.xml,
											"<![CDATA[" + item.getData()
													+ "]]>");
								//������zzs���Ϊ����ѡ�񡰣��滻Ϊ��
								}else if(item.xml.equals("zzs")){
									
									if("��ѡ��".equals(item.getData()))
										map.put(item.xml, "");
									else
										map.put(item.xml, item.getData());	
								} 
								else {
									map.put(item.xml, item.getData());
								}
								// else if (item.xml.equals("qdxs")) {
								// qdxs(map, item.getData());
								// }
							}
						}
					}
				}
			}
		}
		return map;
	}

	public Map<String, Object> getDataNodeAndValue(String dgwz) {
		if (map != null) {
			map = null;
		}
		map = new HashMap<String, Object>();
		for (int i = 0; i < itemBars.size(); i++) {
			if (itemBars.get(i).getVisibility() == View.VISIBLE) {
				for (InfoItem item : itemBars.get(i).getItems()) {
					if (item.isEnabled()) {
						if (!item.xml.equals("dgwz")
								&& !item.xml.equals("gwjysbbh")) {
							if (item.xml.equals("jcxdh")
									|| item.xml.equals("jycs")) {
								map.put(item.xml, item.getData());
							} else {
								if (dgwz.equals("0")) {
									map.put("z" + item.xml, item.getData());
								} else {
									map.put("y" + item.xml, item.getData());
								}
							}
						}
					}
				}
			}
		}
		return map;
	}

	/**
	 * ��ȡ������¼Map���� jyxmû��ʹ��
	 * 
	 * @return
	 */
	public Map<String, Object> getDataNodeAndValueHbxx() {
		if (map != null) {
			map = null;
		}
		map = new HashMap<String, Object>();
		for (int i = 0; i < itemBars.size(); i++) {
			if (itemBars.get(i).getVisibility() == View.VISIBLE) {
				if (itemBars.get(i).titleName.equals("���������Ϣ")) {
					for (InfoItem item : itemBars.get(i).getItems()) {
						if (item.isEnabled()) {
							map.put(item.xml, item.getData());
						}
					}
				}
			}
		}
		return map;
	}

	private void zczw(Map<String, Object> map, String zczw) {
		map.put("zczw", zczw);
		map.put("zczs", zczw.length());
	}

	private void qdxs(Map<String, Object> map, String qdxs) {
		String qdxsvalue = "";
		String zczsvalue = "";
		String zczwvalue = "";
		if (qdxs.equals("4��2������פ��")) {
			qdxsvalue = "2";
			zczsvalue = "1";
			zczwvalue = "2";
		} else if (qdxs.equals("2��1Ħ�г�")) {

		} else if (qdxs.equals("4��2ǰ����פ��")) {
			qdxsvalue = "1";
			zczsvalue = "1";
			zczwvalue = "2";
		} else if (qdxs.equals("4��2ǰ��ǰפ��")) {
			qdxsvalue = "1";
			zczsvalue = "1";
			zczwvalue = "1";
		} else if (qdxs.equals("4��4ȫ����פ��")) {
			qdxsvalue = "12";
			zczsvalue = "1";
			zczwvalue = "2";
		} else if (qdxs.equals("4��4ȫ������פ��")) {
			qdxsvalue = "12";
			zczsvalue = "1";
			zczwvalue = "2";
		} else if (qdxs.equals("6��2������פ��")) {
			qdxsvalue = "3";
			zczsvalue = "1";
			zczwvalue = "3";
		} else if (qdxs.equals("6��2˫�󸡶�����פ��")) {
			qdxsvalue = "23";
			zczsvalue = "1";
			zczwvalue = "2";
		} else if (qdxs.equals("6��4˫����˫��פ��")) {
			qdxsvalue = "23";
			zczsvalue = "2";
			zczwvalue = "23";
		} else if (qdxs.equals("6��4˫������˫��פ��")) {
			qdxsvalue = "23";
			zczsvalue = "2";
			zczwvalue = "23";
		} else if (qdxs.equals("6��6ȫ����˫��פ��")) {
			qdxsvalue = "123";
			zczsvalue = "3";
			zczwvalue = "123";
		} else if (qdxs.equals("6��2������פ�����")) {
			qdxsvalue = "2";
			zczsvalue = "1";
			zczwvalue = "2";
		} else if (qdxs.equals("8��4˫����˫��פ��")) {
			qdxsvalue = "34";
			zczsvalue = "2";
			zczwvalue = "34";
		} else if (qdxs.equals("8��2������פ�����")) {
			qdxsvalue = "3";
			zczsvalue = "1";
			zczwvalue = "3";
		} else if (qdxs.equals("8��4˫����˫��פ�����")) {
			qdxsvalue = "23";
			zczsvalue = "2";
			zczwvalue = "23";
		} else if (qdxs.equals("8��2������פ��ȫ��")) {
			qdxsvalue = "4";
			zczsvalue = "1";
			zczwvalue = "4";
		} else if (qdxs.equals("10��6����������פ��")) {
			qdxsvalue = "345";
			zczsvalue = "3";
			zczwvalue = "345";
		} else if (qdxs.equals("10X4˫����˫��פ�����")) {
			qdxsvalue = "34";
			zczsvalue = "2";
			zczwvalue = "34";
		} else if (qdxs.equals("10X2������פ�����")) {
			qdxsvalue = "3";
			zczsvalue = "1";
			zczwvalue = "3";
		} else if (qdxs.equals("12X4˫����˫��פ�����")) {
			qdxsvalue = "34";
			zczsvalue = "2";
			zczwvalue = "34";
		} else {
			qdxsvalue = "1";
			zczsvalue = "1";
			zczwvalue = "2";
		}
		map.put("qdxs", qdxsvalue);
		map.put("zczs", zczsvalue);
		map.put("zczw", zczwvalue);
	}

	/**
	 * ��ȡ ���� for xml
	 * 
	 * @return
	 */
	public String getData2Xml() {
		String result = "";

		for (int i = 0; i < itemBars.size(); i++) {
			if (itemBars.get(i).getVisibility() == View.VISIBLE) {
				if (i == 0) { // ���ڸ�ʽҪ�� �����Ŀ �ϲ�Ϊһ�� �ڵ�
					result += "<jcxm>";
					result += getDataAt(i, false);
					// ���� ������Ŀ ����20 ,��0Ԥ�� ,����Ϊ20λ
					int addExtar = 20 - itemBars.get(i).getItems().size();
					for (int j = 0; j < addExtar; j++) {
						result += "0";
					}
					result += "</jcxm>";
				} else {
					for (InfoItem item : itemBars.get(i).getItems()) {
						// ���ж� �����õ���Ŀ
						if (item.isEnabled())
							result += item.getData2Xml();
					}
				}
			}
		}

		// result += "</veh></root>" ;
		return result;
	}

	/**
	 * ��ȡָ�� ��Ŀ�� ����
	 * 
	 * @param itemBarInedx
	 *            ��Ŀ��index
	 * @param is2XML
	 *            �Ƿ���xml��ʽ
	 * @return
	 */
	public String getDataAt(int itemBarInedx, boolean is2XML) {
		String result = "";
		InfoItemBar itemBar = this.itemBars.get(itemBarInedx);
		for (InfoItem item : itemBar.getItems()) {
			if (item.isEnabled()) {
				// Ϊ������ɫ����
				if (is2XML) {
					result += item.getData2Xml();
				} else {
					if (item.xml.equals("csys")) {
						result += Md_Car_Temp.getTempCar().csys;
					} else {
						result += item.getData();
					}
				}
				// ԭʼ
				// if (is2XML)
				// result += item.getData2Xml();
				// else
				// result += item.getData();
			}
		}
		return result;
	}

	/**
	 * ���� ��Ŀ��
	 * 
	 * @param itemBarIndex
	 * @param visibility
	 */
	public void setVisibilityAt(int itemBarIndex, int visibility) {
		this.itemBars.get(itemBarIndex).setVisibility(visibility);
	}

	/**
	 * ���� ��Ŀ����
	 * 
	 * @param datas
	 */
	public void setItemsData(Map<String, String> datas) {
		Set<String> keySet = datas.keySet();
		boolean isMatch;
		for (String xmlKey : keySet) {
			isMatch = false;
			for (InfoItemBar itemBar : itemBars) {
				for (InfoItem item : itemBar.getItems()) {
					// ���� ���� ��Ŀ
					if (item.xmlMatch(xmlKey)) { // �жϸ���Ŀ ��xml��ǩ�Ƿ� ƥ��
						if ("pl".equals(xmlKey)) {
							System.out.println(datas.get(xmlKey));
						}
						if ("csys".equals(xmlKey)) {
							InfoItemEdt s=(InfoItemEdt) item;
							s.geteEditText().setEnabled(false);
						}
						if ("zbzl".equals(xmlKey)) {
							if (Integer.valueOf("".equals(datas.get(xmlKey))?"0":datas.get(xmlKey)) > 0) {
								InfoItemEdt s=(InfoItemEdt) item;
								s.geteEditText().setFocusable(false);
								s.geteEditText().setFocusableInTouchMode(false);
							}
						}
						item.setData(datas.get(xmlKey));
						isMatch = true;
					}
				}
			}
		}
	}
/******************************************/
	/**
	 * ���� ��Ŀ���� ��ʼ�ȶ�
	 * 
	 * @param datas
	 */
	public void setItemsDataBD(final Map<String, String> datas,
			final Map<String, String> notice_Map) {
		Set<String> keySet = datas.keySet();
		Set<String> notikeyset = notice_Map.keySet();
		boolean isMatch;
		for (String xmlKey : keySet) {
			// ���� ���� xmlKey
			isMatch = false;
			for (InfoItemBar itemBar : itemBars) {
				for (InfoItem item : itemBar.getItems()) {
					// ���� ���� ��Ŀ
					if (item.xmlMatch(xmlKey)) { // �жϸ���Ŀ ��xml��ǩ�Ƿ� ƥ��
//						if (datas.get("bh").equals("0")) {// ���������Ϊ0�Ͳ��Զ��ȶ�
//							item.setData(datas.get(xmlKey));
//							isMatch = true;
//						} else {
							for (String notKey : notikeyset) {// ����������Ϣ�������жϵ�ǰ
								if (xmlKey.equals(notKey)) {// �жϹ���������������ݽڵ㣨key�������ڵ�Ͳ�������
									if (notice_Map.get(xmlKey).equals(
											datas.get(xmlKey)))// �жϹ����������������ͬ�ڵ�ʱ���Ƚ����ǵ�ֵ�Ƿ����
									{
										item.setData(datas.get(xmlKey));
									} else {// �����ʱ����ʾ
										item.setData(datas.get(xmlKey), true);
									}
								} else if (xmlKey.equals(notKey)) {
									// notKey
									if (keySet.contains(xmlKey)) {
										if (notice_Map.get(xmlKey).equals(
												datas.get(xmlKey))) {
											item.setData(datas.get(xmlKey));
										} else {
											
											item.setData(datas.get(xmlKey),
													true);
											
										}
									} else {
										item.setData(datas.get(xmlKey));
									}
								} else {
									item.setData(datas.get(xmlKey));
								}

							}
							isMatch = true;
//						}
					}

				}
			}
		}
	}
	/*************************
	
	
	
	
	
	/**
	 * ���� ��Ŀ����
	 * 
	 * @param datas
	 */
	public void setJYXMItemsData(Map<String, String> datas, int pos) {
		Set<String> keySet = datas.keySet();
		for (String xmlKey : keySet) {
			for (InfoItem item : itemBars.get(pos).getItems()) {
				if (item.xmlMatch(xmlKey)) {
					item.setData(datas.get(xmlKey));
					item.setEnabled(false);
				}
			}
		}
	}

	/**
	 * ���� ��Ŀ����
	 * 
	 * @param datas
	 */
	public void setItemsDataNull(int pos) {
		for (InfoItem item : itemBars.get(pos).getItems()) {
			item.setEnabled(true);
			item.setData("0");
		}
	}

	/**
	 * ��ʼ�� ������ʽ
	 * 
	 * @param names
	 */
	public void initItemBars(String[] names) {
		for (String name : names) {
			InfoItemBar intemBar = new InfoItemBar(this.context, name);
			itemBars.add(intemBar);
			this.addView(intemBar, 0);
		}
	}

	/**
	 * ���� ��Ŀ�� �Ƿ�����
	 * 
	 * @param itemBarIndex
	 * @param isShow
	 */
	public void setShow(int itemBarIndex, boolean isShow) {
		this.itemBars.get(itemBarIndex).setShow(isShow);
	}

	/**
	 * ��ʼ��EdeΪ��
	 */
	public void initEdtNull() {
		for (int i = 0; i < itemBars.size(); i++) {
			if (itemBars.get(i).getVisibility() == View.VISIBLE) {
				for (InfoItem item : itemBars.get(i).getItems()) {
					// ���ж� �����õ���Ŀ
					if (item instanceof InfoItemEdt
							|| item instanceof InfoItemDate) {
						item.setData("");
						if ("dlysfzh".equals(item.xml)) {
							item.setData(Md_Car_Temp.getTempCar().jyysfzh);
						}
					}
				}
			}
		}
	}

	/**
	 * ���� ָ����Ŀ�� ��ʼ��
	 */
	public void setDefault(int itemBarIndex) {
		this.itemBars.get(itemBarIndex).setDefault();
	}

	/**
	 * ����ȫ�� ��Ŀ�� ��ʼ��
	 */
	public void setAllDefault() {
		for (InfoItemBar itemBar : itemBars) {
			itemBar.setDefault();
		}
	}
}
