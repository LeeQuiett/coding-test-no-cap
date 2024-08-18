#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

int solution(int hp) {
    int answer = 0;
    
    int high = 5;
    int middle = 3;
    int bottom = 1;
    
    int quo = hp / high;
    int remainder = hp % high;
    
    if(remainder == 0)
    {
        answer = quo;
        return answer;
    }
    else
    {
        answer = quo;
        quo = remainder / middle;
        remainder = remainder % middle;
        
        if(remainder == 0)
        {
            answer = answer + quo;
            return answer;
        }
        else
        {
            answer = answer + quo;
            quo = remainder / bottom;
            
            answer = answer + quo;
            return answer;
        }
    }
    
    return answer;
}