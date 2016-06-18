package bigapp.utsav.adapter;

import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import bigapp.utsav.R;
import bigapp.utsav.model.Festival;
import bigapp.utsav.utils.Uiutils;
import bigapp.utsav.views.CircularImageView;

/**
 * Created by nitikaaggarwal on 15/06/16.
 */
public class FestivalListAdapter extends RecyclerView.Adapter<FestivalListAdapter.ItemViewHolder> implements View.OnClickListener {
    private AdapterView.OnItemClickListener mItemClickListener;
    public ArrayList<Festival> festivalList;

    public FestivalListAdapter(Object festivalList) {
        this.festivalList= (ArrayList<Festival>) festivalList;
    }

    @Override
    public void onClick(View v) {

    }
    public static interface OnItemClickListener {
        public void onItemClick(Festival festival);

    }

//    public FestivalListAdapter(OnItemClickListener itemClickListener, List<Festival> festivalList) {
//        this.festivalList = (ArrayList<Festival>) festivalList;
//        this.mItemClickListener = (AdapterView.OnItemClickListener) itemClickListener;
//
//    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder {
        public TextView mFstivalTitle;
        public TextView mFstivalDate;
        public ImageView mFstivalImv;
        public View divider;
        public View rowFestival;



        public ItemViewHolder(View itemView) {
            super(itemView);
            mFstivalTitle = (TextView) itemView.findViewById(R.id.festival_title_tv);
            mFstivalDate = (TextView) itemView.findViewById(R.id.festivallist_tv_date);
            mFstivalImv = (ImageView) itemView.findViewById(R.id.festival_list_imv_type);
            divider = (View)  itemView.findViewById(R.id.festival_list_divider);
            rowFestival = (View)  itemView.findViewById(R.id.row_order_list);
        }
    }

    @Override
    public FestivalListAdapter.ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_festival_list, parent, false);
        return new ItemViewHolder(v);
    }

    @Override
    public void onBindViewHolder(FestivalListAdapter.ItemViewHolder holder, int position) {
        Festival festival = festivalList.get(position);
//        Drawable drawable = Uiutils.getTextDrawable(Uiutils.getOrderFirstCharacter(festival),
//               R.dimen.festival_name_image_width,
//                R.dimen.festival_name_image_height);
//        holder.mFstivalImv.setImageDrawable(drawable);

        holder.mFstivalTitle.setText(festival.getTitle());
        holder.mFstivalDate.setText(festival.getDate());
//        holder.mFstivalImv.setBackgroundColor(Color.TRANSPARENT);
        holder.mFstivalImv.setBackgroundColor(Color.TRANSPARENT);


for (int i=1;i<festivalList.size()-1;i++)
{
    holder.divider.setVisibility(View.VISIBLE);
}
    }

    @Override
    public int getItemCount()  {

        return null != festivalList ? festivalList.size() :  0;
    }


}
