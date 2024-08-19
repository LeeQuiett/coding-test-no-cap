#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

// 파라미터로 주어지는 문자열은 const로 주어집니다. 변경하려면 문자열을 복사해서 사용하세요.
int solution(const char* my_string, const char* is_suffix) {
    int answer = 0;
    int myLen = strlen(my_string);
    int sufLen = strlen(is_suffix);
    
    if(sufLen > myLen)
        return 0;
    
    const char* my_string_copy = my_string + (myLen - sufLen);
    if(strcmp(my_string_copy, is_suffix) == 0)
        return 1;
    else
        return 0;
    return answer;
}