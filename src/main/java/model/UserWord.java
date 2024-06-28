package model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class UserWord {

    @Id
    @GeneratedValue
    long id;
    @ManyToMany
    List<User>  userId;
    @ManyToMany
    List<Word>  wordId;

    public UserWord() {
    }

    public UserWord(List<User> userId, List<Word> wordId) {
        this.userId = userId;
        this.wordId = wordId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<User> getUserId() {
        return userId;
    }

    public void setUserId(List<User> userId) {
        this.userId = userId;
    }

    public List<Word> getWordId() {
        return wordId;
    }

    public void setWordId(List<Word> wordId) {
        this.wordId = wordId;
    }


}
