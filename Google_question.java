/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author vaibhavaggarwal
 */
public class Google_question {
    public static void main(String args[]){
        int a= 4352;
        System.out.println(solution(a));
                
    }
    
    public static int solution(int x){
        int numDigits = countDigits(x);
        int largest = Integer.MIN_VALUE;
        for (int i = 1; i < numDigits; i++) {
            int d1 = extractDigit(x, numDigits, i);
            int d2 = extractDigit(x, numDigits, i-1);
            int average = getRoundedAverage(d1, d2);
            int newNum = 0;
            for (int k = 0; k < numDigits; k++) {
                if(k==i-1){
                    continue;
                }
                if(k==i){
                    newNum = newNum*10+average;
                }else{
                    newNum = newNum*10+extractDigit(x, numDigits, k);
                }
            }
            if(newNum>largest){
                largest = newNum;
            }
        }
        return largest;
    }
    
    public static int getRoundedAverage(int n1, int n2){
        return (int)Math.round((n1+(float)n2)/2.0);
    }
    
    public static int countDigits(int num){
        int numDigits = 0;
        while(num>0){
            numDigits++;
            num/=10;
        }
        return numDigits;
    }
    // 12345
    public static int extractDigit(int num, int digits, int i){
        return (int)(num/Math.pow(10,digits-1-i))%10;
    }
}
