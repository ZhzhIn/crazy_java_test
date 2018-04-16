package chapter17;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class URLDecoderTest {
	public static void main(String[]args) throws Exception{
		String keyWord = URLDecoder.decode("%E6%9D%8E%E5%88%9A+j2ee","UTF-8");
		System.out.println(keyWord);
		String urlStr = URLEncoder.encode("ror敏捷开发指南","GBK");
		System.out.println(urlStr);
	}
}
