package aps;

import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.Set;


public class SendPHP {

    public void doSend(String url, Map<String, String> data) 
            throws Exception 
    {
        URL siteUrl = new URL(url);
        HttpURLConnection conn = (HttpURLConnection) siteUrl.openConnection();
        conn.setRequestMethod("POST");
        conn.setDoOutput(true);
        conn.setDoInput(true);        

        DataOutputStream out = new DataOutputStream(conn.getOutputStream());

        Set<String> keys = data.keySet();
        Iterator keyIter = keys.iterator();
        String content = "";        
        for(int i=0; keyIter.hasNext(); i++) {
            Object key = keyIter.next();
            if(i!=0) {
                content += "&";
            }
            content += key + "=" + URLEncoder.encode(data.get(key), "UTF-8");
        }

        System.out.println(content);
        out.writeBytes(content);    

        out.flush();
        out.close();

        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        System.out.println("\n\nResultado da Pagina: \n\n");
        String line = "";
        while((line=in.readLine())!=null) {
            System.out.println(line);
        }

    }

    public static void main(String[] args) throws Exception{        

        Map<String, String> data = new HashMap<String, String>();
        data.put("username", "usuario");
        data.put("password", "senha");        

        SubmitHTML obj = new SubmitHTML();    

        obj.doSubmit("http://localhost/submitHTML/loginhandler.php", data);        

    }

}