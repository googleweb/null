package scxd.jcz.ajlw.android.model;

import java.util.List;
import java.util.Map;
import java.util.Set;

import scxd.jcz.ajlw.android.Activity.R;
import scxd.jcz.ajlw.android.Adapter.CSYS_Adapter;
import scxd.jcz.ajlw.android.common.MD_ListItem;
import scxd.jcz.ajlw.android.common.Md_Car_Temp;
import scxd.jcz.ajlw.android.db.CarTypeTabHelper;
import scxd.jcz.ajlw.android.util.PromptUtils;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

/**
 * 文本框 项目
 * 
 * @author wdn
 * 
 */
public class InfoItemEdt extends InfoItem {

	private String xml;
	private EditText edit;
	private String match;
	private boolean isAllowEmpty;
	private PopupWindow popView;
	private MyAdapter dropDownAdapter;
	private CSYS_Adapter csys_Adapter;
	private Context context;
	StringBuilder str;

	/**
	 * 普通构造
	 * 
	 * @param context
	 * @param title
	 *            显示标题
	 * @param danwei
	 *            单位
	 * @param xml
	 *            传输与加载数据检验 xml
	 * @param inputLimit
	 *            输入限制
	 * @param match
	 *            正则表达式
	 * @param isAllowEmpty
	 *            是否 允许为空
	 */
	public InfoItemEdt(Context context, String title, String danwei,
			String xml, int inputLimit, String match, boolean isAllowEmpty) {
		super(context, R.layout.item_type_edt, xml, title);
		this.xml = xml;
		this.match = match;
		this.isAllowEmpty = isAllowEmpty;
		this.edit = (EditText) findViewById(R.id.carlogin_item_edit);
		this.context = context;
		TextView titleTextView = (TextView) findViewById(R.id.carlogin_item_txt);
		titleTextView.setText(title + " : ");
		if (danwei != null) {
			TextView danweiTextView = (TextView) findViewById(R.id.item_style_danwei);
			danweiTextView.setText(danwei);
		}
		edit.setInputType(inputLimit);
		if (isAllowEmpty)
			edit.setHint("");
		if ("dlysfzh".equals(xml)) {
			edit.setText(Md_Car_Temp.getTempCar().jyysfzh);
		}
		if (xml.equals("csys")) {
			edit.setFocusable(false);
			edit.setOnClickListener(edit_Click);
		}
		if ("cllx".equals(xml)) {
			edit.setFocusable(false);
			edit.setOnClickListener(edit_ClickCLLX);
		}

	}

	public void hideSoftInputPanel(EditText editText) {
		if (editText == null) {
			return;
		}
		InputMethodManager imm = (InputMethodManager) context
				.getApplicationContext().getSystemService(
						Activity.INPUT_METHOD_SERVICE);
		imm.hideSoftInputFromWindow(editText.getWindowToken(), 0);
	}

	private OnClickListener edit_ClickCLLX = new OnClickListener() {

		@Override
		public void onClick(View arg0) {
			showListDialog();
		}
	};

