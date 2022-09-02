import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int MOD = 1000000007;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        System.out.println(nCr(N, R, MOD));
    }

    private static long nCr(int n, int r, int p) {
        if (r == 0)
            return 1L;

        long[] fac = new long[n + 1];
        fac[0] = 1;

        for (int i = 1; i <= n; i++)
            fac[i] = fac[i - 1] * i % p;

        return (fac[n] * power(fac[r], p - 2, p)
                % p * power(fac[n - r], p - 2, p) % p) % p;

    }

    private static long power(long x, long y, long p) { // 제곱수 구하기, 분할 정복
        long res = 1L;
        x = x % p;
        // => 3^7 > 7 3 1
        while (y > 0) {
            if (y % 2 == 1)
                res = (res * x) % p;
            y = y >> 1;
            x = (x * x) % p;
        }
        return res;
    }
}