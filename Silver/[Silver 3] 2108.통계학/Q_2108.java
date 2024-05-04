import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q_2108 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[8001];
        for(int i = 0; i < n; i++){
            int num = Integer.parseInt(br.readLine());
            arr[num + 4000]++;
        }
        System.out.println(getMean(n, arr));
        System.out.println(getMedian(n, arr));
        System.out.println(getMostFrequency(arr));
        System.out.println(getRange(arr));
    }
    private static int getMean(int size, int[] arr){
        int mean = 0;
        for(int i = 0; i < 8001; i++){
            mean += (i - 4000) * arr[i];
        }
        return Math.round((float)mean / size);
    }
    private static int getMedian(int size, int[] arr){
        int count = 0;
        int mid = size / 2;
        for(int i = 0; i < 8001; i++){
            count += arr[i];
            if(count > mid) return (i - 4000);
        }
        return -1;
    }
    private static int getMostFrequency(int[] arr){
        int mostFrequency = 0;
        int num = -1;
        for(int i = 0; i < 8001; i++) if(arr[i] > mostFrequency) mostFrequency = arr[i];
        for(int i = 0; i < 8001; i++){
            if(arr[i] == mostFrequency){
                if(num < 0) num = i;
                else return i - 4000;
            }
        }
        return num - 4000;
    }
    private static int getRange(int[] arr){
        int min = 0;
        int max = 8000;
        for(int i = 0; i < 8001; i++){
            if(arr[i] > 0){
                min = i;
                break;
            }
        }
        for(int i = 8000; i >= 0; i--){
            if(arr[i] > 0){
                max = i;
                break;
            }
        }
        return max - min;
    }
}
