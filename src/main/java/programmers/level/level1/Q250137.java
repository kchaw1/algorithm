package programmers.level.level1;

public class Q250137 {

    public static void main(String[] args) {
//        int[] bandage = {5, 1, 5};
//        int health = 30;
//        int[][] attacks = {{2, 10}, {9, 15}, {10, 5}, {11, 5}};

//        int[] bandage = {3, 2, 7};
//        int health = 20;
//        int[][] attacks = {{1, 15}, {5, 16}, {8, 6}};

        int[] bandage = {1,1,1};
        int health = 5;
        int[][] attacks = {{1, 2}, {3, 2}};

        System.out.println(solution(bandage, health, attacks));
    }

    /**
     * bandage	health	attacks	result
     * [5, 1, 5]	30	[[2, 10], [9, 15], [10, 5], [11, 5]]	5
     * [3, 2, 7]	20	[[1, 15], [5, 16], [8, 6]]	-1
     * [4, 2, 7]	20	[[1, 15], [5, 16], [8, 6]]	-1
     * [1, 1, 1]	5	[[1, 2], [3, 2]]	3
     */
    public static int solution(int[] bandage, int health, int[][] attacks) {
        int max = getMaxSec(attacks);
        int currentHealth = health;
        int healTime = bandage[0];
        int healAmount = bandage[1];
        int addHealAmount = bandage[1] + bandage[2];

        int successCnt = 0;
        for (int i = 1; i <= max; i++) {
            int currentDamage = getCurrentDamage(i, attacks);
            if (currentDamage == 0) {
                successCnt++;

                if (successCnt == healTime) {
                    currentHealth = heal(currentHealth, health, addHealAmount);
                    successCnt = 0;
                } else {
                    currentHealth = heal(currentHealth, health, healAmount);
                }
            } else {
                successCnt = 0;
                currentHealth -= currentDamage;

                if (currentHealth <= 0) {
                    return -1;
                }
            }
        }

        return currentHealth;
    }

    public static int getMaxSec(int[][] attacks) {
        int max = Integer.MIN_VALUE;

        for (int[] attack : attacks) {
            max = Math.max(attack[0], max);
        }
        return max;
    }

    public static int getCurrentDamage(int currentSec, int[][] attacks) {
        for (int i = 0; i < attacks.length; i++) {
            int sec = attacks[i][0];
            int dam = attacks[i][1];

            if (sec == currentSec) {
                return dam;
            }
        }
        return 0;
    }

    public static int heal(int currentHealth, int maxHealth, int healAmount) {
        int healed = currentHealth + healAmount;
        if (healed >= maxHealth) {
            healed = maxHealth;
        }
        return healed;
    }
}
