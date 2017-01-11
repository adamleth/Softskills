package com.grp12.softskilltools.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.galgespil.stvhendeop.menuapp.R;
import com.grp12.softskilltools.Activities.MainMenu;
import com.grp12.softskilltools.Entities.AbstractItem;
import com.grp12.softskilltools.Util.ResultListAdaptor;

import java.util.List;

/**
 * Created by mathiaslarsen on 14/11/2016.
 */

public class ResultListFragment extends Fragment implements AdapterView.OnItemClickListener, View.OnClickListener{
    private Button button;
    private ListView results;
    private List<AbstractItem> testResults;
    View myView;
    public ResultListFragment(){
        initialize();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.frag_resultlist, container, false);
        results = (ListView) myView.findViewById(R.id.Results);
        results.setAdapter(new ResultListAdaptor(getContext(),testResults));
        results.setOnItemClickListener(this);
        return myView;
    }

    public void initialize(){
        testResults = MainMenu.getInstance().getUser().hentResults();

    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        System.out.println(position);
        AbstractItem tempItem = testResults.get(position);
        Bundle bundle = new Bundle();
        switch (tempItem.getTestType()){
            case DISC:
                DISCResultFragment discFrag= new DISCResultFragment();
                bundle.putSerializable("Item",tempItem);
                discFrag.setArguments(bundle);
                this.getFragmentManager().beginTransaction()
                        .replace(R.id.article_fragment, discFrag,null)
                        .addToBackStack(null)
                        .commit();
                        MainMenu.getInstance().mToolbar.setTitle("DISC RESULTAT");
                break;
            case BELBIN:
                BELBINResultFragment nextFrag= new BELBINResultFragment();
                bundle.putSerializable("Item",tempItem);
                nextFrag.setArguments(bundle);
                this.getFragmentManager().beginTransaction()
                        .replace(R.id.article_fragment, nextFrag,null)
                        .addToBackStack(null)
                        .commit();
                MainMenu.getInstance().mToolbar.setTitle("BELBIN RESULTAT");

                break;
            case THREESIXTY:

                break;
        }

    }

    @Override
    public void onClick(View v) {



    }

}
