package com.example.qklahpita.sqlite;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Qk Lahpita on 8/23/2016.
 */
public class ListQuestionAdapter extends RecyclerView.Adapter<ListQuestionAdapter.ItemHolder> {
    private List<MathWord> mathWordList;
    private Context context;
    private LayoutInflater inflater;

    public ListQuestionAdapter(List<MathWord> mathWordList, Context context) {
        this.mathWordList = mathWordList;
        this.context = context;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public ListQuestionAdapter.ItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_on_list, parent, false);
        ItemHolder itemHolder = new ItemHolder(view);
        return itemHolder;
    }

    @Override
    public void onBindViewHolder(ListQuestionAdapter.ItemHolder holder, int position) {
        MathWord mathWord = mathWordList.get(position);
        if (mathWord != null) {
            holder.tvSub.setText((mathWord.getQuestionContent()));
            for (int i = 0; i < holder.textViewList.size(); i++) {
                holder.textViewList.get(i).setText(mathWord.getListAnswer().get(i));
            }
        }
    }

    @Override
    public int getItemCount() {
        return mathWordList.size();
    }

    public class ItemHolder extends RecyclerView.ViewHolder {
        private TextView tvSub;
        private List<TextView> textViewList;

        public ItemHolder(View itemView) {
            super(itemView);

            tvSub = (TextView) itemView.findViewById(R.id.tv_subject);
            textViewList = new ArrayList<>();
            textViewList.add((TextView) itemView.findViewById(R.id.tv_1));
            textViewList.add((TextView) itemView.findViewById(R.id.tv_2));
            textViewList.add((TextView) itemView.findViewById(R.id.tv_3));
            textViewList.add((TextView) itemView.findViewById(R.id.tv_4));
        }
    }
}
