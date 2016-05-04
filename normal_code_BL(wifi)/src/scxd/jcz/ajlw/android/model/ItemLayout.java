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
 * 项目布局
 * 
 * @author wdn
 */
public class ItemLayout extends LinearLayout {

	private Context context;
	Map<String, Object> map = null;
	/**
	 * 项目分组
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
	 * 向制定 项目分组中添加项目
	 * 
	 * @param itemBarIndex
	 * @param item
	 */
	public void addItem(int itemBarIndex, View item) {
		this.itemBars.get(itemBarIndex).addView(item);
	}

	/**
	 * 检测 每一个项目 是否完成
	 * 
	 * @return
	 */
	public boolean isCompleted() {
		// for (InfoItemBar itemBar : itemBars) {
		// //不遍历 不可见的项目集
		// if(itemBar.getVisibility() != View.GONE){
		// for (InfoItem item : itemBar.getItems()) {
		// //不判断 不可用得项目
		// if(item.isEnabled() && !item.isPassed())
		// return false ;
		// }
		// }
		// }
		return true;
	}

	/**
	 * 检测 每一项数据 合法性
	 */
	public boolean isMatch() {
		for (InfoItemBar itemBar : itemBars) {
			// 不遍历 不可见的项目集
			if (itemBar.getVisibility() == View.VISIBLE) {
				for (InfoItem item : itemBar.getItems()) {
					// 不判断 不可用得项目
					if (item.isEnabled() && !item.isMatch())
						return false;
				}
			}
		}
		return true;
	}

