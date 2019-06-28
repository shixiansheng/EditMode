package cn.abr.sample2;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SouthernBox on 2016/10/25 0025.
 * 列表适配器
 */

public abstract class EditAdapter<T> extends RecyclerView.Adapter {

    protected List<T> mList;

    private boolean isEdit;  //是否处于编辑状态
    private List<EditLayout> allItems = new ArrayList<>();

    public EditAdapter(List<T> list) {
        this.mList = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return onCreateEditViewHolder(parent, viewType);
    }

    public abstract EditViewHolder onCreateEditViewHolder(ViewGroup parent, int viewType);

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final EditViewHolder viewHolder = (EditViewHolder) holder;
        final EditLayout editLayout = viewHolder.editLayout;

        if (!allItems.contains(editLayout)) {
            allItems.add(editLayout);
        }

        editLayout.setEdit(isEdit);

        onBindEditViewHolder(viewHolder, position);


        viewHolder.vDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = viewHolder.getAdapterPosition();
                if (position >= 0) {
                    mList.remove(position);
                    notifyItemRemoved(position);
                    if (position != mList.size()) {
                        notifyItemRangeChanged(position, mList.size() - position);
                    }
                }
            }
        });
    }

    public abstract void onBindEditViewHolder(EditViewHolder holder, int position);

    @Override
    public int getItemCount() {
        return mList.size();
    }

    /**
     * 设置编辑状态
     *
     * @param isEdit 是否为编辑状态
     */
    public void setEdit(boolean isEdit) {
        this.isEdit = isEdit;
        if (isEdit) {
            openLeftAll();
        } else {
            closeAll();
        }
        for (EditLayout editLayout : allItems) {
            editLayout.setEdit(isEdit);
        }
    }

    /**
     * 关闭所有 item
     */
    private void closeAll() {
        for (EditLayout editLayout : allItems) {
            editLayout.close();
        }
    }

    /**
     * 将所有 item 向左展开
     */
    private void openLeftAll() {
        for (EditLayout editLayout : allItems) {
            editLayout.openLeft();
        }
    }

    /**
     * 获取编辑状态
     *
     * @return 是否为编辑状态
     */
    public boolean isEdit() {
        return isEdit;
    }


    public List<T> getList() {
        return mList;
    }
}
