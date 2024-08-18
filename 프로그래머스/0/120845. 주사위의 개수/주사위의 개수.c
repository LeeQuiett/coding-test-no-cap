#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

// box_len은 배열 box의 길이입니다.
int solution(int box[], size_t box_len, int n) {
    int answer = 0;
    
    int boxWidth = box[0];
    int boxLength = box[1];
    int boxHeight = box[2];
    
    int resultWidth = 0;
    int resultLenth = 0;
    int resultHeight = 0;
    
    int resultSecDemention = 0;
    int resultThiDemention = 0;
        
    if(boxWidth >= n && boxLength >= n && boxHeight >= n)
    {
        resultWidth = boxWidth / n;
        resultLenth = boxLength / n;
        resultHeight = boxHeight / n;
        
        resultSecDemention = resultWidth * resultLenth;
        resultThiDemention = resultSecDemention * resultHeight;
    }
    
    answer = resultThiDemention;
    return answer;
}