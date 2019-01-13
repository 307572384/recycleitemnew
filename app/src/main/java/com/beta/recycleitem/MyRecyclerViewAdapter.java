package com.beta.recycleitem;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.List;

/**
 * Created by Kevein on 2019/1/7.17:19
 */

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
	public  OnItemClickListener mOnItemClickListener;//第二步：声明自定义的接口
	private List<Data>          list;//数据源
	private Context             mcontent;//上下文

	public MyRecyclerViewAdapter(List<Data> list, Context context) {
		this.list = list;
		this.mcontent = context;

	}

	@Override
	public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		//选择类型
		switch (viewType) {
			case Data.TYPE_ONE:
				View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemone, parent, false);
				return new OneViewHolder(view);
			case Data.TYPE_TWO:
				view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemtwo, parent, false);
				return new TwoViewHolder(view);
		}
		return null;
	}

	@Override
	public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

	}

	@Override
	public int getItemCount() {

		return list.size();
	}

	//item类型
	@Override
	public int getItemViewType(int position) {
		return list.get(position).type;
	}

	//第三步：定义方法并暴露给外面的调用者
	public void setOnItemClickListener(OnItemClickListener listener) {
		this.mOnItemClickListener = listener;
	}

	//第一步：自定义一个回调接口来实现Click和LongClick事件
	public interface OnItemClickListener {
		void onItemClick(View v, int position);

		void onItemLongClick(View v);
	}

	//第一个item类型
	class OneViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
		private Button btnAgree, btnRefuse;

		public OneViewHolder(View itemView) {
			super(itemView);
			btnAgree = itemView.findViewById(R.id.btn_agree);
			btnRefuse = itemView.findViewById(R.id.btn_refuse);
			// 为item及item内部控件添加点击事件
			itemView.setOnClickListener(this);
			btnAgree.setOnClickListener(this);
			btnRefuse.setOnClickListener(this);
		}


		@Override
		public void onClick(View v) {
			if (mOnItemClickListener != null) {
				mOnItemClickListener.onItemClick(v, getAdapterPosition());
			}
		}
	}

	//第二个item类型
	class TwoViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {


		public TwoViewHolder(View itemView) {
			super(itemView);
			// 为item添加点击事件
			itemView.setOnClickListener(this);
		}

		@Override
		public void onClick(View v) {
			if (mOnItemClickListener != null) {
				mOnItemClickListener.onItemClick(v, getAdapterPosition());
			}
		}
	}
}