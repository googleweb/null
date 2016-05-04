package scxd.jcz.ajlw.android.model;

import java.util.ArrayList;
import java.util.List;

import scxd.jcz.ajlw.android.Activity.R;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * ��Ŀ��
 * 
 * @author wdn
 * 
 */
public class InfoItemBar extends LinearLayout {

	private LinearLayout content;
	private ImageView titleImage;
	private List<InfoItem> items;
	public String titleName;
/**
 * 
 * @param context 
 * @param title
 */
	public InfoItemBar(Context context, String title) {
		super(context);
		LayoutInflater.from(context).inflate(R.layout.itembar, this);
		this.items = new ArrayList<InfoItem>();
		this.titleName = title;
		this.content = (LinearLayout) findViewById(R.id.carLogin_itemBar_content);
		this.titleImage = (ImageView) findViewById(R.id.item_img_title);
		TextView titleTextView = (TextView) findViewById(R.id.carLogin_itemBar_title);
		TextView cljyxmdy = (TextView) findViewById(R.id.cljyxmdy);
		titleTextView.setText(title + " :");
		if (title.equals("���������Ŀ")) {
			cljyxmdy.setTextColor(Color.RED);
			cljyxmdy.setText("�����GB21861-2014 ����1-��������ȫ����������Ŀ��ȷ��������Ŀ");
			cljyxmdy.setVisibility(View.VISIBLE);
		}

		titleTextView.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (content.getVisibility() == GONE) {
					content.setVisibility(VISIBLE);
					titleImage.setImageResource(R.drawable.item_pressed);
				} else {
					content.setVisibility(GONE);
					titleImage.setImageResource(R.drawable.item_unpressed);
				}
			}

		});
	}

	/**
	 * ��� infoItem��Ŀ
	 * 
	 * @param item
	 */
	public void addView(View item) {
		this.content.addView(item);
		if (item instanceof InfoItem)
			this.items.add((InfoItem) item);
	}

	/**
	 * ��ȡ �ƶ�item
	 * 
	 * @param index
	 * @return
	 */
	public InfoItem getItemAt(int index) {
		return items.get(index);
	}

	/**
	 * ��ȡ ȫ��item
	 * 
	 * @return
	 */
	public List<InfoItem> getItems() {
		return items;
	}

	/**
	 * ���� ����Ŀ�� �Ƿ�չ��
	 * 
	 * @param isShow
	 */
	public void setShow(boolean isShow) {
		if (isShow) {
			content.setVisibility(VISIBLE);
			titleImage.setImageResource(R.drawable.item_pressed);
		} else {
			content.setVisibility(GONE);
			titleImage.setImageResource(R.drawable.item_unpressed);
		}
	}

	/**
	 * �Ƿ� ��д���
	 * 
	 * @return
	 */
	public boolean isCompleted() {
		for (InfoItem item : items) {
			if (!item.isPassed())
				return false;
		}
		return true;
	}

	/**
	 * ���� Ĭ��
	 */
	public void setDefault() {
		for (InfoItem item : items) {
			item.setDefault();
		}
	}
}
