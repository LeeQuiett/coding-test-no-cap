#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

int* solution(int money) {
    // return 값은 malloc 등 동적 할당을 사용해주세요. 할당 길이는 상황에 맞게 변경해주세요.
    int* answer = (int*)malloc(2 * 4);    
    int quo = 0;
    int remainder = 0;
    
    quo = money / 5500;
    remainder = money % 5500;
    
    answer[0] = quo;
    answer[1] = remainder;
    
    return answer;
}