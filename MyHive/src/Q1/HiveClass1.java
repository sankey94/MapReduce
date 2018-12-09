package Q1;

import org.apache.hadoop.hive.ql.exec.UDF;
import org.apache.hadoop.io.IntWritable;
//import org.apache.hadoop.io.Text;

public class HiveClass1 extends UDF{
	public IntWritable evaluate (String key,String data)throws Exception
	{
		int max = 0;
		int v=Integer.parseInt(data);
		
		if(max<v)
		{
			max=v;
		}
		return new IntWritable(max);
	}	
}
