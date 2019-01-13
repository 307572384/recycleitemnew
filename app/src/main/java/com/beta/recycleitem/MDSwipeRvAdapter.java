package com.beta.recycleitem;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Kevein on 2019/1/13.20:21
 */

public class MDSwipeRvAdapter extends RecyclerView.Adapter<MDSwipeRvAdapter.ViewHolder> {
	//展示数据
	private ArrayList<String> mData;

	public MDSwipeRvAdapter(ArrayList<String> data) {
		this.mData = data;
	}

	@Override
	public MDSwipeRvAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		// 实例化展示的view
		View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_rv_item, parent, false);
		// 实例化viewholder
		ViewHolder viewHolder = new ViewHolder(v);
		return viewHolder;
	}

	@Override
	public void onBindViewHolder(MDSwipeRvAdapter.ViewHolder holder, int position) {
		//绑定数据
		holder.mTv.setText(mData.get(position));
	}

	public void delete(int position) {
		if (position < 0 || position > getItemCount()) {
			return;
		}
		mData.remove(position);
		notifyItemRemoved(position);
	}

	@Override
	public int getItemCount() {
		return 0;
	}

	public static class ViewHolder extends RecyclerView.ViewHolder {

		TextView mTv;

		public ViewHolder(View itemView) {
			super(itemView);
			mTv = (TextView) itemView.findViewById(R.id.item_tv);
		}
	}
}
