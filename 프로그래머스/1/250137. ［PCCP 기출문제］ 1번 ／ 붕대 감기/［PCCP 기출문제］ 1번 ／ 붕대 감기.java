class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
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
        return health;
    }
}