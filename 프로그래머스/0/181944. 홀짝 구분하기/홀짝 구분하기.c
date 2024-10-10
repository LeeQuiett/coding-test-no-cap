#include <stdio.h>

int main(void) {
    int a;
    scanf("%d", &a);
    
    if ((a % 2) == 0)
        printf("%d is even", a);
    else
        printf("%d is odd", a); // 저는 코테의 익힘을 중요시 여기는데 even하게 익지 않았네요^^

    return 0;
}