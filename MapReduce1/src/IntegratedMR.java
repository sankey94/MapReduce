import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.KeyValueTextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;


public class IntegratedMR {
	public static void main(String[] args) throws Exception
	{
		Configuration config=new Configuration();
		Job job =Job.getInstance(config,"Count Words");
		FileSystem hdfs=FileSystem.get(config); 
		job.setJarByClass(IntegratedMR.class);
		job.setMapperClass(ClassMapper.class);
		job.setReducerClass(WordReducer.class);
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(IntWritable.class);
		Path workDirectory=(Path) hdfs.getWorkingDirectory();
		Path working=new Path(workDirectory,"/loaddata1");
		Path OutputDir=new Path(workDirectory,"/countdir");
		job.setInputFormatClass(KeyValueTextInputFormat.class);
		job.setOutputFormatClass(TextOutputFormat.class);
		FileInputFormat.addInputPath(job,working);
		FileOutputFormat.setOutputPath(job,OutputDir);
		System.exit(job.waitForCompletion(true)?0:1);
	}
}
