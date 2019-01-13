package com.beta.recycleitem;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.ToggleButton;


public class testActivity extends Activity implements View.OnClickListener {
	private Button       button;
	private Button       test2;
	private ToggleButton test;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activitytwo);
		initView();

	}

	private void initView() {
		button = (Button) findViewById(R.id.button);

		button.setOnClickListener(this);
		test2 = (Button) findViewById(R.id.test2);
		test2.setOnClickListener(this);
		test = (ToggleButton) findViewById(R.id.test);
		test.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
			case R.id.button:

				break;
			case R.id.test2:
				break;
			case R.id.test:
				break;
		}
	}
}
