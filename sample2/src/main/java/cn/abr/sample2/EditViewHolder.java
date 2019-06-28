package cn.abr.sample2;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by nanquan.lin on 2017/11/3 0003.
 * 编辑项的 ViewHolder
 */

public abstract class EditViewHolder extends RecyclerView.ViewHolder {
    public EditLayout editLayout;
    public View vContent;
    public View vDelete;

    public EditViewHolder(View itemView) {
        super(itemView);
        editLayout = setEditLayout(itemView);
        vContent = setContent(itemView);
        vDelete = setDelete(itemView);
    }

    public abstract EditLayout setEditLayout(View itemView);

    public abstract View setContent(View itemView);

    public abstract View setDelete(View itemView);


}
