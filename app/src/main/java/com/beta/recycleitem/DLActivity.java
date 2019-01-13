package com.beta.recycleitem;

import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.beta.recycleitem.decoration.MDLinearRvDividerDecoration;

import java.util.ArrayList;

/**
 * Created by Kevein on 2019/1/13.17:32
 * 添加和删除item的Recyclerdemo
 */

public class DLActivity extends MDBaseActivity implements View.OnClickListener {
	private TextView                   mTextViewadd;
	private TextView                   mTextViewdel;
	private RecyclerView               mRecyclerView;
	private MDRvAdapter                mAdapter;
	private RecyclerView.LayoutManager mLayoutManager;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_rv_linear);
		initView();
		initData();
		initAction();
		mRecyclerView.setAdapter(mAdapter);//设置adpter
	}

	private void initAction() {
		mTextViewadd.setOnClickListener(this);
		mTextViewdel.setOnClickListener(this);
	}

	private void initData() {

		mAdapter = new MDRvAdapter(getData());
		mAdapter.setOnItemClickListener(new MDRvAdapter.OnItemClickListener() {
			@Override
			public void onItemClick(View view, int position) {
				Toast.makeText(DLActivity.this, "click " + position + " item", Toast.LENGTH_SHORT).show();//单点击事件
			}

			@Override
			public void onItemLongClick(View view, int position) {
				Toast.makeText(DLActivity.this, "long click " + position + " item", Toast.LENGTH_SHORT).show();//长按点击事件
			}
		});
	}

	private void initView() {
		mTextViewadd = (TextView) findViewById(R.id.rv_add_item_btn);
		mTextViewdel = (TextView) findViewById(R.id.rv_del_item_btn);
		mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
		mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
		//设置布局管理器
		mRecyclerView.setLayoutManager(mLayoutManager);


		//设置item添加和移除的动画
		mRecyclerView.setItemAnimator(new DefaultItemAnimator());
		// 设置Item之间间隔样式
		mRecyclerView.addItemDecoration(new MDLinearRvDividerDecoration(this, LinearLayoutManager.VERTICAL));
	}

	@Override
	public void onClick(View v) {
		int id = v.getId();
		if (id == R.id.rv_add_item_btn) {
			mAdapter.addNewItem();
			mLayoutManager.scrollToPosition(0);
		} else if (id == R.id.rv_del_item_btn) {
			mAdapter.deleteItem();
			mLayoutManager.scrollToPosition(0);
		}
	}

	private ArrayList<String> getData() {
		ArrayList<String> data = new ArrayList<>();
		String temp = " item";
		for (int i = 0; i < 20; i++) {
			data.add(i + temp);
		}

		return data;
	}

}
