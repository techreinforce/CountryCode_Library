package com.techreinforce.countypickerlibrary;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by embed on 6/9/16.
 *
 */
public class CountryListAdapter extends BaseAdapter implements Filterable {

    private static final String TAG = "CountryListAdapter";
    /*********************************************************/

    private Context context;
    List<Country> countries;
    LayoutInflater inflater;
    private ValueFilter valueFilter;
    private List<Country> mCountriesFilterList;

    private int getResId(String drawableName)
    {
//        Utility.printLog(TAG+" getResId drawableName "+drawableName);
        Resources resources = context.getResources();
        return resources.getIdentifier(drawableName, "drawable",
                context.getPackageName());
    }

    CountryListAdapter(Context context, List<Country> countries) {
        super();
        this.context = context;
        this.countries = countries;
        this.mCountriesFilterList = countries;
        inflater = (LayoutInflater) this.context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        getFilter();
    }

    @Override
    public int getCount() {
        return countries.size();
    }

    @Override
    public Object getItem(int arg0) {
        return null;
    }

    @Override
    public long getItemId(int arg0) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View cellView = convertView;
        Cell cell;
        Country country = countries.get(position);
//        Utility.printLog(TAG+" country list "+countries.get(position).getFlag());

        if (convertView == null)
        {
            cell = new Cell();
            cellView = inflater.inflate(R.layout.item_country_picker, null);
            cell.textView = cellView.findViewById(R.id.row_title);
            cell.imageView = cellView.findViewById(R.id.row_icon);
            cellView.setTag(cell);
        } else
            cell = (Cell) cellView.getTag();

        cell.textView.setText(country.getName()+" ("+ country.getDialCode()+")");
        String drawableName = "flag_"
                + country.getCode().toLowerCase(Locale.ENGLISH);
//        Utility.printLog(TAG+" drawableName  "+drawableName);
        int drawableId = getResId(drawableName);
        country.setFlag(drawableId);
        cell.imageView.setImageResource(getResId(drawableName));
        return cellView;
    }

    static class Cell {
        TextView textView;
        ImageView imageView;
    }

    @Override
    public Filter getFilter() {
        if(valueFilter==null) {

            valueFilter=new ValueFilter();
        }

        return valueFilter;
    }

    private class ValueFilter extends Filter {

        //Invoked in a worker thread to filter the data according to the constraint.
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults results=new FilterResults();
            if(constraint!=null && constraint.length()>0){
                ArrayList<Country> filterList=new ArrayList<Country>();
                for(int i=0;i<mCountriesFilterList.size();i++){
                    if((mCountriesFilterList.get(i).getName().toUpperCase())
                        .contains(constraint.toString().toUpperCase())) {
                        Country contacts = new Country();
                        contacts.setName(mCountriesFilterList.get(i).getName());
                        contacts.setCode(mCountriesFilterList.get(i).getCode());
                        contacts.setDialCode(mCountriesFilterList.get(i).getDialCode());
                        contacts.setFlag(mCountriesFilterList.get(i).getFlag());
                        contacts.setMaxDigits(mCountriesFilterList.get(i).getMaxDigits());
                        contacts.setMinDigits(mCountriesFilterList.get(i).getMinDigits());
                        filterList.add(contacts);
                    }
                }
                results.count=filterList.size();
                results.values=filterList;
            }else{
                results.count=mCountriesFilterList.size();
                results.values=mCountriesFilterList;
            }
            return results;
        }


        //Invoked in the UI thread to publish the filtering results in the user interface.
        @SuppressWarnings("unchecked")
        @Override
        protected void publishResults(CharSequence constraint,
                                      FilterResults results) {
            countries=(ArrayList<Country>) results.values;
            notifyDataSetChanged();
        }
    }
}
