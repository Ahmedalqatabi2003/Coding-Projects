
/**
 *  SLOTMACHINE
 *
 * @author (Ahmed Al-qatabi)
 * @version (11/15/23)
 */
import java.util.Random;

public class SlotMachine {
    private int wheel1;
    private int wheel2;
    private int wheel3;
    private int bank;

    public SlotMachine() {
        Random rand = new Random();
        wheel1 = rand.nextInt(7) + 1;
        wheel2 = rand.nextInt(7) + 1;
        wheel3 = rand.nextInt(7) + 1;
        bank = 0;
    }

    public String toString() {
        return "Wheels: " + wheel1 + ", " + wheel2 + ", " + wheel3 + " | Bank: " + bank;
    }

    public String bet(int amount) {
        bank = amount;
        return "You bet " + amount + ". Bank: " + bank;
    }

    public void pull() {
        if (bank <= 0) {
            System.out.println("Error: Insufficient funds to play.");
            return;
        }
        bank--;

        Random rand = new Random();
        wheel1 = rand.nextInt(7) + 1;
        wheel2 = rand.nextInt(7) + 1;
        wheel3 = rand.nextInt(7) + 1;

        System.out.println("Lever Pulled");
        System.out.println("Wheels: " + wheel1 + ", " + wheel2 + ", " + wheel3);

        if (wheel1 != wheel2 && wheel2 != wheel3 && wheel1 != wheel3) {
            System.out.println("No matches. Nothing Won. Bank: " + bank);
        } else if (wheel1 == wheel2 && wheel2 == wheel3) {
            if (wheel1 == 7) {
                bank += 100;
                System.out.println("Jackpot! 100 dollars. Bank: " + bank);
            } else {
                bank += 6;
                System.out.println("Three the same. Won: 6 dollars. Bank: " + bank);
            }
        } else {
            bank += 2;
            System.out.println("Two the same. Won: 2 dollars. Bank: " + bank);
        }
    }

    public void cashOut() {
        System.out.println("Thanks for playing. Here is your " + bank + " dollars");
        bank = 0;
    }
}
