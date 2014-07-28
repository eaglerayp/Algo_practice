
public class plateau {
	public static int findlongestlength(int[] input){ //find longest same integer's length
		int maxlen=0;
		for(int i=0;i<input.length;i++){
			if(input[i]==input[i-maxlen]){
				maxlen++;
			}
		}
		return maxlen;
	}
    public static int findlongestelement(int[] input){ //find longest same integer
        int maxlen=0;
        int maxindex=0;
        for(int i=0;i<input.length;i++){
            if(input[i]==input[i-maxlen]){
                maxlen++;
                maxindex=i;
            }
        }
        return input[maxindex];
    }
}
