package model;

import javax.persistence.*;

@Entity
@Table
public class Guess {

    @Id
    @GeneratedValue
    long id;
    @ManyToOne
    UserWord  userWordId;
    char character;
    boolean isTrue;

    public Guess() {
    }

    public Guess(UserWord userWordId, char character, boolean isTrue) {
        this.userWordId = userWordId;
        this.character = character;
        this.isTrue = isTrue;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public UserWord getUserWordId() {
        return userWordId;
    }

    public void setUserWordId(UserWord userWordId) {
        this.userWordId = userWordId;
    }

    public char getCharacter() {
        return character;
    }

    public void setCharacter(char character) {
        this.character = character;
    }

    public boolean isTrue() {
        return isTrue;
    }

    public void setTrue(boolean aTrue) {
        isTrue = aTrue;
    }
}