	/**
	 * 获取 布局中 每一项Item 的 Log
	 */
	public String Log() {
		String result = "";
		for (InfoItemBar itemBar : itemBars) {
			// 不遍历 不可见的项目集
			if (itemBar.getVisibility() == View.VISIBLE) {
				for (InfoItem item : itemBar.getItems()) {
					// 不判断 不可用得项目
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
	 * 获取车辆登录Map对象 jyxm没有使用
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
				if (itemBars.get(i).titleName.equals("车辆检测项目")) {
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
				if (itemBars.get(i).titleName.equals("综检检验项目")) {
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
					if (!itemBars.get(i).titleName.equals("车辆基本信息二")
							&& !itemBars.get(i).titleName.equals("环检基础信息")) {
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
								//主轴数zzs如果为”请选择“，替换为空
								}else if(item.xml.equals("zzs")){
									
									if("请选择".equals(item.getData()))
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
	 * 获取车辆登录Map对象 jyxm没有使用
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
				if (itemBars.get(i).titleName.equals("环检基础信息")) {
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
		if (qdxs.equals("4×2后驱后驻车")) {
			qdxsvalue = "2";
			zczsvalue = "1";
			zczwvalue = "2";
		} else if (qdxs.equals("2×1摩托车")) {

		} else if (qdxs.equals("4×2前驱后驻车")) {
			qdxsvalue = "1";
			zczsvalue = "1";
			zczwvalue = "2";
		} else if (qdxs.equals("4×2前驱前驻车")) {
			qdxsvalue = "1";
			zczsvalue = "1";
			zczwvalue = "1";
		} else if (qdxs.equals("4×4全驱后驻车")) {
			qdxsvalue = "12";
			zczsvalue = "1";
			zczwvalue = "2";
		} else if (qdxs.equals("4×4全连驱后驻车")) {
			qdxsvalue = "12";
			zczsvalue = "1";
			zczwvalue = "2";
		} else if (qdxs.equals("6×2后驱后驻车")) {
			qdxsvalue = "3";
			zczsvalue = "1";
			zczwvalue = "3";
		} else if (qdxs.equals("6×2双后浮动桥中驻车")) {
			qdxsvalue = "23";
			zczsvalue = "1";
			zczwvalue = "2";
		} else if (qdxs.equals("6×4双后驱双后驻车")) {
			qdxsvalue = "23";
			zczsvalue = "2";
			zczwvalue = "23";
		} else if (qdxs.equals("6×4双后连驱双后驻车")) {
			qdxsvalue = "23";
			zczsvalue = "2";
			zczwvalue = "23";
		} else if (qdxs.equals("6×6全连驱双后驻车")) {
			qdxsvalue = "123";
			zczsvalue = "3";
			zczwvalue = "123";
		} else if (qdxs.equals("6×2中驱中驻车半挂")) {
			qdxsvalue = "2";
			zczsvalue = "1";
			zczwvalue = "2";
		} else if (qdxs.equals("8×4双后驱双后驻车")) {
			qdxsvalue = "34";
			zczsvalue = "2";
			zczwvalue = "34";
		} else if (qdxs.equals("8×2中驱中驻车半挂")) {
			qdxsvalue = "3";
			zczsvalue = "1";
			zczwvalue = "3";
		} else if (qdxs.equals("8×4双中驱双中驻车半挂")) {
			qdxsvalue = "23";
			zczsvalue = "2";
			zczwvalue = "23";
		} else if (qdxs.equals("8×2后驱后驻车全挂")) {
			qdxsvalue = "4";
			zczsvalue = "1";
			zczwvalue = "4";
		} else if (qdxs.equals("10×6三后驱三后驻车")) {
			qdxsvalue = "345";
			zczsvalue = "3";
			zczwvalue = "345";
		} else if (qdxs.equals("10X4双中驱双中驻车半挂")) {
			qdxsvalue = "34";
			zczsvalue = "2";
			zczwvalue = "34";
		} else if (qdxs.equals("10X2中驱中驻车半挂")) {
			qdxsvalue = "3";
			zczsvalue = "1";
			zczwvalue = "3";
		} else if (qdxs.equals("12X4双中驱双中驻车半挂")) {
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
	 * 获取 数据 for xml
	 * 
	 * @return
	 */
	public String getData2Xml() {
		String result = "";

		for (int i = 0; i < itemBars.size(); i++) {
			if (itemBars.get(i).getVisibility() == View.VISIBLE) {
				if (i == 0) { // 由于格式要求 检测项目 合并为一个 节点
					result += "<jcxm>";
					result += getDataAt(i, false);
					// 现在 检验项目 不足20 ,用0预留 ,补充为20位
					int addExtar = 20 - itemBars.get(i).getItems().size();
					for (int j = 0; j < addExtar; j++) {
						result += "0";
					}
					result += "</jcxm>";
				} else {
					for (InfoItem item : itemBars.get(i).getItems()) {
						// 不判断 不可用得项目
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
	 * 获取指定 项目集 数据
	 * 
	 * @param itemBarInedx
	 *            项目集index
	 * @param is2XML
	 *            是否已xml格式
	 * @return
	 */
	public String getDataAt(int itemBarInedx, boolean is2XML) {
		String result = "";
		InfoItemBar itemBar = this.itemBars.get(itemBarInedx);
		for (InfoItem item : itemBar.getItems()) {
			if (item.isEnabled()) {
				// 为车身颜色而做
				if (is2XML) {
					result += item.getData2Xml();
				} else {
					if (item.xml.equals("csys")) {
						result += Md_Car_Temp.getTempCar().csys;
					} else {
						result += item.getData();
					}
				}
				// 原始
				// if (is2XML)
				// result += item.getData2Xml();
				// else
				// result += item.getData();
			}
		}
		return result;
	}

	/**
	 * 隐藏 项目集
	 * 
	 * @param itemBarIndex
	 * @param visibility
	 */
	public void setVisibilityAt(int itemBarIndex, int visibility) {
		this.itemBars.get(itemBarIndex).setVisibility(visibility);
	}

	/**
	 * 设置 项目数据
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
					// 遍历 所有 项目
					if (item.xmlMatch(xmlKey)) { // 判断该项目 得xml标签是否 匹配
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
	 * 设置 项目数据 开始比对
	 * 
	 * @param datas
	 */
	public void setItemsDataBD(final Map<String, String> datas,
			final Map<String, String> notice_Map) {
		Set<String> keySet = datas.keySet();
		Set<String> notikeyset = notice_Map.keySet();
		boolean isMatch;
		for (String xmlKey : keySet) {
			// 遍历 所有 xmlKey
			isMatch = false;
			for (InfoItemBar itemBar : itemBars) {
				for (InfoItem item : itemBar.getItems()) {
					// 遍历 所有 项目
					if (item.xmlMatch(xmlKey)) { // 判断该项目 得xml标签是否 匹配
//						if (datas.get("bh").equals("0")) {// 如果公告编号为0就不自动比对
//							item.setData(datas.get(xmlKey));
//							isMatch = true;
//						} else {
							for (String notKey : notikeyset) {// 遍历公告信息这样来判断当前
								if (xmlKey.equals(notKey)) {// 判断公告数据与基本数据节点（key）其他节点就不做处理
									if (notice_Map.get(xmlKey).equals(
											datas.get(xmlKey)))// 判断公告数据与基本数据同节点时，比较他们的值是否相等
									{
										item.setData(datas.get(xmlKey));
									} else {// 不相等时做提示
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
	 * 设置 项目数据
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
	 * 设置 项目数据
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
	 * 初始化 分组样式
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
	 * 设置 项目集 是否收缩
	 * 
	 * @param itemBarIndex
	 * @param isShow
	 */
	public void setShow(int itemBarIndex, boolean isShow) {
		this.itemBars.get(itemBarIndex).setShow(isShow);
	}

	/**
	 * 初始化Ede为空
	 */
	public void initEdtNull() {
		for (int i = 0; i < itemBars.size(); i++) {
			if (itemBars.get(i).getVisibility() == View.VISIBLE) {
				for (InfoItem item : itemBars.get(i).getItems()) {
					// 不判断 不可用得项目
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
	 * 设置 指定项目集 初始化
	 */
	public void setDefault(int itemBarIndex) {
		this.itemBars.get(itemBarIndex).setDefault();
	}

	/**
	 * 设置全部 项目集 初始化
	 */
	public void setAllDefault() {
		for (InfoItemBar itemBar : itemBars) {
			itemBar.setDefault();
		}
	}
}
