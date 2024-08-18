#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

// array_len은 배열 array의 길이입니다.
int solution(int array[], size_t array_len) {
    int answer = 0;
    int tmp = 0;
    for(int i = 0; i < array_len - 1; i++)
    {
        for(int j = array_len - 1; j > i; j--)
        {
            if(array[j - 1] > array[j]){
                tmp = array[j];
                array[j] = array[j - 1];
                array[j - 1] = tmp;
            }
                
        }
    }
    
    answer = array[array_len/2];
    
    return answer;
}