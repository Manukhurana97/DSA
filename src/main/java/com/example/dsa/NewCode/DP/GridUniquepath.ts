/* 
approach : 
1. indexing 
2. explore all stuff
3. return sum/max/min... */  

class GridUniquePath{
    // move right, move down, count ways

    uniquePaths(m: number, n: number): number {
        const arr: number[][] = [];
        for(let i=0;i<m;i++){
            arr.push(new Array(n).fill(0));
        }
        // return uniquePathRecurssion(m-1, n-1);
        // return this.uniquePathMemoization(m-1, n-1, arr);
        return this.uniquePathTabulation(m-1, n-1, arr);
    };
    
    
    // recursion : top person got the answer by going down
    uniquePathRecurssion(m: number, n: number): number {
        if(m<0 || n<0) return 0;
        if(m==0 && n==0) return 1;
       
        
        const up = this.uniquePathRecurssion(m - 1, n);
        const left = this.uniquePathRecurssion(m, n - 1);
    
        return up + left;
    };
    
    // memorization
    uniquePathMemoization(m: number, n: number, arr: number[][]): number{
        if(m<0 || n<0) return 0;
        if(m==0 && n==0) return 1;
    
        if(arr[m][n] !=0) return arr[m][n];
       
        
        const up = this.uniquePathMemoization(m - 1, n, arr);
        const left = this.uniquePathMemoization(m, n - 1, arr);
    
        arr[m][n] = up+left;
    
        return up + left;
    }

    // tabulation : (Declare Base case, express states in for loop, copy the recurrence and write)
    uniquePathTabulation(m: number, n: number, arr: number[][]): number {
        for (let i = 0; i <= m; i++) {
            for (let j = 0; j <= n; j++) {
                if (i === 0 && j === 0) {
                    arr[i][j] = 1;
                } else {
                    const down = i > 0 ? arr[i - 1][j] : 0;
                    const left = j > 0 ? arr[i][j - 1] : 0;
                    arr[i][j] = down + left;
                }
            }
        }
        return arr[m][n];
    } 
    
    
    // space 
    uniquePathSpaceOptimization(m: number, n: number): number{

        var arr: number[] = new Array(n).fill(0);
        
        for (let i = 0; i <= m; i++) {
            var prev = arr;
            for (let j = 0; j <= n; j++) {
                if (i === 0 && j === 0) {
                    arr[i] = 1;
                } else {
                    const down = i > 0 ? prev[j] : 0;
                    const left = j > 0 ? arr[j - 1] : 0;
                    arr[i] = down + left;
                }
            }

            arr = prev;
        }
        return arr[n-1];
    }

}


const  grid = new GridUniquePath();
var pathCount = grid.uniquePaths(3,7);

console.log("Total Path : ", pathCount);