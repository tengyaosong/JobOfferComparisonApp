package edu.gatech.seclass.jobcompare6300;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/*
CITATION
Tutorial was used to stand up this framework:
- WEBSITE
--- https://demonuts.com/android-listview-tutorial/#ch
 */


public class ListViewAdapter extends BaseAdapter {
    private Context context;
    public static ArrayList<JobsListViewModel> modelArrayList;
    private static final int MAX_SELECTABLE = 2;
    private ArrayList<Integer> positionsToCompare = new ArrayList<>();
    ApplicationContextProvider appContext;

    public ListViewAdapter(Context context, ArrayList<JobsListViewModel> modelArrayList) {
        this.context = context;
        this.modelArrayList = modelArrayList;
        this.appContext = (ApplicationContextProvider) context.getApplicationContext();
    }

    @Override
    public int getCount() {
        return modelArrayList.size();
    }
    @Override
    public Object getItem(int position) {
        return modelArrayList.get(position);
    }
    @Override
    public long getItemId(int position) {
        return 0;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder container;
        if (convertView == null) {
            container = new ViewHolder(); LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.row_listview, null, true);
            container.checkBox = (CheckBox) convertView.findViewById(R.id.listViewCheckbox);
            container.jobString = (TextView) convertView.findViewById(R.id.listViewJobString);
            convertView.setTag(container);
        }else {
            container = (ViewHolder)convertView.getTag();
        }
        container.jobString.setText(modelArrayList.get(position).getFullBanner());
        container.checkBox.setChecked(modelArrayList.get(position).getSelected());
        container.checkBox.setTag(R.integer.btnplusview, convertView);
        container.checkBox.setTag( position);
        container.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){

            @Override
            public void onCheckedChanged(CompoundButton buttonView,
                                         boolean isChecked) {
                int amountChecked = countActiveSelect();
                Integer indice = (Integer)  container.checkBox.getTag();
                if(isChecked && !(amountChecked < MAX_SELECTABLE)){
                    container.checkBox.setChecked(false);
                    // Code to display your message.
                    appContext.setCompareList(positionsToCompare);
                    //System.out.println("We are in toast with amount ::  " + amountChecked);
                    Toast.makeText(context, "You are only allowed to choose 2 jobs!", Toast.LENGTH_SHORT).show();
                }else if(isChecked && (amountChecked < MAX_SELECTABLE)){
                    positionsToCompare.add(indice);
                    appContext.setCompareList(positionsToCompare);
                    //System.out.println("IN SELECTING CHECKBOX :: " + appContext.getCompareList().toString());
                }else{
                    positionsToCompare.remove(positionsToCompare.indexOf(indice));
                    appContext.setCompareList(positionsToCompare);
                    //System.out.println("IN DE SELECTION CHECKBOX :: " + appContext.getCompareList().toString());
                }
            }
        });
        container.checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer position = (Integer)  container.checkBox.getTag();
                if(modelArrayList.get(position).getSelected()){
                    modelArrayList.get(position).setSelected(false);
                }else {
                    if (countActiveSelect() < MAX_SELECTABLE)
                        modelArrayList.get(position).setSelected(true);
                }
            }
        });
        return convertView;
    }
    private class ViewHolder {
        protected CheckBox checkBox;
        private TextView jobString;
    }

    private int countActiveSelect() {
        //int type = 0;
        int i = 0;
        for (JobsListViewModel item : modelArrayList) {
            if (item.getSelected() == true) {
                //System.out.println("We are incrementing on type :: " + type);
                i++;
            }
            //type++;
        }
        return i;
    }
}
