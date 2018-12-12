package GameData;

import java.io.IOException;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
public class MapperMixDta extends Mapper<LongWritable,Text,Text,DoubleWritable> 
{
	public void map(LongWritable key,Text value,Context ctx) throws IOException, InterruptedException
	{
		 try 
		 {
	          if (key.get() == 0 && value.toString().contains("header") ) 
	          {
	                return;
	          }
	          else 
	          {
	    
	        	  String [] data=value.toString().split(",");
	      		int i=data.length-1;
	      		String game_id=data[i];
	      		String att=data[1];
	      		String teamname=game_id.substring(9,12);
	      		//System.out.println(teamname);
	      		String col1=data[0];
	      		Text team;
	      		DoubleWritable attendence;
	      		if(col1.equals("Attendance")) 
	      		{
	      			team=new Text(teamname);
	      			System.out.println(team);
	      			attendence=new DoubleWritable(Double.parseDouble(att));
	      			ctx.write(team,attendence);
	      		}
	       }
		 }catch (Exception e) {
			// TODO: handle exception
		}
	}
}
	




