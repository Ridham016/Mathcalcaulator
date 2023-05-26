package cordova.plugin.mathcalculator;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * This class echoes a string called from JavaScript.
 */
public class MathCalculator extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
       if (action.equals("add")) {
            this.add(args, callbackContext);
            return true;
        }
      else if (action.equals("substract")) {
            this.substract(args, callbackContext);
            return true;
        }
        return false;
    }



    private void add(JSONArray args, CallbackContext callbackContext) {
        if(args!=null) {
            try{
                int p1=Integer.parseInt(args.getJSONObject(0).getString("param1")); 
                int p2= Integer.parseInt(args.getJSONObject(1).getInt("param2"));
                int result=p1+p2;
                callbackContext.success("Result is "+result);
            }
            catch(Exception e){
                CallbackContext.error("Something went wrong" + e);
            }
        }
        else{
            callbackContext.error("Expected one non-empty string argument.");
        }
}
    private void substract(JSONArray args, CallbackContext callbackContext) {
        if(args!=null) {
            try{
                int p1=Integer.parseInt(args.getJSONObject(0).getString("param1")); 
                int p2= Integer.parseInt(args.getJSONObject(1).getInt("param2"));
                int result=p1-p2;
                callbackContext.success("Result is "+result);
            }
            catch(Exception e){
                CallbackContext.error("Something went wrong" + e);
            }
        }
        else{
            callbackContext.error("Expected one non-empty string argument.");
        }
}
}
