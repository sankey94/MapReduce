package GameData;
import java.util.StringTokenizer;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class MapperMixDta extends Mapper<LongWritable,Text,Text,IntWritable>{
	public void map (LongWritable  key, Text value , Context ctc)
	{
		String[] line =value.toString().split(",");
		
		String game_id=line[2].substring(arg0)
		//int game_id1=Integer.parseInt(line[2]);
		
		attend a=
		
		
		

	    
	   
	    
	    
		
			
			
	}

}
