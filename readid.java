import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
/**
 * Created by syshih on 2014/8/11.
 */

public class readid {
    public static void main(String [] args) throws IOException {
        String a = ".....?";
        a=a.substring(0,a.length()-2);
        System.out.print(a);
        double startTime,endTime,totTime;
        startTime = System.currentTimeMillis();
        File input=new File("D:\\phantomjs\\code\\朱學恆relation.txt");
        BufferedReader br = new BufferedReader(new FileReader(input));
        String line =br.readLine();
        Set<Long> ids=new HashSet<Long>();
        while(line!=null){
            String[] userids=line.split(";");
            for(String id:userids){
                ids.add(Long.parseLong(id));
            }
            line =br.readLine();
        }
        //把要測試的程式放到endTime前面
        endTime = System.currentTimeMillis();
        //取得程式結束的時間
        totTime = endTime - startTime;
        //計算經過多久
        System.out.println("Using Time:" + totTime/1000);
        System.out.println(ids.size());
    }
}
