package bigapp.utsav.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import bigapp.utsav.R;
import bigapp.utsav.adapter.FestivalListAdapter;
import bigapp.utsav.model.Festival;

public class CalendarFestivalListFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private List<Festival> festivalList = new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
      View rootView = inflater.inflate(R.layout.fragment_calendar_festival_list, container, false);
   Itemview(rootView);
        return(rootView);

    }
    public void Itemview(View rootView)
    {
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.Calendar_festival_list_rv);
        mRecyclerView.hasFixedSize();

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new FestivalListAdapter(festivalList);
        mRecyclerView.setAdapter(mAdapter);
        prepareFestivalData();
    }

    private void prepareFestivalData() {
        Festival festival = new Festival("Guru Purnima","Jul 19, 2016");
        festivalList.add(festival);

        festival = new Festival("Nag Panchami", "Aug 07, 2016");
        festivalList.add(festival);

        festival = new Festival("Varalakshmi Vrat", "Aug 12, 2016");
        festivalList.add(festival);

        festival = new Festival("Raksha-Bandhan", "Aug 18, 2016");
        festivalList.add(festival);
        festival = new Festival("Krishna Janmashtami", "Aug 25, 2016");
        festivalList.add(festival);
        festival = new Festival("Ganesh Chaturthi", "Sep 05, 2016");
        festivalList.add(festival);
        festival = new Festival("Onam", "Sep 14, 2016");
        festivalList.add(festival);
        festival = new Festival("Vishwakarma Puja", "Sep 16, 2016");
        festivalList.add(festival);festival = new Festival("Mahalaya Amavasya", "Sep 30, 2016");
        festivalList.add(festival);festival = new Festival("Navaratri begins", "Oct 01, 2016");
        festivalList.add(festival);festival = new Festival("Navaratri ends", "Oct 10, 2016");
        festivalList.add(festival);festival = new Festival("Dusshera", "Oct 11, 2016");
        festivalList.add(festival);festival = new Festival("Shardad Purnima", "Oct 15, 2016");
        festivalList.add(festival);festival = new Festival("Karwa Chauth", "Oct 19, 2016");
        festivalList.add(festival);festival = new Festival("Dhanteras", "Oct 28, 2016");
        festivalList.add(festival);festival = new Festival("Diwali", "Oct 30, 2016");
        festivalList.add(festival);
        festival = new Festival("Bhai Dooj", "Nov 01, 2016");
        festivalList.add(festival);festival = new Festival("Chhath Puja", "Nov 06, 2016");
        festivalList.add(festival);festival = new Festival("Kartik Poornima", "Nov 14, 2016");
        festivalList.add(festival);festival = new Festival("Geeta Jayanti", "Dec 10, 2016");
        festivalList.add(festival);festival = new Festival("Dhanu Sankranti", "Dec 15, 2016");
        festivalList.add(festival);






        mAdapter.notifyDataSetChanged();
    }


}

