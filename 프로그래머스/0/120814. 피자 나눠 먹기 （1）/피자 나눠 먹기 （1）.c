#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

int solution(int n) {
    int answer = 0;
    int pizza = 7;
    int quo = 0;
    int remanider = 0;
    
    quo = n / 7;
    remanider = n % 7;
    
    if(remanider == 0)
    {
        answer = quo;
    }
    else
    {
        answer = quo + 1;    
    }
    
    return answer;
}