/*
approach :
1. indexing
2. explore all stuff
3. return sum/max/min... */
class GridUniquePath {
    // move right, move down, count ways
    uniquePaths(m, n) {
        const arr = [];
        for (let i = 0; i < m; i++) {
            arr.push(new Array(n).fill(0));
        }
        // return uniquePathRecurssion(m-1, n-1);
        return this.uniquePathMemoization(m - 1, n - 1, arr);
    }
    ;
    // recursion : top person got the answer by going down
    uniquePathRecurssion(m, n) {
        if (m < 0 || n < 0)
            return 0;
        if (m == 0 && n == 0)
            return 1;
        const up = this.uniquePathRecurssion(m - 1, n);
        const left = this.uniquePathRecurssion(m, n - 1);
        return up + left;
    }
    ;
    uniquePathMemoization(m, n, arr) {
        if (m < 0 || n < 0)
            return 0;
        if (m == 0 && n == 0)
            return 1;
        if (arr[m][n] != 0)
            return arr[m][n];
        const up = this.uniquePathMemoization(m - 1, n, arr);
        const left = this.uniquePathMemoization(m, n - 1, arr);
        arr[m][n] = up + left;
        return up + left;
    }
}
const grid = new GridUniquePath();
var pathCount = grid.uniquePaths(3, 7);
console.log("Total Path : ", pathCount);
