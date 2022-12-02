package io.meowkita.catsimulator.cat.decorators;

import io.meowkita.catsimulator.cat.Cat;

public class LockInteractionCat extends Cat {

    private boolean canInteract = true;

    public LockInteractionCat(Cat cat) {
        super(cat);
    }

    @Override
    public void play(int amount) {
        if (!canInteract) {
            throw new IllegalStateException("You have already interacted with this cat! The cat must fall asleep before you can interact with it again.");
        }

        super.play(amount);
        canInteract = false;
    }

    @Override
    public void feed(int amount) {
        if (!canInteract) {
            throw new IllegalStateException("You have already interacted with this cat! The cat must fall asleep before you can interact with it again.");
        }

        super.feed(amount);
        canInteract = false;
    }

    @Override
    public void heal(int amount) {
        if (!canInteract) {
            throw new IllegalStateException("You have already interacted with this cat! The cat must fall asleep before you can interact with it again.");
        }

        super.heal(amount);
        canInteract = false;
    }

    @Override
    public void sleep(int amount) {
        canInteract = true;
        super.sleep(amount);
    }

}
