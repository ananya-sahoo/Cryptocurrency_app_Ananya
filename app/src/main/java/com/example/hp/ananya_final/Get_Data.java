package com.example.hp.ananya_final;

import android.os.AsyncTask;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.net.ssl.HttpsURLConnection;

public class Get_Data  extends AsyncTask<Void,Void,JSONObject>
{
    String value="";
    String row="";
    String returnvalues="";
    MainActivity mainActivity;
    ArrayList<ListView_Ex> arrayList=new ArrayList<ListView_Ex>();

    static ArrayList<ListView_Ex> save_arrylist=new ArrayList<ListView_Ex>();

    Adpater_Customize adapter;
    static JSONArray jsonarray;
    static URL url;
    public Get_Data(MainActivity context)
    {
        mainActivity=context;
    }

    @Override
    protected void onPostExecute(JSONObject object)
    {
        super.onPostExecute(object);
        ListView listView=mainActivity.findViewById(R.id.listview);
        try
        {
            if(arrayList.size()>0)
            {
                adapter=new Adpater_Customize(mainActivity,arrayList);
            }
            else
                adapter=new Adpater_Customize(mainActivity,save_arrylist);
        }
        catch (Exception e)
        {


        }
        listView.setAdapter(adapter);
    }
    @Override
    protected JSONObject doInBackground(Void... voids)
    {
        try
        {
            url = new URL("https://api.coinmarketcap.com/v1/ticker/");
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url.openConnection();
            InputStream inputStream = httpsURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line = "";
            while (line != null)
            {

                line = bufferedReader.readLine();
                value += line;

            }
            jsonarray=new JSONArray(value);
            for (int i=0;i<jsonarray.length();i++)
            {
                JSONObject obj=jsonarray.getJSONObject(i);

                ListView_Ex listView_ex=new ListView_Ex(obj.getString("name"),obj.getString("price_usd"),obj.getString("percent_change_1h"));
                arrayList.add(listView_ex);




            }

        }
        catch (MalformedURLException malex)
        {

        }
        catch (IOException ioe)
        {

        }
        catch (JSONException jsone)
        {

        }
        if(arrayList.size()!=0)
        {
            save_arrylist=arrayList;
        }





        return null;
    }
    public class ListView_Ex
    {
        public String name;
        public String usd;
        public String change_last_hour;
        public ListView_Ex(String name,String usd_exchange,String percent_change_last_hour)
        {
            this.name=name;
            this.usd=usd_exchange;
            this.change_last_hour=percent_change_last_hour;
        }
    }
}
