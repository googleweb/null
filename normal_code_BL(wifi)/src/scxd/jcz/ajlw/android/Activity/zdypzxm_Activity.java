package scxd.jcz.ajlw.android.Activity;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import scxd.jcz.ajlw.android.Activity.Common.DefautDialog;
import scxd.jcz.ajlw.android.common.Md_Car_Temp;
import scxd.jcz.ajlw.android.model.MD_Xml_Wjxm;
import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
/**
 * 自定义拍照项目
 * @author Administrator
 *@time
 */
public class zdypzxm_Activity extends Activity {

	Button bcbt = null;
	CheckBox[] cb = new CheckBox[9];
	ArrayList a = new ArrayList();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Application_Activity.getApplication_Exit().addActivity(this);
		setContentView(R.layout.zdypzxm);
		cb[0] = (CheckBox) findViewById(R.id.hpsb);
		cb[1] = (CheckBox) findViewById(R.id.fdjh);
		cb[2] = (CheckBox) findViewById(R.id.wgzp);
		cb[3] = (CheckBox) findViewById(R.id.cnzqxh);
		cb[4] = (CheckBox) findViewById(R.id.qita);
		cb[5] = (CheckBox) findViewById(R.id.aqscpz);
		cb[6] = (CheckBox) findViewById(R.id.xsjlypz);
		cb[7] = (CheckBox) findViewById(R.id.tczsbz);
		cb[8] = (CheckBox) findViewById(R.id.mhqpz);
		bcbt = (Button) findViewById(R.id.bcbt);
		bcbt.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Md_Car_Temp.getTempCar().str = null;
				StringBuffer sb = new StringBuffer();
				sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?><root><body>");
				for (int i = 0; i < a.size(); i++) {
					String ii = (String) a.get(i);
					switch (Integer.parseInt(ii)) {
					case 0:
						sb.append("<zplist><id>87</id>");
						sb.append("<name>号牌识别</name>");
						sb.append("<code>87</code></zplist>");
						break;
					case 1:
						sb.append("<zplist><id>79</id>");
						sb.append("<name>发动机号码</name>");
						sb.append("<code>79</code></zplist>");
						break;
					case 2:
						sb.append("<zplist><id>84</id>");
						sb.append("<name>外观照片</name>");
						sb.append("<code>84</code></zplist>");
						break;
					case 3:
						sb.append("<zplist><id>15</id>");
						sb.append("<name>车内最前方向后拍照</name>");
						sb.append("<code>15</code></zplist>");
						break;
					case 4:
						sb.append("<zplist><id>0</id>");
						sb.append("<name>其它</name>");
						sb.append("<code>0</code></zplist>");
						break;
					case 5:
						sb.append("<zplist><id>17</id>");
						sb.append("<name>安全手锤拍照</name>");
						sb.append("<code>17</code></zplist>");
						break;
					case 6:
						sb.append("<zplist><id>18</id>");
						sb.append("<name>行驶记录仪拍照</name>");
						sb.append("<code>18</code></zplist>");
						break;
					case 7:
						sb.append("<zplist><id>81</id>");
						sb.append("<name>停车指示标志</name>");
						sb.append("<code>81</code></zplist>");
						break;
					case 8:
						sb.append("<zplist><id>16</id>");
						sb.append("<name>灭火器拍照</name>");
						sb.append("<code>16</code></zplist>");
						break;
					}
				}
				sb.append("</body></root>");
				Md_Car_Temp.getTempCar().str = sb.toString();
				if (addDataList(addListMXN())) {
					finish();
				} else {
					DefautDialog.showDialog(
							zdypzxm_Activity.this,
							zdypzxm_Activity.this.getResources().getString(
									R.string.SYS_TITLE), "自定义照片失败！请重试", false,
							new DefautDialog.OnClickListener() {
								@Override
								public void onClick(DefautDialog dialog,
										View arg0) {
									dialog.dimiss();
									finish();
								}
							}, null);
				}
			}
		});
		cb[0].setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				if (isChecked && !a.contains("0")) {
					a.add("0");
				} else if (!isChecked) {
					a.remove("0");
				}
			}
		});
		cb[1].setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				if (isChecked && !a.contains("1")) {
					a.add("1");
				} else if (!isChecked) {
					a.remove("1");
				}
			}
		});
		cb[2].setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				if (isChecked && !a.contains("2")) {
					a.add("2");
				} else if (!isChecked) {
					a.remove("2");
				}
			}
		});
		cb[3].setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				if (isChecked && !a.contains("3")) {
					a.add("3");
				} else if (!isChecked) {
					a.remove("3");
				}
			}
		});
		cb[4].setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				if (isChecked && !a.contains("4")) {
					a.add("4");
				} else if (!isChecked) {
					a.remove("4");
				}
			}
		});
		cb[5].setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				if (isChecked && !a.contains("5")) {
					a.add("5");
				} else if (!isChecked) {
					a.remove("5");
				}
			}
		});
		cb[6].setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				if (isChecked && !a.contains("6")) {
					a.add("6");
				} else if (!isChecked) {
					a.remove("6");
				}
			}
		});
		cb[7].setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				if (isChecked && !a.contains("7")) {
					a.add("7");
				} else if (!isChecked) {
					a.remove("7");
				}
			}
		});
		cb[8].setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				if (isChecked && !a.contains("8")) {
					a.add("8");
				} else if (!isChecked) {
					a.remove("8");
				}
			}
		});

		initState();
		deleteCFX();
	}

	/**
	 * 监听平板返回按键按下事件
	 */
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		return false;
	}

	private ArrayList strCFX =null;

	private void deleteCFX() {
		if (strCFX != null && strCFX.size() != 0) {
			for (int i = 0; i < strCFX.size(); i++) {
				for(int j=0;j<Md_Car_Temp.getTempCar().mDataList.size();j++){
					if(strCFX.get(i).equals(Md_Car_Temp.getTempCar().mDataList.get(j)
					.get("pz_code").toString())){
						Md_Car_Temp.getTempCar().mDataList.remove(j);
					}
				}
			}
		}
		strCFX=null;
	}

	private void initState() {
		for (int i = 0; i < Md_Car_Temp.getTempCar().mDataList.size(); i++) {
			if (Md_Car_Temp.getTempCar().mDataList == null) {
				Md_Car_Temp.getTempCar().mDataList = new ArrayList<Map<String, Object>>();
			}
			String code = Md_Car_Temp.getTempCar().mDataList.get(i)
					.get("pz_code").toString();
			switch (Integer.parseInt(code)) {
			case 87:
				if(strCFX==null){
					strCFX=new ArrayList();
				}
				cb[0].setChecked(true);
				strCFX.add(code);
				continue;
			case 79:
				if(strCFX==null){
					strCFX=new ArrayList();
				}
				cb[1].setChecked(true);
				strCFX.add(code);
				continue;
			case 84:
				if(strCFX==null){
					strCFX=new ArrayList();
				}
				cb[2].setChecked(true);
				strCFX.add(code);
				continue;
			case 15:
				if(strCFX==null){
					strCFX=new ArrayList();
				}
				cb[3].setChecked(true);
				strCFX.add(code);
				continue;
			case 0:
				if(strCFX==null){
					strCFX=new ArrayList();
				}
				cb[4].setChecked(true);
				strCFX.add(code);
				continue;
			case 17:
				if(strCFX==null){
					strCFX=new ArrayList();
				}
				cb[5].setChecked(true);
				strCFX.add(code);
				break;
			case 18:
				if(strCFX==null){
					strCFX=new ArrayList();
				}
				cb[6].setChecked(true);
				strCFX.add(code);
				continue;
			case 81:
				if(strCFX==null){
					strCFX=new ArrayList();
				}
				cb[7].setChecked(true);
				strCFX.add(code);
				continue;
			case 16:
				if(strCFX==null){
					strCFX=new ArrayList();
				}
				cb[8].setChecked(true);
				strCFX.add(code);
				continue;
			}
		}
	}

	private List<MD_Xml_Wjxm> addListMXN() {
		Document doc1 = null;
		List<MD_Xml_Wjxm> listMXN = null;
		try {
			listMXN = new ArrayList<MD_Xml_Wjxm>();
			if (Md_Car_Temp.getTempCar().str != null) {
				doc1 = DocumentHelper.parseText(URLDecoder.decode(Md_Car_Temp
						.getTempCar().str));
				Element root = doc1.getRootElement();
				Iterator iterbody = root.elementIterator("body");
				while (iterbody.hasNext()) {
					Element recordEless = (Element) iterbody.next();
					Iterator itersElIterator = recordEless
							.elementIterator("zplist");
					while (itersElIterator.hasNext()) {
						Element itemEle = (Element) itersElIterator.next();
						String id = URLDecoder_Str(itemEle
								.elementTextTrim("id"));
						String name = URLDecoder_Str(itemEle
								.elementTextTrim("name"));
						String zp_code = URLDecoder_Str(itemEle
								.elementTextTrim("code"));

						listMXN.add(new MD_Xml_Wjxm("", zp_code, "", name,
								zp_code, id, "0"));
					}
				}
			}
		} catch (Exception e) {
			return null;
		}
		return listMXN;
	}

	private boolean addDataList(List<MD_Xml_Wjxm> listMXN) {
		if (listMXN != null && listMXN.size() > 0
				&& Md_Car_Temp.getTempCar().mDataList != null) {
			for (int i = 0; i < listMXN.size(); i++) {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("pz_img", R.drawable.camera2);
				map.put("pz_xm", listMXN.get(i).name);
				map.put("pz_code", listMXN.get(i).code);
				map.put("property", listMXN.get(i).property);
				if (!Md_Car_Temp.getTempCar().mDataList.contains(map)) {
					Md_Car_Temp.getTempCar().mDataList.add(map);
					if(Md_Car_Temp.getTempCar().zdyPZXM==null){
						Md_Car_Temp.getTempCar().zdyPZXM=new ArrayList<String>();
					}
					Md_Car_Temp.getTempCar().zdyPZXM.add(listMXN.get(i).code);
				}
			}
			Md_Car_Temp.getTempCar().carPhotoBooeal = true;
			return true;
		}
		return false;
	}

	private static String URLDecoder_Str(String str) {
		try {
			return URLDecoder.decode(str, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			return str;
		}
	}
}
