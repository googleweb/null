package scxd.jcz.ajlw.android.Activity;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import scxd.jcz.ajlw.android.Activity.Common.BaseActivity;
import scxd.jcz.ajlw.android.Activity.Common.FileUtil;
import scxd.jcz.ajlw.android.Activity.Common.PromptUtils;
import scxd.jcz.ajlw.android.Activity.Common.ResponseFactory;
import scxd.jcz.ajlw.android.common.Md_Car_Temp;
import scxd.jcz.ajlw.android.model.MapBeanWDL;
import android.app.Activity;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class GG_photoActivity extends BaseActivity {
	/**
	 * ��ʾ��Ԥ������
	 */
private TextView txtCameraImgv;
/**
 * ��ʾͼƬ
 */
private ImageView mImageView;
/**
 * ��߰�ť
 */
private View left_shake;
/**
 * �ұ߰�ť
 */
private View right_shake;
/**
 * ��ʾ����1/5
 */
private TextView bottom_shake;
Map<String, Object> requestMap = null;
Map<String, Object> requesGGXXMap = null;
Map<String, Object> requesGGZPMap = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_gg_photo);
		getView();
		queryGGZP();
	}
	private void getView() {
		txtCameraImgv=(TextView) findViewById(R.id.txtCameraImgv);
		mImageView=(ImageView) findViewById(R.id.imgvCamera);
		left_shake=findViewById(R.id.left_shake);
		right_shake=findViewById(R.id.right_shake);
		bottom_shake=(TextView) findViewById(R.id.bottom_shake);
				
				
				
				
	}
	
	/**
	 * ������Ƭ��ѯ
	 */
	private void queryGGZP() {
	MapBeanWDL beanWDL=	(MapBeanWDL) getIntent().getExtras().get("BEAN");
	Map<String, String> maop=beanWDL.getWdlMap();
	String ggbh=maop.get("bh");
	Md_Car_Temp.getTempCar().ggbh=ggbh;
		try {
			FileUtil.deleteFilesByDirectory(new File(
					"/mnt/sdcard/jclwjcz/ggimage/"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (requestMap != null) {
			requestMap = null;
		}
		if (requesGGZPMap != null) {
			requesGGZPMap = null;
		}
		if (!"".equals(ggbh)) {
			//Md_Car_Temp.getTempCar().ggcxlx = "ggzpcx";
		//	Md_Car_Temp.getTempCar().ggbh = bh.getData().trim();
			requestMap = new HashMap<String, Object>();
			requesGGZPMap = new HashMap<String, Object>();
			requesGGZPMap.put("ggbh", ggbh);
			requestMap.put("QueryCondition", requesGGZPMap);
			request("18C09", requestMap, R.string.QUERY_CAR_GGZPINFO,
					new String[] { "2" });
		} else {
			Toast.makeText(this, "��Ƭ��Ų���Ϊ�գ�", 1000).show();
			bottom_shake.setText(0+"/"+0);
			return;
		}
	}
	@Override
	public void onRequestSuccess(String jkid, Object result) {
		 if ("18C09".equals(jkid)) {
				Map<String, Object> responseMap = (Map<String, Object>) result;
				if (!responseMap.get("code").equals("0")) {
					showGGZP((String) responseMap.get("zpbh"));
				} else {
					//Toast.makeText(this, "û�в�ѯ��������Ƭ��", 1000).show();
					txtCameraImgv.setText("�޹�����Ƭ");  
					bottom_shake.setText(0+"/"+0);
				}
			}
	}

	private String[] zpbhs = null;
	private int surI = 0;
/**
 * ��ʾ������Ƭ
 * @param zpbh
 */
	/**
	 * ��ʾ������Ƭ
	 * @param zpbh
	 */
		
	/**
	 * ��ȡͼƬ�ڱ���·��
	 * @param zpbh ��Ƭ���
	 * @return ·��
	 */
		private String getImagePath(String zpbh) {
			return "/mnt/sdcard/jclwjcz/ggimage/" + Md_Car_Temp.getTempCar().ggbh
					+ "/" + zpbh + ".jpg";
			// return "/mnt/sdcard/jclwjcz/ggimage/888888/" + zpbh + ".png";
		}
	/**
	 * ͨ����Ƭ·�����λͼ
	 * @param imagePath
	 * @return
	 */
		private Bitmap getBitmap(String imagePath) {
			Bitmap bitmap = BitmapFactory.decodeFile(imagePath);
			return bitmap;
		}
	private void showGGZP(String zpbh) {
		try {
			if (zpbh.equals("")) {
				Toast.makeText(GG_photoActivity.this, "û�в�ѯ��������Ƭ��", 1000).show();
				return;
			}
			surI = 0;
			zpbhs = zpbh.split(",");
			zpbh = "";
			final int length=zpbhs.length;
			if(length>0){
			left_shake.setVisibility(View.VISIBLE);
			right_shake.setVisibility(View.VISIBLE);
			
			
			
			left_shake.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View v) {
					if (surI >= 1) {
						surI = surI - 1;
						mImageView
								.setImageBitmap(getBitmap(getImagePath(zpbhs[surI])));
						bottom_shake.setText(surI+1+"/"+length);
					} else {
						Toast.makeText(GG_photoActivity.this, "����һ����Ƭ�ˣ�", 1000)
								.show();
					}
				}
			});
			right_shake.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View v) {
					if (surI < (length - 1)) {
						surI++;
						mImageView
								.setImageBitmap(getBitmap(getImagePath(zpbhs[surI])));
						bottom_shake.setText(surI+1+"/"+length);
					} else {
						Toast.makeText(GG_photoActivity.this, "����һ����Ƭ�ˣ�", 1000)
								.show();
					}
				}
			});
			txtCameraImgv.setVisibility(View.GONE);
			mImageView.setVisibility(View.VISIBLE);
			mImageView
			.setImageBitmap(getBitmap(getImagePath(zpbhs[surI])));
			bottom_shake.setText(surI+1+"/"+length);
			}else{
				txtCameraImgv.setText("�޹�����Ƭ");  
			}
			
		} catch (Exception e) {
			Toast.makeText(GG_photoActivity.this, "û�в�ѯ��������Ƭ������", 1000).show();
		}
	}

}
