package com.example.asus.android_webservice_client1;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.asus.model.CauHoi;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class DanhSachCauHoiActivity extends AppCompatActivity {

    ListView lvCH;
    ArrayAdapter<CauHoi> cauHoiArrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danh_sach_cau_hoi);
        SetControl();
    }


    class DanhSachCauHoiTask extends AsyncTask<Void,Void,ArrayList<CauHoi>>{
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(ArrayList<CauHoi> cauHois) {
            super.onPostExecute(cauHois);
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected ArrayList<CauHoi> doInBackground(Void... voids) {
            ArrayList<CauHoi> dsch = new ArrayList<>();
            try{
                URL url = new URL();
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                connection.setRequestProperty("Content-Type","application/json;charset-uft-8");

                InputStreamReader inputStreamReader = new InputStreamReader(connection.getInputStream(),"UTF-8");
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                StringBuilder builder = new StringBuilder();
                String line = null;
                while ((line = bufferedReader.readLine()) != null)
                {
                    builder.append(line);
                }
                JSONArray jsonArray = new JSONArray(builder.toString());
                for(int i = 0; i<jsonArray.length();i++)
                {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    int mach = jsonObject.getInt("MACH");
                    String ndch = jsonObject.getString("NDCH");
                    String a = jsonObject.getString("A");
                    String b = jsonObject.getString("B");
                    String c = jsonObject.getString("C");
                    String d = jsonObject.getString("D");
                    String da = jsonObject.getString("DA");

                    CauHoi ch = new CauHoi();
                    ch.setMACH(mach);
                    ch.setNDCH(ndch);
                    ch.setA(a);
                    ch.setB(b);
                    ch.setC(c);
                    ch.setD(d);
                    ch.setDA(da);
                    dsch.add(ch);
                }
                bufferedReader.close();
            }catch (Exception ex){
                Log.e("Loi",ex.toString());
            }
            return dsch;
        }
    }

    private void SetControl() {
        lvCH = findViewById(R.id.lvCauHoi);
        cauHoiArrayAdapter = new ArrayAdapter<CauHoi>(DanhSachCauHoiActivity.this,android.R.layout.simple_list_item_1);
        lvCH.setAdapter(cauHoiArrayAdapter);
    }
}
