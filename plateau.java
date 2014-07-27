
public class plateau {
	public static int findlongestlength(int[] input){ //find longest same integer's length
		int maxlen=1;
		for(int i=1;i<input.length;i++){
			if(input[i]==input[i-maxlen]){
				maxlen++;
			}
		}
		return maxlen;
	}
}
