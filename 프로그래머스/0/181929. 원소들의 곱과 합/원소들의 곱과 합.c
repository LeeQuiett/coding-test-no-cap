#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

// num_list_len은 배열 num_list의 길이입니다.
int solution(int num_list[], size_t num_list_len) {
    int answer = 0;
    int multiply = num_list[0];
    int square = num_list[0];
    
    for(int i = 1; i < num_list_len; i++)
    {
        multiply *= num_list[i];
        square += num_list[i];
    }
    square = square * square;
    if(multiply < square)
        return 1;
    return answer;
}