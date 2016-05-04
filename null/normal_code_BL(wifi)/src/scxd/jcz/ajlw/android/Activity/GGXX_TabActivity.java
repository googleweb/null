package scxd.jcz.ajlw.android.Activity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import scxd.jcz.ajlw.android.Application.MyApplication;
import scxd.jcz.ajlw.android.common.Md_Car_Temp;
import scxd.jcz.ajlw.android.model.MapBeanWDL;
import android.annotation.SuppressLint;
import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TextView;

public class GGXX_TabActivity extends  TabActivity implements OnTabChangeListener {
	/**
	 * ��ǰѡ�е�Tab���
	 */
	private int mCurSelectTabIndex = 0;
	/**
	 * Ĭ��ѡ�е�һ��tabҳ �ƶ���־����
	 */
	private final int INIT_SELECT = 0;
	/**
	 * ��������ִ��ʱ��
	 */
	private final int DELAY_TIME = 500;
	private TabHost mTabHost;
	/**
	 * ���Tabҳ��ImageView��Ϣ
	 */
	public List<LinearLayout> linearLayouts = new ArrayList<LinearLayout>();
	
	
	private ImageView mBack;
	private TextView mHphm;
	private TextView mZyc;
	private TextView mType;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ggxx__tab);
		getView();
		init(savedInstanceState);
	}
	private void getView() {
		// TODO Auto-generated method stub
		mBack=(ImageView) findViewById(R.id.back);
		mHphm=(TextView) findViewById(R.id.hphm);
		mType=(TextView) findViewById(R.id.car_type);
		mZyc=(TextView) findViewById(R.id.zyc);
		mBack.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent=new Intent(GGXX_TabActivity.this, GGXX_ListActivity.class);
				startActivity(intent);
				finish();
			}
		});
	}
	/**
	 * ��ʼ���������
	 */
	private void init(Bundle savedInstanceState) {
		
		// mTabHost = (TabHost) findViewById(R.id.tabhost);
		mTabHost = getTabHost(); // ��Ϊ������TabActivity
		mTabHost.setup();
		Intent intent=getIntent();
		MapBeanWDL beanWDL=	(MapBeanWDL) intent.getExtras().get("BEAN");
		Map<String, String> maop=beanWDL.getWdlMap();
		mHphm.setText(Md_Car_Temp.car_hphm);
		mType.setText(maop.get("car_hpzl"));
		Bundle bundle = intent.getExtras();
		// ������Ϣ
		Intent menuIntent = new Intent(this,
				GGDetailActivity.class);
		menuIntent.putExtras(bundle);//��ֵͨ��bundle������
		mTabHost.addTab(mTabHost
				.newTabSpec("car_infor")
				.setIndicator(
						composeLayout("�����ȶ�"))
				.setContent(menuIntent));
		// �������
		Intent homeIntent = new Intent(this,
				GG_photoActivity.class);
		homeIntent.putExtras(bundle);//��ֵͨ��bundle������
		mTabHost.addTab(mTabHost
				.newTabSpec("out_check")
				.setIndicator(
						composeLayout( "������Ƭ"))
				.setContent(homeIntent));
		
		// getMiddle();
		// ����TabHost�ı�����ɫ
		// tabHost.setBackgroundColor(Color.argb(20, 22, 70, 150));
		mTabHost.setBackgroundResource(R.drawable.tablebar_bg);

		// ���õ�ǰѡ�е�Tabҳ
		mTabHost.setCurrentTab(mCurSelectTabIndex);
		linearLayouts.get(0).setBackgroundDrawable(
				getResources().getDrawable(R.drawable.tab_widget2));
		// TabHost����¼�
		mTabHost.setOnTabChangedListener(this);
		// ��ʼ���ƶ���ʶ�����Ƶ���һ��tabҳ
		initCurSelectTab();
		
		
	}
	/**
	 * ��ʼ��ѡ��Tab����ͼƬ
	 */
	public void initCurSelectTab() {
		// Ĭ��ѡ���ƶ�ͼƬλ��
		Message msg = new Message();
		msg.what = INIT_SELECT;
		initSelectTabHandle.sendMessageDelayed(msg, DELAY_TIME);
	}
	/**
	 * ��ʼ��ѡ��Tab����ͼƬ��Handler
	 */
	@SuppressLint("HandlerLeak")
	private Handler initSelectTabHandle = new Handler() {
		public void handleMessage(Message msg) {
			switch (msg.what) {
			case INIT_SELECT:
				moveTopSelect(MyApplication.tableindex);
				break;
			default:
				break;
			}
			super.handleMessage(msg);
		}
	};
	/**
	 * �ƶ�tabѡ�б�ʶͼƬ
	 * 
	 * @param selectIndex
	 * @param curIndex
	 */
	public void moveTopSelect(int selectIndex) {

		MyApplication.tableindex = selectIndex;
		// �ı䵱ǰѡ�а�ť����
		mCurSelectTabIndex = selectIndex;
	}
	/**
	 * ƴװ��view
	 * 
	 * @param ͼƬ
	 * @param ����
	 * @return
	 */
	public View composeLayout( String  t) {
		View view;
		LayoutInflater inflater = LayoutInflater.from(this);
		view = inflater.inflate(R.layout.tab_bottom, null);
		LinearLayout layout = (LinearLayout) view.findViewById(R.id.tab_layout);
		ImageView iv = (ImageView) view.findViewById(R.id.tab_img);
		TextView text = (TextView) view.findViewById(R.id.tab_name);
		linearLayouts.add(layout);
		layout.setBackgroundResource(R.drawable.tab_widget);
//		iv.setImageResource(i);
		text.setText(t);
		return view;
	}

	@Override
	public void onTabChanged(String tabId) {
		// TODO Auto-generated method stub
		linearLayouts.get(0).setBackgroundDrawable(
				getResources().getDrawable(R.drawable.tab_widget));
		linearLayouts.get(1).setBackgroundDrawable(
				getResources().getDrawable(R.drawable.tab_widget));
		

		if (tabId.equalsIgnoreCase("car_infor")) {
			linearLayouts.get(0).setBackgroundDrawable(
					getResources().getDrawable(R.drawable.tab_widget2));
			// �ƶ��ײ�����ͼƬ
			moveTopSelect(0);
		} else if (tabId.equalsIgnoreCase("out_check")) {
			linearLayouts.get(1).setBackgroundDrawable(
					getResources().getDrawable(R.drawable.tab_widget2));
			// �ƶ��ײ�����ͼƬ
			moveTopSelect(1);
		} 

	}


}
