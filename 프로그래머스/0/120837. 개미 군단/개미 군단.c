#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

int solution(int hp) {
    int answer = 0;
    int high, middle, bottom;
    high = hp / 5;
    middle = (hp % 5) / 3;
    bottom = ((hp % 5) % 3) / 1;
    answer = high + middle + bottom;
    
    return answer;
}