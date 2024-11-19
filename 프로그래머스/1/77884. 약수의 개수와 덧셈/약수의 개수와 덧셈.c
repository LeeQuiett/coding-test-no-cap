#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

int solution(int left, int right) {
    int cnt = 0;
    int aksu = 0;
    
    for (int i = left; i <= right; i++) {
        for (int j = 1; j <= i; j++) {
            if ((i % j) == 0) {
                aksu++;
            }
        }
        if ((aksu % 2) == 0) {
            cnt += i;
        } else {
            cnt -= i;
        }
        aksu = 0;
    }
    
    return cnt;
}