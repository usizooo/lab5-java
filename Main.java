package org.example;
public class Main {
    public static void main(String[] args) {
    }
    //Статические функции
    //Функция для расчета общей стоимости содержания всех заключенных
    public static double calculateTotalAmount(double costForOnePrisoner, int quantityPrisoner){
        return costForOnePrisoner * quantityPrisoner;
    }

    // Функция для вычисления оставшихся дней от всего срока наказания
    public static int calculateRemainingDays(int totalSentenceDuration, int daysServed) {
        return totalSentenceDuration - daysServed;
    }

    //Функция для проверки возможности встречи с родными
    public static boolean canHaveVisitation(boolean isVisitationDay, boolean isAllowed) {
        return isVisitationDay && isAllowed;
    }

    //Обычные функции
    // Функция для выдачи штрафного времени за нарушение правил тюрьмы
    public int issuePenaltyTime(int originalTime, int violation) {
        return originalTime + violation * 30; // Например, за каждое нарушение првил добавляется 30 дней
    }

    // Функция, устанавливающая новый срок наказания в случае повторного правонарушения
    public int setNewSentenceDuration(int currentDuration, int repeatedViolations) {
        return currentDuration + repeatedViolations * 365; // Например, за каждое повторное нарушение добавляется год
    }

    // Функция для выдачи дополнительного бонуса за хорошее поведение
    public int rewardForGoodBehavior(int originalSentenceDuration) {
        return originalSentenceDuration / 5; // Например, 5% от исходной длительности наказания
    }

    // Функции для ответвлений
    // Функция для пересмотра срока наказания в случае отмены бонуса за хорошее поведение (ответвление от rewardForGoodBehavior)
    public int reviewSentenceDuration(int originalSentenceDuration, boolean bonusCancelled) {
        if (bonusCancelled) {
            // Если бонус отменен, удлиним срок наказания на 10%
            return originalSentenceDuration + (originalSentenceDuration / 10);
        } else {
            return originalSentenceDuration; // Возвращаем исходный срок наказания
        }
    }

    // Функция для учета дополнительного бонуса за отличное поведение (ответвление от rewardForGoodBehavior)
    public int extraRewardForExemplaryBehavior(int originalSentenceDuration, boolean exemplaryBehavior) {
        if (exemplaryBehavior) {
            // Если заключенный проявляет примерное поведение, сокращаем срок на 8% от исходного срока наказания
            return originalSentenceDuration - (originalSentenceDuration * 8 / 100);
        } else {
            return originalSentenceDuration / 5; // Возвращаем исходный бонус за хорошее поведение
        }
    }

    // Функция для учета условий рецидива преступлений при установлении нового срока наказания (ответвление от setNewSentenceDuration)
    public int adjustSentenceDurationForRecidivism(int currentDuration, int repeatedViolations, boolean repeatOffense) {
        if (repeatOffense) {
            // Если произошел рецидив преступлений, увеличиваем срок наказания на количество повторных нарушений, умноженное на 2 года
            return currentDuration + (repeatedViolations * (2 * 365));
        } else {
            return currentDuration; // Возвращаем исходный срок наказания
        }
    }

    // Функция для пересчета срока наказания в случае получения амнистии (ответвление от setNewSentenceDuration)
    public static int recalculateSentenceDuration(int currentDuration, boolean grantedAmnesty) {
        if (grantedAmnesty) {
            // Если амнистия предоставлена, срок наказания сокращается на половину
            return currentDuration / 2;
        } else {
            return currentDuration; // Возвращаем исходный срок наказания
        }
    }
}