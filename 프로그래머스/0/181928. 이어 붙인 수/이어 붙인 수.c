#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>
#include <string.h>

// num_list_len은 배열 num_list의 길이입니다.
int solution(int num_list[], size_t num_list_len) {
    int answer = 0;
    char resultStrEven[100] = "";
    char resultStrOdd[100] = "";
    
    for(int i = 0; i < num_list_len; i++)
    {
        char buffer[12] = "";
        if(num_list[i] % 2 == 0)
        {
            sprintf(buffer, "%d", num_list[i]);
            strcat(resultStrEven, buffer);
        }
        else
        {
            sprintf(buffer, "%d", num_list[i]);
            strcat(resultStrOdd, buffer);
        }       
    }
    int resultEvenNum = atoi(resultStrEven);
    int resultOddNum = atoi(resultStrOdd);
    
    answer = resultEvenNum + resultOddNum;
    
    return answer;
}