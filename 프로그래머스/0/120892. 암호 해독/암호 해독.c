#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>
#include <string.h> 

char* solution(const char* cipher, int code) {
    int len = strlen(cipher);
    int answer_len = len / code;
    char* answer = (char*)malloc(answer_len + 1); 
    int cnt = 0;
    
    for (int i = code - 1; i < len; i += code) {
        answer[cnt++] = cipher[i];
    }
    answer[cnt] = '\0';
    
    return answer;
}
