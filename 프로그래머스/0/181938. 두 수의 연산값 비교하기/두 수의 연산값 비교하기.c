#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>
#include <string.h>

int solution(int a, int b) {
    int answer = 0;
    int result;
    int newCalculation;
    char str[12];
    char str2[12];
    
    result = 2 * a * b;   
    
    sprintf(str, "%d", a); // int를 char 배열로 변환
    sprintf(str2, "%d", b);

    int length = strlen(str); // 문자열의 길이를 계산
    int length2 = strlen(str2);
    
    for (int i = 0; i < length2; i++)
    {
        str[length] = str2[i];
        length++;
    }
    str[length] = '\0';
    
    newCalculation = atoi(str);
    
    if (result > newCalculation)
        return result;
    else
        return newCalculation;
           
    return 0;
}