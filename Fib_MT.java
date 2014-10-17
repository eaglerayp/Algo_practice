/**
 * Created by eagle on 2014/9/16.
 */
public class Fib_MT {
    public static int[] two_dimension_matrix_multiply(int []matrix_1,int[]matrix_2){
        int []result=new int [4];
        result[0]=matrix_1[0]*matrix_2[0]+matrix_1[1]*matrix_2[2];
        result[1]=matrix_1[0]*matrix_2[1]+matrix_1[1]*matrix_1[3];
        result[2]=matrix_1[2]*matrix_2[0]+matrix_1[3]*matrix_2[2];
        result[3]=matrix_1[2]*matrix_2[1]+matrix_1[3]*matrix_2[3];
        return result;
    }
    public static int[] two_dimension_matrix_square(int[] init,int []matrix_1,int  n){
        int []result=new int [4];
        if(n==1){
            return matrix_1;
        }else if((n&0x01)==1){
            result[0]=matrix_1[0]*init[0]+matrix_1[1]*init[2];
            result[1]=matrix_1[0]*init[1]+matrix_1[1]*init[3];
            result[2]=matrix_1[2]*init[0]+matrix_1[3]*init[2];
            result[3]=matrix_1[2]*init[1]+matrix_1[3]*init[3];
            return two_dimension_matrix_square(init,result,n-1);
        }else{
            result[0]=matrix_1[0]*matrix_1[0]+matrix_1[1]*matrix_1[2];
            result[1]=matrix_1[0]*matrix_1[1]+matrix_1[1]*matrix_1[3];
            result[2]=matrix_1[2]*matrix_1[0]+matrix_1[3]*matrix_1[2];
            result[3]=matrix_1[2]*matrix_1[1]+matrix_1[3]*matrix_1[3];
            return two_dimension_matrix_square(init,result,n>>1);
        }
    }
    public static int matrix_fib(int n){
        int []matrix={1,1,1,0};
        if(n<=2){
            return 1;
        }else{
            matrix=two_dimension_matrix_square(matrix,matrix,n-2);
            return matrix[0]+matrix[1];
        }
}
    public static void main(String [] args) {
        System.out.println(matrix_fib(1024));
    }
}
