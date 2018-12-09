package attendancemaxyear;



import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;


public class MaxYearMapper extends Mapper<LongWritable, Text, Text, FloatWritable> {


	public void map(LongWritable key, Text value,Context context) {
		String [] str=value.toString().split(",");
		String year=str[0];
		System.out.println(year);
		float percentage=0;
		try {
			percentage=Float.parseFloat(str[str.length-1]);
			context.write(new Text(year), new FloatWritable(percentage));

		}
		catch(Exception e) {
			 percentage=0;
		}
		
		

	}
	

}
