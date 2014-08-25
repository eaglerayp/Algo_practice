import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by syshih on 2014/8/25.
 */
public class Regex {
    public static void testRegex(){
        String content="5678</a>  4591</a>";
        String job="";
        Matcher JobMatcher = Pattern.compile("\\d+</a>", Pattern.CASE_INSENSITIVE | Pattern.DOTALL).matcher( content );
        while( JobMatcher.find() ){
            System.out.println(JobMatcher.group(0));
        }
    }
}
