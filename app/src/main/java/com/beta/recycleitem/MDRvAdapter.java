package com.beta.recycleitem;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Kevein on 2019/1/13.17:46
 */

public class MDRvAdapter extends RecyclerView.Adapter<MDRvAdapter.ViewHolder> {
	//展示数据
	private ArrayList<String>               mData;
	//事件回调监听
	private MDRvAdapter.OnItemClickListener onItemClickListener;

	public MDRvAdapter(ArrayList<String> data) {
		this.mData = data;
	}

	public void updateData(ArrayList<String> data) {
		this.mData = data;
		notifyDataSetChanged();
	}

	/**
	 * 添加新的Item
	 */
	public void addNewItem() {
		if (mData == null) {
			mData = new ArrayList<>();
		}
		mData.add(0, "new item");
		notifyItemInserted(0);
	}

	//删除item
	public void deleteItem() {
		if (mData == null || mData.isEmpty()) {
			return;
		}
		mData.remove(0);
		notifyItemRemoved(0);
	}

	/**
	 * 设置回调监听
	 *
	 * @param listener
	 */
	public void setOnItemClickListener(MDRvAdapter.OnItemClickListener listener) {
		this.onItemClickListener = listener;
	}

	@Override
	public MDRvAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		// 实例化展示的view
		View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_rv_item, parent, false);
		// 实例化viewholder
		ViewHolder viewHolder = new ViewHolder(v);
		return viewHolder;
	}

	@Override
	public void onBindViewHolder(final MDRvAdapter.ViewHolder holder, int position) {
		//绑定数据
		holder.mTv.setText(mData.get(position));
		holder.itemView.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if (onItemClickListener != null) {
					int pos = holder.getLayoutPosition();
					onItemClickListener.onItemClick(holder.itemView, pos);
				}
			}
		});
		holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View v) {
				if (onItemClickListener != null) {
					int pos = holder.getLayoutPosition();
					onItemClickListener.onItemLongClick(holder.itemView, pos);
				}
				return true;
			}


		});
	}

	@Override
	public int getItemCount() {
		return mData.size();
	}

	public interface OnItemClickListener {
		void onItemClick(View view, int position);

		void onItemLongClick(View view, int position);
	}

	public static class ViewHolder extends RecyclerView.ViewHolder {

		TextView mTv;

		public ViewHolder(View itemView) {
			super(itemView);
			mTv = (TextView) itemView.findViewById(R.id.item_tv1);
		}
	}
}
