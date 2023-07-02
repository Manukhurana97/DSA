package com.example.dsa.OldCode.Arrays;

public class CelebrityProb {

    int celebrity(int M[][], int n){

        if(n!=M.length) return -1;

        int i=0, j = 0;
        while(i<n && j<n){
            if(M[j][i]==1) j++;
            else i++;
        }

        for( i=0;i<n;i++){
            if( i!=j && (M[j][i]==1 || M[i][j]==0)) return -1;
        }
        return j;
    }

}
