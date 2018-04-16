//package chapter17;
//
//import java.awt.List;
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.net.URL;
//import java.net.URLConnection;
//import java.text.RuleBasedCollator;
//import java.util.Map;
//
//public class TestGetPost {
//	public static String sendGet(String url,String param){
//		String result="";
//		BufferedReader in = null;
//		try{
//			String urlName = url +"?"+param;
//			URL realUrl = new URL(urlName);
//			URLConnection conn = realUrl.openConnection();
//			conn.setRequestProperty("accept", "*/*");
//			conn.setRequestProperty("connection", "Keep-Alive");
//			conn.setRequestProperty("user-agent", "Mozilla/4.0 ("
//					+ "compatible;MSIE 6.0; Windows NT 5.1; SV1)");
//			conn.connect();
//			
////			System.out.println(conn.getInputStream());
//			Map<String, List<String>>map = conn.getHeaderFields();
//			for(String key :map.keySet()){
//				System.out.println(key+"-->"+map.get(key));
//			}
//			in = new BufferedReader(
//					new InputStreamReader(conn.getInputStream()));
//			String line ;
//			while((line = in.readLine())!=null){
//				result +="\n"+line;
//			}
//		}catch(Exception ex){
//			System.out.println("发送get请求出现异常");
//			ex.printStackTrace();
//		}finally{
//			if(in!=null){
//				in.close();
//			}
//		}
//		return result;
//	}
//	public 
//}
