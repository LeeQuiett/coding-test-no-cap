class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        // t초 동안 붕대 감음, 1초마다 x만큼의 체력을 회복
        // t초 연속으로 붕대를 감으면 y만큼 체력을 추가 회복
        // 붕대 감기 기술의 시전 시간, 1초당 회복량, 추가 회복량 => bandage
        // 체력 회복중 공격 당하면 기술이 취소됨, 공격 당하는 순간엔 체력 회복 불가
        // 기술 취소나 끝나면 다시 붕대를 감으며 연속 성공 시간이 0으로 초기화됨
        // 최대 체력 health
        // 공격 시간과 피해량을 담은 2차원 정수 배열 attacks
        // 남은 체력 리턴하기, 체력 0 되면 -1 리턴
        
        int totalLoopLen = attacks[attacks.length - 1][0];
        int maxHealth = health;
        
        int skillTime = bandage[0];  
        int healPerSec = bandage[1];
        int additionalHealAmount = bandage[2];
        int spellCastCnt = 0;
        
        boolean flag = false;
        
        for (int i = 1; i <= totalLoopLen; i++) {
            for (int j = 0; j < attacks.length; j++) {
                flag = false;
                if (i == attacks[j][0]) {
                    health = health - attacks[j][1];
                    if (health <= 0) return -1;
                    spellCastCnt = 0;
                    flag = true;
                    break;
                }
            }
            if (flag == false) {
                health = health + healPerSec;
                spellCastCnt++;
                if (health >= maxHealth) health = maxHealth;
            }
            if (spellCastCnt == skillTime) {
                health += additionalHealAmount;
                spellCastCnt = 0;
                if (health >= maxHealth) health = maxHealth;
            }
        }
        
        
        int answer = health;
        return answer;
    }
}