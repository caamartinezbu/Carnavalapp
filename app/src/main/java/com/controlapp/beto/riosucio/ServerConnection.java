package com.controlapp.beto.riosucio;

/**
 * Created by JuanSe on 6/11/16.
 */

import android.os.AsyncTask;
import android.view.Gravity;
import android.widget.TextView;

import com.controlapp.beto.riosucio.Cuadrillas;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;


/**
 * Created by JuanSe on 6/11/16.
 */
class ServerConnection extends AsyncTask<String, Void, String> {

    private Cuadrillas cuadrillas_view;

    public ServerConnection(Cuadrillas cuadrillas_view){
        this.cuadrillas_view = cuadrillas_view;
    }


    @Override
    protected String doInBackground(String... params) {

        try {
            Constants constants = new Constants();
            return downloadUrl(constants.getGangsQueryUrl());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(String output) {

        if (output != null) {

            TextView lblMessage = (TextView) this.cuadrillas_view.findViewById(R.id.lblMessage);
            lblMessage.setText("Faltan " + output +  " dias para que se desbloquee el contenido de cuadrillas");
            lblMessage.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
            //Toast.makeText(this.cuadrillas_view, output, Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    protected void onPreExecute() {
    }

    @Override
    protected void onProgressUpdate(Void... values) {
    }


    public String downloadUrl(String url) throws IOException {

        URL urlObj = new URL(url);
        HttpURLConnection urlConnection = (HttpURLConnection) urlObj.openConnection();
        InputStream is = urlConnection.getInputStream();
        InputStream inputStream = (InputStream) urlConnection.getContent();
        int contentLength =  urlConnection.getContentLength();

        StringBuffer buffer = new StringBuffer();
        byte[] data = new byte[256];
        int len = 0;
        while (-1 != (len = inputStream.read(data)) ) {
            buffer.append(new String(data, 0, len));
        }

        String response = "";
        response = buffer.toString();

        if (!response.equals("")){
            JSONObject obj = null;
            try {
                obj = new JSONObject(response);
                return obj.optString("restant_days");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