	private void showListDialog() {

		View popView = LayoutInflater.from(context).inflate(
				R.layout.cllx_layout, null);
		final AutoCompleteTextView text = (AutoCompleteTextView) popView
				.findViewById(R.id.autotext);
		Button sumbit = (Button) popView.findViewById(R.id.sumbit);
		Button query = (Button) popView.findViewById(R.id.query);
		
		sumbit.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				String cl = text.getText().toString().trim();
				if (MD_ListItem.GetCllxString(cl) != null) {
					edit.setText(MD_ListItem.GetCllxString(cl));
					PromptUtils.closeAlertDialog();
				} else {
					Toast.makeText(context, "无法匹配当前车辆类型", 1).show();
				}
			}
		});
		initAutoComplete(text);
		final ListView car_listview = (ListView) popView.findViewById(R.id.car_mohu);
		cartypes = MD_ListItem.Get_cllx();
		adapter = new ArrayAdapter<Md_cartype>(
				context, R.layout.autoview,cartypes );
		car_listview.setAdapter(adapter);
		car_listview.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				edit.setText(cartypes.get(arg2).value);
				PromptUtils.closeAlertDialog();

			}
		});
		query.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				String type = text.getText().toString().trim();
				if (!"".equals(type)) {
					CarTypeTabHelper carTypeTabHelper = CarTypeTabHelper
							.getInstance();
					 cartypes = carTypeTabHelper.likequery(type);
					 adapter= new ArrayAdapter<Md_cartype>(
								context, R.layout.autoview,cartypes );
					 car_listview.setAdapter(adapter);
					 
					
				} else {
					cartypes = MD_ListItem.Get_cllx();
					adapter = new ArrayAdapter<Md_cartype>(
							context, R.layout.autoview,cartypes );
					car_listview.setAdapter(adapter);
				}
			}
		});
		PromptUtils.showAlertDialog(context, "提示：", popView, "车辆类型", "返  回",
				new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						PromptUtils.closeAlertDialog();
					}
				});
	}

	private void initAutoComplete(AutoCompleteTextView auto) {
		final int size = MD_ListItem.Get_cllxArray().size();
		String[] arr = (String[]) MD_ListItem.Get_cllxArray().toArray(
				new String[size]);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(context,
				R.layout.autoview, arr);
		// 只保留最近的50条的记录
		/*
		 * if (hisArrays.length > 50) { String[] newArrays = new String[50];
		 * System.arraycopy(hisArrays, 0, newArrays, 0, 50); adapter = new
		 * ArrayAdapter<String>(context, R.layout.autoview, newArrays); }
		 */
		auto.setAdapter(adapter);
		auto.setDropDownHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
		auto.setThreshold(2);
		// auto.setCompletionHint("滑动查看最近的5条记录");
		auto.setOnFocusChangeListener(new View.OnFocusChangeListener() {

			@Override
			public void onFocusChange(View v, boolean hasFocus) {
				AutoCompleteTextView view = (AutoCompleteTextView) v;
				if (!hasFocus) {
					view.showDropDown();
				}

			}
		});

	}

	private OnClickListener edit_Click = new OnClickListener() {

		@Override
		public void onClick(View v) {
			if (popView != null) {
				popView.dismiss();
				popView = null;
			}
			ListView listView = new ListView(context);
			popView = new PopupWindow(listView, edit.getWidth(),
					ViewGroup.LayoutParams.WRAP_CONTENT, false);
			Button ltggButton = new Button(context);
			ltggButton.setText("确定选择");
			ltggButton.setOnClickListener(click);
			hideSoftInputPanel(edit);
			csys_Adapter = new CSYS_Adapter(MD_ListItem.Get_colors(), context,
					popView, edit);
			// dropDownAdapter = new MyAdapter(context,
			// MD_ListItem.Get_colors()); // 车身颜色pop弹出

			listView.setOnItemClickListener(item_click);
			listView.addHeaderView(ltggButton);
			listView.setAdapter(csys_Adapter);
			listView.setCacheColorHint(Color.parseColor("#EBEBEB"));
			listView.setBackgroundColor(Color.parseColor("#EBEBEB"));

			popView.setFocusable(true);
			popView.setOutsideTouchable(true);
			popView.showAsDropDown(edit);

		}
	};
	private OnClickListener click = new OnClickListener() {

		@SuppressWarnings("static-access")
		@Override
		public void onClick(View v) {
			Map<Integer, String> dataMap = csys_Adapter.getCheckDate();

			if (str == null) {
				str = new StringBuilder();
			} else {
				str = null;
				str = new StringBuilder();
			}
			if (csys_Adapter.getCheckDate().size() > 0) {
				Set<Integer> keyset = dataMap.keySet();

				for (int i : keyset) {
					if ("".equals(str.toString())) {
						str.append(dataMap.get(i));
					} else {
						str.append(",");
						str.append(dataMap.get(i));
					}
				}

				edit.setText(str.toString());
			}

			popView.dismiss();

		}
	};
	private OnItemClickListener item_click = new OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			edit.setText(((Md_cartype) dropDownAdapter.getItem(position))
					.getValue());
			popView.dismiss();
		}
	};
	private ArrayAdapter<Md_cartype> adapter;
	private List<Md_cartype> cartypes;

	/**
	 * 带默认值 构造
	 * 
	 * @param context
	 * @param title
	 * @param danwei
	 * @param defaultValue
	 *            默认值
	 * @param xml
	 * @param inputLimit
	 * @param match
	 * @param isAllowEmpty
	 */
	public InfoItemEdt(Context context, String title, String danwei,
			String defaultValue, String xml, int inputLimit, String match,
			boolean isAllowEmpty) {
		super(context, R.layout.item_type_edt, xml, title);
		this.xml = xml;
		this.match = match;
		this.isAllowEmpty = isAllowEmpty;
		this.edit = (EditText) findViewById(R.id.carlogin_item_edit);
		TextView titleTextView = (TextView) findViewById(R.id.carlogin_item_txt);
		titleTextView.setText(title + " : ");
		if (danwei != null) {
			TextView danweiTextView = (TextView) findViewById(R.id.item_style_danwei);
			danweiTextView.setText(danwei);
		}
		edit.setInputType(inputLimit);
		if (isAllowEmpty)
			edit.setHint("允许为空");
		// 设置默认
		edit.setText(defaultValue);
	}

	@Override
	public String getData() {
		if (xml.equals("csys")) {
			if (edit.getText().toString().toUpperCase().trim().equals("")) {
				return "";
			}
			String values = "";
			try {
				char[] chars = edit.getText().toString().toUpperCase().trim()
						.replace(",", "").toCharArray();
				if (chars.length > 0) {
					for (int i = 0; i < chars.length; i++) {
						char[] cs = { chars[i] };
						String csys = new String(cs);
						if (!values.equals("")) {
							values = values + MD_ListItem.Get_colors3(csys);
						} else {
							values = MD_ListItem.Get_colors3(csys);
						}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			Md_Car_Temp.getTempCar().csys = values;
			return values;
		} else if ("cllx".equals(xml)) {
			String data = edit.getText().toString().toUpperCase().trim();
			String values = "";
			if (!"".equals(data)) {
				for (int i = 0; i < MD_ListItem.Get_cllx().size(); i++) {
					if (MD_ListItem.Get_cllx().get(i).getValue().equals(data)) {
						values = MD_ListItem.Get_cllx().get(i).getName();
						break;
					}
				}
			}
			return values;
		} else {
			return edit.getText().toString().toUpperCase().trim();
		}
		// return match;
	}

	/**
	 * double i = 1704; double c; c = (double) (i / 1000); BigDecimal b = new
	 * BigDecimal(c); double f1 =
	 * b.setScale(1,BigDecimal.ROUND_UP).doubleValue();
	 * 
	 * 最终效果1.8
	 */
	@Override
	public void setData(String data) {
		if (xml.equals("pl")) {
			System.out.println(data);
		}
		if ("cllx".equals(xml)) {
			for (int i = 0; i < MD_ListItem.Get_cllx().size(); i++) {
				if (MD_ListItem.Get_cllx().get(i).getName().equals(data)) {
					data = MD_ListItem.Get_cllx().get(i).getValue();
					break;
				}
			}
		}

		edit.setText(data);
		// if (xml.equals("pl")) {
		// int pl = 0;
		// if (Md_Car_Temp.getTempCar().isQuery) {
		// try {
		// pl = Integer.parseInt(data);
		// if (pl != 0) {
		// float plf = pl / 1000;
		// edit.setText(Float.toString(plf));
		// } else {
		// edit.setText("");
		// }
		// } catch (Exception e) {
		// edit.setText(data);
		// }
		// } else {
		// edit.setText(data);
		// }
		// } else {
		// edit.setText(data);
		// }
	}

	@Override
	public boolean isPassed() {
		if (!isAllowEmpty)
			return !edit.getText().toString().trim().equals("");
		return true;
	}

	@Override
	public boolean isMatch() {
		// if (isAllowEmpty && edit.getText().toString().trim().equals(""))
		// return true;
		// else {
		// if (match != null)
		// return edit.getText().toString().trim().replace(" ", "")
		// .matches(this.match);
		// return true;
		// }
		if (isAllowEmpty) {
			return true;
		} else {
			if (edit.getText().toString().trim().equals("")) {
				edit.setFocusable(true);
				edit.requestFocus();
				return false;
			} else {
				if (match != null) {
					return edit.getText().toString().trim().replace(" ", "")
							.matches(this.match);
				}
				return true;
			}
		}
	}

	@Override
	public void setEnabled(boolean enabled) {
		super.setEnabled(enabled);
		this.edit.setEnabled(enabled);
		this.edit.setText("");
		if (!enabled) {
			this.edit.setHint("不用输入");
		} else {
			this.edit.setHint("");
		}
	}

	public EditText geteEditText() {
		return edit;
	}

	@Override
	public void setDefault() {
		this.edit.setText("");
	}

	class MyAdapter extends BaseAdapter {

		private List<Md_cartype> data;
		private Context con;
		private LayoutInflater mflater;

		public MyAdapter(Context context, List<Md_cartype> data) {
			this.data = data;
			this.con = context;
			mflater = LayoutInflater.from(con);
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return data.size();
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return data.get(position);
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			if (convertView == null) {
				convertView = mflater.inflate(R.layout.editauto, null);
			}
			TextView auto = (TextView) convertView.findViewById(R.id.textview);
			auto.setText(((Md_cartype) data.get(position)).getValue());
			return convertView;
		}

	}

	@Override
	public void setData(String data, boolean b) {
		edit.setText(data);
		edit.setTextColor(Color.RED);

	}
}
