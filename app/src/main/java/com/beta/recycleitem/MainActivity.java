package com.beta.recycleitem;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

	private RecyclerView          rv_recy;
	private MyRecyclerViewAdapter adpter;
	private List<Data>            list;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initView();
		initData();

		rv_recy.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));//布局管理器
		adpter = new MyRecyclerViewAdapter(list, this);//从adapter中获取到存储的数据源list
		rv_recy.setAdapter(adpter);
		//设置item及item中的控件点击事件
		adpter.setOnItemClickListener(MyItemClickListener);
	}


	private void initView() {
		rv_recy = (RecyclerView) findViewById(R.id.rv_recy);
	}

	//存放生成条目
	private void initData() {
		list = new ArrayList<>();
		list.add(new Data(1, "看看这个资源吧"));
		list.add(new Data(2, "1"));
		list.add(new Data(1, "2"));
		list.add(new Data(2, "3"));
		list.add(new Data(1, "4"));
		list.add(new Data(2, "5"));
		list.add(new Data(1, "6"));
		list.add(new Data(2, "7"));

	}

	/**
	 * item＋item里的控件点击监听事件
	 */
	private MyRecyclerViewAdapter.OnItemClickListener MyItemClickListener = new MyRecyclerViewAdapter.OnItemClickListener() {

		@Override
		public void onItemClick(View v, int position) {
			switch (v.getId()) {
				case R.id.btn_agree:
					//对item进行判断如果是第一个那么我们进行跳转反之则提示消息
						if(position==0) {
							Intent intent = new Intent(MainActivity.this, testActivity.class);
							intent.putExtra("name", list.get(position).toString());
							startActivity(intent);

						}
						else{
							Toast.makeText(MainActivity.this, "你点击了同意按钮" + (position + 1), Toast.LENGTH_SHORT).show();
						}

					break;
				case R.id.btn_refuse:
					Toast.makeText(MainActivity.this, "你点击了拒绝按钮" + (position + 1), Toast.LENGTH_SHORT).show();
					break;
				default:
					Toast.makeText(MainActivity.this, "你点击了item按钮" + (position + 1), Toast.LENGTH_SHORT).show();
					break;
			}
		}

		@Override
		public void onItemLongClick(View v) {

		}


	};

}