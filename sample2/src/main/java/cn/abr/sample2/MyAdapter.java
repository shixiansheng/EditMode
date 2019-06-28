package cn.abr.sample2;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import java.util.List;

import cn.abr.sample2.EditAdapter;

/**
 * .
 * Created by Administrator on 2018/8/9/009.
 */
public class MyAdapter extends EditAdapter<String> {


    public MyAdapter(List<String> list) {
        super(list);
    }

    @Override
    public EditViewHolder onCreateEditViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,parent,false));
    }

    @Override
    public void onBindEditViewHolder(EditViewHolder holder, int position) {
        ((ViewHolder) holder).home_list_default_title.setText(mList.get(position));
    }

    private static class ViewHolder extends EditViewHolder {

        private final TextView home_list_default_title;

        ViewHolder(View itemView) {
            super(itemView);
            home_list_default_title = itemView.findViewById(R.id.home_list_default_title);
        }

        @Override
        public EditLayout setEditLayout(View itemView) {
            return itemView.findViewById(R.id.edit_layout);
        }

        @Override
        public View setContent(View itemView) {
            return itemView.findViewById(R.id.home_list_default_root_ly);
        }


        @Override
        public View setDelete(View itemView) {
            return itemView.findViewById(R.id.fl_pre_delete);
        }

    }
}
