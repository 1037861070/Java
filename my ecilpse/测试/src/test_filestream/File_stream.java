package test_filestream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class File_stream {

	public static void main(String[] args) throws IOException {
		// TODO �Զ����ɵķ������
   File file1=new File("C:/HaxLogs.txt");
   File file2=new File("b.txt");
 file1.createNewFile();
 System.out.println(file1.getName());
   if(file1.exists()){
	   FileInputStream fis=new FileInputStream(file1);
	   FileOutputStream fos=new FileOutputStream(file2);
	   String str="love";
	   System.out.println(str);
	   byte[] bt=new byte[1024];
	   int count=0;
	   while((count=fis.read(bt))>0){
		   String str1=new String(bt,0,count);
		   System.out.println(str1);
		   byte[] bt2=str1.getBytes();
		   fos.write(bt2);
	   }
	   fis.close();
	   fos.close();
   }
	}

}
