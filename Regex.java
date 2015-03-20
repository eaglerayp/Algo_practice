import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by syshih on 2014/8/25.
 */
public class Regex {
    public static void testRegex(){
        String content="-¥1231.4B \t";
        String job="";
        Matcher JobMatcher = Pattern.compile("(-*+).(\\d+.\\d+)", Pattern.CASE_INSENSITIVE | Pattern.DOTALL).matcher( content );
        int i=0;
        while( JobMatcher.find() ){
            System.out.println(JobMatcher.group(0));
            System.out.println(JobMatcher.group(1));
            System.out.println(JobMatcher.group(2));
        }
    }
}
