package com.example.demo;

import lombok.Value;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.parameters.P;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

@SpringBootTest
class DemoApplicationTests {

//    public static void main(String[] args)throws IOException{
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder sb = new StringBuilder();
//        int n = Integer.parseInt(br.readLine());
//        int[] arr = new int[n];
//        int[] index = new int[8001]; //최빈값 구하기 위한 배열
//        double[] result = new double[4];
//        List<Integer> list = new ArrayList<>();
//        int min = 0;
//
//        for(int i=0; i<n; i++){
//            arr[i] = Integer.parseInt(br.readLine());
//            result[0]+=arr[i]; //산술합계
//            index[arr[i]+4000]++;
//            if(min<index[arr[i]+4000]){
//                min = index[arr[i]+4000];
//            }
//        }
//        Arrays.sort(arr);
//        for(int i=0; i<index.length; i++){
//            if(index[i] == min){
//                list.add(i-4000);
//            }
//        }
//        if(list.size()>1){
//            result[2] = list.get(1);
//        }else{
//            result[2] = list.get(0);
//        }
//        result[0] = Math.round(result[0]/n); //산술평균
//        result[1] = arr[n/2]; //중앙값
//        result[3] = arr[n-1] - arr[0];// 범위
//        for(int i=0; i<result.length; i++){
//            sb.append((int)result[i]).append("\n");
//        }
//        System.out.print(sb);
//    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]){
                    return o1[1] - o2[1];
                }
                return o1[0] - o2[0];
            }
        });

        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[0].length; j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }

    }
}
