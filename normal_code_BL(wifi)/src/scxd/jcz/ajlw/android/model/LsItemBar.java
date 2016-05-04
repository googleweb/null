package scxd.jcz.ajlw.android.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import scxd.jcz.ajlw.android.Activity.R;
import scxd.jcz.ajlw.android.common.Md_Car_Temp;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;

/**
 * ·����Ŀ ��
 * @author wdn
 *
 */
public class LsItemBar extends LinearLayout {

	private int jcxm ;	
	private String xmmc ;	//xml���� ��Ŀ ��ʾ
	/**
	 * ·����Ա
	 */
	private Spinner lsrySpinner ;
	private ArrayAdapter<String> adapter ;
	private ArrayList<String> lsryList ;
	
	/**
	 * ·����Ŀ
	 */
	private HashMap<String, LsItem> items = new HashMap<String, LsItem>() ;
	
	public LsItemBar(Context context, AttributeSet attrs) {
		super(context, attrs);
		LayoutInflater.from(context).inflate(R.layout.ls_lsry_layout, this) ;
		this.lsrySpinner = (Spinner) findViewById(R.id.ls_spinner_people) ;
		this.lsryList = LsPeopleProvider.getInstance(context).query() ;//��ȡ·����Ա�б�
		this.adapter = new ArrayAdapter<String>(
				context, 
				android.R.layout.simple_spinner_item, 
				lsryList) ; 
		this.adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		this.lsrySpinner.setAdapter(adapter) ;
				
	}
	
	/**
	 * ���·����Ŀ
	 * @param key
	 * @param view
	 */
	public void addItem(String key ,LsItem item){
		this.items.put(key, item) ;
		this.addView(item , 1) ;
	}
	
	/**
	 * �Ƿ� ��ȱʡ��
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public boolean isComplete(){
		try {
			if (!lsrySpinner.getSelectedItem().toString().equals("")) {
				Iterator iterator = items.entrySet().iterator();
				while (iterator.hasNext()) {
					Map.Entry entry = (Entry) iterator.next() ;
//				����Object key = entry.getKey();
					if(((LsItem) entry.getValue()).getData().equals(""))
						throw new Exception() ;
				} 
			}
		} catch (Exception e) {
			return false ;
		}
		return true ;
	}
	
	/**
	 * ��ʾ ��Ŀ����
	 * @param xml
	 */
	public void setItemsData(HashMap<String, String> itemsDataMap){
//		Log.e("itemsData", itemsDataMap.toString()) ;
		try {
			/**
			 * ���� ·����Ա 
			 * �����·����Ա�Ѿ���ɾ�� �� ��ʱ�����б�,��δ���뱾�����ݿ�
			 */
			String lsry = itemsDataMap.get(this.xmmc.toLowerCase()+"-username") ;
			Log.e("itemsData", lsry) ;
			boolean ishaveLsry = false ;
			for (int i=0 ;i<lsryList.size() ;i++) {
				if(lsryList.get(i).equals(lsry)) {
					lsrySpinner.setSelection(i) ;
					ishaveLsry = true ;
				}
			}
			if(!ishaveLsry){
				lsryList.add(0 ,lsry);
				lsrySpinner.setSelection(0) ;
			}
			this.adapter.notifyDataSetChanged() ;
			
			/**
			 * ���� ·����Ŀ �����������
			 */
			Iterator iterator = items.entrySet().iterator();
			while (iterator.hasNext()) {
				Map.Entry entry = (Entry) iterator.next() ;
				String key = (String) entry.getKey() ;
				LsItem item = (LsItem) entry.getValue() ;
//				Log.e("item", this.xmmc+"-"+key + "   " + this.xmmc+"-"+key+"pd") ;
			
				String data = itemsDataMap.get(this.xmmc.toLowerCase()+"-"+key) ;
				boolean ispass = itemsDataMap.get(this.xmmc.toLowerCase()+"-"+key+"pd").equals("1") ? true : false ;
				item.setData(data, ispass) ;
			}
		} catch (Exception e) {
//			Log.d(this.xmmc, "û������");
		}
				
	}
	
	/**
	 * @return xml for items ��װxml�ļ�
	 */
	public String getItemsForXml(){
		//spiner��û������ʱ  ��ȡѡ����  �쳣
		String itemDataXml = "" ;
		try {
			itemDataXml = String.format("<?xml version=\"1.0\" encoding=\"GBK\"?>" +
				"<root>" +
				"<veh>" + 
				"<jclsh>%s</jclsh>"+
				"<hphm>%s</hphm> "+
				"<hpzl>%s</hpzl>"+
				"<cllx>%s</cllx>"+
				"<clsbdh>%s</clsbdh>"+
				"<jcxm>%s</jcxm>"+	
				"<xmmc>%s</xmmc>"+
				"<username>%s</username>", 
				Md_Car_Temp.getTempCar().car_lsh,
				Md_Car_Temp.getTempCar().car_hphm,
				Md_Car_Temp.getTempCar().car_hpzl,
				Md_Car_Temp.getTempCar().car_lx,
				Md_Car_Temp.getTempCar().car_vin,
				this.jcxm,
				this.xmmc,
				lsrySpinner.getSelectedItem().toString()) ;

			Iterator iterator = items.entrySet().iterator();
			while (iterator.hasNext()) {
				Map.Entry entry = (Entry) iterator.next() ;
//			����Object key = entry.getKey();
				//��ȡ ÿ��Item ���� �� xml��ʽ
				itemDataXml += ((LsItem) entry.getValue()).getData() ;
			}
			
		} catch (Exception e) {
			itemDataXml = "" ;
		}
		return itemDataXml ;
	}
	/**
	 * @param jcxm
	 * @param xmmc
	 */
	public void setItemTitle(int jcxm ,String xmmc){
		this.jcxm = jcxm ;
		this.xmmc = xmmc ;
	}
	
	public String getXmmc(){
		return this.xmmc ;
	}
	
	public void setDisable(){
		lsrySpinner.setEnabled(false) ;
		Iterator iterator = items.entrySet().iterator();
		while (iterator.hasNext()) {
			Map.Entry entry = (Entry) iterator.next() ;
//		����Object key = entry.getKey();
			((LsItem) entry.getValue()).setDisable() ;
				
		}
	}
	
}
