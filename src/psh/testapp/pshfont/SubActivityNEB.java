package psh.testapp.pshfont;

import android.app.ActionBar;
import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class SubActivityNEB extends Activity implements View.OnClickListener{

	private static final String TYPEFACE_NAME = "fonts/NanumGothicExtraBold.ttf";	
	
	private Typeface typeface = null;
	
	private static final String TYPEFACE_NAME2 = "fonts/NanumGothic.otf";
	private Typeface typeface2 = null;
	
	private void loadTypeface() {
		if (typeface == null)
			typeface = Typeface.createFromAsset(getAssets(), TYPEFACE_NAME);
		
		if (typeface2 == null)
			typeface2 = Typeface.createFromAsset(getAssets(), TYPEFACE_NAME2);
	}
	
	@Override
	public void onClick(View v) {
		switch(v.getId()){
		case R.id.backbutton1:			
			finish();
			break;
		}
		// TODO 자동 생성된 메소드 스텁

	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		loadTypeface();
		
		setContentView(R.layout.activity_sub_n);	
		
		View myButtonLayout = getLayoutInflater().inflate(R.layout.psh_sctionbar, null);		
		myButtonLayout.findViewById(R.id.backbutton1).setOnClickListener(this);		
		TextView test = (TextView) myButtonLayout.findViewById(R.id.titleView1);
		test.setText("나눔고딕익스트라볼드");
		test.setTypeface(typeface2);
		
		ActionBar barbar = getActionBar();
		barbar.setCustomView(myButtonLayout);				
		barbar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);

		LinearLayout linerLO = new LinearLayout(this);

		linerLO.setOrientation(LinearLayout.VERTICAL);

		TextView txt = new TextView(this);

		txt.setText("승호가 만든 폰트 비교하기 NanumGothicExtraBold");

		linerLO.addView(txt);

		TextView[] tv = new TextView[140];

		ScrollView scc = new ScrollView(this);

		for (int i = 0; i < tv.length; i++) {
			tv[i] = new TextView(this);
			tv[i].setTypeface(typeface);
			tv[i].setText((i + 10) + "SmileDay스마일데이2014");
			tv[i].setTextSize(TypedValue.COMPLEX_UNIT_SP, i + 10);
			linerLO.addView(tv[i]);			
		}

		scc.addView(linerLO);

		setContentView(scc);

	}	

}
