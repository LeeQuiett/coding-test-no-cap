#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

int solution(int a, int b, bool flag) {
    int answer = 0;
    
    if(flag)
    {
        return a + b;
    }
    answer = a - b;
    return answer;
}