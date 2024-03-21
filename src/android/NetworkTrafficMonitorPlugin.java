package com.exlo.networktrafficmonitorplugin;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;

import android.net.TrafficStats;

public class NetworkTrafficMonitorPlugin extends CordovaPlugin {
    
    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("getTotalBytesTransmitted")) {
            long bytesTransmitted = TrafficStats.getTotalTxBytes();
            callbackContext.success(bytesTransmitted);
            return true;
        } else if (action.equals("getTotalBytesReceived")) {
            long bytesReceived = TrafficStats.getTotalRxBytes();
            callbackContext.success(bytesReceived);
            return true;
        }
        return false;
    }
}
