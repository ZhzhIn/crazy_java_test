package chapter17;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.URL;
import java.net.URLConnection;

class DownThread extends Thread{
	private final int BUFF_LEN=32;
	private long start;
	private long end;
	private InputStream is;
	private RandomAccessFile raf;
	public DownThread(long start,long end,InputStream is ,RandomAccessFile raf){
		System.out.println(start+"--->"+end);
		this.start=start;
		this.end=end;
		this.is=is;
		this.raf=raf;
	}
	public void run(){
		try{
			is.skip(start);
			raf.seek(start);
			byte[] buff=new byte[BUFF_LEN];
			long contentLen = end-start;
			long times = contentLen/BUFF_LEN +4;//一次一个字节？raf和inputStream
			int hasRead = 0;
			for(int i =0;i<times;i++){
				hasRead=is.read(buff);
				if(hasRead<0){
					break;
				}
				raf.write(buff, 0, hasRead);
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try {
			if(is!=null){
				
					is.close();
				
			}else if(raf!=null){
				raf.close();
			}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
public class MutilDown {
	public static void main(String[]args){
		final int DOWN_THREAD_NUM=4;
		final String OUT_FILE_NAME="down.jpg";
		InputStream[]isArr=new InputStream[DOWN_THREAD_NUM];
		RandomAccessFile []outArr=new RandomAccessFile[DOWN_THREAD_NUM];
		try{
			URL url = new URL("https://csdnimg.cn"
		+"/jifen/images/xunzhang/xunzhang/chizhiyiheng.png");
/*			System.out.println(url.getFile()+"\n"+url.getHost()
			+"\n"+url.getPath()+"\n"+url.getPort()+"\n"+url.getProtocol()
			+"\n"+url.getQuery());*/
			URLConnection conn = url.openConnection();
			System.out.println(conn.getContent()+"\n"+conn.getHeaderField("Server")+"\n"+conn.getHeaderFields()+"\n"
					+/*conn.getInputStream()+"\n"+conn.getOutputStream()+"\n"+*/
					conn.getContentEncoding()+"\n"+conn.getContentLength()+"\n"
					+conn.getContentType()+"\n"+conn.getDate()+"\n"+
					conn.getExpiration()+"\n"+conn.getLastModified());
			isArr[0] = url.openStream();
			long fileLen = getFileLength(url);
			System.out.println("网络资源的大小"+fileLen);
			outArr[0]=new RandomAccessFile(OUT_FILE_NAME,"rw");
			for(int i =0;i<fileLen;i++){
				outArr[0].write(0);
			}
			long numPerThred = fileLen/DOWN_THREAD_NUM;
			long left=fileLen%DOWN_THREAD_NUM;
			for(int i =0;i<DOWN_THREAD_NUM;i++){
				if(i!=0){
					isArr[i]=url.openStream();
					outArr[i]=new RandomAccessFile(OUT_FILE_NAME,
							"rw");
				}
				if(i == DOWN_THREAD_NUM-1){
					new DownThread(i*numPerThred, (i+1)*numPerThred
							, isArr[i], outArr[i]).start();
				}else{
					new DownThread(i*numPerThred,(i+1)*numPerThred,
							isArr[i],outArr[i]).start();
				}
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
	}
	public static long getFileLength(URL url) throws Exception{
		long length=0;
		URLConnection con = url.openConnection();
		long size = con.getContentLength();
		length= size;
		return length;
	}
}
