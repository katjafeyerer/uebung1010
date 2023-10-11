package Splittisplit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TextAnalyzer implements Runnable{

    private List<String> list = new ArrayList<>();

    public TextAnalyzer(List<String> list) {
        this.list = list;
    }

    @Override
    public void run() {
        int valuePerCharacter = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        for (String l: list) {
            valuePerCharacter+=l.length();
        }

    }
}
